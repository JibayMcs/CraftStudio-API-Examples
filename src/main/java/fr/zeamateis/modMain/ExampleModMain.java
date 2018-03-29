package fr.zeamateis.modMain;

import org.apache.logging.log4j.Logger;

import fr.zeamateis.modMain.handler.BlocksHandler;
import fr.zeamateis.modMain.handler.ItemsHandler;
import fr.zeamateis.modMain.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@Mod(modid = ExampleModMain.MODID, name = ExampleModMain.NAME, version = ExampleModMain.VERSION)
public class ExampleModMain
{
    public static final String MODID = "example_mod";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @SidedProxy(clientSide = "fr.zeamateis.modMain.proxy.ClientProxy", serverSide = "fr.zeamateis.modMain.proxy.ServerProxy")
    private static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	logger = event.getModLog();
        proxy.onPreInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.onInit(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.onPostInit(event);
    }

    public static CommonProxy getProxy() {
        return proxy;
    }
}