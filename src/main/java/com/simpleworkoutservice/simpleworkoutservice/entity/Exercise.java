package com.simpleworkoutservice.simpleworkoutservice.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int user_id;

    @JsonBackReference
    @ManyToMany(mappedBy = "exercises")
    private Set<Workout> workouts = new HashSet<>();

    @Column(name = "name")
    private String name;

    public Exercise() {
    }

    public Exercise(int id, int user_id, Set<Workout> workouts, String name) {
        this.id = id;
        this.user_id = user_id;
        this.workouts = workouts;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public Set<Workout> getWorkouts() {
        return this.workouts;
    }

    public void setWorkout(Set<Workout> workouts) {
        this.workouts = workouts;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                " user_id='" + getUserId() + "'" +
                ", workouts='" + getWorkouts() + "'" +
                ", name='" + getName() + "'" +
                "}";
    }

}
