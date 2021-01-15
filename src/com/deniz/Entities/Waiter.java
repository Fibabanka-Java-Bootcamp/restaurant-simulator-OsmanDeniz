package com.deniz.Entities;

import java.util.concurrent.PriorityBlockingQueue;

public class Waiter {
    private static final Cheff[] cheffs = {new Cheff("Sef 1"), new Cheff("Sef 2")};
    private static int aditionCount = 0;
    private final String waiterName;
    private Order order;
    private boolean isAvailable;
    private Desk orderDesk;
    private Waiter[] waiters;
    private PriorityBlockingQueue<Integer> pQueue;

    public Waiter(String waiterName) {
        this.waiterName = waiterName;
        isAvailable = true;
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
        createOrder();
    }

    // Musterinin siparisini aldigi yer
    public void setOrderSize(int orderSize) {
        isAvailable = false;
        this.order.setOrderName(orderSize);
        aditionSendToCheff();
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setCookIsReady(PriorityBlockingQueue<Integer> pQueue, Order whichOrder) {
        this.pQueue = pQueue;
        order = whichOrder;
        deliverOrder();
    }

    private void deliverOrder() {
        Customer c = order.getOrderDesk().getCustomerOnDesk();
        c.eat(pQueue);
    }

    public void createOrder() {
        order = new Order("Siparis " + aditionCount++, orderDesk);
    }

    private void aditionSendToCheff() {
        int i = 0;
        while (true) {
            if (cheffs[i].isAvailable()) {
                System.out.println(waiterName + " " + (i + 1) + ".sefe siparisi iletti");
                cheffs[i].setWaiterList(waiters);
                cheffs[i].setOrder(order, this);
                break;
            }
            if (i < cheffs.length - 1) i++;
            else i = 0;
        }
    }
}
