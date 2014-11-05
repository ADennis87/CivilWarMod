package ninjapancakes87.civilwar;

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
import cpw.mods.fml.common.network.IGuiHandler;

public class CivilWarCommonProxy implements IGuiHandler{
	
	public void registerRenderThings(){
		
	}
	
	public int addArmor(String s){
		return 0;
	}
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		switch(ID){
		case 6: return new ContainerCannon(player.inventory, (TileEntityCannon) tile_entity);
		case 8: return new ContainerMucket(player.inventory, (TileEntityMucket) tile_entity);
		case 9: return new ContainerHaversack(player.inventory, (IInventory)tile_entity);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		switch(ID){
		case 6: return new GuiCannon(player.inventory, (TileEntityCannon) tile_entity);
		case 8: return new GuiMucket(player.inventory, (TileEntityMucket) tile_entity);
		case 9: return new GuiHaversack(player.inventory, (IInventory)tile_entity);
		}
		return null;
	}
}