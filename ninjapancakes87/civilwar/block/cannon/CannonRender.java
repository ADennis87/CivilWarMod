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
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);

        // Render
        
        model.render((Entity)null,0.0F, 0.0F, 0.0F, 0.0F, 0.0F, scale);

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

}
