package fr.zeamateis.modMain;

import org.apache.logging.log4j.Logger;

import fr.zeamateis.example.blocks.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ExampleModMain.MODID, name = ExampleModMain.NAME, version = ExampleModMain.VERSION)
public class ExampleModMain
{
    public static final String MODID = "example_mod";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @SidedProxy(clientSide = "fr.zeamateis.example.blocks.proxy.ClientProxy", serverSide = "fr.zeamateis.example.blocks.proxy.ServerProxy")
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