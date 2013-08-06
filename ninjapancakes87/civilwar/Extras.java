package ninjapancakes87.civilwar;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import ninjapancakes87.civilwar.item.ItemDefault;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Extras {
	public static String s = CivilWar.modid + ":textures/";
	public static String sb = s + "blocks/";
	public static String si = s + "items/";
	public static String sm = s = "mob/";
	public static void addName(Object object, String name){
		LanguageRegistry.addName(object, name);
	}
	public static void addBlock(Block par1, String par2){
		GameRegistry.registerBlock(par1, par2);
		addName(par1, par2);
	}
	public static Item addDefaultItem(Item par1, int par2, String par3){
		par1 = new ItemDefault(par2);
		par1.setUnlocalizedName(par3);
		addName(par1, par3);
		return par1;
	}
	public static void addUniqueEntityID(int par1, Class par2, String par3){
		par1 = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(par2,par3, par1);
	}
	public static void addUniqueLivingEntityID(int par1, Class par2, String par3, Object mod, int par4, int par5, boolean par6){
		addUniqueEntityID(par1, par2, par3);
		EntityRegistry.registerModEntity(par2, par3, par1, mod, par4, par5, par6);
	}
	public static void registerEntityEgg(Class <? extends Entity> entity, int entityid, int primaryColor, int secondaryColor){
		EntityList.IDtoClassMapping.put(entityid, entity);
		EntityList.entityEggs.put(entityid, new EntityEggInfo(entityid, primaryColor,secondaryColor));			
	}
	public static float func_82498_a()
    {
        return 6.0F;
    }

    public static float func_82500_b()
    {
        return 1.1F;
    }
}
