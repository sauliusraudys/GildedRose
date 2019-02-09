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
 * "Aged Brie" quality increases the older it gets
 */
public class AgedBrieItem extends RegularItem {

    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public Item updateQuality() {
        if (quality < 50) {
            quality++;
        }
        sellIn--;
        return this;
    }
}
