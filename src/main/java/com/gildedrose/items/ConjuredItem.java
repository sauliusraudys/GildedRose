/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gildedrose.items;

import com.gildedrose.Item;

/**
 *
 * @author saulius
 */
public class ConjuredItem extends RegularItem {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public Item updateQuality() {
        // "Conjured" items degrade in Quality twice as fast as normal items
        decreaseQualityTwice();
        decrementSellInDays();
        if (sellIn < 0) {
            decreaseQualityTwice();
        }
        return this;
    }
    
    private void decreaseQualityTwice() {
        decreaseQuality();
        decreaseQuality();
    }
}
