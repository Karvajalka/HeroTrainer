package com.satgnu.herotrainer.game.inventory;

public class Item {

    /* List of items that exist in the game */
    public enum Type {
        Scale,
        FancyScale,
    }

    public Type item_type;

    /**
     * Constructor
     * @param type - Type of item this is
     */
    public Item(Type type)
    {
        this.item_type = type;
    }

    /**
     * @return - Sprite path used for rendering
     */
    public String getImagePath()
    {
        return "items/" + item_type.toString().toLowerCase() + ".png";
    }
}
