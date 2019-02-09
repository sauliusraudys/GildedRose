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
        if (quality > 0) {
            quality--;
        }
        sellIn--;
        if (sellIn < 0 && quality > 0) {
            quality--;
        }
        return this;
    }
}
