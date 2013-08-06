package ninjapancakes87.civilwar.block.cannon;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import ninjapancakes87.civilwar.Extras;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityCannonRenderer extends TileEntitySpecialRenderer {
	private static final ResourceLocation texture = new ResourceLocation(Extras.sb + "cannon.png");
    /** The cannon model */
    private Cannon model;
    
    /** Instance of renderManager, super one is not visible*/
    protected RenderManager renderManager;

    public TileEntityCannonRenderer()
    {
    	this.model = new Cannon();
    }
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f) {
		TileEntityCannon cannonTE = (TileEntityCannon)tileentity;
		GL11.glPushMatrix();
		this.func_110628_a(texture);
		GL11.glTranslatef((float) d0 + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);
		 short scale = 0;

	        if(cannonTE.getRotation() == 2){
	            scale = 0;
	        }

	        if(cannonTE.getRotation() == 3){
	            scale = 180;
	        }

	        if(cannonTE.getRotation() == 4){
	            scale = -90;
	        }

	        if(cannonTE.getRotation() == 5){
	            scale = 90;
	        }

	        GL11.glRotatef(scale, 0.0F, 1.0F, 0.0F);
	        GL11.glRotatef(90, 0, 1.0F, 0);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix(); 
	}


}