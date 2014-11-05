package ninjapancakes87.civilwar.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import ninjapancakes87.civilwar.Strings;
import ninjapancakes87.civilwar.entity.EntitySoldier;
import ninjapancakes87.civilwar.entity.EntitySoldier_Union;

public class RenderUnionSoldier extends RenderBiped
{
 protected ModelBiped model;
 
 public RenderUnionSoldier (ModelBiped model, float f)
 {
  super(model, f);
  model = ((ModelBiped)mainModel);
  
 }
 
 public void renderSoldier(EntitySoldier soldier, double par2, double par4, double par6, float par8, float par9)
 {
     super.doRender(soldier, par2, par4, par6, par8, par9);
     super.func_147906_a(soldier, soldier.getProfessionName(), par2, par4 + 0.3D, par6, 16);
     super.func_147906_a(soldier, EnumChatFormatting.RED + "Health: " + EnumChatFormatting.RESET + soldier.getHealth(), par2, par4, par6, 16);
 }
 
 public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderSoldier((EntitySoldier_Union)par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderSoldier((EntitySoldier_Union)par1Entity, par2, par4, par6, par8, par9);
    }
 protected ResourceLocation Texture(EntitySoldier_Union par1){
	 return Strings.getSoldierTexture(par1);
 }

 protected ResourceLocation getEntityTexture(Entity par1Entity)
 {
     return this.Texture((EntitySoldier_Union)par1Entity);
 }
}