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
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals(AGED_BRIE) || items[i].name.equals(BACKSTAGE)) {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(BACKSTAGE)) {
                        if (items[i].sellIn < 11 && items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                        if (items[i].sellIn < 6 && items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                }
            } else {
                if (items[i].quality > 0) {
                    if (items[i].name.equals(SULFURAS)) {
                        continue;
                    } else {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            }

            if (items[i].name.equals(SULFURAS)) {
                continue;
            } else {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (items[i].name.equals(AGED_BRIE)) {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                } else {
                    if (items[i].name.equals(BACKSTAGE)) {
                        items[i].quality = items[i].quality - items[i].quality;
                    } else {
                        if (items[i].quality > 0) {
                            if (items[i].name.equals(SULFURAS)) {
                                continue;
                            }
                            items[i].quality = items[i].quality - 1;
                        }
                    }
                }
            }
        }
    }
}
