package ninjapancakes87.civilwar.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.Registry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSaber extends ItemSword{

	public ItemSaber(int par1, EnumToolMaterial par3EnumToolMaterial) {
		super(par1, par3EnumToolMaterial);
		
		this.setCreativeTab(CivilWar.tabCivilWar);
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		if(itemID == Registry.saber.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:saber");
		}
	}

}
