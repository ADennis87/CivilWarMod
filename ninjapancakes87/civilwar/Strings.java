package ninjapancakes87.civilwar;

import net.minecraft.util.ResourceLocation;
import ninjapancakes87.civilwar.entity.EntitySoldier;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Strings { 
	public static String CANNONBALL = "Civil War:cannonball";
	public static String CLOTH = "Civil War:cloth";
	public static String CLOTH2 = "Civil War:cloth2";
	public static String COIN = "Civil War:coin";
	public static String COIN2 = "Civil War:coin2";
	public static String LEAD = "Civil War:lead";
	public static String REVOLVER = "Civil War:revolver";
	public static String MUSKETBALL = "Civil War:musketball";
	public static String SABER = "Civil War:saber";
	public static String MUSKET_1 = "Civil War:musket";
	public static String HAVERSACK = "Civil War:haversack";
	public static String MUCKET = "Civil War:mucket";
	public static String CANTEEN_EMPTY = "Civil War:canteen_0";
	public static String CANTEEN_FULL = "Civil War:canteen_1";
	
	public static String LEAD_ORE = "Civil War:leadOre";
	public static String GHOST = "Civil War:ghost";
	public static String CANNON = "Civil War:textures/blocks/cannon.png";
	public static String MUCKET_BLOCK = "Civil War:textures/blocks/mucket.png";
	
	public static String CANNON_GUI = "Civil War:textures/gui/cannon.png";
	public static String HAVERSACK_GUI = "Civil War:textures/gui/haversack.png";
	
	public static String ARMOR_1 = "civil war:textures/armor/2cloth_1.png";
	public static String ARMOR_2 = "civil war:textures/armor/2rebel_1.png";
	public static String ARMOR_3 = "civil war:textures/armor/2cloth_2.png";
	
	public static String MUSKETBALL_AMMO = "civil war:textures/items/ammo.png";
	
	public String SOLDIER_UNION = "civil war:textures/mob/";
	public String SOLDIER_REBEL = "civil war:textures/mob/";
	
	public static String PROPERTIES = "CivilWarProperties";
	
	public static String[] ranks = {"Private", "Corporal", "Sergeant", "Sergeant Major", "Lieutenant", "Captain", "Major", "Lieutenant Colonel", "Colonel", "Brigadier General", "Major General" };
	public static String[] army = {"Company", "Regiment", "Brigade", "Divison", "Corps", "Army"};
	
	public static String[] firstNames = {"Andrew", "John", "William", "James", "George", "Charles", "Henry", "Thomas", "Samuel", "David"};
	public static String[] lastNames = {"Buckley", "Mayor", "Smith", "York", "Augustine", "Gerald", "Alexander", "Homer", "Grant", "Lee"};
		
	public static int UnionID;
	public static int RebelID;
	public static int MusketID;
	
	private static String loc;
	
	public static ResourceLocation getSoldierTexture(EntitySoldier par1){
		if(par1.getProfession() == 0){
			loc = "doctor.png";
		}
		else if(par1.getProfession() == 1){
			loc = "wm.png";
		}
		else if(par1.getProfession() == 2){
			if(par1.getRank() < 24){
				loc = "soldier.png";
			}
			else if(par1.getRank() >= 25 && par1.getRank() < 100){
				loc = "captain.png";
			}
			else{
				loc = "commander.png";
			}
		}
		if(par1.isUnion){
			return new ResourceLocation("civil war:textures/mob/" + loc);
		}
		else{
			return new ResourceLocation("civil war:textures/mob/r" + loc);
		}
	}
}
