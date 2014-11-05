package ninjapancakes87.civilwar.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.Registry;
import ninjapancakes87.civilwar.Strings;

public class BlockDefault extends Block{

	public BlockDefault() {
		super(Material.rock);
		setCreativeTab(CivilWar.tabCivilWar);
		setHardness(3.0F);
		setResistance(5.0F);
		}
}
