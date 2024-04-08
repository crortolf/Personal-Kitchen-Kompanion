package com.example.kitchenkompanion;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GroceryItem {
    public String name, units;
    private boolean status;
    public float amount, minimumAmount;

    private GregorianCalendar expiration;

    public GroceryItem(String name, String units, float amount, int[] expiration) {
        this.name = name;
        this.units = units;
        this.amount = amount;
        this.status = false;
        minimumAmount = 0;
        //year month day
        this.expiration = new GregorianCalendar(expiration[0], expiration[1], expiration[2]);
    }

    public GroceryItem(String name, String units, float amount, int[] expiration, float minimumAmount) {
        this(name, units, amount, expiration);
        this.minimumAmount = minimumAmount;
    }

    public String toString() {
        String amountS, minimumAmountS;
        amountS = (amount % 1.0 == 0.0) ? String.valueOf((int) amount) : String.valueOf(amount);
        minimumAmountS = (minimumAmount % 1.0 == 0.0) ? String.valueOf((int) minimumAmount) : String.valueOf(minimumAmount);
        return amountS + " (min " + minimumAmountS + ") " + units  + "(s) of " + name;
    }

    public String amountToString() {
        String amountS;
        amountS = (amount % 1.0 == 0.0) ? String.valueOf((int) amount) : String.valueOf(amount);
        return amountS + " " + units;
    }

    public String getExpiration() {
        return expiration.get(Calendar.MONTH)+"/"+expiration.get(Calendar.DATE)
                +"/"+expiration.get(Calendar.YEAR);
    }

    public String getName() {
        return name;
    }
    public String getUnits() { return units; }
    public float getAmount() { return amount; }
    public boolean getStatus() { return status; }
}
