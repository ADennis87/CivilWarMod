package ninjapancakes87.civilwar.render;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import ninjapancakes87.civilwar.Strings;
import ninjapancakes87.civilwar.model.ModelMucket;
import ninjapancakes87.civilwar.tileentity.TileEntityMucket;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityMucketRenderer extends TileEntitySpecialRenderer implements IItemRenderer{
    /** The cannon model */
    private ModelMucket model;
    
    public short scale;
    
    public TileEntityMucket te;
    
    private static RenderItem renderItem = new RenderItem();
    
    /** Instance of renderManager, super one is not visible*/
    protected RenderManager renderManager;

    public TileEntityMucketRenderer()
    {
    	this.model = new ModelMucket();  
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
		TileEntityMucket te = (TileEntityMucket)tileentity;
		this.bindTexture(new ResourceLocation(Strings.MUCKET_BLOCK));
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d0 + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);
		GL11.glRotatef(90, 0, 1.0F, 0);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix(); 
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return type == ItemRenderType.INVENTORY;
	}
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}
	/*@Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		Icon icon = item.getIconIndex();
    	switch (type) {
            case ENTITY: {
        		this.renderItem.renderIcon(0, 0, icon, 16, 16);
                return;
            }
            case EQUIPPED: {
        		this.renderItem.renderIcon(0, 0, icon, 16, 16);
                return;
            }
            case EQUIPPED_FIRST_PERSON: {
        		this.renderItem.renderIcon(0, 0, icon, 16, 16);
                return;
            }
            case INVENTORY: {
        		this.renderItem.renderIcon(0, 0, icon, 16, 16);
                return;
            }
            default:
                return;
        
        }
    }*/
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {		
	}
}