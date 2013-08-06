package ninjapancakes87.civilwar.Entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderUnionSoldier extends RenderBiped
{
 protected ModelBiped modelB;
 public EntitySoldier_Union soldier;
 
 public RenderUnionSoldier (ModelBiped model, float f)
 {
  super(model, f);
  modelB = ((ModelBiped)mainModel);
  
 }
 
 public void renderS(EntitySoldier_Union entity, double par2, double par4, double par6, float par8, float par9)
    {
	 super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
 
 public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderS((EntitySoldier_Union)par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderS((EntitySoldier_Union)par1Entity, par2, par4, par6, par8, par9);
    }
 protected ResourceLocation func_110832_a(EntitySoldier_Union par1)
 {
     return par1.getTexture();
 }

 protected ResourceLocation func_110775_a(Entity par1Entity)
 {
     return this.func_110832_a((EntitySoldier_Union)par1Entity);
 }
}