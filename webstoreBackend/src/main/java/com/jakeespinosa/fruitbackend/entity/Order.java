package com.jakeespinosa.fruitbackend.entity;

import jakarta.persistence.*;
import java.time.Instant;

/* to do:
    return order details
    check if items are in stock
        decrement database if so
        throw error if not
 */

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="time_stamp")
    private long timeStamp;

    @Column(name="apples_purchased")
    private int applesPurchased;

    @Column(name="bananas_purchased")
    private int bananasPurchased;

    @Column(name="watermelon_purchased")
    private int watermelonsPurchased;

    public Order() {

    }

    public Order(long timeStamp, int applesPurchased, int bananasPurchased, int watermelonsPurchased) {
        this.timeStamp = timeStamp;
        this.applesPurchased = applesPurchased;
        this.bananasPurchased = bananasPurchased;
        this.watermelonsPurchased = watermelonsPurchased;
    }

    public Order(int applesPurchased, int bananasPurchased, int watermelonsPurchased) {
        this.applesPurchased = applesPurchased;
        this.bananasPurchased = bananasPurchased;
        this.watermelonsPurchased = watermelonsPurchased;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getApplesPurchased() {
        return applesPurchased;
    }

    public void setApplesPurchased(int applesPurchased) {
        this.applesPurchased = applesPurchased;
    }

    public int getBananasPurchased() {
        return bananasPurchased;
    }

    public void setBananasPurchased(int bananasPurchased) {
        this.bananasPurchased = bananasPurchased;
    }

    public int getWatermelonsPurchased() {
        return watermelonsPurchased;
    }

    public void setWatermelonsPurchased(int watermelonsPurchased) {
        this.watermelonsPurchased = watermelonsPurchased;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", timeStamp=" + timeStamp +
                ", applesPurchased=" + applesPurchased +
                ", bananasPurchased=" + bananasPurchased +
                ", watermelonsPurchased=" + watermelonsPurchased +
                '}';
    }

    @PrePersist
    private void onCreate() {
        timeStamp = Instant.now().getEpochSecond();
    }
}
