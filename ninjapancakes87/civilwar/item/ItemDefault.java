package ninjapancakes87.civilwar.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.Extras;
import ninjapancakes87.civilwar.Registry;
import ninjapancakes87.civilwar.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDefault extends Item{
	
	public Extras e;
	
	public ItemDefault(){
		super();
		this.setCreativeTab(CivilWar.tabCivilWar);
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		if(this == Registry.cannonball)
		{
			this.itemIcon = iconRegister.registerIcon(Strings.CANNONBALL);
		}
		else if(this == Registry.cloth)
		{
			this.itemIcon = iconRegister.registerIcon(Strings.CLOTH);
		}
		else if(this == Registry.cloth2)
		{
			this.itemIcon = iconRegister.registerIcon(Strings.CLOTH2);
		}
		else if(this == Registry.coin)
		{
			this.itemIcon = iconRegister.registerIcon(Strings.COIN);
		}
		else if(this == Registry.coin2)
		{
			this.itemIcon = iconRegister.registerIcon(Strings.COIN2);
		}
		else if(this == Registry.lead)
		{
			this.itemIcon = iconRegister.registerIcon(Strings.LEAD);
		}
		else if(this == Registry.musket)
		{
			this.itemIcon = iconRegister.registerIcon(Strings.MUSKET_1);
		}
		else if(this == Registry.musketball)
		{
			this.itemIcon = iconRegister.registerIcon(Strings.MUSKETBALL);
		}
		else if(this == Registry.revolver)
		{
			this.itemIcon = iconRegister.registerIcon(Strings.REVOLVER);
		}
		/*else if(this == Registry.haversack)
		{
			this.itemIcon = iconRegister.registerIcon(Strings.HAVERSACK);
		}*/
		else if(this == Registry.Imucket)
		{
			this.itemIcon = iconRegister.registerIcon(Strings.MUCKET);
		}
	}
}
