package fr.zeamateis.example.blocks.common.block.base;

import fr.zeamateis.modMain.ExampleModMain;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.chunk.Chunk;

/**
 * A simple base class for Animated(or not) Blocks (with a TileEntity) made on CraftStudio
 * */
public abstract class BlockTileEntity<T extends BaseTileEntity> extends BlockContainer
{
    public String    name;

    public BlockTileEntity(final String name, final Material material) {
        super(material);
        this.name = name;
        this.setRegistryName(ExampleModMain.MODID, name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }

    /**
     * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
     * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
     */
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
    
    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}
