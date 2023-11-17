package com.gildedrose;

import java.util.Objects;

class GildedRose {
    static Item[] items;

    public GildedRose(Item[] items) {
        GildedRose.items = items;
    }


    public static void updateQuality() {
        //if item qua
        updateNormalItemQuality();
        updateConjuredItemQuality();
        updateSpecialItemQuality();
    }


    public static void updateNormalItemQuality(){

        for (int i = 0; i < items.length; i++){

            if (items[i].sellIn > 0 && !items[i].name.equals("Sulfuras")&& !items[i].name.equals("Aged Brie") && !items[i].name.contains("Backstage")){
                items[i].sellIn--;
                items[i].quality--;
            }

        }
    }

    public static void updateSpecialItemQuality(){

        String itemName;
        for (int i = 0; i < items.length; i++){
            itemName = items[i].name;
            switch (itemName){
                case "Aged Brie":
                    items[i].sellIn--;
                    items[i].quality++;
                    if (items[i].quality >= 50){
                        items[i].quality = 50;
                    }
                    break;

                case "Sulfuras":
                    items[i].sellIn+=0;
                    items[i].quality = 80;
                    break;
                default:
                    break;
            }

            if (items[i].name.contains("Backstage")){
                if (items[i].sellIn <= 10 && items[i].sellIn > 5){
                    items[i].quality += 2;
                }
                else if (items[i].sellIn <= 5 && items[i].sellIn > 0){
                    items[i].quality += 3;
                }
                else if (items[i].sellIn > 10){
                    items[i].quality += 1;
                }
                else if (items[i].sellIn <= 0){
                    items[i].quality = 0;
                }
            }

        }
    }

    public static void updateConjuredItemQuality(){

        for (int i = 0; i < items.length; i++){

            if (items[i].sellIn > 0 && items[i].name.contains("Conjured")&& !items[i].name.equals("Sulfuras")&& !items[i].name.equals("Aged Brie") && !items[i].name.contains("Backstage")){
                items[i].sellIn--;
                items[i].quality-=2;
            }

        }
    }



}








