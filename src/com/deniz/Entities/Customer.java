package com.deniz.Entities;

import java.util.PriorityQueue;
import java.util.Random;

public class Customer {

    private int customerId;
    private Desk customerDesk;
    private Desk tempDesk;
    private Waiter customerWaiter;
    private final Random rnd = new Random();


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
            System.out.println("Musteri_" + customerId + ", " + desk.getDeskName() + "'e oturdu.");

            return true;
        }
        return false;
    }

    public boolean callWaiter(Waiter waiter) {
        if (waiter.isAvailable()) {
            this.customerWaiter = waiter;
            customerWaiter.setOrderDesk(tempDesk);
            customerDesk.setCustomerOnDesk(this);
            System.out.println("Musteri_" + customerId + ", " + waiter.getWaiterName() + "'i cagirdi.");
            return true;
        }
        return false;
    }

    // Musterinin siparis verme kismi
    public void setOrderFromDesk() {
        customerWaiter.setOrderSize(rnd.nextInt(50));
    }

    public void eat(PriorityQueue<Integer> pQueue) {
        System.out.println("Musteri_" + customerId + " yemegini yemeye basladi.");
        while (!pQueue.isEmpty())
            System.out.print(pQueue.poll() + " ");
        System.out.println("Musteri_" + customerId + " yemegini bitirdi.");
        System.out.println("===============  ========= ===============");
    }

}