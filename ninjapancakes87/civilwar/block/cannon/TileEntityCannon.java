package ninjapancakes87.civilwar.block.cannon;

import java.util.logging.Level;
import java.util.logging.LogRecord;

import cpw.mods.fml.common.FMLLog;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.Registry;

public class TileEntityCannon extends TileEntity implements ISidedInventory{
	public TileEntityCannonRenderer TErender;
	
	private static final int[] slots_left = new int[] {0};
	private static final int[] slots_right = new int[] {1};
	
	private String field_94130_e;
	
	private ItemStack[] cannonItemStacks = new ItemStack[2];
	
	 public int getSizeInventory()
	    {
	        return this.cannonItemStacks.length;
	    }
	 public ItemStack getStackInSlot(int par1)
	    {
	        return this.cannonItemStacks[par1];
	    }
	 public ItemStack decrStackSize(int par1, int par2)
	    {
	        if (this.cannonItemStacks[par1] != null)
	        {
	            ItemStack itemstack;

	            if (this.cannonItemStacks[par1].stackSize <= par2)
	            {
	                itemstack = this.cannonItemStacks[par1];
	                this.cannonItemStacks[par1] = null;
	                return itemstack;
	            }
	            else
	            {
	                itemstack = this.cannonItemStacks[par1].splitStack(par2);

	                if (this.cannonItemStacks[par1].stackSize == 0)
	                {
	                    this.cannonItemStacks[par1] = null;
	                }

	                return itemstack;
	            }
	        }
	        else
	        {
	            return null;
	        }
	    }

	    /**
	     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
	     * like when you close a workbench GUI.
	     */
	    public ItemStack getStackInSlotOnClosing(int par1)
	    {
	        if (this.cannonItemStacks[par1] != null)
	        {
	            ItemStack itemstack = this.cannonItemStacks[par1];
	            this.cannonItemStacks[par1] = null;
	            return itemstack;
	        }
	        else
	        {
	            return null;
	        }
	    }
	    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
	    {
	        this.cannonItemStacks[par1] = par2ItemStack;

	        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
	        {
	            par2ItemStack.stackSize = this.getInventoryStackLimit();
	        }
	    }
	    public String getInvName()
	    {
	        return this.isInvNameLocalized() ? this.field_94130_e : "container.cannon";
	    }
	    public boolean isInvNameLocalized()
	    {
	        return this.field_94130_e != null && this.field_94130_e.length() > 0;
	    }
	    public void setGuiDisplayName(String par1Str)
	    {
	        this.field_94130_e = par1Str;
	    }
	    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
	    {
	        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	    }

	    public void openChest() {}

	    public void closeChest() {}
	    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack)
	    {
	        return par1 == 2 ? false : (par1 == 1 ? getCannonUseful(par2ItemStack) : true);
	    }
	    public int[] getAccessibleSlotsFromSide(int par1)
	    {
	        return par1 == 1 ? slots_left : slots_right;
	    }
	    public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3)
	    {
	        return this.isItemValidForSlot(par1, par2ItemStack);
	    }
	    public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3)
	    {
	        return par3 != 0 || par1 != 1 || par2ItemStack.itemID == Item.bucketEmpty.itemID;
	    }
		public int getInventoryStackLimit()
	    {
	        return 64;
	    }
	@Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);
		NBTTagList nbttaglist = nbtTagCompound.getTagList("Items");
		CivilWar.CwLogger.log(Level.INFO, "Read rotation: " + this.getMetadata());
	}
	@Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = new NBTTagList();
	    par1NBTTagCompound.setTag("Items", nbttaglist);
		CivilWar.CwLogger.log(Level.INFO, "Write rotation: " + this.getMetadata());
	}
	public int getMetadata(){
		World w = this.worldObj;
		return w.getBlockMetadata(xCoord, yCoord, zCoord);
	}
	public static boolean getCannonUseful(ItemStack par1){
		int i = par1.itemID;
		if(i == Item.gunpowder.itemID){
			return true;
		}
		if(i == Registry.cannonball.itemID){
			return true;
		}
		else{
			return false;
		}
	}
}
