package fr.zeamateis.modMain.handler;

import fr.zeamateis.example.blocks.common.block.tileEntity.TileEntityBlockAnimated;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInventoryHandler extends TileEntityItemStackRenderer
{
    
    @Override
    public void renderByItem(ItemStack itemStack) {
        String block = Block.getBlockFromItem(itemStack.getItem()).getUnlocalizedName().replace("tile.", "");

        TileEntityBlockAnimated tile_entity_block_animated = new TileEntityBlockAnimated();

        switch (block) {
            case "block_animated":
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