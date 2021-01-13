package com.deniz.Entities;

import java.util.PriorityQueue;

public class Waiter {
    private static int aditionCount = 0;
    private static final Cheff[] cheffs = {new Cheff("Sef 1"), new Cheff("Sef 2")};
    private final String waiterName;
    private Order order;
    private boolean isAvailable;
    private Desk orderDesk;
    private Waiter[] waiters;
    private PriorityQueue<Integer> pQueue;

    public Waiter(String waiterName) {
        this.waiterName = waiterName;
        isAvailable = true;
        createOrder();
    }

    public void setWaiters(Waiter[] waiters) {
        this.waiters = waiters;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    // Musteri masa sectigi zaman atamasi yapiliyor.

    public void setOrderDesk(Desk orderDesk) {
        this.orderDesk = orderDesk;
    }
    // Musterinin siparisini aldigi yer

    public void setOrderSize(int orderSize) {
        this.order.setOrderName(orderSize);
        aditionSendToCheff();
    }
    public String getWaiterName() {
        return waiterName;
    }

    public void setCookIsReady(PriorityQueue<Integer> pQueue, Order whichOrder) {
        this.pQueue = pQueue;
        order = whichOrder;
        deliverOrder();
    }

    private void deliverOrder() {
        Customer c = orderDesk.getCustomerOnDesk();
        c.eat(pQueue);
    }

    public void createOrder() {
        order = new Order("Siparis " + aditionCount++, orderDesk);
    }

    private void aditionSendToCheff() {
        int i = 0;
        while (true) {
            if (cheffs[i].isAvailable()) {
                cheffs[i].setWaiterList(waiters);
                cheffs[i].setOrder(order);
                break;
            }
            if (i < cheffs.length) i++;
            else i = 0;
        }
    }
}
