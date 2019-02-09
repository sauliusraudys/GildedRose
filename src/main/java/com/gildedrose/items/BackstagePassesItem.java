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
        if (quality < 50) {
            quality++;
        }
        if (sellIn < 11 && quality < 50) {
            quality++;
        }
        if (sellIn < 6 && quality < 50) {
            quality++;
        }
        sellIn--;
        if (sellIn < 0) {
            quality=0;
        }
        return this;
    }
}
