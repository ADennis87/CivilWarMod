package ninjapancakes87.civilwar;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ninjapancakes87.civilwar.block.cannon.ContainerCannon;
import ninjapancakes87.civilwar.block.cannon.GuiCannon;
import ninjapancakes87.civilwar.block.cannon.TileEntityCannon;

public class GuiHandler implements IGuiHandler{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		switch(ID){
		case 6: return new ContainerCannon(player.inventory, (TileEntityCannon) tile_entity);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		switch(ID){
		case 6: return new GuiCannon(player.inventory, (TileEntityCannon) tile_entity);
		}
		return null;
	}
}
