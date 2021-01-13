package com.deniz.Entities;

import java.util.PriorityQueue;
import java.util.Random;


public class Cheff {
    private String cheffName;
    private Order order;
    private boolean isAvailable;
    private PriorityQueue<Integer> pQueue;
    private final Random rnd = new Random();
    private Waiter[] waiterList;

    public Cheff(String cheffName) {
        this.cheffName = cheffName;
        isAvailable = true;
    }


    public void setOrder(Order order) {
        this.order = order;
        isAvailable = false;
        prepareOrder();
    }

    public String getCheffName() {
        return cheffName;
    }

    public void setCheffName(String cheffName) {
        this.cheffName = cheffName;
    }


    public boolean isAvailable() {
        return isAvailable;
    }


    private void prepareOrder() {
        pQueue = new PriorityQueue<>();

        int orderSize = order.getOrderName();

        for (int i = 0; i < orderSize; i++) {
            pQueue.add(rnd.nextInt(1000));
        }
        sendOrder();
    }

    private void sendOrder() {
        Waiter availableWaiter = searchAvailableWaiter();
        availableWaiter.setCookIsReady(pQueue, order);
        System.out.println(order.getOrderName() + " hazir. ");
        isAvailable = true;

    }

    private Waiter searchAvailableWaiter() {
        int i = 0;
        while (true) {
            if (waiterList[i].isAvailable()) return waiterList[i];
            if (i < waiterList.length) i++;
            else i = 0;
        }
    }


    public void setWaiterList(Waiter[] waiterList) {
        this.waiterList = waiterList;
    }
}
