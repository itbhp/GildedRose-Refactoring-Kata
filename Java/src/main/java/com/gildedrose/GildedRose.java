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
            switch (item.name) {
                case AGED_BRIE:
                    new AgedBrieUpdateItem().update(item);
                    break;
                case BACKSTAGE:
                    new BackStageUpdateItem().update(item);
                    break;
                case SULFURAS:
                    new SulfurasUpdateItem().update(item);
                    break;
                default:
                    new GenericUpdateItem().update(item);
                    break;
            }
        }
    }

}
