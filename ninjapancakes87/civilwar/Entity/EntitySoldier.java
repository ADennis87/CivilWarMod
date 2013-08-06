package ninjapancakes87.civilwar.Entity;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.INpc;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.Extras;
import ninjapancakes87.civilwar.item.EntityMusketBall;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntitySoldier extends EntityTameable implements INpc, IRangedAttackMob{
	
	private static final SoldierRegistry INSTANCE = new SoldierRegistry();
	
	public static final ResourceLocation loc = new ResourceLocation(Extras.sm + "soldier.png");
	
	public boolean isUnion;
	
	public static SoldierRegistry instance()
    {
        return INSTANCE;
    }
	public EntitySoldier(World par1World)
    {
        this(par1World, 0);
    }
	public EntitySoldier(World par1World, int par2)
    {
        super(par1World);
    }

	protected void func_110147_ax()
    {
        super.func_110147_ax();
        // Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(50.0D);
        // Follow Range - default 32.0D - min 0.0D - max 2048.0D
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(32.0D);
        // Knockback Resistance - default 0.0D - min 0.0D - max 1.0D
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(0.0D);
        // Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.13D);
    }
	protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(20, Integer.valueOf(4));
    }
    public void setAttackTarget(EntityLivingBase par1EntityLiving)
    {
        super.setAttackTarget(par1EntityLiving);

        if (par1EntityLiving instanceof EntityPlayer)
        {
            this.setAngry(true);
        }
    }
    public String getProfessionName(int par1){
		 switch(par1){
		 case 0: return "General of the Army";
		 case 1: return "Captain";
		 case 2: return "Doctor";
		 case 3: return "Barracks Master";
		 case 4: return "Soldier (" + soldierRanks(1) + ")";
		 case 5: return "Cavalry Man";
		 default: return "Soldier";
		 }
	 }
    public String soldierRanks(int par1){
    	switch(par1){
    	case 1: return "Private";
    	default: return "Private";
    	}
    	
    }

	public int getMaxHealth()
    {
        return this.isTamed() ? 20 : 8;
    }
	 public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.writeEntityToNBT(par1NBTTagCompound);
	        par1NBTTagCompound.setBoolean("Angry", this.isAngry());
	        par1NBTTagCompound.setInteger("Profession", this.getProfession());
	        }

	    /**
	     * (abstract) Protected helper method to read subclass entity data from NBT.
	     */
	    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.readEntityFromNBT(par1NBTTagCompound);
	        this.setAngry(par1NBTTagCompound.getBoolean("Angry"));
	        this.setProfession(par1NBTTagCompound.getInteger("Profession"));
	    }
	    protected boolean canDespawn()
	    {
	        return this.isAngry() && !this.isTamed();
	    }
	    public void setProfession(int par1)
	    {
	    	this.dataWatcher.updateObject(20, Integer.valueOf(par1));
	    }

	    public int getProfession()
	    {
	        return this.dataWatcher.getWatchableObjectInt(20);
	    }
	    protected String getLivingSound()
	    {
	        return "mob.villager.default";
	    }

	    /**
	     * Returns the sound this mob makes when it is hurt.
	     */
	    protected String getHurtSound()
	    {
	        return "Civil War:hurt";
	    }

	    /**
	     * Returns the sound this mob makes on death.
	     */
	    protected String getDeathSound()
	    {
	        return "Civil War:hurt";
	    }
	    protected float getSoundVolume()
	    {
	        return 0.4F;
	    }
		@Override
		public EntityAgeable createChild(EntityAgeable entityageable) {
			return null;
		}
		 public int getMaxSpawnedInChunk()
		    {
		        return 16;
		    }
		 public boolean isBreedingItem(ItemStack par1ItemStack)
		    {
		        return par1ItemStack == null ? false : (!(Item.itemsList[par1ItemStack.itemID] instanceof ItemFood) ? false : ((ItemFood)Item.itemsList[par1ItemStack.itemID]).isWolfsFavoriteMeat());
		    }
		 public boolean attackEntityAsMob(Entity par1Entity)
		    {
		        int i = this.isTamed() ? 4 : 2;
		        return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), i);
		    }
		 public boolean isAngry()
		    {
		        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
		    }

		    /**
		     * Sets whether this wolf is angry or not.
		     */
		    public void setAngry(boolean par1)
		    {
		        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

		        if (par1)
		        {
		            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 2)));
		        }
		        else
		        {
		            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -3)));
		        }
		    }
		    @SideOnly(Side.CLIENT)
		    public void handleHealthUpdate(byte par1)
		    {
		        super.handleHealthUpdate(par1);
		    }

		    public boolean func_70922_bv()
		    {
		        return this.dataWatcher.getWatchableObjectByte(19) == 1;
		    }
		    protected void updateAITick()
		    {
		    	super.updateAITick();
		    }
		    public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
		    {
		        if (this.isEntityInvulnerable())
		        {
		            return false;
		        }
		        else
		        {
		            Entity entity = par1DamageSource.getEntity();

		            if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
		            {
		                par2 = (par2 + 1) / 2;
		            }

		            return super.attackEntityFrom(par1DamageSource, par2);
		        }
		    }
		    public void func_70918_i(boolean par1)
		    {
		        byte b0 = this.dataWatcher.getWatchableObjectByte(19);

		        if (par1)
		        {
		            this.dataWatcher.updateObject(19, Byte.valueOf((byte)1));
		        }
		        else
		        {
		            this.dataWatcher.updateObject(19, Byte.valueOf((byte)0));
		        }
		    }
		    public static void applyRandomTrade(EntitySoldier villager, Random rand)
		    {
		        int trade = rand.nextInt(5);
		        villager.setProfession(trade);
		    }
			@Override
			public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLiving, float f) {
				 EntityMusketBall entityarrow = new EntityMusketBall(this.worldObj, this, par1EntityLiving, 1.6F, (float)(14 - this.worldObj.difficultySetting * 4));

			     this.playSound("Civil War:gunshot", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
			     this.worldObj.spawnEntityInWorld(entityarrow);
				
			}
	 @SideOnly(Side.CLIENT)
	 public ResourceLocation getTexture(){
		//String basic = Extras.sm;
		 String basic = CivilWar.modid + ":textures/mob/";
		if(isUnion){
		 switch (this.getProfession()){
		 	case 0:return new ResourceLocation(basic + "commander.png");
			case 1:return new ResourceLocation(basic + "captain.png");
			case 2:return new ResourceLocation(basic + "doctor.png");
			case 3:return new ResourceLocation(basic + "wm.png");
			case 4:return new ResourceLocation(basic + "soldier.png");
			default:return this.loc;
			        }
		}
		else if(!isUnion){
			switch (this.getProfession()){
				case 0:return new ResourceLocation(basic + "rcommander.png");
				case 1:return new ResourceLocation(basic + "rcaptain.png");
				case 2:return new ResourceLocation(basic + "rdoctor.png");
				case 3:return new ResourceLocation(basic + "rwm.png");
				case 4:return new ResourceLocation(basic + "rsoldier.png");
				default:return this.loc;
				    }
				 }
		else{
			return this.loc;
			 }
		}
}
