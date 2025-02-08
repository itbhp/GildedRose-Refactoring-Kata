package com.gildedrose;

class GildedRose {
    private static final UpdateItemFactory updateItemFactory = new UpdateItemFactory();
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            createUpdaterFor(item).update(item);
        }
    }

    private static UpdateItem createUpdaterFor(Item item) {
        return updateItemFactory.invoke(item);
    }
}
