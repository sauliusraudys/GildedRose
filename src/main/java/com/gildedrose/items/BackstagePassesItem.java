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
public class BackstagePassesItem extends RegularItem {

    public BackstagePassesItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public Item updateQuality() {
        increaseQuality();
        // Quality increases by 2 when there are 10 days or less
        if (sellIn < 11) {
            increaseQuality();
        }
        // Quality increases by 3 when there are 5 days or less
        if (sellIn < 6) {
            increaseQuality();
        }
        decrementSellInDays();
        // but Quality drops to 0 after the concert
        if (sellIn < 0) {
            quality=0;
        }
        return this;
    }
}
