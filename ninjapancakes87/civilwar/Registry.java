package ninjapancakes87.civilwar;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import ninjapancakes87.civilwar.block.BlockCannon;
import ninjapancakes87.civilwar.block.BlockDefault;
import ninjapancakes87.civilwar.block.BlockGhost;
import ninjapancakes87.civilwar.block.BlockMucket;
import ninjapancakes87.civilwar.client.CivilWarClientProxy;
import ninjapancakes87.civilwar.entity.EntityMusketBall;
import ninjapancakes87.civilwar.entity.EntitySoldier_Rebel;
import ninjapancakes87.civilwar.entity.EntitySoldier_Union;
import ninjapancakes87.civilwar.item.CWArmor;
import ninjapancakes87.civilwar.item.ItemCanteen;
import ninjapancakes87.civilwar.item.ItemHaversack;
import ninjapancakes87.civilwar.item.ItemMucket;
import ninjapancakes87.civilwar.item.ItemMusket;
import ninjapancakes87.civilwar.item.ItemRevolver;
import ninjapancakes87.civilwar.item.ItemSaber;
import ninjapancakes87.civilwar.tileentity.TileEntityCannon;
import ninjapancakes87.civilwar.tileentity.TileEntityFlag;
import ninjapancakes87.civilwar.tileentity.TileEntityMucket;
import ninjapancakes87.civilwar.world.Ore;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Registry {
	public Extras e;
		
	public static CivilWarCommonProxy proxy;
	
	public static CivilWarClientProxy client;
	
	public static World worldObj;
	
	static ArmorMaterial ClothArmor = EnumHelper.addArmorMaterial("Soldier", 33, new int[]{1, 3, 2, 1}, 3);
																	   //DIAMOND(33, new int[]{3, 8, 6, 3}, 10);
	int renderA = proxy.addArmor("Soldier");
	static ToolMaterial CW = EnumHelper.addToolMaterial("Saber", 2, 131, 12.0F, 10, 22);
	public static int realrender = -1;

	public static Item musket, musketball, cannonball;
	public static Item revolver;
	public static Item saber;
	public static Item cloth, cloth2;
	public static Item coin, coin2;
	public static Item lead;
	//public static Item haversack;
	public static Item canteen;
	public static Item Imucket;
	
	public static Item cap, unionuniform, rebeluniform, legs, boots;
	
	public static Block leadOre, mucket;
	
	public static Block cannon, pole;//, ghost;
	
	public static void preInit() {
		BlocksAndItems();
		GameRegistry();
	}	
	
	public static void Init(){
		EntityRegistry();
		EverythingElse();
	}
	public static void postInit(){
		FMLLog.info("Civil War " + CivilWar.version + " initialized");
		}
	public static void BlocksAndItems(){
		musket = new ItemMusket().setUnlocalizedName("musket");
		revolver = new ItemRevolver().setUnlocalizedName("revolver");
		saber = (new ItemSaber(CW)).setUnlocalizedName("saber");
		//haversack = (new ItemHaversack()).setUnlocalizedName("haversack");
		canteen = (new ItemCanteen(2, false)).setUnlocalizedName("canteen");
		Imucket = (new ItemMucket()).setUnlocalizedName("imucket");
		
		musketball = Extras.addDefaultItem(musketball, "minieball").setTextureName(CivilWar.modid + ":musketball");
		cannonball = Extras.addDefaultItem(cannonball, "cannonball").setTextureName(CivilWar.modid + ":cannonball");
		cloth = Extras.addDefaultItem(cloth, "cloth1").setTextureName(CivilWar.modid + ":cloth");
		cloth2 = Extras.addDefaultItem(cloth2, "cloth2").setTextureName(CivilWar.modid + ":cloth2");
		coin = Extras.addDefaultItem(coin, "coin1").setTextureName(CivilWar.modid + ":coin");
		coin2 = Extras.addDefaultItem(coin2, "coin2").setTextureName(CivilWar.modid + ":coin2");
		lead = Extras.addDefaultItem(lead, "lead").setTextureName(CivilWar.modid + ":lea");
		
		cap = (new CWArmor(ClothArmor,0, 0)).setUnlocalizedName("cap").setTextureName(CivilWar.modid + ":cap");
		unionuniform = (new CWArmor(ClothArmor, 0, 1)).setUnlocalizedName("uniform1").setTextureName(CivilWar.modid + ":union uniform");
		rebeluniform = (new CWArmor(ClothArmor,0, 1)).setUnlocalizedName("uniform2").setTextureName(CivilWar.modid + ":rebel uniform");
		legs = (new CWArmor(ClothArmor, 0, 2)).setUnlocalizedName("pants").setTextureName(CivilWar.modid + ":pants");
		boots = (new CWArmor(ClothArmor, 0, 3)).setUnlocalizedName("boots").setTextureName(CivilWar.modid + ":boots");
		
		leadOre = (new BlockDefault()).setBlockName("CWleadore").setBlockTextureName(CivilWar.modid + ":leadOre");;
		cannon = (new BlockCannon()).setBlockName("cannon").setBlockTextureName(CivilWar.modid + ":cannonT");
		//ghost = (new BlockGhost()).setBlockName("ghost").setBlockTextureName(CivilWar.modid + ":ghost");
		mucket = (new BlockMucket()).setBlockName("mucket").setBlockTextureName(CivilWar.modid + ":mucket");
	}
	public static void GameRegistry(){
		GameRegistry.addRecipe(new ItemStack(revolver, 1), "xxx", " yx", 'x', Items.iron_ingot, 'y', Items.flint_and_steel);
		GameRegistry.addRecipe(new ItemStack(musket, 1), "xxx"," yz", "xxx", 'x', Blocks.planks, 'y', Items.stick, 'z', Items.flint_and_steel);
		GameRegistry.addRecipe(new ItemStack(musketball, 8), " x ", " x ", 'x', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(musketball, 16), " x ", " x ", 'x', lead);
		GameRegistry.addRecipe(new ItemStack(cannonball, 4), "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', musketball);
		GameRegistry.addRecipe(new ItemStack(cannonball, 8), "xxx", "xyx", "xxx", 'x', lead, 'y', musketball);
		GameRegistry.addRecipe(new ItemStack(cannon, 1), "xxx", "xxy", "zzz", 'x', Items.iron_ingot, 'y', Items.flint_and_steel, 'z', Blocks.planks);
		GameRegistry.addRecipe(new ItemStack(saber, 1), " x ", " x ", "yxy", 'x', Items.iron_ingot, 'y', Items.gold_ingot);
		//GameRegistry.addRecipe(new ItemStack(haversack, 1), "   ", "xyx", "xxx", 'x', Items.leather, 'y', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(Imucket, 1), "x x", "xxx", "y y", 'x', Items.iron_ingot, 'y', Blocks.cobblestone);
		GameRegistry.addShapelessRecipe(new ItemStack(canteen, 1), new ItemStack(Items.leather), new ItemStack(Items.leather), new ItemStack(Items.leather), new ItemStack(Items.leather));
		GameRegistry.addShapelessRecipe(new ItemStack(cloth, 1), new ItemStack(Blocks.wool, 1, 11));
		GameRegistry.addShapelessRecipe(new ItemStack(cloth2, 1), new ItemStack(Blocks.wool, 1, 8));
		GameRegistry.addShapelessRecipe(new ItemStack(coin, 2), new ItemStack(Items.iron_ingot), new ItemStack(cloth), new ItemStack(Items.iron_ingot));
		GameRegistry.addShapelessRecipe(new ItemStack(coin2, 2), new ItemStack(Items.iron_ingot), new ItemStack(cloth2), new ItemStack(Items.iron_ingot));
		
		GameRegistry.addRecipe(new ItemStack(cap, 1), "xyx", "x x", 'x', new ItemStack(Blocks.wool, 1, 15), 'y', new ItemStack(Blocks.wool, 1, 4));
		GameRegistry.addRecipe(new ItemStack(unionuniform, 1), "x x", "xxx", "xxx", 'x', cloth);
		GameRegistry.addRecipe(new ItemStack(rebeluniform, 1), "x x", "xxx", "xxx", 'x', cloth2);
		GameRegistry.addRecipe(new ItemStack(legs, 1), "xxx", "x x", "x x", 'x', new ItemStack(Blocks.wool, 1, 9));
		GameRegistry.addRecipe(new ItemStack(boots, 1), "x x", "x x", 'x', new ItemStack(Blocks.wool, 1, 15));	
		
		GameRegistry.addSmelting(new ItemStack(leadOre), new ItemStack(lead), 5.0F);
		
		GameRegistry.registerWorldGenerator(new Ore(), 10);
		
		GameRegistry.registerItem(musket, musket.getUnlocalizedName());
		GameRegistry.registerItem(revolver, revolver.getUnlocalizedName());
		GameRegistry.registerItem(saber, saber.getUnlocalizedName());
		//GameRegistry.registerItem(haversack, haversack.getUnlocalizedName());
		GameRegistry.registerItem(canteen, canteen.getUnlocalizedName());
		GameRegistry.registerItem(Imucket, Imucket.getUnlocalizedName());
		GameRegistry.registerItem(cap, cap.getUnlocalizedName());
		GameRegistry.registerItem(unionuniform, unionuniform.getUnlocalizedName());
		GameRegistry.registerItem(rebeluniform, rebeluniform.getUnlocalizedName());
		GameRegistry.registerItem(legs, legs.getUnlocalizedName());
		GameRegistry.registerItem(boots, boots.getUnlocalizedName());

					
		//Extras.addBlock(cannon, "Cannon", 2);
		Extras.addBlock(mucket, "Mucket", 1);
		//Extras.addBlock(ghost, "Ghost Block: IF YOU SEE THIS YOU SCREWED UP", 2);
		Extras.addBlock(leadOre, "Lead Ore", 3);
	}
	public static void EntityRegistry(){
		Strings.MusketID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityMusketBall.class,"Musket Ball", Strings.MusketID);
		Strings.UnionID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntitySoldier_Union.class,"Union Soldier", Strings.UnionID, 003366, 996600);
		Strings.RebelID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntitySoldier_Rebel.class,"Rebel Soldier", Strings.RebelID, 0xCCCCCC, 0x0033CC);
		
		EntityRegistry.registerModEntity(EntitySoldier_Union.class, "Union Soldier", Strings.UnionID, CivilWar.instance, 80, 2, true);
		EntityRegistry.registerModEntity(EntitySoldier_Rebel.class, "Rebel Soldier", Strings.RebelID, CivilWar.instance, 80, 2, true);
		
		EntityRegistry.addSpawn(EntitySoldier_Union.class, 2, 4, 8, EnumCreatureType.creature, BiomeGenBase.forest,BiomeGenBase.jungle,BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.taiga);
		EntityRegistry.addSpawn(EntitySoldier_Rebel.class, 2, 4, 8, EnumCreatureType.creature, BiomeGenBase.desert,BiomeGenBase.desertHills,BiomeGenBase.forest,BiomeGenBase.jungle, BiomeGenBase.swampland);	
	}
	public static void EverythingElse(){
		GameRegistry.registerTileEntity(TileEntityCannon.class, "Civil_War_Cannon");
		GameRegistry.registerTileEntity(TileEntityFlag.class, "Flag");
		GameRegistry.registerTileEntity(TileEntityMucket.class, "Mucket");
		NetworkRegistry.INSTANCE.registerGuiHandler(CivilWar.instance, new CivilWarCommonProxy());
		OreDictionary.registerOre("oreLead", leadOre);
		OreDictionary.registerOre("ingotLead", new ItemStack(lead));
		AchievementPage.registerAchievementPage(Achievements.page);
		FurnaceRecipes.smelting().func_151393_a(leadOre, new ItemStack(lead), 0.7F);
	}
}