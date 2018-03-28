package fr.zeamateis.example.blocks.common.block.tileEntity;

import com.leviathanstudio.craftstudio.CraftStudioApi;
import com.leviathanstudio.craftstudio.common.animation.AnimationHandler;

import fr.zeamateis.example.blocks.common.block.base.BaseTileEntity;
import fr.zeamateis.modMain.ExampleModMain;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;

public class TileEntityBlockAnimated extends BaseTileEntity
{
    protected static AnimationHandler animHandler = CraftStudioApi.getNewAnimationHandler(TileEntityBlockAnimated.class);

    static {
        TileEntityBlockAnimated.animHandler.addAnim(ExampleModMain.MODID, "block_animated_anim", "block_animated", true);
    }

    public TileEntityBlockAnimated() {}

    @Override
    public AnimationHandler getAnimationHandler() {
        return TileEntityBlockAnimated.animHandler;
    }

    @Override
    public void update() {
        super.update();

        if (this.isWorldRemote() && !this.getAnimationHandler().isAnimationActive(ExampleModMain.MODID, "block_animated_anim", this))
            this.getAnimationHandler().startAnimation(ExampleModMain.MODID, "block_animated_anim", this);

    }
}