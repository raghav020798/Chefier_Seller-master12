package com.app.ryanbansal.uidesign;


/**
 * Created by RyanBansal on 12/7/17.
 */

public class Order {

    private String quantity;

    private String dish;

    private String address;

    public Order() {
    }

    public Order(String quantity, String dish, String address) {
        this.quantity = quantity;
        this.dish = dish;
        this.address = address;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getDish() {
        return dish;
    }

    public String getAddress() {
        return address;
    }
}
