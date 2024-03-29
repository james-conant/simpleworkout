package com.simpleworkoutservice.simpleworkoutservice.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "workouts")
public class Workout extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    private User user;
    @JoinColumn(name = "user_id", referencedColumnName = "id")

    @Column(name = "name")
    private String name;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "exercises_workouts", joinColumns = @JoinColumn(name = "workout_id"), inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private Set<Exercise> exercises = new HashSet<>();

    public Workout() {
    }

    public Workout(int id, User user, String name, Set<Exercise> exercises) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.exercises = exercises;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", exercises='" + exercises + '\'' +
                ", createdAt=" + getCreatedAt() +
                '}';
    }
}
