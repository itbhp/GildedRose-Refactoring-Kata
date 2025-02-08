package com.gildedrose;

import java.util.Optional;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            createUpdaterFor(item).update(item);
        }
    }

    private UpdateItem createUpdaterFor(Item item) {
        return switch (item.name) {
            case AGED_BRIE:
                yield new AgedBrieUpdateItem();
            case BACKSTAGE:
                yield new BackStageUpdateItem();
            case SULFURAS:
                yield new SulfurasUpdateItem();
            default:
                yield new GenericUpdateItem();
        };
    }

}
