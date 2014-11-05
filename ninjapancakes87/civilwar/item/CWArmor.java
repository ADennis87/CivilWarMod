package ninjapancakes87.civilwar.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.Registry;
import ninjapancakes87.civilwar.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CWArmor extends ItemArmor{
	public ArmorMaterial material;

	public CWArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(CivilWar.tabCivilWar);
		}
	/** 
	 * Returns the Armor Texture File
	 */
	@Override
	public String getArmorTexture(ItemStack par1, Entity entity, int slot, String layer){
		if(par1.getItem() == Registry.unionuniform||par1.getItem() == Registry.boots)
			{
				return Strings.ARMOR_1;
			}
		if(par1.getItem() == Registry.cap || par1.getItem() == Registry.rebeluniform)
			{
				return Strings.ARMOR_2;
			}
		if(par1.getItem() == Registry.legs)
			{
				return Strings.ARMOR_3;
			}
		return Strings.ARMOR_3;
		
	}
	/*
	 * Loads the textures for the icons (what you see in your inventory)
	 
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		if(this == Registry.cap)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:cap");
		}
		if(this == Registry.rebeluniform)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:rebel uniform");
		}
		if(this == Registry.unionuniform)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:union uniform");
		}
		if(this == Registry.legs)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:pants");
		}
		if(this == Registry.boots)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:boots");
		}
	}*/
}

