package com.deniz.Entities;

import java.util.PriorityQueue;
import java.util.Random;

public class Customer {

    private int customerId;
    private Desk customerDesk;
    private Desk tempDesk;
    private Waiter customerWaiter;
    private Random rnd;


    public Customer(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    public boolean selectDesk(Desk desk) {
        if (desk.isEmtpy()) {
            this.customerDesk = desk;
            tempDesk = desk;
            System.out.println("Musteri"+customerId+", "+desk.getDeskName() + "\'e oturdu.");
            return true;
        }
        return false;
    }

    public boolean callWaiter(Waiter waiter) {
        if (waiter.isAvailable()) {
            this.customerWaiter = waiter;
            customerWaiter.setOrderDesk(tempDesk);
            customerDesk.setCustomerOnDesk(this);
            System.out.println("Musteri"+customerId+", "+waiter.getWaiterName() + "\'i cagirdi.");
            return true;
        }
        return false;
    }

    // Musterinin siparis verme kismi
    public void setOrderDesk() {
        customerWaiter.setOrderSize(9);//rnd.nextInt(100));
    }

    public void eat(PriorityQueue<Integer> pQueue){
        System.out.print(pQueue.poll()+" ");
    }

}