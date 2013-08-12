package ninjapancakes87.civilwar;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;

public class Config {
	
	public static int EntityMusketBallID;
	public static int EntityCannonballID;
	public static int Soldier_UnionID;
	public static int Soldier_RebelID;
	public static int cannonID;
	public static int ghostID;
	
	public static int MusketID;
	public static int musketballID;
	public static int cannonballID;
	public static int revolverID;
	public static int saberID;
	public static int clothID;
	public static int cloth2ID;
	public static int coinID;
	public static int coin2ID;
	public static int leadID;
	public static int leadOreID;
	
	public static int helmetID;
	public static int chestplateID;
	public static int chestplate2ID;
	public static int legsID;
	public static int bootsID;
	
	public static String cannonS;
	public static int attackTime;
	
	public static void Init(FMLPreInitializationEvent event){
		Configuration config;
		if(FMLCommonHandler.instance().getSide() == Side.CLIENT)
		{
			config = new Configuration(new File(Minecraft.getMinecraft().mcDataDir + "/config/" + CivilWar.modid + ".cfg"));
		}
		else
		{
			config = new Configuration(new File("/config/" + CivilWar.modid + ".cfg"));
		}
		
		config.load();
		
		clothID = config.getItem("Blue_Cloth", 3901).getInt();
		cloth2ID = config.getItem("Gray_Cloth", 3902).getInt();
		coinID = config.getItem("Union_Coin", 3903).getInt();
		coin2ID = config.getItem("Confederate_Coin", 3904).getInt();
		MusketID = config.getItem("Musket", 3904).getInt();
		revolverID = config.getItem("Revolver", 3905).getInt();
		musketballID = config.getItem("Minie_Ball", 3906).getInt();
		saberID = config.getItem("Saber", 3907).getInt();
		cannonballID = config.getItem("Cannon_Ball", 3908).getInt();
		leadID = config.getItem("Lead", 3909).getInt();
		
		helmetID = config.getItem("Cap (Helmet)", 3910).getInt();
		chestplateID = config.getItem("Union_Uniform", 3911).getInt();
		chestplate2ID = config.getItem("Rebel_Uniform", 3912).getInt();
		legsID = config.getItem("Legs", 3913).getInt();
		bootsID = config.getItem("Boots", 3914).getInt();
		
		leadOreID = config.getBlock("Lead Ore", 3920).getInt();
		
		cannonID = config.getBlock("Cannon",3921).getInt();
		ghostID = config.getBlock("Ghost", "Is a technical block used to correct the collision bounding box for the cannon", 3922).getInt();
		cannonS = config.get("Misc", "Cannon TE Name", "Cannon").getString();
		attackTime = config.get("Misc", "Soldier Attack Rate (set higher for longer breaks inbetween shots, and set lower for less time between shots", 15).getInt();
		
		config.save();
	}
}
