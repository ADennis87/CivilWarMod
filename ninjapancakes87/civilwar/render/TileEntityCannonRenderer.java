package ninjapancakes87.civilwar.render;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import ninjapancakes87.civilwar.Extras;
import ninjapancakes87.civilwar.Strings;
import ninjapancakes87.civilwar.model.Cannon;
import ninjapancakes87.civilwar.tileentity.TileEntityCannon;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityCannonRenderer extends TileEntitySpecialRenderer implements IItemRenderer{
    /** The cannon model */
    private Cannon model;
    
    public short scale;
    
    /** Instance of renderManager, super one is not visible*/
    protected RenderManager renderManager;

    public TileEntityCannonRenderer()
    {
    	this.model = new Cannon();
    }
    /**
     * Used for rendering the tile entity
     * @param tileentity is the tile entity you are using
     * @param d0 used for translation on the X axis
     * @param d1 used for translation on the Y axis
     * @param d2 used for translation on the Z axis
     * @param f is not used for anything (at least in mine).
     */
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f) {
		TileEntityCannon cannonTE = (TileEntityCannon)tileentity;
		this.bindTexture(new ResourceLocation(Strings.CANNON));
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d0 + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);
		int rotation = cannonTE.getMetadata(
				); 
		if(rotation == 3){
            scale = -90;
        }

        if(rotation == 2){
            scale = 90;
        }

        if(rotation == 5){
            scale = 180;
        }

        if(rotation == 4){
            scale = 0;
        }
        GL11.glRotatef(scale, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(90, 0, 1.0F, 0);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix(); 
	}
	@Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {

        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
    	switch (type) {
            case ENTITY: {
                renderCannon(-0.5F, 5.0F, 0.5F, 0.25F, 180F, 0F, 0F, 0F, false);
                return;
            }
            case EQUIPPED: {
                renderCannon(1.0F, 6.1F, 3.0F, 0.25F, 180F, 180F, 0F, 0F, false);
                return;
            }
            case EQUIPPED_FIRST_PERSON: {
                renderCannon(0F, 6.0F, 0F, 0.25F, 180F, 0F, 0F, 270F, false);
                return;
            }
            case INVENTORY: {
                renderCannon(0.8F, 4.3F, 0F, 0.23F, 180F, 180F, 0F, 0F, false);
                return;
            }
            default:
                return;
        }
    }

    private void renderCannon(float x, float y, float z, float scale, float rotate, float r1, float r2, float r3, boolean ra) {

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        // Scale, Translate, Rotate
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        GL11.glRotatef(rotate, r1, r2, r3);

        // Bind texture
        //FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Strings.CANNON));
        this.bindTexture(new ResourceLocation(Strings.CANNON));

        // Render
        
        model.render((Entity)null,0.0F, 0.0F, 0.0F, 0.0F, 0.0F, scale);

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}