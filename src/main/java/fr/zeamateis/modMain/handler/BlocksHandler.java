package fr.zeamateis.modMain.handler;

import fr.zeamateis.example.blocks.common.block.BlockAnimated;
import fr.zeamateis.example.blocks.common.block.tileEntity.TileEntityBlockAnimated;
import fr.zeamateis.modMain.helper.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;

public class BlocksHandler extends RegistryHelper.EMMBlocks
{

    public static final BlockAnimated block_animated = new BlockAnimated();

    public BlocksHandler(RegistryEvent.Register<Block> event) {
        register(event, block_animated);
    }

    public void registerTileEntity() {
        registerTileEntity(TileEntityBlockAnimated.class, "tile_entity_animated_block");
    }

}