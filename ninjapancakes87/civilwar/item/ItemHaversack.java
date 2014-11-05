package ninjapancakes87.civilwar.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.tileentity.TileEntityMucket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHaversack extends ItemDefault{
	
	public ItemHaversack() {
		super();
	}
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		par3EntityPlayer.openGui(CivilWar.instance, 9, par2World, par3EntityPlayer.serverPosX, par3EntityPlayer.serverPosY, par3EntityPlayer.serverPosZ);
        return par1ItemStack;
    }
}
