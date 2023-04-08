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
    private int watermelonPurchased;

    public Order() {

    }

    public Order(long timeStamp, int applesPurchased, int bananasPurchased, int watermelonPurchased) {
        this.timeStamp = timeStamp;
        this.applesPurchased = applesPurchased;
        this.bananasPurchased = bananasPurchased;
        this.watermelonPurchased = watermelonPurchased;
    }

    public Order(int applesPurchased, int bananasPurchased, int watermelonPurchased) {
        this.applesPurchased = applesPurchased;
        this.bananasPurchased = bananasPurchased;
        this.watermelonPurchased = watermelonPurchased;
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

    public int getWatermelonPurchased() {
        return watermelonPurchased;
    }

    public void setWatermelonPurchased(int watermelonPurchased) {
        this.watermelonPurchased = watermelonPurchased;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", timeStamp=" + timeStamp +
                ", applesPurchased=" + applesPurchased +
                ", bananasPurchased=" + bananasPurchased +
                ", watermelonPurchased=" + watermelonPurchased +
                '}';
    }

    @PrePersist
    private void onCreate() {
        timeStamp = Instant.now().getEpochSecond();
    }
}
