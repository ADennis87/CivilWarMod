package ninjapancakes87.civilwar.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import ninjapancakes87.civilwar.Achievements;
import ninjapancakes87.civilwar.ExtendedProperties;
import ninjapancakes87.civilwar.Registry;

public class EntitySoldier_Rebel extends EntitySoldier{
	public Minecraft mc;

	public EntitySoldier_Rebel(World par1World) {
		super(par1World, false);
		this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntitySoldier_Union.class, 1, false));
	}

	public boolean interact(EntityPlayer par1EntityPlayer) {
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
		Item food = itemstack.getItem();

		if (this.isTamed()) {
			if (itemstack != null) {
				if (food instanceof ItemFood) {
					ItemFood itemfood = (ItemFood) food;
	
					if (itemstack.getItem() == Items.bread || itemstack.getItem() == Items.apple) {
						if(this.getHealth() < this.getMaxHealth()){
							if (!par1EntityPlayer.capabilities.isCreativeMode) {
								--itemstack.stackSize;
							}
							this.heal(((ItemFood) food).func_150905_g(itemstack));

						
							if (itemstack.stackSize <= 0) {
							par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem,(ItemStack) null);
							}

							return true;
						}
					}
				}
			}
			if (par1EntityPlayer.equals(this.getOwner()) && !this.worldObj.isRemote && !this.isBreedingItem(itemstack)) {
				this.isJumping = false;
				this.setPathToEntity((PathEntity) null);
			}
		} else if (itemstack != null && itemstack.getItem() == Registry.coin2 && !this.isAngry()) {
			if (!par1EntityPlayer.capabilities.isCreativeMode) {
				--itemstack.stackSize;
			}

			if (itemstack.stackSize <= 0) {
				par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem,(ItemStack) null);
			}

			if (!this.worldObj.isRemote) {
				ExtendedProperties ep = new ExtendedProperties(par1EntityPlayer);
				if(ep.getIsUnion() != 1){
					if (this.rand.nextInt(3) == 0) {
						this.setTamed(true);
						par1EntityPlayer.addChatMessage(new ChatComponentText("You have recruited a " + EnumChatFormatting.AQUA + this.getProfessionName() + EnumChatFormatting.RESET + " to your " + EnumChatFormatting.GRAY + ep.getArmyName()));
						ep.setArmySize(ep.getArmySize() + 1);
						ep.setIsUnion(-1);
						this.setPathToEntity((PathEntity) null);
						this.setAttackTarget((EntityLiving) null);
						this.setOwner(par1EntityPlayer.getDisplayName());
						par1EntityPlayer.triggerAchievement(Achievements.merc);
					}
				}
				else{
					par1EntityPlayer.addChatMessage(new ChatComponentText("You have already hired " + EnumChatFormatting.BLUE + "Union " + EnumChatFormatting.RESET + "soldiers!"));
				}
			}

			return true;
		}

		return super.interact(par1EntityPlayer);
	}

	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData) {
		par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);
		this.applyRandomTrade(this, worldObj.rand);
		return par1EntityLivingData;
	}

	public EntitySoldier_Rebel func_90012_b(EntityAgeable par1EntityAgeable) {
		EntitySoldier_Rebel entityvillager = new EntitySoldier_Rebel(this.worldObj);
		entityvillager.onSpawnWithEgg((IEntityLivingData) null);
		return entityvillager;
	}
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLiving, float f) {
		if(this.getProfession() == 2){
		EntityMusketBall entityarrow = new EntityMusketBall(this.worldObj, this, par1EntityLiving, 1.6F, (float) (14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
		this.playSound("Civil War:gunshot", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(entityarrow);
		}
	}
}
