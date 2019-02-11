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
public class BackstagePassesItem extends RegularItem {

    public BackstagePassesItem(Quality quality, SellInDays sellIn) {
        super(quality, sellIn);
    }

    @Override
    public void updateQuality() {
        quality.increase();
        // Quality increases by 2 when there are 10 days or less
        if (sellIn.isElevenDaysBeforeConcert()) {
            quality.increase();
        }
        // Quality increases by 3 when there are 5 days or less
        if (sellIn.isFiveDaysBeforeConcert()) {
            quality.increase();
        }
        sellIn.decrement();
        // but Quality drops to 0 after the concert
        if (sellIn.IsOverdue()) {
            quality.setQuality(0);
        }
    }
}
