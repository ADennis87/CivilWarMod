package ninjapancakes87.phone.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import ninjapancakes87.phone.Strings;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class GuiPhone extends GuiContainer
{
	public World worldObj;
    public GuiPhone(World par1World)
    {
    	super(new ContainerPhone());
    	this.worldObj = par1World;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        String s = "" + this.worldObj.getTotalWorldTime();
        this.fontRendererObj.drawString(s, 8, this.ySize - 50, 4210752);
        }
    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Strings.PHONE_GUI));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}

