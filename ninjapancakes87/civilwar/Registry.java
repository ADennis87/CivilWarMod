package ninjapancakes87.civilwar;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import ninjapancakes87.civilwar.Entity.EntitySoldier_Rebel;
import ninjapancakes87.civilwar.Entity.EntitySoldier_Union;
import ninjapancakes87.civilwar.block.BlockDefault;
import ninjapancakes87.civilwar.block.cannon.BlockCannon;
import ninjapancakes87.civilwar.block.cannon.TileEntityCannon;
import ninjapancakes87.civilwar.client.CivilWarClientProxy;
import ninjapancakes87.civilwar.item.CWArmor;
import ninjapancakes87.civilwar.item.EntityCannonBall;
import ninjapancakes87.civilwar.item.EntityMusketBall;
import ninjapancakes87.civilwar.item.ItemMusket;
import ninjapancakes87.civilwar.item.ItemRevolver;
import ninjapancakes87.civilwar.item.ItemSaber;
import ninjapancakes87.civilwar.worldgen.Ore;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Registry {
	public Extras e;
	
	public static CivilWarCommonProxy proxy;
	
	public static CivilWarClientProxy client;
	
	public static World worldObj;
	
	static EnumArmorMaterial ClothArmor = EnumHelper.addArmorMaterial("Soldier", 33, new int[]{1, 3, 2, 1}, 3);
																	   //DIAMOND(33, new int[]{3, 8, 6, 3}, 10);
	int renderA = proxy.addArmor("Soldier");
	static EnumToolMaterial CW = EnumHelper.addToolMaterial("Saber", 2, 150, 12.0F, 10, 22);
	public static int realrender = -1;

	public static Item musket;
	public static Item musketball;
	public static Item revolver;
	public static Item saber;
	public static Item cloth;
	public static Item cloth2;
	public static Item coin;
	public static Item coin2;
	public static Item lead;
	
	public static Item cap;
	public static Item unionuniform;
	public static Item rebeluniform;
	public static Item legs;
	public static Item boots;
	
	public static Block leadOre;
	
	public static Block cannon;
	public static Item cannonball;
	
	public static void preInit() {
		BlocksAndItems();
		GameRegistry();
		LanguageRegistry();	
	}	
	
	public static void Init(){
		EntityRegistry();
		EverythingElse();
	}
	public static void postInit(){
		CivilWar.CwLogger.info("Civil War " + CivilWar.version + " initialized");
	}
	public static void BlocksAndItems(){
		musket = (new ItemMusket(Config.MusketID)).setUnlocalizedName("Musket");
		revolver = (new ItemRevolver(Config.revolverID)).setUnlocalizedName("Revolver");
		saber = (new ItemSaber(Config.saberID,CW)).setUnlocalizedName("Saber");
		
		musketball = Extras.addDefaultItem(musketball, Config.musketballID, "Minie Ball");
		cannonball = Extras.addDefaultItem(cannonball, Config.cannonballID, "Cannonball");
		cloth = Extras.addDefaultItem(cloth, Config.clothID, "Blue Cloth");
		cloth2 = Extras.addDefaultItem(cloth2, Config.cloth2ID, "Gray Cloth");
		coin = Extras.addDefaultItem(coin, Config.coinID, "Union Coin");
		coin2 = Extras.addDefaultItem(coin2, Config.coin2ID, "Confederate Coin");
		lead = Extras.addDefaultItem(lead, Config.leadID, "Lead");
		
		cap = (new CWArmor(Config.helmetID,ClothArmor,0, 0)).setUnlocalizedName("Cap");
		unionuniform = (new CWArmor(Config.chestplateID,ClothArmor, 0, 1)).setUnlocalizedName("Union Uniform");
		rebeluniform = (new CWArmor(Config.chestplate2ID, ClothArmor,0, 1)).setUnlocalizedName("Rebel Uniform");
		legs = (new CWArmor(Config.legsID,ClothArmor, 0, 2)).setUnlocalizedName("Pants");
		boots = (new CWArmor(Config.bootsID,ClothArmor, 0, 3)).setUnlocalizedName("Boots");
		
		leadOre = (new BlockDefault(Config.leadOreID)).setUnlocalizedName("Lead Ore");

		cannon = (new BlockCannon(Config.cannonID));
	}
	public static void LanguageRegistry(){
		Extras.addName(musket, "Musket");
		Extras.addName(revolver, "Revolver");
		Extras.addName(saber, "Saber");
		
		Extras.addName(cap, "Cap");
		Extras.addName(unionuniform, "Union Uniform");
		Extras.addName(rebeluniform, "Confederate Uniform");
		Extras.addName(legs, "Pants");
		Extras.addName(boots, "Boots");
		
		LanguageRegistry.instance().addStringLocalization("entity.Union Soldier.name", "en_US", "Union Soldier");
		LanguageRegistry.instance().addStringLocalization("entity.Rebel Soldier.name", "en_US", "Confederate Soldier");
		LanguageRegistry.instance().addStringLocalization("death.attack.mb", "%1$s was shot to death"); 
		LanguageRegistry.instance().addStringLocalization("death.attack.mb.player", "%1$s was shot to death by %2$s"); 
		//LanguageRegistry.instance().addStringLocalization("death.attack.mb.item", "%1$s was shot to death by %2$s using custom gun %3$s"); 
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabCivilWar", "en_US", "Civil War");
		LanguageRegistry.instance().addStringLocalization("death.attack.cb", "%1$s was blown up"); 
		LanguageRegistry.instance().addStringLocalization("death.attack.cb.player", "%1$s was blown up by %2$s"); 
	}
	public static void GameRegistry(){
		GameRegistry.addRecipe(new ItemStack(revolver, 1), "xxx", " yx", 'x', Item.ingotIron, 'y', Item.flintAndSteel);
		GameRegistry.addRecipe(new ItemStack(musket, 1), "xxx"," yz", "xxx", 'x', Block.planks, 'y', Item.stick, 'z', Item.flintAndSteel);
		GameRegistry.addRecipe(new ItemStack(musketball, 8), " x ", " x ", 'x', Item.ingotIron);
		GameRegistry.addRecipe(new ItemStack(musketball, 16), " x ", " x ", 'x', lead);
		GameRegistry.addRecipe(new ItemStack(cannonball, 4), "xxx", "xyx", "xxx", 'x', Item.ingotIron, 'y', musketball);
		GameRegistry.addRecipe(new ItemStack(cannonball, 8), "xxx", "xyx", "xxx", 'x', lead, 'y', musketball);
		GameRegistry.addRecipe(new ItemStack(cannon, 1), "xxx", "xxy", "zzz", 'x', Item.ingotIron, 'y', Item.flintAndSteel, 'z', Block.planks);
		GameRegistry.addRecipe(new ItemStack(saber, 1), " x ", " x ", "yxy", 'x', Item.ingotIron, 'y', Item.ingotGold);
		GameRegistry.addShapelessRecipe(new ItemStack(cloth, 4), new ItemStack(Block.cloth, 1, 11));
		GameRegistry.addShapelessRecipe(new ItemStack(cloth2, 4), new ItemStack(Block.cloth, 1, 8));
		GameRegistry.addShapelessRecipe(new ItemStack(coin, 2), new ItemStack(Item.ingotGold), new ItemStack(cloth));
		GameRegistry.addShapelessRecipe(new ItemStack(coin2, 2), new ItemStack(Item.ingotGold), new ItemStack(cloth2));
		
		GameRegistry.addRecipe(new ItemStack(cap, 1), "xxx", "x x", 'x', new ItemStack(Block.cloth, 1, 11));
		GameRegistry.addRecipe(new ItemStack(unionuniform, 1), "x x", "xxx", "xxx", 'x', cloth);
		GameRegistry.addRecipe(new ItemStack(rebeluniform, 1), "x x", "xxx", "xxx", 'x', cloth2);
		GameRegistry.addRecipe(new ItemStack(legs, 1), "xxx", "x x", "x x", 'x', new ItemStack(Block.cloth, 1, 9));
		GameRegistry.addRecipe(new ItemStack(boots, 1), "x x", "x x", 'x', new ItemStack(Block.cloth, 1, 15));	
		
		GameRegistry.addSmelting(Config.leadOreID, new ItemStack(lead), 5.0F);
		
		GameRegistry.registerWorldGenerator(new Ore());
			
		Extras.addBlock(cannon, "Cannon");
		Extras.addBlock(leadOre, "Lead Ore");
		//CivilWar.CwLogger.log(Level.INFO, "Registered Game Registry");
	}
	public static void EntityRegistry(){
		Config.EntityMusketBallID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityMusketBall.class,"Musket Ball", Config.EntityMusketBallID);
		Config.cannonballID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityCannonBall.class,"Cannon Ball", Config.cannonballID);
		Config.Soldier_UnionID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntitySoldier_Union.class,"Union Soldier", Config.Soldier_UnionID);
		Config.Soldier_RebelID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntitySoldier_Rebel.class,"Rebel Soldier", Config.Soldier_RebelID);
		
		EntityRegistry.registerModEntity(EntitySoldier_Union.class, "Union Soldier", Config.Soldier_UnionID, CivilWar.instance, 80, 2, true);
		EntityRegistry.registerModEntity(EntitySoldier_Rebel.class, "Rebel Soldier", Config.Soldier_RebelID, CivilWar.instance, 80, 2, true);
		
		EntityRegistry.addSpawn(EntitySoldier_Union.class, 5, 1, 3, EnumCreatureType.creature, BiomeGenBase.forest,BiomeGenBase.jungle,BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.taiga);
		EntityRegistry.addSpawn(EntitySoldier_Rebel.class, 5, 1, 3, EnumCreatureType.creature, BiomeGenBase.desert,BiomeGenBase.desertHills,BiomeGenBase.forest,BiomeGenBase.jungle, BiomeGenBase.swampland);
		
		Extras.registerEntityEgg(EntitySoldier_Union.class,Config.Soldier_UnionID, 003366, 996600);
		Extras.registerEntityEgg(EntitySoldier_Rebel.class,Config.Soldier_RebelID, 0xCCCCCC, 0x0033CC);
		
	}
	public static void EverythingElse(){
		GameRegistry.registerTileEntity(TileEntityCannon.class, Config.cannonS);
		OreDictionary.registerOre("oreLead", leadOre);
		OreDictionary.registerOre("ingotLead", new ItemStack(lead));
		MinecraftForge.setBlockHarvestLevel(leadOre, "pickaxe", 3);
	}
}