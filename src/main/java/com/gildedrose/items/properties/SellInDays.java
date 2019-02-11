/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gildedrose.items.properties;

/**
 *
 * @author saulius
 */
public class SellInDays {

    int sellIn;

    public SellInDays(int sellIn) {
        this.sellIn = sellIn;
    }

    public void decrement() {
        sellIn = sellIn - 1;
    }

    public int getSellIn() {
        return sellIn;
    }

    public boolean IsOverdue() {
        return sellIn < 0;
    }
    
    public boolean isElevenDaysBeforeConcert() {
        return sellIn < 11;
    }
    public boolean isFiveDaysBeforeConcert() {
        return sellIn < 6;
    }

}
