package com.gildedrose;

class GildedRose {
    private static final ItemUpdaterFactory ITEM_UPDATER_FACTORY = new ItemUpdaterFactory();
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            createUpdaterFor(item).update(item);
        }
    }

    private static ItemUpdater createUpdaterFor(Item item) {
        return ITEM_UPDATER_FACTORY.createFor(item);
    }
}
