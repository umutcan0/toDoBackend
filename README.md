## Todo backend requirements


### Reminder
- Reminder entity OK
- JPA Repository for Reminders OK
- Reminder Controller OK

### Firebase
- Integration OK
- Firebase Bean OK
- Messaging Service OK

### TODO
- Login / Register - 1
- Item - User arasında relationship - 2
- Multitenancy - 3
- Scheduling
- Firebase push notification
- Restricted Endpoints
- Todo Listeleri
- Pub/Sub

INSTALL: 
- Github CLI



Cumartesi icin:
- Role isminde entity acilacak id, role_type = Enum(ADMIN, USER)
- RoleEnum
- ItemList ici repository 
- Role icin repository
- Role'u user ile mapleme
```java 
//- User altinda olan mapleme
@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
```
WebSecurity