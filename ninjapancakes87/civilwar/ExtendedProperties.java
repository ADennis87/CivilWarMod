package ninjapancakes87.civilwar;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedProperties implements IExtendedEntityProperties{
	
	/**The number of soldiers hired by the player*/
	private int armySize = 0;
	
	/**Whether the player has hired a Union or Confederate soldier*/
	private int isUnion = 0;
	
	private EntityPlayer player;
	
	public ExtendedProperties(EntityPlayer player){
		this.player = player;
	}
	
	public int getArmySize(){
		return player.getDataWatcher().getWatchableObjectInt(21);
	}
	
	public String getArmyName(){
		return Strings.army[this.getArmySize() / 10];
	}
	
	public void setArmySize(int par1){
		player.getDataWatcher().updateObject(21, par1);
		this.armySize = par1;
		//player.addChatComponentMessage(new ChatComponentText("Size: " + this.getArmySize()));
	}
	
	public int getIsUnion(){
		return player.getDataWatcher().getWatchableObjectInt(22);
	}
	
	public void setIsUnion(int par1){
		player.getDataWatcher().updateObject(22, par1);
		this.isUnion = par1;
		//player.addChatComponentMessage(new ChatComponentText("Is Union: " + this.getIsUnion()));
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		compound.setInteger("armySize", this.getArmySize());
		compound.setInteger("isUnion", this.getIsUnion());
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		this.setArmySize(compound.getInteger("armySize"));
		this.setIsUnion(compound.getInteger("isUnion"));
	}

	@Override
	public void init(Entity entity, World world) {
		if(entity instanceof EntityPlayer){
			this.player.getDataWatcher().addObject(21, Integer.valueOf(armySize));
			this.player.getDataWatcher().addObject(22, Integer.valueOf(isUnion));
		}
	}
}
