package com.butiksystem.motiveramerav2.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Reward {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false)
    private String name;

    @Column(nullable = false)
    private int costInPoints;

    @ManyToOne
    @JoinColumn(name = "for_child_id")
    private User forStudent;  // Vilket barn får denna reward

    @ManyToOne
    @JoinColumn(name = "created_by_parent_id")
    private User createdByParent;  // Vilken förälder skapade den

    @Column (nullable = false)
    private boolean claimed = false;

    @Column (name = "claimed_date")
    private LocalDateTime claimedDate;

    public Reward() {}

    public Reward(String name, int costInPoints, User forStudent, User createdByParent) {
        this.name = name;
        this.costInPoints = costInPoints;
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

    public int getCostInPoints() {
        return costInPoints;
    }

    public void setCostInPoints(int costInPoints) {
        this.costInPoints = costInPoints;
    }

    public User getForStudent() {
        return forStudent;
    }

    public void setForStudent(User forStudent) {
        this.forStudent = forStudent;
    }

    public User getCreatedByParent() {
        return createdByParent;
    }

    public void setCreatedByParent(User createdByParent) {
        this.createdByParent = createdByParent;
    }

    public boolean isClaimed() {
        return claimed;
    }

    public void setClaimed(boolean claimed) {
        this.claimed = claimed;
    }

    public LocalDateTime getClaimedDate() {
        return claimedDate;
    }

    public void setClaimedDate(LocalDateTime claimedDate) {
        this.claimedDate = claimedDate;
    }
}
