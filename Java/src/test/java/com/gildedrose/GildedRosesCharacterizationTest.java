package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRosesCharacterizationTest {

    @Test
    @DisplayName("Sulfuras stay unchanged")
    void sulfuras() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(10, item.getSellIn());
        assertEquals(10, item.getQuality());
    }

    @Test
    @DisplayName("Aged Brie with quality over 50 and sellIn over 0")
    void brie1() {
        Item item = new Item("Aged Brie", 10, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(9, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

    @Test
    @DisplayName("Aged Brie with quality under 50 and sellIn over 0")
    void brie2() {
        Item item = new Item("Aged Brie", 10, 48);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(9, item.getSellIn());
        assertEquals(49, item.getQuality());
    }

    @Test
    @DisplayName("Aged Brie with quality under 50 and sellIn under 0")
    void brie3() {
        Item item = new Item("Aged Brie", -1, 48);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(-2, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

    @Test
    @DisplayName("Aged Brie with quality 50 and sellIn under 0")
    void brie4() {
        Item item = new Item("Aged Brie", -1, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(-2, item.getSellIn());
        assertEquals(50, item.getQuality());
    }


    @Test
    @DisplayName("Backstage pass with quality over 50")
    void backstage1() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(9, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

    @Test
    @DisplayName("Backstage pass with quality under 50 and sellIn over 10")
    void backstage2() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 49);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(10, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

    @Test
    @DisplayName("Backstage pass with quality 49 and sellIn between 6 and 10")
    void backstage3() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 49);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(5, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

    @Test
    @DisplayName("Backstage pass with quality under 49 and sellIn between 6 and 10")
    void backstage4() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 48);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(5, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

    @Test
    @DisplayName("Backstage pass with quality 49 and sellIn under 6")
    void backstage5() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(4, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

    @Test
    @DisplayName("Backstage pass with quality 48 and sellIn under 6")
    void backstage6() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(4, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

    @Test
    @DisplayName("Backstage pass with quality under 48 and sellIn under 6")
    void backstage7() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 14);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(4, item.getSellIn());
        assertEquals(17, item.getQuality());
    }

    @Test
    @DisplayName("Backstage pass with sellIn below 0")
    void backstage8() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 14);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(-2, item.getSellIn());
        assertEquals(0, item.getQuality());
    }
    @Test
    @DisplayName("Backstage pass sellIn temporal coupling")
    void backstage9() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 24);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(10, item.getSellIn());
        assertEquals(25, item.getQuality());
    }

    @Test
    @DisplayName("Generic item with sellIn and quality greater than 0")
    void generic1() {
        Item item = new Item("An Item", 10, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(9, item.getSellIn());
        assertEquals(9, item.getQuality());
    }

    @Test
    @DisplayName("Generic item with sellIn > 0 and quality 0")
    void generic2() {
        Item item = new Item("An Item", 10, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(9, item.getSellIn());
        assertEquals(0, item.getQuality());
    }

    @Test
    @DisplayName("Generic item with sellIn < 0 and quality > 0")
    void generic3() {
        Item item = new Item("An Item", -1, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(-2, item.getSellIn());
        assertEquals(8, item.getQuality());
    }
}
