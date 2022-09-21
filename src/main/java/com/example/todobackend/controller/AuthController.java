package com.example.todobackend.controller;


import com.example.todobackend.configuration.jwt.JwtUtils;
import com.example.todobackend.configuration.services.EmailDetails;
import com.example.todobackend.configuration.services.EmailServiceImpl;
import com.example.todobackend.configuration.services.UserDetailsImpl;
import com.example.todobackend.entity.*;
import com.example.todobackend.exception.*;
import com.example.todobackend.log.InfoLogger;
import com.example.todobackend.repository.RoleRepository;
import com.example.todobackend.repository.TokenRepository;
import com.example.todobackend.repository.UserRepository;
import com.example.todobackend.repository.VerifiedRepository;
import com.example.todobackend.requests.LoginRequest;
import com.example.todobackend.requests.SignUpRequest;
import com.example.todobackend.responses.LoginResponse;
import com.example.todobackend.responses.SignUpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth") // auth/register
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    VerifiedRepository verifiedRepository;
    @Autowired
    private JwtUtils jwtUtils; //private olmayacak mı

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<SignUpResponse> registerUser(@RequestBody SignUpRequest signUpRequest) {  // "role": ["user"] firstname surname email,username, password email var mi yok mu
        userRepository.findByUsername(signUpRequest.getUsername()).ifPresent(existingUser -> {
            throw new UserWithUsernameExistsException(existingUser.getUsername());
        });

        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getName(),
                signUpRequest.getSurname()
        );

        Role userRole = roleRepository.findByName(ERole.USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found.")); // RoleWithNameNotFoundException

        user.setRole(userRole);
        User user1 = userRepository.save(user);
        Random random = new Random();
        Verified verified=new Verified(true, random.nextLong(100000000), false, user1);
        verifiedRepository.save(verified);
        emailServiceImpl.sendSimpleMail(new EmailDetails(user1.getEmail(), verified.getVerificationSlug(), "Hesabinizi onaylayin"));

        return new ResponseEntity<>(new SignUpResponse("Kullanici basarili bir sekilde kayit oldu! Giris yapiniz."), HttpStatus.OK);
    }

    @InfoLogger("Kullanici Giris Yapti")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {  // firstname surname email,username, password email var mi yok mu
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication); // Backendin kendi icinde yonettigi cache tokeni - Diger adiyla session auth
        String jwt = jwtUtils.generateJwtToken(authentication); // JWT Token - 1 haftalik token

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Token token = new Token(); // NotificationToken
        token.setFcm_token(loginRequest.getFcm_token());
        token.setUser(userRepository.findByUsername(loginRequest.getUsername()).orElseThrow()); //Passworddonotmatchexception
        tokenRepository.save(token);
        return new ResponseEntity<>(new LoginResponse(
                jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail()), HttpStatus.OK);
    }


    @GetMapping("/verify/{verified_id}")
    public ResponseEntity<String> getVerifyById(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) Locale locale,
            @PathVariable("verified_id") Long verified_id) {
        verifiedRepository.findByVerificationSlug(verified_id).map(verified -> {
            verified.setApproved(true);
            return verifiedRepository.save(verified);
        }).orElseThrow(() -> new UserCouldNotBeVerifiedException(verified_id));
        return new ResponseEntity<>(messageSource.getMessage("{validation.successful}",null, locale), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
}
// () -> {} / lambda, arrow function, anonymous function