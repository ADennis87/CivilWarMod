package ninjapancakes87.civilwar.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSword;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.Registry;
import ninjapancakes87.civilwar.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSaber extends ItemSword{

	public ItemSaber(ToolMaterial par3EnumToolMaterial) {
		super(par3EnumToolMaterial);
		
		this.setCreativeTab(CivilWar.tabCivilWar);
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(Strings.SABER);
	}

}
