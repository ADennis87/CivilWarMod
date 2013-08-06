package ninjapancakes87.civilwar.item;

import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCannonBall extends Render
{
	private static final ResourceLocation loc = new ResourceLocation("civil war:textures/items/ammo.png");

	private final ModelSkeletonHead skeletonHeadModel = new ModelSkeletonHead();
    public void renderCannonBall(EntityCannonBall par1EntityArrow, double par2, double par4, double par6, float par8, float par9)
    {
    	GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        float f4 = 0.0625F;
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        this.func_110777_b(par1EntityArrow);
        this.skeletonHeadModel.render(par1EntityArrow, 0.0F, 0.0F, 0.0F, 0F, 0F, f4);
        GL11.glPopMatrix();
    }

    protected ResourceLocation func_110779_a(EntityCannonBall par1EntityArrow)
    {
        return loc;
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110779_a((EntityCannonBall)par1Entity);
    }

	@Override
	public void doRender(Entity entity, double d0, double d1, double d2,float f, float f1) {
		this.renderCannonBall((EntityCannonBall)entity, d0, d1, d2, f, f1);
		
	}
	
}
