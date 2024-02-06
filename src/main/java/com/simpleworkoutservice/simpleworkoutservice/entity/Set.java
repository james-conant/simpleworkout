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
@Table(name = "sets")
public class Set extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "exercise_id", referencedColumnName = "id")
    private Workout workout;

    @Column(name = "weight")
    private int weight;

    @Column(name = "reps")
    private int reps;

    public Set() {
    }

    public Set(int id, Workout workout, int weight, int reps) {
        this.id = id;
        this.workout = workout;
        this.weight = weight;
        this.reps = reps;
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

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getReps() {
        return this.reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public Set id(int id) {
        setId(id);
        return this;
    }

    public Set workout(Workout workout) {
        setWorkout(workout);
        return this;
    }

    public Set weight(int weight) {
        setWeight(weight);
        return this;
    }

    public Set reps(int reps) {
        setReps(reps);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", workout='" + getWorkout() + "'" +
                ", weight='" + getWeight() + "'" +
                ", reps='" + getReps() + "'" +
                "}";
    }

}
