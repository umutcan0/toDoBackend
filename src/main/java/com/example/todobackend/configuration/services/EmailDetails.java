package com.example.todobackend.configuration.services;

/*import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;*/
public class EmailDetails {

    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;

    public EmailDetails(String recipient, Long verification_slug, String subject) {
        this.recipient = recipient;
        this.msgBody = "www.todoapp.com/auth/verify/"+ verification_slug.toString();
        this.subject = subject;
    }
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
