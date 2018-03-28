package fr.zeamateis.example.blocks.common.item.base;

import fr.zeamateis.modMain.ExampleModMain;
import net.minecraft.item.Item;

public class ItemBase extends Item
{
    public ItemBase(final String itemName) {
        setItemName(this, itemName);
    }

    /**
     * Set the registry name of {@code item} to {@code itemName} and the
     * unlocalised name to the full registry name.
     *
     * @param item
     *            The item
     * @param itemName
     *            The item's name
     */
    public static void setItemName(final Item item, final String itemName) {
        item.setRegistryName(ExampleModMain.MODID, itemName);
        item.setUnlocalizedName(item.getRegistryName().toString());
    }
}