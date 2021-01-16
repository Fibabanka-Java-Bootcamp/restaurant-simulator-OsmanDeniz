package com.deniz.Entities;

public class Desk {
    private boolean isAvaliable;
    private final int deskID;
    private Customer customer;

    public Desk(int deskID, boolean isAvaliable) {
        this.deskID = deskID;
        this.isAvaliable = isAvaliable;
    }

    public Desk changeState() {
        this.setAvaliable(!this.isAvaliable);
        return this;
    }

    public boolean isAvaliable() {
        return isAvaliable;
    }

    private void setAvaliable(boolean avaliable) {
        isAvaliable = avaliable;
    }

    public int getDeskID() {
        return deskID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
