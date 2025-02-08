package com.gildedrose;

class ItemUpdaterFactory {

    public ItemUpdater createFor(Item item) {
        return switch (item.name) {
            case "Aged Brie":
                yield new AgedBrieItemUpdater();
            case "Backstage passes to a TAFKAL80ETC concert":
                yield new BackStageItemUpdater();
            case "Sulfuras, Hand of Ragnaros":
                yield new SulfurasItemUpdater();
            default:
                yield new GenericItemUpdater();
        };
    }
}
