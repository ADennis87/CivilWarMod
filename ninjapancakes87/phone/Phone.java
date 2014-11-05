package ninjapancakes87.phone;


import org.apache.logging.log4j.core.Logger;

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

//@Mod(modid = Phone.modid, name = "Phone", version = Phone.version)

public class Phone {

	 
	@Instance(Phone.modid)
	public static Phone instance;
	
	@SidedProxy(clientSide="ninjapancakes87.phone.PhoneClientProxy", serverSide="ninjapancakes87.phone.PhoneCommonProxy")
	public static PhoneCommonProxy proxy;
	
	public static PhoneClientProxy client;
	
	public static final String modid = "phone";
	
	public static final String version = "1.0";
	
	//public static CreativeTabs tabCivilWar = new CreativeTabPhone(CreativeTabs.getNextID(),"tabCivilWar");
	
	//public static Logger CwLogger = Logger.getLogger("Civil War");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){		
		EventHandlerPhone eventHandler = new EventHandlerPhone();
		MinecraftForge.EVENT_BUS.register(eventHandler);
		
		//CwLogger.setParent((Logger) FMLLog.getLogger());
		
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
