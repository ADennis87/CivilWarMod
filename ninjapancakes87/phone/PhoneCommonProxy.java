package ninjapancakes87.phone;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ninjapancakes87.civilwar.gui.ContainerCannon;
import ninjapancakes87.civilwar.gui.ContainerHaversack;
import ninjapancakes87.civilwar.gui.ContainerMucket;
import ninjapancakes87.civilwar.gui.GuiCannon;
import ninjapancakes87.civilwar.gui.GuiHaversack;
import ninjapancakes87.civilwar.gui.GuiMucket;
import ninjapancakes87.civilwar.tileentity.TileEntityCannon;
import ninjapancakes87.civilwar.tileentity.TileEntityMucket;
import ninjapancakes87.phone.gui.ContainerPhone;
import ninjapancakes87.phone.gui.GuiPhone;
import cpw.mods.fml.common.network.IGuiHandler;

public class PhoneCommonProxy implements IGuiHandler{

	public void registerRenderThings() {		
	}
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		switch(ID){
		case 10: return new ContainerPhone();
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		switch(ID){
		case 10: return new GuiPhone(world);
		}
		return null;
	}
}
