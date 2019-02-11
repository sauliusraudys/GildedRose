/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gildedrose.items.properties;

/**
 *
 * @author saulius
 */
public class Quality {

    int quality;

    public Quality(int quality) {
        this.quality = quality;
    }

    public void decrease() {
         // The Quality of an item is never negative
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    public void increase() {
        // The Quality of an item is never more than 50
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

}
