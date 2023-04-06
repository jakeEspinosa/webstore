package com.jakeespinosa.fruitbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "apples")
    private int apples;

    @Column(name = "bananas")
    private int bananas;

    @Column(name = "watermelons")
    private int watermelons;

    public Cart() {

    }

    public Cart(Cart cart) {
        username = cart.getUsername();
        apples = cart.getApples();
        bananas = cart.getBananas();
        watermelons = cart.getWatermelons();
    }

    public Cart(String username, int apples, int bananas, int watermelons) {
        this.username = username;
        this.apples = apples;
        this.bananas = bananas;
        this.watermelons = watermelons;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getApples() {
        return apples;
    }

    public void setApples(int apples) {
        this.apples = apples;
    }

    public int getBananas() {
        return bananas;
    }

    public void setBananas(int bananas) {
        this.bananas = bananas;
    }

    public int getWatermelons() {
        return watermelons;
    }

    public void setWatermelons(int watermelons) {
        this.watermelons = watermelons;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "username='" + username + '\'' +
                ", apples=" + apples +
                ", bananas=" + bananas +
                ", watermelons=" + watermelons +
                '}';
    }
}