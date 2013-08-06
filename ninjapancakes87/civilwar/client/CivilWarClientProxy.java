package ninjapancakes87.civilwar.client;

import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;
import ninjapancakes87.civilwar.CivilWarCommonProxy;
import ninjapancakes87.civilwar.Config;
import ninjapancakes87.civilwar.Entity.EntitySoldier_Rebel;
import ninjapancakes87.civilwar.Entity.EntitySoldier_Union;
import ninjapancakes87.civilwar.Entity.RenderRebelSoldier;
import ninjapancakes87.civilwar.Entity.RenderUnionSoldier;
import ninjapancakes87.civilwar.block.cannon.CannonRender;
import ninjapancakes87.civilwar.block.cannon.TileEntityCannon;
import ninjapancakes87.civilwar.block.cannon.TileEntityCannonRenderer;
import ninjapancakes87.civilwar.item.EntityCannonBall;
import ninjapancakes87.civilwar.item.EntityMusketBall;
import ninjapancakes87.civilwar.item.RenderAmmo;
import ninjapancakes87.civilwar.item.RenderCannonBall;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class CivilWarClientProxy extends CivilWarCommonProxy{
	  @Override
	  public void registerRenderThings()
	  {
		    RenderingRegistry.registerEntityRenderingHandler(EntityMusketBall.class, new RenderAmmo());
			RenderingRegistry.registerEntityRenderingHandler(EntityCannonBall.class, new RenderCannonBall());
			RenderingRegistry.registerEntityRenderingHandler(EntitySoldier_Union.class, new RenderUnionSoldier(new ModelBiped(), 0.5F));
			RenderingRegistry.registerEntityRenderingHandler(EntitySoldier_Rebel.class, new RenderRebelSoldier(new ModelBiped(), 0.5F));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCannon.class, new TileEntityCannonRenderer());
			MinecraftForgeClient.registerItemRenderer(Config.cannonID, new CannonRender());
	  }
		public int addArmor(String s) {
		    return RenderingRegistry.addNewArmourRendererPrefix(s);
		}
}
