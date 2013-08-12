package ninjapancakes87.civilwar.block.cannon;

import java.util.logging.Level;
import java.util.logging.LogRecord;

import cpw.mods.fml.common.FMLLog;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import ninjapancakes87.civilwar.CivilWar;

public class TileEntityCannon extends TileEntity{
	public byte rotation;
	public Block block;
	public TileEntityCannonRenderer TErender;

	@Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);
		byte r = nbtTagCompound.getByte("rotation");
		this.setRotation(r);
		//this.rotate(this.direction(r));
		CivilWar.CwLogger.log(Level.INFO, "Rotation: " + this.rotation);
	}
	@Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setByte("rotation", this.getRotation());
		CivilWar.CwLogger.log(Level.INFO, "Rotation: " + this.rotation);
	}
	public byte getRotation(){
		return this.rotation;
	}
	public void setRotation(byte par1){
		this.rotation = par1;
	}
	/*public boolean rotate(ForgeDirection axis){
		return block.rotateBlock(this.worldObj, this.xCoord, this.yCoord, this.zCoord, axis);	
	}	
	public ForgeDirection direction(byte r){
		if(r == 2){
			return ForgeDirection.SOUTH;
		}
		else if(r == 3){
			return ForgeDirection.EAST;
		}
		else if(r == 4){
			return ForgeDirection.NORTH;
		}
		else if(r == 5){
			return ForgeDirection.WEST;
		}
		else{
			return ForgeDirection.DOWN;
		}
	}*/
}
