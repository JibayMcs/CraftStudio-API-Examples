package fr.zeamateis.modMain.handler;

import fr.zeamateis.example.blocks.common.item.base.ItemBlockBase;
import fr.zeamateis.modMain.helper.RegistryHelper;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public class ItemsHandler extends RegistryHelper.EMMItems
{
    public ItemsHandler(RegistryEvent.Register<Item> event) {
        register(event, new ItemBlockBase(BlocksHandler.block_animated));
    }

    public void modelRegistry(ModelRegistryEvent event) {
        registerModel(Item.getItemFromBlock(BlocksHandler.block_animated), "block_animated", 0);
    }
}