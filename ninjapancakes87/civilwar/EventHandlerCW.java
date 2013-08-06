package ninjapancakes87.civilwar;

import java.util.logging.Level;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EventHandlerCW {
	
	@ForgeSubscribe
	@SideOnly(Side.CLIENT)
	public void onSoundLoad(SoundLoadEvent event) {
		try{
			event.manager.addSound("Civil War:gunshot.ogg");
			event.manager.addSound("Civil War:hurt.wav");
			event.manager.addSound("Civil War:thump.wav");
			event.manager.addSound("Civil War:cannon.wav");
			CivilWar.CwLogger.finer("Sounds successfully registered");
		}
		catch(Exception e){
			 CivilWar.CwLogger.log(Level.WARNING, "Sounds not loaded!");
		}
	}
}
