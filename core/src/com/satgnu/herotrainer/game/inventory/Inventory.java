package com.satgnu.herotrainer.game.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public class InventoryItem {
        public Item item; // reference to item
        public int count; // count in stack
    }

    // This should be Item
    private List<InventoryItem> items = new ArrayList<>();

    /**
     *
     * @param item - Stack to check for
     * @param count - Count to add
     * @return - 1 if added to existing stack, 2 if new stack
     */
    public int addToInventory(Item item, int count)
    {
        InventoryItem stack = findExistingStack(item);

        if(stack != null) {
            stack.count += count;
            return 1;
        } else {
            stack = new InventoryItem();
            stack.item = item;
            stack.count = count;

            items.add(stack);
            return 2;
        }
    }

    /**
     *
     * @param item - Stack to check for
     * @param count - Count to subtract
     * @return int - 0 if nothing removed, 1 if partial stack removed, 2 if full stack removed
     */
    public int removeFromInventory(Item item, int count)
    {
        InventoryItem stack = findExistingStack(item);
        if(stack != null) {
            stack.count -= count;

            // If stack empty, remove it.
            if(stack.count < 1) {
                items.remove(stack);
                return 2;
            }

            return 1;
        }

        return 0;
    }

    /**
     * Returns the existing InventoryItem in the inventory to modify the stack (or remove)
     *
     * @param item_to_add - Stack to check for
     * @return InventoryItem - existing invitem to modify the stack (or remove). Null if none exists
     */
    private InventoryItem findExistingStack(Item item_to_add)
    {
        for (InventoryItem inv_item : items) {
            if(inv_item.item.item_type == item_to_add.item_type) {
                return inv_item;
            }
        }

        return null;
    }

    /**
     * Returns a stack of items at the given inventory slot index
     *
     * @param index - position in inventory (offset) to find stack
     * @return InventoryItem - stack if item at this inv slot
     */
    public InventoryItem getItemStackAtPosition(int index)
    {
        if(items.size() > index) {
            return items.get(index);
        }

        return null;
    }
}
