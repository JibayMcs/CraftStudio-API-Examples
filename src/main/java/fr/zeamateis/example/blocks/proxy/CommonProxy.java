package fr.zeamateis.example.blocks.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class CommonProxy
{

    public abstract void preInit(FMLPreInitializationEvent event);

    public void onPreInit(FMLPreInitializationEvent event) {
        preInit(event);
    }

    public abstract void init(FMLInitializationEvent event);

    public void onInit(FMLInitializationEvent event) {
        init(event);
    }

    public abstract void postInit(FMLPostInitializationEvent event);

    public void onPostInit(FMLPostInitializationEvent event) {
        postInit(event);
    }

    public abstract void bindEntityRenderer();

    public abstract void bindTESR();
}