package ninjapancakes87.civilwar.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.Extras;
import ninjapancakes87.civilwar.Registry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDefault extends Item{
	
	public Extras e;
	
	public ItemDefault(int par1){
		super(par1);
		
		this.setCreativeTab(CivilWar.tabCivilWar);
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		if(itemID == Registry.cannonball.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:cannonball");
		}
		else if(itemID == Registry.cloth.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:cloth");
		}
		else if(itemID == Registry.cloth2.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:cloth2");
		}
		else if(itemID == Registry.coin.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:coin");
		}
		else if(itemID == Registry.coin2.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:coin2");
		}
		else if(itemID == Registry.lead.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:lead");
		}
		else if(itemID == Registry.musket.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:musket");
		}
		else if(itemID == Registry.musketball.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:musketball");
		}
		else if(itemID == Registry.revolver.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:revolver");
		}
		else if(itemID == Registry.saber.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:saber");
		}
	}

}
