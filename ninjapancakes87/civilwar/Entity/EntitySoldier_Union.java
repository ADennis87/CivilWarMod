package ninjapancakes87.civilwar.Entity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.INpc;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.world.World;
import ninjapancakes87.civilwar.Config;
import ninjapancakes87.civilwar.Registry;

public class EntitySoldier_Union extends EntitySoldier implements INpc, IRangedAttackMob
{
    private int randomTickDivider;
    
    public Minecraft mc;

    /** addDefaultEquipmentAndRecipies is called if this is true */
    private boolean needsInitilization;

    /** Last player to trade with this villager, used for aggressivity. */
    private String lastBuyingPlayer;
    private boolean field_82190_bM;
    private float field_82191_bN;
    
    public Class EntitySoldier_Rebel;

    public EntitySoldier_Union(World par1World)
    {
    	this(par1World, 0);
    	isUnion = true;
    }

    public EntitySoldier_Union(World par1World, int par2)
    {
        super(par1World);
        isUnion = true;
        this.randomTickDivider = 0;
        this.setProfession(par2);
        this.addItems();
        this.setSize(0.6F, 1.8F);
        this.getNavigator().setBreakDoors(true);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0D, Config.attackTime, 51));
        this.tasks.addTask(3, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntitySoldier_Rebel.class, 1, false));
    }
    public boolean isAIEnabled()
    {
        return true;
    }
    protected void entityInit(){
    	super.entityInit();
    }
    public void setProfession(int par1)
    {
    	super.setProfession(par1);
    }
    public int getProfession()
    {
        return super.getProfession();
    }
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
    }
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
    }
    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean canMateWith(EntityAnimal par1EntityAnimal)
    {
        return false;
    }
	 private void addItems(){
		 int x = this.getProfession();
		 if(x == 0){
			setCurrentItemOrArmor(0, new ItemStack(Registry.musket, 1, 0));
		 }
		 else if(x == 1){
			setCurrentItemOrArmor(0, new ItemStack(Registry.revolver, 1, 0));
		 }
		else if(x == 2){
			setCurrentItemOrArmor(0, new ItemStack(Item.appleRed, 1, 0));
		 }
		else if(x == 3){
			setCurrentItemOrArmor(0, new ItemStack(Item.gunpowder, 1, 0));
		 }
		else if(x == 4){
	        setCurrentItemOrArmor(0, new ItemStack(Registry.musket, 1, 0));
	     }
	 }
	    protected void setArmor(int par1){
	    	if(par1 == 0){
	    		setCurrentItemOrArmor(1, new ItemStack(Item.plateIron));
	    	}
	    	else if(par1 == 1){
	    		setCurrentItemOrArmor(0, new ItemStack(Registry.cap));
	    	}
	    }
	   
	    public boolean interact(EntityPlayer par1EntityPlayer)
	    {
	        ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

	        if (this.isTamed())
	        {
	            if (itemstack != null)
	            {
	                if (Item.itemsList[itemstack.itemID] instanceof ItemFood)
	                {
	                    ItemFood itemfood = (ItemFood)Item.itemsList[itemstack.itemID];

	                    if (itemstack == new ItemStack(Item.appleRed) && this.dataWatcher.getWatchableObjectInt(18) < this.getMaxHealth())
	                    {
	                        if (!par1EntityPlayer.capabilities.isCreativeMode)
	                        {
	                            --itemstack.stackSize;
	                        }

	                        this.heal(itemfood.getHealAmount());

	                        if (itemstack.stackSize <= 0)
	                        {
	                            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
	                        }

	                        return true;
	                    }
	                }
	            }

	            if (par1EntityPlayer.username.equalsIgnoreCase(this.getOwnerName()) && !this.worldObj.isRemote && !this.isBreedingItem(itemstack))
	            {
	                this.isJumping = false;
	                this.setPathToEntity((PathEntity)null);
	            }
	        }
	        else if (itemstack != null && itemstack.itemID == Registry.coin.itemID && !this.isAngry())
	        {
	            if (!par1EntityPlayer.capabilities.isCreativeMode)
	            {
	                --itemstack.stackSize;
	            }

	            if (itemstack.stackSize <= 0)
	            {
	                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
	            }

	            if (!this.worldObj.isRemote)
	            {
	                if (this.rand.nextInt(3) == 0)
	                {
	                    this.setTamed(true);
	                    par1EntityPlayer.addChatMessage("You have recruited a " + this.getProfessionName(this.getProfession()) + " to your army");
	                    this.setPathToEntity((PathEntity)null);
	                    this.setAttackTarget((EntityLiving)null);
	                    this.setEntityHealth(20);
	                    this.setOwner(par1EntityPlayer.username);
	                    this.playTameEffect(true);
	                }
	                else
	                {
	                    this.playTameEffect(false);
	                }
	            }

	            return true;
	        }

	        return super.interact(par1EntityPlayer);
	    }
	    
	   public EntitySoldier_Union func_90012_b(EntityAgeable par1EntityAgeable)
	    {
	        EntitySoldier_Union entityvillager = new EntitySoldier_Union(this.worldObj);
	        entityvillager.func_110161_a((EntityLivingData)null);
	        return entityvillager;
	    }

	   public EntityLivingData func_110161_a(EntityLivingData par1EntityLivingData)
	    {
	        par1EntityLivingData = super.func_110161_a(par1EntityLivingData);
	        super.applyRandomTrade(this, worldObj.rand);
	        return par1EntityLivingData;
	    }
}