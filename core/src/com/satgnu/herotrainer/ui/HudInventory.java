package com.satgnu.herotrainer.ui;

import com.badlogic.gdx.math.Vector2;
import com.satgnu.herotrainer.Render;
import com.satgnu.herotrainer.game.inventory.Inventory;
import com.satgnu.herotrainer.game.inventory.Item;

public class HudInventory implements IHudElement {

    private Inventory inventory; // Inventory this hud represents.

    public HudInventory(Inventory inv)
    {
        this.inventory = inv;
    }

    @Override
    public void draw(Vector2 coords)
    {
        /* Draw the visible (top) stack of inv stuff */
        for(int i=0; i<9; i++) {
            Render.DrawTexture("ui/portrait_background2.png", (int)coords.x + i * 70, (int)coords.y);

            // Draw whatever item is at this stack position
            Inventory.InventoryItem inv_item = inventory.getItemStackAtPosition(i);
            if(inv_item != null) {
                // Draw image
                Render.DrawTexture(inv_item.item.getImagePath(), (int)coords.x + 14 + i * 70, (int)coords.y+16);

                // Draw count
                Render.font.draw(Render.batch, "" + inv_item.count, (int)coords.x + 42 + i * 70, (int)coords.y+16);
            }
        }

        /* Draw the expand button */
    }

}
