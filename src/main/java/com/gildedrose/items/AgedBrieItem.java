/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gildedrose.items;

import com.gildedrose.items.properties.SellInDays;
import com.gildedrose.items.properties.Quality;

/**
 *
 * @author saulius
 * "Aged Brie" quality increases the older it gets
 */
public class AgedBrieItem extends RegularItem {

    public AgedBrieItem(Quality quality, SellInDays sellIn) {
        super(quality, sellIn);
    }

    @Override
    public void updateQuality() {
        quality.increase();
        sellIn.decrement();
    }
}
