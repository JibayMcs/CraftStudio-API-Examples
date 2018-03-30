package fr.zeamateis.modMain.handler;

import fr.zeamateis.example.blocks.common.block.tileEntity.TileEntityBlockAnimated;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * The most important class to create a perfect render of a TESR Block, with an inventory renderer
 * */
public class TileEntityInventoryHandler extends TileEntityItemStackRenderer
{
    
    @Override
    public void renderByItem(ItemStack itemStack) {
        String block = Block.getBlockFromItem(itemStack.getItem()).getUnlocalizedName().replace("tile.", "");

        TileEntityBlockAnimated tile_entity_block_animated = new TileEntityBlockAnimated();

        switch (block) {
            case "block_animated":
            	//Call the render method of the TileEntity to override the renderByItem method
                this.render(tile_entity_block_animated);
                break;
            default:
                super.renderByItem(itemStack);
        }
    }

    private void render(TileEntity tileEntityIn) {
        TileEntityRendererDispatcher.instance.render(tileEntityIn, 0.0D, 0.0D, 0.0D, 0.0F);
    }
}