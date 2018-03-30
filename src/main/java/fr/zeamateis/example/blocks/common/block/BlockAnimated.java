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
        super("block_animated", Material.IRON);
    }

	@Override
	public TileEntityBlockAnimated createNewTileEntity(World worldIn, int meta) {
		return new TileEntityBlockAnimated();
	}
}