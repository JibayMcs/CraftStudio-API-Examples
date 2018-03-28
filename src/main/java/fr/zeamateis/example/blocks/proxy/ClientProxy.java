package fr.zeamateis.example.blocks.proxy;

import com.leviathanstudio.craftstudio.client.registry.CSRegistryHelper;
import com.leviathanstudio.craftstudio.client.registry.CraftStudioLoader;
import com.leviathanstudio.craftstudio.client.util.EnumRenderType;
import com.leviathanstudio.craftstudio.client.util.EnumResourceType;

import fr.zeamateis.example.blocks.client.render.tesr.RenderAnimatedBlock;
import fr.zeamateis.example.blocks.common.block.tileEntity.TileEntityBlockAnimated;
import fr.zeamateis.modMain.ExampleModMain;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event) {}

    @Override
    public void init(FMLInitializationEvent event) {}

    @Override
    public void postInit(FMLPostInitializationEvent event) {}

    @Override
    public void bindEntityRenderer() {}

    @Override
    public void bindTESR() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlockAnimated.class, new RenderAnimatedBlock<>());
    }

    @CraftStudioLoader
    public static void registerCraftStudioAssets() {
        CSRegistryHelper registry = new CSRegistryHelper(ExampleModMain.MODID);
        registry.register(EnumResourceType.MODEL, EnumRenderType.BLOCK, "justice_statue");
        registry.register(EnumResourceType.ANIM, EnumRenderType.BLOCK, "band_recorder_anim");
    }

}