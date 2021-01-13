package org.kodluyoruz;

import com.deniz.Entities.Customer;
import com.deniz.Entities.Desk;
import com.deniz.Entities.Waiter;

public class Main {

    public static void main(String[] args) {
        // =============== CUSTOMER ===================
        Customer c1 = new Customer(1);
        // =============== DESKS ===================
        Desk[] desks = {new Desk("Masa1"), new Desk("Masa2"), new Desk("Masa3"), new Desk("Masa4"), new Desk("Masa5")};
        // =============== WAITER ===================
        Waiter[] waiters = {new Waiter("Garson1"), new Waiter("Garson2"), new Waiter("Garson3")};
        // =============== ========= ===================


        int i = 0;
        while (true) {
            if (c1.selectDesk(desks[i])) break;
            if (i < desks.length) i++;
            else i = 0;
        }

        i = 0;
        while (true) {

            if (c1.callWaiter(waiters[i])) {
                waiters[i].setWaiters(waiters);
                c1.setOrderDesk();
                break;
            }
            if (i < waiters.length) i++;
            else i = 0;
        }


    }
}
