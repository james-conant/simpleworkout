package com.simpleworkoutservice.simpleworkoutservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "workout_id", referencedColumnName = "id")
    private Workout workout;

    @Column(name = "name")
    private String name;

    public Exercise() {
    }

    public Exercise(int id, Workout workout, String name) {
        this.id = id;
        this.workout = workout;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Workout getWorkout() {
        return this.workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
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
                ", workout='" + getWorkout() + "'" +
                ", name='" + getName() + "'" +
                "}";
    }

}
