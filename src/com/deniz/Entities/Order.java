package com.deniz.Entities;

public class Order {
    private final String aditionName;
    private final Desk orderDesk;
    private boolean isReady;
    private int orderName;


    public Order(String aditionName, Desk orderDesk) {
        this.aditionName = aditionName;
        this.orderDesk = orderDesk;
        isReady = false;

    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public Desk getOrderDesk() {
        return orderDesk;
    }

    public int getOrderName() {
        return orderName;
    }

    public void setOrderName(int orderName) {
        this.orderName = orderName;
    }
}
