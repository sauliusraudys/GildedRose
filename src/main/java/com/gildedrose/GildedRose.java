package com.gildedrose;

import com.gildedrose.items.properties.SellInDays;
import com.gildedrose.items.properties.Quality;
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
                    src = new AgedBrieItem(new Quality(i.quality), new SellInDays(i.sellIn));
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    src = new SulfurasBrieItem(new Quality(i.quality), new SellInDays(i.sellIn));
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    src = new BackstagePassesItem(new Quality(i.quality), new SellInDays(i.sellIn));
                    break;
                case "Conjured Mana Cake":
                    src = new ConjuredItem(new Quality(i.quality), new SellInDays(i.sellIn));
                    break;
                default:
                    src = new RegularItem(new Quality(i.quality), new SellInDays(i.sellIn));
            }
            src.updateQuality();
            i.quality = src.getQuality();
            i.sellIn = src.getSellIn();
        }
    }
}
