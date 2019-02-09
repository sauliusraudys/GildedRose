package com.gildedrose;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;

import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GildedRoseTest {

    @Test
    public void t1RegularItem() {
        // - At the end of each day our system lowers both values for every item
        Item[] items = new Item[]{new Item("Cafe", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("regular item quality mismach", 0, app.items[0].quality);

        // - Once the sell by date has passed, Quality degrades twice as fast
        items = new Item[]{new Item("Cafe", 0, 2)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("regular item quality mismach after sell by date has passed", 0, app.items[0].quality);

        //- The Quality of an item is never negative
        items = new Item[]{new Item("Cafe", 0, 0)};
        app = new GildedRose(items);
        app.updateQuality();
        assertTrue("regular item quality becames negative " + app.items[0].quality, app.items[0].quality > -1);
    }

    @Test
    public void t2AgedBrieItem() {
        // "Aged Brie" actually increases in Quality the older it gets
        Item[] items = new Item[]{new Item("Aged Brie", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie item quality mismach", 2, app.items[0].quality);

        // - The Quality of an item is never more than 50
        items = new Item[]{new Item("Aged Brie", 1, 50)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie item quality mismach", 50, app.items[0].quality);
    }

    @Test
    public void t3SulfurasItem() {
        // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros item quality mismach", 1, app.items[0].quality);
        assertEquals("Sulfuras, Hand of Ragnaros item sellIn mismach", 1, app.items[0].sellIn);
    }

    @Test
    public void t4BackstagePassesItem() {
        // "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        // like Aged Brie 
        assertEquals("Backstage passes to a TAFKAL80ETC concert item quality mismach", 2, app.items[0].quality);
        // Quality increases by 2 when there are 10 days 
        items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 1)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert item quality mismach (less then 10)", 3, app.items[0].quality);
        // Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert item quality mismach (less then 5)", 4, app.items[0].quality);
        // The Quality of an item is never more than 50
        items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert item quality becames more then 50", 50, app.items[0].quality);
        // Quality drops to 0 after the concert
        items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert item quality becames 0 (after the concert)", 0, app.items[0].quality);
    }

    @Test
    public void t5ConjuredItem() {
        // - At the end of each day our system lowers both values for every item
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Mana Cake item quality mismach", 8, app.items[0].quality);

        // - Once the sell by date has passed, Quality degrades twice as fast
        items = new Item[]{new Item("Conjured Mana Cake", 0, 10)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Mana Cake item quality mismach", 6, app.items[0].quality);

        //- The Quality of an item is never negative
        items = new Item[]{new Item("Cafe", 0, 0)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("regular item quality mismach", 0, app.items[0].quality);
        assertTrue("regular item quality becames negative " + app.items[0].quality, app.items[0].quality > -1);

    }
}
