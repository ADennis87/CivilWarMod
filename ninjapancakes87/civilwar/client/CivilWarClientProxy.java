package ninjapancakes87.civilwar.client;

import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;
import ninjapancakes87.civilwar.CivilWarCommonProxy;
import ninjapancakes87.civilwar.Registry;
import ninjapancakes87.civilwar.entity.EntityMusketBall;
import ninjapancakes87.civilwar.entity.EntitySoldier_Rebel;
import ninjapancakes87.civilwar.entity.EntitySoldier_Union;
import ninjapancakes87.civilwar.render.RenderAmmo;
import ninjapancakes87.civilwar.render.RenderRebelSoldier;
import ninjapancakes87.civilwar.render.RenderUnionSoldier;
import ninjapancakes87.civilwar.render.TileEntityCannonRenderer;
import ninjapancakes87.civilwar.render.TileEntityMucketRenderer;
import ninjapancakes87.civilwar.tileentity.TileEntityCannon;
import ninjapancakes87.civilwar.tileentity.TileEntityMucket;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class CivilWarClientProxy extends CivilWarCommonProxy{
	  @Override
	  public void registerRenderThings()
	  {
		    RenderingRegistry.registerEntityRenderingHandler(EntityMusketBall.class, new RenderAmmo());
			RenderingRegistry.registerEntityRenderingHandler(EntitySoldier_Union.class, new RenderUnionSoldier(new ModelBiped(), 0.5F));
			RenderingRegistry.registerEntityRenderingHandler(EntitySoldier_Rebel.class, new RenderRebelSoldier(new ModelBiped(), 0.5F));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCannon.class, new TileEntityCannonRenderer());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMucket.class, new TileEntityMucketRenderer());
			//MinecraftForgeClient.registerItemRenderer(Registry.cannon, new TileEntityCannonRenderer());
			//MinecraftForgeClient.registerItemRenderer(Registry.mucket, new TileEntityMucketRenderer());
	  }
		public int addArmor(String s) {
		    return RenderingRegistry.addNewArmourRendererPrefix(s);
		}
}
