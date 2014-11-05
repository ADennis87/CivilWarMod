package ninjapancakes87.phone.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerPhone extends Container{

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}

}
