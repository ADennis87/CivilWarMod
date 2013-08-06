package ninjapancakes87.civilwar.block.cannon;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import ninjapancakes87.civilwar.Extras;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

//@SideOnly(Side.CLIENT)
public class CannonRender implements IItemRenderer {
	
	private static final ResourceLocation texture = new ResourceLocation(Extras.sb + "cannon.png");

	protected RenderManager renderManager;
	 
    private Cannon model;

    public CannonRender() {

        model = new Cannon();
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
                renderCannon(-0.5F, 0.0F, 0.5F, 0.25F, 0F, 0F, 0F, 0F, 0);
                return;
            }
            case EQUIPPED: {
                renderCannon(1.0F, 5.1F, 3.0F, 0.25F, 180F, 0F, 0F, 0F, 0);
                return;
            }
            case EQUIPPED_FIRST_PERSON: {
                renderCannon(0.0F, 6.0F, 0.0F, 0.25F, -90F, -110F, 0F, 90F, 1);
                return;
            }
            case INVENTORY: {
                renderCannon(-1.0F, 2.2F, -0.1F, 0.23F, 180F, 0F, 0F, 0F, 0);
                return;
            }
            default:
                return;
        }
    }

    private void renderCannon(float x, float y, float z, float scale, float rotate, float r1, float r2, float r3, float a) {

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        // Scale, Translate, Rotate
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        GL11.glRotatef(rotate, r1, r2, r3);
        if( a == 1){
        	GL11.glRotatef(rotate, r1, r2, r3);
        }

        // Bind texture
        //this.renderManager.renderEngine.func_110577_a(texture);
        FMLClientHandler.instance().getClient().renderEngine.func_110577_a(texture);

        // Render
        
        model.render((Entity)null,0.0F, 0.0F, 0.0F, 0.0F, 0.0F, scale);

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

}
