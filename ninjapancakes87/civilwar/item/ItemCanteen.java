package ninjapancakes87.civilwar.item;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.Registry;
import ninjapancakes87.civilwar.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCanteen extends ItemFood{
	
	@SideOnly(Side.CLIENT)
	private IIcon canteenEmpty;
	@SideOnly(Side.CLIENT)
	private IIcon canteenFull;
	
	public ItemCanteen(int par2, boolean par4) {
		super(par2, par4);
		this.setCreativeTab(CivilWar.tabCivilWar);
		this.maxStackSize = 1;
		this.setAlwaysEdible();
		this.setHasSubtypes(true);
	}
	@Override
	public String getUnlocalizedName(ItemStack stack){
		String s = this.getDamage(stack) == 0 ? "empty" : "full";
		return "item." + s + "canteen";
	}
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
		this.canteenEmpty = par1IconRegister.registerIcon(Strings.CANTEEN_EMPTY);
		this.canteenFull = par1IconRegister.registerIcon(Strings.CANTEEN_FULL);
    }
	 @SideOnly(Side.CLIENT)
	 public IIcon getIconFromDamage(int par1){
		 if(par1 == 0){
			 return this.canteenEmpty;
		 }
		 if(par1 == 1){
			 return this.canteenFull;
		 }
		 else{
			 return this.canteenEmpty;
		 }
	 }
	 @Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
	    super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
        if (!par2World.isRemote)
        {
            par3EntityPlayer.clearActivePotions();
            par3EntityPlayer.addChatMessage(new ChatComponentText("Healed!"));
        }
        return new ItemStack(Registry.canteen, 1, 0);
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	if(this.getDamage(par1ItemStack) == 0){
    	MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);

        if (movingobjectposition == null)
        {
            return par1ItemStack;
        }
        else
        {
            if (movingobjectposition.typeOfHit == MovingObjectType.BLOCK)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
                {
                    return par1ItemStack;
                }

                if (par2World.getBlock(i, j, k).getMaterial() == Material.water)
                {
                    --par1ItemStack.stackSize;

                    if (par1ItemStack.stackSize <= 0)
                    {
                        return new ItemStack(Registry.canteen, 1, 1);
                    }

                    if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Registry.canteen)))
                    {
                        par3EntityPlayer.dropItem(Registry.canteen, 1);
                    }
                }
            }
        }
    	}
    	else if(this.getDamage(par1ItemStack) == 1){
    		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
    	}
        return par1ItemStack;
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
    }
}
