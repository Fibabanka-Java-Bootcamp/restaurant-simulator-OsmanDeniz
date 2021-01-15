package com.deniz.Manager;

import com.deniz.Entities.Customer;
import com.deniz.Entities.Desk;
import com.deniz.Entities.Waiter;

public class CustomerManager extends Thread {
    static int i = 0;
    Desk[] desks;
    Waiter[] waiters;
    int deskSize = 0;

    public CustomerManager(Desk[] d, Waiter[] w) {
        this.desks = d;
        this.waiters = w;
        deskSize = desks.length;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " basliyor.");
        createAndStartCustomer();
    }

    private synchronized void createAndStartCustomer() {
        int i = 0;
        while (true) {
            Customer c = new Customer(++i);
            selectDesk(c);
            selectWaiter(c);
            if (i == 100) break;
        }

    }

    private synchronized void selectDesk(Customer customer) {
        while (true) {
            if (customer.selectDesk(desks[i])) {
                desks[i].setEmtpy(false);
                break;
            }
            if (i < deskSize - 1) i++;
            else i = 0;
        }
    }

    private synchronized void selectWaiter(Customer customer) {
        int i = 0;
        while (true) {
            if (customer.callWaiter(waiters[i])) {
                waiters[i].setWaiters(waiters);
                customer.setOrderFromDesk();
                break;
            }
            if (i < waiters.length) i++;
            else i = 0;
        }
    }
}
