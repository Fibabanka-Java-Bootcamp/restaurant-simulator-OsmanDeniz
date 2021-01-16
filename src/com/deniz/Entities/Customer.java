package com.deniz.Entities;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class Customer {
    private final int customerID;
    private boolean isSit;
    private boolean isServiceOpen;
    private final Random rnd = new Random();

    public Customer(int customerID, boolean isSit) {
        this.customerID = customerID;
        this.isSit = isSit;
        this.isServiceOpen = false;
    }

    public boolean selectDesk(Desk customerDesk) {
        if (customerDesk.isAvaliable()) {
            System.out.println("Musteri_" + customerID + ", Masa_" + customerDesk.getDeskID() + "'e oturdu.");
            return true;
        }
        return false;
    }

    public boolean callWaiter(Waiter waiter) {
        if (waiter.isAvaliable()) {
            System.out.println("Musteri_" + customerID + ", Garson_" + waiter.getWaiterID() + "'i cagirdi.");
            return true;
        }
        return false;
    }

    public void eatWrap(PriorityBlockingQueue<Integer> wrap) {
        System.out.println("\nMusteri_" + customerID + "'nin durumu eline ulasti, kurt gibi acikmis olmali ki boyle istahli yiyor.");
        while (!wrap.isEmpty())
            System.out.print(wrap.poll() + " ");
    }

    public int getWrapSize() {
        return rnd.nextInt(40);
    }

    public int getCustomerID() {
        return customerID;
    }

    public boolean isSit() {
        return isSit;
    }

    public void setSit(boolean sit) {
        isSit = sit;
    }

    public boolean isServiceOpen() {
        return isServiceOpen;
    }

    public void setServiceOpen(boolean serviceOpen) {
        isServiceOpen = serviceOpen;
    }
}
