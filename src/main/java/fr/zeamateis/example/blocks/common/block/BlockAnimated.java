package fr.zeamateis.example.blocks.common.block;


import fr.zeamateis.example.blocks.common.block.base.BlockTileEntity;
import fr.zeamateis.example.blocks.common.block.tileEntity.TileEntityBlockAnimated;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAnimated extends BlockTileEntity<TileEntityBlockAnimated>
{

    public BlockAnimated() {
        super("block_animated", Material.IRON, TileEntityBlockAnimated.class);
    }

    // public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState
    // state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float
    // hitX, float hitY, float hitZ)
    // {
    // if (!worldIn.isRemote)
    // {
    // TileEntity tileEntity = worldIn.getTileEntity(pos);
    // if(tileEntity instanceof TileEntityBandRecorder) {
    // TileEntityBandRecorder tileBandRecorder =
    // (TileEntityBandRecorder)tileEntity;
    //
    // tileBandRecorder.getAnimationHandler().startAnimation(modid,
    // animationName, animatedElement);
    //
    // return true;
    // }
    // return false;
    // }
    // }

	@Override
	public TileEntityBlockAnimated createNewTileEntity(World worldIn, int meta) {
		return new TileEntityBlockAnimated();
	}
}