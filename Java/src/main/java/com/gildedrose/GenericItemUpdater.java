package com.gildedrose;

import java.util.function.Consumer;

public class GenericItemUpdater implements Consumer<Item> {
    @Override
    public void accept(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
