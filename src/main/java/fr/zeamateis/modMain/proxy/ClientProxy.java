package fr.zeamateis.modMain.proxy;

import com.leviathanstudio.craftstudio.client.registry.CSRegistryHelper;
import com.leviathanstudio.craftstudio.client.registry.CraftStudioLoader;
import com.leviathanstudio.craftstudio.client.util.EnumRenderType;
import com.leviathanstudio.craftstudio.client.util.EnumResourceType;

import fr.zeamateis.example.blocks.client.render.tesr.RenderAnimatedBlock;
import fr.zeamateis.example.blocks.common.block.tileEntity.TileEntityBlockAnimated;
import fr.zeamateis.modMain.ExampleModMain;
import fr.zeamateis.modMain.handler.TileEntityInventoryHandler;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event) {}

    @Override
    public void init(FMLInitializationEvent event) {
    	//Instanciate the Render Inventory class
        TileEntityItemStackRenderer.instance = new TileEntityInventoryHandler();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {}

    @Override
    public void bindEntityRenderer() {}

    @Override
    public void bindTESR() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlockAnimated.class, new RenderAnimatedBlock<>());
    }

    /**
     * Register all CraftStudio assets for you project (animations, entity model, block model)
     */
    @CraftStudioLoader
    public static void registerCraftStudioAssets() {
        CSRegistryHelper registry = new CSRegistryHelper(ExampleModMain.MODID);
        registry.register(EnumResourceType.MODEL, EnumRenderType.BLOCK, "block_animated");
        registry.register(EnumResourceType.ANIM, EnumRenderType.BLOCK, "block_animated_anim");
    }

}