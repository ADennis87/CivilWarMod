package ninjapancakes87.civilwar;

import java.util.logging.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import ninjapancakes87.civilwar.client.CivilWarClientProxy;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = CivilWar.modid, name = "Civil War", version = CivilWar.version)
@NetworkMod(clientSideRequired = true, serverSideRequired = true)

public class CivilWar {

	 
	@Instance(CivilWar.modid)
	public static CivilWar instance;
	
	@SidedProxy(clientSide="ninjapancakes87.civilwar.client.CivilWarClientProxy", serverSide="ninjapancakes87.civilwar.common.CivilWarCommonProxy")
	public static CivilWarCommonProxy proxy;
	
	public static CivilWarClientProxy client;
	
	public static final String modid = "civil war";
	
	public static final String version = "Build 4";
	
	public static CreativeTabs tabCivilWar = new CreativeTabCivilWar(CreativeTabs.getNextID(),"tabCivilWar");
	
	public static Logger CwLogger = Logger.getLogger("Civil War");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		Config.Init(event);
		
		EventHandlerCW eventHandler = new EventHandlerCW();
		MinecraftForge.EVENT_BUS.register(eventHandler);
		
		CwLogger.setParent(FMLLog.getLogger());
		
		Registry.preInit();
	}
	@EventHandler
	public void Init(FMLInitializationEvent event){
		Registry.Init();
		
		proxy.registerRenderThings();
	}
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event){		
		Registry.postInit();
	}
}
