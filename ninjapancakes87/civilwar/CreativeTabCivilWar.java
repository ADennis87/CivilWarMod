package ninjapancakes87.civilwar;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabCivilWar extends CreativeTabs{

	public CreativeTabCivilWar(int position, String name) {
		super(position,name);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Item getTabIconItem() {
		return Registry.musket;
	}

}
