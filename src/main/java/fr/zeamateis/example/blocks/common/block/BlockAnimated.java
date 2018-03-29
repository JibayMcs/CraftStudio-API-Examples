package fr.zeamateis.example.blocks.common.block;


import fr.zeamateis.example.blocks.common.block.base.BlockTileEntity;
import fr.zeamateis.example.blocks.common.block.tileEntity.TileEntityBlockAnimated;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAnimated extends BlockTileEntity<TileEntityBlockAnimated>
{

    public BlockAnimated() {
        super("block_animated", Material.IRON, TileEntityBlockAnimated.class);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    /**
     * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
     * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
     */
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

	@Override
	public TileEntityBlockAnimated createNewTileEntity(World worldIn, int meta) {
		return new TileEntityBlockAnimated();
	}
}