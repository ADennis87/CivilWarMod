package ninjapancakes87.civilwar.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.Registry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CWArmor extends ItemArmor{
	public EnumArmorMaterial material;

	public CWArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(CivilWar.tabCivilWar);
		}
	/** 
	 * Returns the Armor Texture File
	 */
	@Override
	public String getArmorTexture(ItemStack par1, Entity entity, int slot, int layer){
		if(par1.itemID == Registry.unionuniform.itemID||par1.itemID == Registry.boots.itemID)
			{
				return "civil war:textures/armor/cloth_1.png";
			}
		if(par1.itemID == Registry.cap.itemID || par1.itemID == Registry.rebeluniform.itemID)
			{
				return "civil war:textures/armor/rebel_1.png";
			}
		if(par1.itemID == Registry.legs.itemID)
			{
				return "civil war:textures/armor/cloth_2.png";
			}
		return "civil war:textures/armor/cloth_2.png";
		
	}
	/**
	 * Loads the textures for the icons (what you see in your inventory)
	 */
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		if(itemID == Registry.cap.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:cap");
		}
		if(itemID == Registry.rebeluniform.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:rebel uniform");
		}
		if(itemID == Registry.unionuniform.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:union uniform");
		}
		if(itemID == Registry.legs.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:pants");
		}
		if(itemID == Registry.boots.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("Civil War:boots");
		}
	}
}

