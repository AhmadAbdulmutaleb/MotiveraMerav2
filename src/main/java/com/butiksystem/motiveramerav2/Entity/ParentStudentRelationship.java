package com.butiksystem.motiveramerav2.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "parent_student_relationships",
        uniqueConstraints = @UniqueConstraint(columnNames = {"parent_id", "student_id"}))
public class ParentStudentRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    private User parent;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    public ParentStudentRelationship() {}

    public ParentStudentRelationship(User parent, User student) {
        this.parent = parent;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }
}
