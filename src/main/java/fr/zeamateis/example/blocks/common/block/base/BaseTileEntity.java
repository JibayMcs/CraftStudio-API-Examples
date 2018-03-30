package fr.zeamateis.example.blocks.common.block.base;

import java.util.Random;

import com.leviathanstudio.craftstudio.common.animation.simpleImpl.AnimatedTileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * A simple base class for Animated Blocks (TileEntity) with CraftStudio
 * */
public class BaseTileEntity extends AnimatedTileEntity
{
    public BaseTileEntity() {}

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        final NBTTagCompound nbtTag = new NBTTagCompound();
        writeToNBT(nbtTag);
        return new SPacketUpdateTileEntity(pos, 1, nbtTag);
    }

    @Override
    public void onDataPacket(final NetworkManager net, final SPacketUpdateTileEntity packet) {
        readFromNBT(packet.getNbtCompound());
    }

    /*
     * Not sure if it's really working.
     * It's for extend the render distance of a >1x1 block.
     * */
    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(pos, pos.add(5, 5, 5));
    }
}