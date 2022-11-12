package org.example.models;

import javax.persistence.*;

@Entity
@Table(name = "Details")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Cost")
    private int cost;

    @Column(name = "Description")
    private String description;

    public Detail() {}

    public Detail(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public Detail(String name, int cost, String description) {
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
