package ninjapancakes87.civilwar.block.cannon;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCannon extends TileEntity{
	public byte rotation = 0;

	@Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);
		byte r = nbtTagCompound.getByte("rotation");
		this.setRotation(r);
	}
	@Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setByte("rotation", this.rotation);
	}
	public byte getRotation(){
		return this.rotation;
	}
	public void setRotation(byte par1){
		this.rotation = par1;
	}
}
