package com.deniz.Manager;

import com.deniz.Entities.Customer;
import com.deniz.Entities.Desk;
import com.deniz.Entities.Waiter;

public class CustomerManager {
    Desk[] desks;
    Waiter[] waiters;


    public CustomerManager(Desk[] d, Waiter[] w) {
        this.desks = d;
        this.waiters = w;

    }

    public void createAndStartCustomer() {
        int i = 0;
        while (true) {
            Customer c = new Customer(++i);
            selectDesk(c);
            selectWaiter(c);
            if (i == 100) break;
        }

    }

    private void selectDesk(Customer customer) {
        int i = 0;
        while (true) {
            if (customer.selectDesk(desks[i])) {
                desks[i].setEmtpy(false);
                break;
            }
            if (i < desks.length) i++;
            else i = 0;
        }
    }

    private void selectWaiter(Customer customer) {

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
