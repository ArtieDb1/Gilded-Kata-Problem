package com.gildedrose;

//IDEALlY YOU WOULD HAVE MADE THIS CLASS INTERACT WITH AN INTERFACE
public class Item {

    public String name;

    public int sellIn; //int representing how many days left to sell the item

    public int quality; //how valuable is the item up to 50

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
