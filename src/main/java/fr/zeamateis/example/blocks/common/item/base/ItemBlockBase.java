package fr.zeamateis.example.blocks.common.item.base;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

/**A simple base class to create ItemBlock*/
public class ItemBlockBase extends ItemBlock
{
    public ItemBlockBase(Block block) {
        super(block);
        this.setRegistryName(String.format("item_block_%s", block.getUnlocalizedName().replaceAll("(tile.)", "")));
    }
}