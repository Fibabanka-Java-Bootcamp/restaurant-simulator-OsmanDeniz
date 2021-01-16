package org.kodluyoruz;

import com.deniz.Entities.Customer;
import com.deniz.Entities.Desk;
import com.deniz.Entities.Waiter;
import com.deniz.Threads.CustomerThread;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Desk[] desks = {
                new Desk(1, false),
                new Desk(2, false),
                new Desk(3, true)};

        Waiter[] waiters = {
                new Waiter(1, false),
                new Waiter(2, false),
                new Waiter(3, true)};


        Customer c = new Customer(1, false);
        Customer c2 = new Customer(2, false);

        CustomerThread thread = new CustomerThread(c, desks, waiters);
        CustomerThread thread2 = new CustomerThread(c2, desks, waiters);

        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

    }


}

