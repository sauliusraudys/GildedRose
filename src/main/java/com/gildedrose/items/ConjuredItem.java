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
public class ConjuredItem extends RegularItem {

    public ConjuredItem(Quality quality, SellInDays sellIn) {
        super(quality, sellIn);
    }

    @Override
    public void updateQuality() {
        // "Conjured" items degrade in Quality twice as fast as normal items
        decreaseQualityTwice();
        sellIn.decrement();
        if (sellIn.IsOverdue()) {
            decreaseQualityTwice();
        }
    }
    
    private void decreaseQualityTwice() {
        quality.decrease();
        quality.decrease();
    }
}
