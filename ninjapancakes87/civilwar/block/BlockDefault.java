package ninjapancakes87.civilwar.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.Registry;

public class BlockDefault extends Block{

	public BlockDefault(int par1) {
		super(par1, Material.rock);
		setCreativeTab(CivilWar.tabCivilWar);
		setHardness(3.0F);
		setResistance(5.0F);
		}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
	if(blockID == Registry.leadOre.blockID)
	{
		this.blockIcon = iconRegister.registerIcon("Civil War:leadOre");
	}
	}

}
