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

public abstract class BlockTileEntity<T extends BaseTileEntity> extends BlockContainer
{
    public String    name;
    private Class<T> tileClass;

    public BlockTileEntity(final String name, final Material material, Class<T> tileClass) {
        super(material);
        this.name = name;
        this.setRegistryName(ExampleModMain.MODID, name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.tileClass = tileClass;
    }

    @Override
    public EnumBlockRenderType getRenderType(final IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    public T getWorldTile(IBlockAccess world, BlockPos pos) {
        if (world instanceof ChunkCache)
            return (T) ((ChunkCache) world).getTileEntity(pos, Chunk.EnumCreateEntityType.CHECK);
        else
            return (T) world.getTileEntity(pos);
    }

    public boolean checkWorldTile(IBlockAccess world, BlockPos pos) {
        if (world instanceof ChunkCache)
            return tileClass.isInstance(((ChunkCache) world).getTileEntity(pos, Chunk.EnumCreateEntityType.CHECK));
        else
            return tileClass.isInstance(world.getTileEntity(pos));
    }

    public Class<T> getTileClass() {
        return tileClass;
    }
}
