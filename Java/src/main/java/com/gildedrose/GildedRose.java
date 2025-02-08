package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /*
      1. Nested if -> code less nested
          1.1 reversing if condition
          1.2 introduce guard clauses
      2. similar if conditions and then extract methods
      3. introduce constant for magic literals, find duplications and extract them
     */
    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(AGED_BRIE)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0 && item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.name.equals(BACKSTAGE)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                    if (item.sellIn < 11 && item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                    if (item.sellIn < 6 && item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    item.quality = 0;
                }
            }

            if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE) && !item.name.equals(SULFURAS)) {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }

                item.sellIn = item.sellIn - 1;

                if (item.quality > 0 && item.sellIn < 0) {
                    item.quality = item.quality - 1;
                }
            }
        }
    }
}
