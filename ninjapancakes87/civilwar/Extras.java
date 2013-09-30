package ninjapancakes87.civilwar;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import ninjapancakes87.civilwar.item.ItemDefault;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Extras {
	public static String s = CivilWar.modid + ":textures/";
	public static String sb = s + "blocks/";
	public static String si = s + "items/";
	public static String sm = s + "mob/";
	public static String sg = s + "gui/";
	public static void addName(Object object, String name){
		LanguageRegistry.addName(object, name);
	}
	public static void addBlock(Block block, String name, int hardness){
		GameRegistry.registerBlock(block, name);
		addName(block, name);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", hardness);
	}
	public static Item addDefaultItem(Item par1, int id, String name){
		par1 = new ItemDefault(id);
		par1.setUnlocalizedName(name);
		addName(par1,name);
		return par1;
	}
	public static void registerEntityEgg(Class <? extends Entity> entity, int entityid, int primaryColor, int secondaryColor){
		EntityList.IDtoClassMapping.put(entityid, entity);
		EntityList.entityEggs.put(entityid, new EntityEggInfo(entityid, primaryColor,secondaryColor));			
	}
}
