package hu.ibello.demo.model;

import hu.ibello.core.Description;
import hu.ibello.data.Model;

@Model
@Description("Test data for sending message")
public class ContactData {

    private String name;
    private String email;
    private String subject;
    private String message;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
