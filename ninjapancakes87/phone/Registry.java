package ninjapancakes87.phone;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.CivilWarCommonProxy;
import ninjapancakes87.phone.item.ItemPhone;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Registry {
	
	public static Item phone;

	public static void preInit() {
		BlocksAndItems();
		GameRegistry();		
	}

	public static void Init() {
		EntityRegistry();
		EverythingElse();
	}

	public static void postInit() {
		FMLLog.info("INFO", Phone.modid + " mod v" + Phone.version + "initialized");
	}
	public static void BlocksAndItems() {
		phone = new ItemPhone().setUnlocalizedName("phone").setTextureName("phone:phone");
	}
	public static void GameRegistry() {
		GameRegistry.registerItem(phone, "phone");
		
		GameRegistry.addRecipe(new ItemStack(phone, 1),"xyx", "xzx", "xxx", 'x', Items.iron_ingot, 'y', Items.stick, 'z', Items.diamond);
	}
	public static void EntityRegistry() {
		
	}
	public static void EverythingElse() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Phone.instance, new PhoneCommonProxy());
	}

}
