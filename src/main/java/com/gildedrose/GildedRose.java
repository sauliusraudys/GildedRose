package com.gildedrose;

import com.gildedrose.items.*;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item i : items) {
            RegularItem src;
            switch (i.name) {
                case "Aged Brie":
                    src = new AgedBrieItem(i.name, i.sellIn, i.quality);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    src = new SulfurasBrieItem(i.name, i.sellIn, i.quality);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    src = new BackstagePassesItem(i.name, i.sellIn, i.quality);
                    break;
                case "Conjured Mana Cake":
                    src = new ConjuredItem(i.name, i.sellIn, i.quality);
                    break;
                default:
                    src = new RegularItem(i.name, i.sellIn, i.quality);
            }
            Item dest = src.updateQuality();
            i.quality = dest.quality;
            i.sellIn = dest.sellIn;
        }
    }
}
