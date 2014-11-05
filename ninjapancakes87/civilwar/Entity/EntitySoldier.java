package ninjapancakes87.civilwar.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import ninjapancakes87.civilwar.Extras;
import ninjapancakes87.civilwar.Registry;
import ninjapancakes87.civilwar.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntitySoldier extends EntityTameable implements IMerchant, INpc,IRangedAttackMob {
	protected int[] levelUp = {5, 10, 15, 20, 25, 35, 45, 55, 65, 100};
	
	/** Whether the soldier is a Union soldier or not */
	public boolean isUnion;
		
	/**The custom name for this soldier*/
	public String name;
	
    /** This villager's current customer. */
    private EntityPlayer buyingPlayer;

	private MerchantRecipeList buyingList;
	
    private float field_82191_bN;
    
    public static final Map villagerStockList = new HashMap();
    
    private int timeUntilReset;

    /** addDefaultEquipmentAndRecipies is called if this is true */
    private boolean needsInitilization;
    
    private String lastBuyingPlayer;
    
    private int healCooldown;
    
	public EntitySoldier(World par1World, boolean par2) {
		super(par1World);
		this.isUnion = par2;
		this.addDefaultEquipmentAndRecipies();
		this.setSize(0.6F, 1.8F);
		this.getNavigator().setBreakDoors(true);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIArrowAttack(this, 0.5D, 15, 51));
        this.tasks.addTask(3, new EntityAIFollowOwner(this, 0.5D, 10.0F, 2.0F));
        this.tasks.addTask(4, new EntityAIWander(this, 0.5D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(20, Integer.valueOf(0));
		this.dataWatcher.addObject(21, Integer.valueOf(0));
		name = this.getRandomName();
	}
	
	@Override
	protected boolean canDespawn() {
		return this.isAngry() && !this.isTamed();
	}
	
	@Override
	public void onLivingUpdate(){
		super.onLivingUpdate();
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
	}	

	@Override
	protected String getLivingSound() {
		return (String)null;
	}

	@Override
	protected String getHurtSound() {
		return "Civil War:hurt";
	}
	
	@Override
	protected String getDeathSound() {
		return "Civil War:hurt";
	}

	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}

	@Override
	public void setAttackTarget(EntityLivingBase par1EntityLiving) {
		super.setAttackTarget(par1EntityLiving);
		if (par1EntityLiving instanceof EntityPlayer) {
			this.setAngry(true);
		}
	}

	public String getProfessionName() {
		switch (this.getProfession()) {
		case 0: return "Doctor";
		case 1: return "Barracks Master";
		case 2: return "Soldier (" + soldierRanks() + ")";
		//case 3: return "Cavalry";
		default: return "Soldier";
		}
	}
	
	public int getRank(){
		return this.dataWatcher.getWatchableObjectInt(21);
	}
	
	public String soldierRanks() {
		int i = this.getRank();
		return Strings.ranks[i/5];
	}
	
	public String getRandomName(){
		int i = rand.nextInt(9);
		int j = rand.nextInt(9);
		return Strings.firstNames[i] + " " + Strings.lastNames[j];
	}
	public void setRank(int par1){
		this.dataWatcher.updateObject(21, par1);
		
	}
	public void levelUp(EntityPlayer par1EntityPlayer){
		this.setRank(this.getRank() + 1);
		for(int i = 0; i < levelUp.length; i++ ){
			if(this.getRank() == levelUp[i]){
				this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue() + 5.0D);
				this.setHealth(this.getHealth() + 5);
				par1EntityPlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA + this.name + EnumChatFormatting.RESET + " is now a " + EnumChatFormatting.GRAY + this.soldierRanks()));
				
			}
		}
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String par1){
		this.name = par1;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		//par1NBTTagCompound.setString("Owner", this.getOwnerName());
		par1NBTTagCompound.setBoolean("Angry", this.isAngry());
		par1NBTTagCompound.setBoolean("isUnion", this.isUnion);
		par1NBTTagCompound.setInteger("Type", this.getProfession());
		par1NBTTagCompound.setString("cName", this.getName());
		par1NBTTagCompound.setInteger("rank", this.getRank());
		if (this.buyingList != null)
        {
            par1NBTTagCompound.setTag("Offers", this.buyingList.getRecipiesAsTags());
        }
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		//this.setOwner(par1NBTTagCompound.getString("Owner"));
		this.setAngry(par1NBTTagCompound.getBoolean("Angry"));
		this.setProfession(par1NBTTagCompound.getInteger("Type"));
		this.isUnion = par1NBTTagCompound.getBoolean("isUnion");
		this.setRank(par1NBTTagCompound.getInteger("rank"));
		this.setName(par1NBTTagCompound.getString("cName"));
		if (par1NBTTagCompound.hasKey("Offers"))
        {
            NBTTagCompound nbttagcompound1 = par1NBTTagCompound.getCompoundTag("Offers");
            this.buyingList = new MerchantRecipeList(nbttagcompound1);
        }
	}

	public void setProfession(int par1) {
		this.dataWatcher.updateObject(20, Integer.valueOf(par1));
	}

	public int getProfession() {
		return this.dataWatcher.getWatchableObjectInt(20);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		return (EntityAgeable)null;
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 16;
	}

	public boolean isAngry() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
	}

	public void setAngry(boolean par1) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

		if (par1) {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 | 2)));
		} else {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 & -3)));
		}
	}

	public boolean canMateWith(EntityAnimal par1EntityAnimal) {
		return false;
	}

	public boolean func_70922_bv() {
		return this.dataWatcher.getWatchableObjectByte(19) == 1;
	}

	public boolean isAIEnabled() {
		return true;
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else {
			Entity entity = par1DamageSource.getEntity();

			if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
				par2 = (par2 + 1) / 2;
			}

			return super.attackEntityFrom(par1DamageSource, par2);
		}
	}

	public void func_70918_i(boolean par1) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(19);

		if (par1) {
			this.dataWatcher.updateObject(19, Byte.valueOf((byte) 1));
		} else {
			this.dataWatcher.updateObject(19, Byte.valueOf((byte) 0));
		}
	}

	public static void applyRandomTrade(EntitySoldier villager, Random rand) {
		int trade = rand.nextInt(5);
		if(trade >= 2){
			villager.setProfession(2);
		}
		else{
			villager.setProfession(trade);
		}
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entitylivingbase, float f) {
		super.attackEntity(entitylivingbase, f);		
	}
	
	public boolean isTrading()
    {
        return this.buyingPlayer != null;
    }
	
	public void setCustomer(EntityPlayer par1EntityPlayer)
	{
		this.buyingPlayer = par1EntityPlayer;
	}

	@Override
	public EntityPlayer getCustomer() {
		return this.buyingPlayer;
	}
	
	public boolean interact(EntityPlayer par1EntityPlayer){
        ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
        boolean flag = itemstack != null && itemstack.getItem() == Items.spawn_egg && itemstack.getItem() == Registry.coin && itemstack.getItem() == Registry.coin2;

		if (!flag && this.isEntityAlive() && !this.isTrading() && this.getProfession() == 1)
        {
            if (!this.worldObj.isRemote)
            {
                this.setCustomer(par1EntityPlayer);
                par1EntityPlayer.displayGUIMerchant(this, this.getName());
            }

            return true;
        }
		else{
			return super.interact(par1EntityPlayer);
		}
	}

	@Override
	public MerchantRecipeList getRecipes(EntityPlayer entityplayer) {
		if (this.buyingList == null)
        {
            this.addDefaultEquipmentAndRecipies();
        }

        return this.buyingList;
	}

	private void addDefaultEquipmentAndRecipies() {
		setCurrentItemOrArmor(0, new ItemStack(Registry.musket, 1, 0));

		if (this.buyingList != null)
        {
            this.field_82191_bN = MathHelper.sqrt_float((float)this.buyingList.size()) * 0.2F;
        }
        else
        {
            this.field_82191_bN = 0.0F;
        }

        MerchantRecipeList merchantrecipelist;
        merchantrecipelist = new MerchantRecipeList();
        int j;

        addCoinedItem(merchantrecipelist, Registry.musket, this.rand, this.adjustProbability(0.5F), 2, 1);
        addCoinedItem(merchantrecipelist, Registry.revolver, this.rand, this.adjustProbability(0.5F), 2, 1);
        addCoinedItem(merchantrecipelist, Registry.saber, this.rand, this.adjustProbability(0.3F), 4, 1);         
        addCoinedItem(merchantrecipelist, Registry.musketball, this.rand, this.adjustProbability(0.8F), 1, 4);
        addEmeraldItem(merchantrecipelist, this.rand, this.adjustProbability(0.5F));              
        addEmeraldItem(merchantrecipelist, this.rand, this.adjustProbability(0.5F));             


        if (merchantrecipelist.isEmpty())
        {
            addCoinedItem(merchantrecipelist, Items.gold_ingot, this.rand, 1.0F, 1, 1);
        }

        Collections.shuffle(merchantrecipelist);

        if (this.buyingList == null)
        {
            this.buyingList = new MerchantRecipeList();
        }

        for (int j1 = 0; j1 < 1 && j1 < merchantrecipelist.size(); ++j1)
        {
            this.buyingList.addToListWithCheck((MerchantRecipe)merchantrecipelist.get(j1));
        }
	}
	
	private float adjustProbability(float par1)
    {
        float f1 = par1 + this.field_82191_bN;
        return f1 > 0.9F ? 0.9F - (f1 - 0.9F) : f1;
    }

	@SideOnly(Side.CLIENT)
	public void setRecipes(MerchantRecipeList merchantrecipelist) {
	}

	@Override
	public void useRecipe(MerchantRecipe par1MerchantRecipe) {
		par1MerchantRecipe.incrementToolUses();
        this.livingSoundTime = -this.getTalkInterval();
        this.playSound("mob.villager.yes", this.getSoundVolume(), this.getSoundPitch());

        if (par1MerchantRecipe.hasSameIDsAs((MerchantRecipe)this.buyingList.get(this.buyingList.size() - 1)))
        {
            this.timeUntilReset = 40;
            this.needsInitilization = true;

            if (this.buyingPlayer != null)
            {
                this.lastBuyingPlayer = this.buyingPlayer.getCommandSenderName();
            }
            else
            {
                this.lastBuyingPlayer = null;
            }
        }
        this.setRank(this.getRank() + 5);
	}

	@Override
	public void func_110297_a_(ItemStack itemstack) {		
	}
	/**
	 * 
	 * @param par0MerchantRecipeList The Recipe List to add the recipe to
	 * @param par1 The ID of the item to be traded for
	 * @param par2Random Compared to par3, not sure why.  Was in villager code.
	 * @param par3 Compared to par2Random.nextFloat(), not sure why.  Was in villager code.
	 * @param par4 Number of coins this item costs
	 * @param par6 Number of par1 to be sold
	 */
	public void addCoinedItem(MerchantRecipeList par0MerchantRecipeList, Item par1, Random par2Random, float par3, int par4, int par6)
    {
        if (par2Random.nextFloat() < par3)
        {
        	if(this.isUnion){
            par0MerchantRecipeList.add(new MerchantRecipe(new ItemStack(Registry.coin, par4), new ItemStack(par1, par6, 0)));
        	}
        	else if(!this.isUnion){
        	par0MerchantRecipeList.add(new MerchantRecipe(new ItemStack(Registry.coin2, par4), new ItemStack(par1, par6, 0)));
        	}
        }
    }
	/**
	 * This method is used only for trading emeralds -> coins.
	 * 
	 * @param par0MerchantRecipeList The Recipe List the trade will be added to
	 * @param par2Random Random object, compared to par3.  Don't know why, was in villager code.
	 * @param par3 Float, compared to par2random.nextFloat().  Don't know why, was in villager code.
	 */
	public void addEmeraldItem(MerchantRecipeList par0MerchantRecipeList, Random par2Random, float par3)
    {
        if (par2Random.nextFloat() < par3)
        {
        	if(this.isUnion){
            par0MerchantRecipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(Registry.coin, 2, 0)));
        	}
        	else if(!this.isUnion){
            par0MerchantRecipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(Registry.coin2, 2, 0)));
        	}
        }
    }
	public void triggerHeal(EntitySoldier soldier){
		if(this.getProfession() == 0){
				//System.out.println("Is Doctor");
				while(this.getHealth() < this.getMaxHealth()){
					soldier.heal(1.0F);
					this.healCooldown = 10;
					//System.out.println(soldier.getHealth());
					while(this.healCooldown < 0){
						--this.healCooldown;
						//System.out.println(this.healCooldown);
					}
			}
		}
	}
}
