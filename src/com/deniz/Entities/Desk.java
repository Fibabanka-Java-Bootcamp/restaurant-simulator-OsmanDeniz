package com.deniz.Entities;

public class Desk {
    private String deskName;
    private int spendTime;
    private boolean isEmtpy;

    public Customer getCustomerOnDesk() {
        return customerOnDesk;
    }

    private Customer customerOnDesk;


    public void setCustomerOnDesk(Customer customerOnDesk) {
        this.customerOnDesk = customerOnDesk;
    }


    public boolean isEmtpy() {
        return isEmtpy;
    }

    public void setEmtpy(boolean emtpy) {
        isEmtpy = emtpy;
    }

    public Desk(String name) {

        this.deskName = name;
        spendTime = 1000;
        isEmtpy = true;
    }

    public String getDeskName() {
        return deskName;
    }
}
