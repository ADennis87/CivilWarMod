package ninjapancakes87.civilwar.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import ninjapancakes87.civilwar.Extras;
import ninjapancakes87.civilwar.Strings;
import ninjapancakes87.civilwar.tileentity.TileEntityCannon;

public class GuiCannon extends GuiContainer
{
    private TileEntityCannon i;

    public GuiCannon(InventoryPlayer par1InventoryPlayer, TileEntityCannon tile_entity)
    {
        super(new ContainerCannon(par1InventoryPlayer, tile_entity));
        this.i = tile_entity;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        String s = "Cannon";
        this.fontRendererObj.drawString(StatCollector.translateToLocal("Inventory"), 8, this.ySize - 94, 4210752);
        }
    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Strings.CANNON_GUI));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}

