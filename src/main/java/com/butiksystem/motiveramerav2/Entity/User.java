package com.butiksystem.motiveramerav2.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import com.butiksystem.motiveramerav2.Entity.Role;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


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

    @NotNull(message = "Du måste välja kontotyp")
    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ParentStudentRelationship> student = new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ParentStudentRelationship> parent = new HashSet<>();

   @Column
   @Min(value = 0)
    private int points = 0;
    // viktigt att testa att den börjar som 0 men sen ändras när man får poöng.

    @Column (name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();



    public User () {}

    public User(String name, String email, String password, Role role ) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<ParentStudentRelationship> getStudent() {
        return student;
    }

    public void setStudent(Set<ParentStudentRelationship> student) {
        this.student = student;
    }

    public Set<ParentStudentRelationship> getParent() {
        return parent;
    }

    public void setParent(Set<ParentStudentRelationship> parent) {
        this.parent = parent;
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
