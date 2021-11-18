package com.example.chickenmemo;

public class SaveData {
    public String customer_name;
    public String items_name;
    public int total_amount;
    public String date_of_order;
    public String balance_amount;
    public int advance_amount;

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getItems_name() {
        return items_name;
    }

    public void setItems_name(String items_name) {
        this.items_name = items_name;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public String getDate_of_order() {
        return date_of_order;
    }

    public void setDate_of_order(String date_of_order) {
        this.date_of_order = date_of_order;
    }

    public String getBalance_amount() {
        return balance_amount;
    }

    public void setBalance_amount(String balance_amount) {
        this.balance_amount = balance_amount;
    }

    public int getAdvance_amount() {
        return advance_amount;
    }

    public void setAdvance_amount(int advance_amount) {
        this.advance_amount = advance_amount;
    }

    public SaveData() {
    }


    public SaveData(String customer_name, String items_name, int total_amount, String date_of_order, String balance_amount, int advance_amount) {
        this.customer_name = customer_name;
        this.items_name = items_name;
        this.total_amount = total_amount;
        this.date_of_order = date_of_order;
        this.balance_amount = balance_amount;
        this.advance_amount = advance_amount;
    }
}
