package com.example.mytrueapplication;

public class SingletonPriceCart {


    private static SingletonPriceCart instance;

    public static SingletonPriceCart getInstance() {
        if (instance == null)
            instance = new SingletonPriceCart();
        return instance;
    }

    private SingletonPriceCart() {
    }

    private String val;

    public String getValue() {
        return val;
    }

    public void setValue(String value) {
        this.val = value;
    }
}
