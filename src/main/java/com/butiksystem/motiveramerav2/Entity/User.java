package com.butiksystem.motiveramerav2.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;


@Entity
@Table(name ="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Namn får inte vara tom")
    @Size(min = 2, max = 30, message="Måste vara mellan 2-30 tecken")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email får inte vara tom")
    @Email(message = "Email måste vara i rätt format")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Lösenord får inte vara tomt")
    @Size(min = 6, message = "Lösenord måste vara minst 6 tecken")
    @Column (nullable = false)
    private String password;

    @NotBlank(message = "Du måste välja kontotyp")
    @Column (nullable = false)
    private String Role;

   @Column
   @Min(value = 0)
    private int points = 0;
    // viktigt att testa att den börjar som 0 men sen ändras när man får poöng.

    @Column (name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    public User () {}

    public User(String name, String email, String password, String role ) {

        this.name = name;
        this.email = email;
        this.password = password;
        Role = role;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
