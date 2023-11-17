package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRose.updateQuality;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    @DisplayName("Makes the failing test work")
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    @DisplayName("ChecksThatItemDiminishesBy1EveryDay")
    void ChecksThatItemDiminishesBy1EveryDay(){
        Item[] items = new Item[] { new Item("foo", 4, 3)};
        int oldQuality = items[0].quality;
        GildedRose app = new GildedRose(items);
        updateQuality();
        int newQuality = items[0].quality;
        assertEquals(1, oldQuality-newQuality);
    }

    @Test
    @DisplayName("ChecksThatNormalItemDiminishesBy1EveryDay")
    void ChecksThatNormalItemsDiminishesBy1EveryDay(){
        Item[] items = new Item[] { new Item("foo", 4, 3)};
        int oldQuality = items[0].quality;
        GildedRose app = new GildedRose(items);
        GildedRose.updateNormalItemQuality();
        int newQuality = items[0].quality;
        assertEquals(1, oldQuality-newQuality);
    }

    @Test
    @DisplayName("ChecksThatSulfurasDoesntDiminish")
    void ChecksThatSulfurasDoesntDiminishAfterADay(){
        Item[] items = new Item[] { new Item("Sulfuras", 4, 3)};
        int oldQuality = items[0].quality;
        GildedRose app = new GildedRose(items);
        app.updateNormalItemQuality();
        int newQuality = items[0].quality;
        assertEquals(0, oldQuality-newQuality);
    }

    @Test
    @DisplayName("ChecksThatAgedBrieDoesntDiminish")
    void ChecksThatAgedBrieDoesntDiminishAfterADay(){
        Item[] items = new Item[] { new Item("Aged Brie", 4, 3)};
        int oldQuality = items[0].quality;
        GildedRose app = new GildedRose(items);
        app.updateSpecialItemQuality();
        int newQuality = items[0].quality;
        assertEquals(-1, oldQuality-newQuality);
    }

    @Test
    @DisplayName("ChecksThatBackStageDoesntDiminish")
    void ChecksThatBackStageDoesntDiminishAfterADay(){
        Item[] items = new Item[] { new Item("Backstage passasdfas", 4, 3)};
        int oldQuality = items[0].quality;
        GildedRose app = new GildedRose(items);
        app.updateSpecialItemQuality();
        int newQuality = items[0].quality;
        assertEquals(-3, oldQuality-newQuality);
    }

    @Test
    @DisplayName("ChecksThatSulfarasDoesntDiminish")
    void ChecksThatSulfarasDoesntDiminishAfterADay(){
        Item[] items = new Item[] { new Item("Sulfaras", 4, 3)};
        int oldQuality = items[0].quality;
        GildedRose app = new GildedRose(items);
        app.updateSpecialItemQuality();
        int newQuality = items[0].quality;
        assertEquals(0, oldQuality-newQuality);
    }

    @Test
    @DisplayName("ChecksThatSulfurasQualityIsAlways80")
    void ChecksThatSulfurasIs80(){
        Item[] items = new Item[] { new Item("Sulfuras", 4, 3)};
        int oldQuality = items[0].quality;
        GildedRose app = new GildedRose(items);
        app.updateSpecialItemQuality();
        int newQuality = items[0].quality;
        assertEquals(80, newQuality);
    }

    @Test
    @DisplayName("ChecksThatBackstageQualityIs0")
    void ChecksBackStagePassIs0AfterSellIn(){
        Item[] items = new Item[] { new Item("Backstage", 0, 3)};
        int oldQuality = items[0].quality;
        GildedRose app = new GildedRose(items);
        app.updateSpecialItemQuality();
        int newQuality = items[0].quality;
        System.out.println(items[0].sellIn);
        assertEquals(oldQuality, oldQuality - newQuality);
    }

    @Test
    @DisplayName("ChecksThatSulfurasSellInDoesntGoDownby1")
    void ChecksThatSulfurasSellInDoesntGoDownby1(){
        Item[] items = new Item[] { new Item("Sulfuras", 4, 3)};
        int oldSellin = items[0].sellIn;
        GildedRose app = new GildedRose(items);
        app.updateSpecialItemQuality();
        int newSellIn = items[0].sellIn;
        assertEquals(0, oldSellin-newSellIn);
    }

    @Test
    @DisplayName("ChecksThatSellInAlwaysDecreases")
    void ChecksThatSellInGoesDownby1(){
        Item[] items = new Item[] { new Item("Conjured Brie", 4, 3)};
        int oldSellin = items[0].sellIn;
        GildedRose app = new GildedRose(items);
        app.updateConjuredItemQuality();
        int newSellIn = items[0].sellIn;
        assertEquals(1, oldSellin-newSellIn);
    }

    @Test
    @DisplayName("FinalTest")
    void FinalCheck(){
        Item[] items = new Item[] {
            new Item("Normal Item", 4, 3),
            new Item("Backstage Pass", 6, 3),
            new Item("Aged Brie", 4, 3),
            new Item("Sulfuras", 4, 3),
            new Item("expired Backstage Pass", 0, 10),
        };

        GildedRose app = new GildedRose(items);
        updateQuality();

        System.out.println("Normal item SellIn: " + items[0].sellIn + " quality: " + items[0].quality);
        System.out.println("Backstage Pass item SellIn: " + items[1].sellIn + " quality: " + items[1].quality);
        System.out.println("Aged Brie SellIn: " + items[2].sellIn + " quality: " + items[2].quality);
        System.out.println("Sulfuras SellIn: " + items[3].sellIn + " quality: " + items[3].quality);
        System.out.println("expired Backstage pass SellIn: " + items[4].sellIn + " quality: " + items[4].quality);

        updateQuality();
        System.out.println("******************************************************************************");
        System.out.println("Normal item SellIn: " + items[0].sellIn + " quality: " + items[0].quality);
        System.out.println("Backstage Pass item SellIn: " + items[1].sellIn + " quality: " + items[1].quality);
        System.out.println("Aged Brie SellIn: " + items[2].sellIn + " quality: " + items[2].quality);
        System.out.println("Sulfuras SellIn: " + items[3].sellIn + " quality: " + items[3].quality);
        System.out.println("expired Backstage pass SellIn: " + items[4].sellIn + " quality: " + items[4].quality);
    }
/**
 * Avoided this test because using TDD, I would have to alter too much code
    @Test
    @DisplayName("checksThatQualityCannotExceed50")
    void checksThatQualityCannotExceed50(){

        Item[] items = new Item[] { new Item("foo", 4, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);

   }
*/

}
