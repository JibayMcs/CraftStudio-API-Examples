package fr.zeamateis.modMain;

import fr.zeamateis.modMain.handler.BlocksHandler;
import fr.zeamateis.modMain.handler.ItemsHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@EventBusSubscriber(modid = ExampleModMain.MODID)
public class RegistryHandler
{

    private static ItemsHandler  itemsHandler;
    private static BlocksHandler blocksHandler;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        blocksHandler = new BlocksHandler(event);
        blocksHandler.registerTileEntity();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        itemsHandler = new ItemsHandler(event);

    }

    @SubscribeEvent
    public static void registerItemsModels(ModelRegistryEvent event) {
        itemsHandler.modelRegistry(event);
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        ExampleModMain.getProxy().bindTESR();
        ExampleModMain.getProxy().bindEntityRenderer();
    }

}