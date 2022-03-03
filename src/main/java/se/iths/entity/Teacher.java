package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.json.bind.annotation.JsonbTransient;


@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @NotNull
    @Size(min = 2)
    private String firstName;

    @NotEmpty
    @NotNull
    @Size(min = 2)
    private String lastName;

    @NotEmpty
    @NotNull
    @Size(min = 2)
    private String email;

    private String phoneNumber;
    @ManyToOne
    private Subject subject;
    public Teacher(String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Teacher() {
    }

    @JsonbTransient
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}