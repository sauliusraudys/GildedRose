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
 * "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
 */
public class SulfurasBrieItem extends RegularItem {

    public SulfurasBrieItem(Quality quality, SellInDays sellIn) {
        super(quality, sellIn);
    }

    @Override
    public void updateQuality() {
        // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
        // it means - do nothing
    }
}
