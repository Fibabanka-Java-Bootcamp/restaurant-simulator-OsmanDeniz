package com.deniz.Entities;

public class Waiter {
    private final int waiterID;
    private boolean isAvaliable;

    public Waiter(int waiterID, boolean isAvaliable) {
        this.waiterID = waiterID;
        this.isAvaliable = isAvaliable;
    }

    public int getWaiterID() {
        return waiterID;
    }

    public Waiter changeState() {
        this.setAvaliable(!this.isAvaliable);

        return this;
    }

    public boolean isAvaliable() {
        return isAvaliable;
    }

    private void setAvaliable(boolean avaliable) {
        isAvaliable = avaliable;
    }
}
