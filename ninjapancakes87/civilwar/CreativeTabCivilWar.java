package ninjapancakes87.civilwar;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabCivilWar extends CreativeTabs{

	public CreativeTabCivilWar(int position, String name) {
		super(position,name);
	}
	@SideOnly(Side.CLIENT)	
	public int getTabIconItemIndex() {	
		return Registry.musket.itemID; 
	}

}
