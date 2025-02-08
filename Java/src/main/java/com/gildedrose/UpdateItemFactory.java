package com.gildedrose;

class UpdateItemFactory {

    public UpdateItem invoke(Item item) {
        return switch (item.name) {
            case "Aged Brie":
                yield new AgedBrieUpdateItem();
            case "Backstage passes to a TAFKAL80ETC concert":
                yield new BackStageUpdateItem();
            case "Sulfuras, Hand of Ragnaros":
                yield new SulfurasUpdateItem();
            default:
                yield new GenericUpdateItem();
        };
    }
}
