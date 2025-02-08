package com.gildedrose;

import java.util.function.Consumer;

class GildedRose {
    private static final ItemUpdaterFactory ITEM_UPDATER_FACTORY = new ItemUpdaterFactory();
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            createUpdaterFor(item).accept(item);
        }
    }

    private static Consumer<Item> createUpdaterFor(Item item) {
        return ITEM_UPDATER_FACTORY.createFor(item);
    }
}
