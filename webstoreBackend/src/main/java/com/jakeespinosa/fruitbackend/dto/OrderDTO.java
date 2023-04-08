package com.jakeespinosa.fruitbackend.dto;

public class OrderDTO {
    private String username;
    private int applesPurchased;
    private int bananasPurchased;
    ;
    private int watermelonPurchased;

    public OrderDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setWatermelonsPurchased(int watermelonPurchased) {
        this.watermelonPurchased = watermelonPurchased;
    }
}
