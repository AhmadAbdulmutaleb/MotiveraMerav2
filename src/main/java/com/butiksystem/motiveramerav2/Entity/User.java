package com.butiksystem.motiveramerav2.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


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



}
