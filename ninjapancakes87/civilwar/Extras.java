package ninjapancakes87.civilwar;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import ninjapancakes87.civilwar.entity.EntitySoldier;
import ninjapancakes87.civilwar.item.ItemDefault;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Extras {
		
	public static EntitySoldier[] soldiers;

	public static void addBlock(Block block, String name, float hardness){
		GameRegistry.registerBlock(block, name);
		block.setHardness(hardness);
	}
	public static Item addDefaultItem(Item par1, String name){
		par1 = new ItemDefault();
		par1.setUnlocalizedName(name);
		GameRegistry.registerItem(par1, name);
		return par1;
	}
	/*public List getSoldiersAroundEntity(EntityLivingBase par1){
		par1.worldObj.getClosestPlayerToEntity(par1Entity, par2)
	}*/
}
