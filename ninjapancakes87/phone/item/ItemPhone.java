package ninjapancakes87.phone.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ninjapancakes87.phone.Phone;

public class ItemPhone extends Item{
	public ItemPhone(){
		super();
		this.setCreativeTab(CreativeTabs.tabRedstone);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if(!par2World.isRemote){
			par3EntityPlayer.openGui(Phone.instance, 10, par2World, (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ);
		}
        return par1ItemStack;
    }
}
