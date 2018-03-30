package fr.zeamateis.example.blocks.common.block.tileEntity;

import com.leviathanstudio.craftstudio.CraftStudioApi;
import com.leviathanstudio.craftstudio.common.animation.AnimationHandler;

import fr.zeamateis.example.blocks.common.block.base.BaseTileEntity;
import fr.zeamateis.modMain.ExampleModMain;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;

/**
 * Sample TileEntity for an animated block
 * */
public class TileEntityBlockAnimated extends BaseTileEntity
{
	//Create a new animation handler for this TileEntity
    protected static AnimationHandler animHandler = CraftStudioApi.getNewAnimationHandler(TileEntityBlockAnimated.class);

    //Register Animation
    static {
        TileEntityBlockAnimated.animHandler.addAnim(ExampleModMain.MODID, "block_animated_anim", "block_animated", true);
    }

    public TileEntityBlockAnimated() {}

    @Override
    public AnimationHandler getAnimationHandler() {
        return TileEntityBlockAnimated.animHandler;
    }

    /**
     * Update method to launch animation of the animated block
     * It always loop, with the checking condition,
     * !this.getAnimationHandler().isAnimationActive()
     */
    @Override
    public void update() {
        super.update();
        if (this.isWorldRemote() && !this.getAnimationHandler().isAnimationActive(ExampleModMain.MODID, "block_animated_anim", this))
            this.getAnimationHandler().startAnimation(ExampleModMain.MODID, "block_animated_anim", this);
    }
}