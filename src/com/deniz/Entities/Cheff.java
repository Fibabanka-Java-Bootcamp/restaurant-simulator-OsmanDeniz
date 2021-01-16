package com.deniz.Entities;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class Cheff {
    private final int cheffID;
    private final Random rnd = new Random();
    private boolean isAvaliable;
    private Order order;
    private Waiter[] waiters;
    private PriorityBlockingQueue<Integer> wrap;

    public Cheff(int cheffID, boolean isAvaliable) {
        this.cheffID = cheffID;
        this.isAvaliable = isAvaliable;
        isAvaliable = false;
        order = null;
    }

    public int getCheffID() {
        return cheffID;
    }

    public boolean isAvaliable() {
        return isAvaliable;
    }

    public void setAvaliable(boolean avaliable) {
        System.out.println("Cheff_" + cheffID + ", " + order.getDesk().getDeskID() + " numarada oturan Musteri_" + order.getDesk().getCustomer().getCustomerID() + "'in siparisini hazirlamak icin mutfaga girdi.");
        isAvaliable = avaliable;
    }

    public void setOrder(Order order) {
        System.out.println("Musteri_" + order.getDesk().getCustomer().getCustomerID() + "'in siparisi Cheff_" + cheffID + "'ye ulasti.");
        this.order = order;
        wrap = new PriorityBlockingQueue<>();
    }

    public void setWaiters(Waiter[] waiters) {
        this.waiters = waiters;
    }

    public PriorityBlockingQueue<Integer> prepareOrder() {
        for (int i = 0; i < order.getWrapSize(); i++) {
            wrap.add(rnd.nextInt(30));
        }
        order.setReady(true);
        isAvaliable = true;
        return wrap;
    }


}
