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
 */
public class RegularItem {

    Quality quality;
    SellInDays sellIn;

    public RegularItem(Quality quality, SellInDays sellIn) {
        this.quality = quality;
        this.sellIn = sellIn;
    }

    public void updateQuality() {
        quality.decrease();
        sellIn.decrement();
        if (sellIn.IsOverdue()) {
            quality.decrease();
        }
    }

    public int getQuality() {
        return quality.getQuality();
    }

    public int getSellIn() {
        return sellIn.getSellIn();
    }
    

}
