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
public class LiftSet extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "week_id")
    private int week_id;

    @Column(name = "workout_id")
    private int workout_id;

    @Column(name = "exercise_id")
    private int exercise_id;

    @Column(name = "weight")
    private int weight;

    @Column(name = "reps")
    private int reps;

    public LiftSet() {
    }

    public LiftSet(int id, int week_id, int workout_id, int exercise_id, int weight, int reps) {
        this.id = id;
        this.week_id = week_id;
        this.workout_id = workout_id;
        this.exercise_id = exercise_id;
        this.weight = weight;
        this.reps = reps;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeekId() {
        return this.week_id;
    }

    public void setWeekId(int week_id) {
        this.week_id = week_id;
    }

    public int getWorkoutId() {
        return this.workout_id;
    }

    public void setWorkoutId(int workout_id) {
        this.workout_id = workout_id;
    }

    public int getExerciseId() {
        return this.exercise_id;
    }

    public void setExerciseId(int exercise_id) {
        this.exercise_id = exercise_id;
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

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", week_id='" + getWeekId() + "'" +
                ", workout_id='" + getWorkoutId() + "'" +
                ", exercise_id='" + getExerciseId() + "'" +
                ", weight='" + getWeight() + "'" +
                ", reps='" + getReps() + "'" +
                "}";
    }

}
