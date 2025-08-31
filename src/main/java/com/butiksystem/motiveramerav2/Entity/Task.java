package com.butiksystem.motiveramerav2.Entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String status;

    @Column (name = "created_date")
    private LocalDateTime createdDate;

    @Column (name = "point_reward")
    private int pointRedward;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Task(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }

    public Task() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public int getPointRedward() {
        return pointRedward;
    }

    public void setPointRedward(int pointRedward) {
        this.pointRedward = pointRedward;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
