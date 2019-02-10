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
public class RegularItem extends Item {

    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public Item updateQuality() {
        decreaseQuality();
        decrementSellInDays();
        decreaseQualityTwiceOnceSellByDateHasPassed();
        return this;
    }

    protected void decreaseQuality() {
        // The Quality of an item is never negative
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    protected void decrementSellInDays() {
        sellIn = sellIn - 1;
    }

    protected void decreaseQualityTwiceOnceSellByDateHasPassed() {
        if (sellIn < 0 && quality > 0) {
            decreaseQuality();
        }
    }

    protected void increaseQuality() {
        // The Quality of an item is never more than 50
        if (quality < 50) {
            quality = quality + 1;
        }
    }
}
