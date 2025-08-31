package com.butiksystem.motiveramerav2.Entity;

import jakarta.persistence.*;

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

    public Reward() {}

    public Reward(String name, int costInPoints) {
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
}
