package ninjapancakes87.civilwar.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import ninjapancakes87.civilwar.tileentity.TileEntityCannon;

public class ContainerCannon extends Container
{
    private TileEntityCannon te;

    public ContainerCannon(InventoryPlayer par1InventoryPlayer, TileEntityCannon par2TileEntityCannon)
    {
        this.te = par2TileEntityCannon;
        this.addSlotToContainer(new Slot(par2TileEntityCannon, 0, 49, 33));
        this.addSlotToContainer(new Slot(par2TileEntityCannon, 1, 115, 33));
        //this.addSlotToContainer(new SlotCS2(par2TileEntityCS, 3, 50, 50));
        int i;

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 8 + i * 18, 142));
        }
    }
    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.te.isUseableByPlayer(par1EntityPlayer);
    }
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
    }
    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {

        ItemStack itemStack = null;
        Slot slot = (Slot) inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack()) {

            ItemStack slotItemStack = slot.getStack();
            itemStack = slotItemStack.copy();

            /**
             * If we are shift-clicking an item out of the Aludel's container,
             * attempt to put it in the first available slot in the player's
             * inventory
             */
            if (slotIndex < 2) {

                if (!this.mergeItemStack(slotItemStack, 2, inventorySlots.size(), false)) {
                    return null;
                }
            }
            else {

                /**
                 * If the stack being shift-clicked into the Aludel's container
                 * is a fuel, first try to put it in the fuel slot. If it cannot
                 * be merged into the fuel slot, try to put it in the input
                 * slot.
                 */
                if (TileEntityCannon.getIsUseful(slotItemStack)) {
                    if (!this.mergeItemStack(slotItemStack, 0, 1, false)) {
                        return null;
                    }
                }

                /**
                 * Finally, attempt to put stack into the input slot
                 */
                else if (!this.mergeItemStack(slotItemStack, 0, 1, false)) {
                    return null;
                }
            }

            if (slotItemStack.stackSize == 0) {
                slot.putStack((ItemStack) null);
            }
            else {
                slot.onSlotChanged();
            }
        }

        return itemStack;
    }

}
