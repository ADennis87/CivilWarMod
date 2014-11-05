package ninjapancakes87.civilwar.tileentity;

import java.util.logging.Level;
import java.util.logging.LogRecord;

import cpw.mods.fml.common.FMLLog;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.Registry;

public class TileEntityCannon extends TileEntity implements ISidedInventory{
	private static final int[] left = new int[] {0};
	private static final int[] right = new int[] {1};
	
	private String customName;
	
	/**
     * The ItemStacks that hold the items currently being used in the cannon
     */
	private ItemStack[] cannonItemStacks = new ItemStack[2];

    public int getSizeInventory() {
        return 2;
    }

    public ItemStack getStackInSlot(int slotIndex) {
        return this.cannonItemStacks[slotIndex];
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
	 public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack)
	    {
	        return par1 == 0 ? getIsUseful(par2ItemStack) : (par1 == 1 ? getIsUseful(par2ItemStack) : true);
	    }
	 public int getInventoryStackLimit()
	    {
	        return 64;
	    }
	 public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.readFromNBT(par1NBTTagCompound);
	        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
	        this.cannonItemStacks = new ItemStack[this.getSizeInventory()];

	        for (int i = 0; i < nbttaglist.tagCount(); ++i)
	        {
	            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.getCompoundTagAt(i);
	            byte b0 = nbttagcompound1.getByte("Slot");

	            if (b0 >= 0 && b0 < this.cannonItemStacks.length)
	            {
	                this.cannonItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
	            }
	        }

	        if (par1NBTTagCompound.hasKey("CustomName"))
	        {
	            this.customName = par1NBTTagCompound.getString("CustomName");
	        }
	    }

	    /**
	     * Writes a tile entity to NBT.
	     */
	    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.writeToNBT(par1NBTTagCompound);
	        NBTTagList nbttaglist = new NBTTagList();

	        for (int i = 0; i < this.cannonItemStacks.length; ++i)
	        {
	            if (this.cannonItemStacks[i] != null)
	            {
	                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	                nbttagcompound1.setByte("Slot", (byte)i);
	                this.cannonItemStacks[i].writeToNBT(nbttagcompound1);
	                nbttaglist.appendTag(nbttagcompound1);
	            }
	        }

	        par1NBTTagCompound.setTag("Items", nbttaglist);

	        if (this.hasCustomInventoryName())
	        {
	            par1NBTTagCompound.setString("CustomName", this.customName);
	        }
	    }
	public int getMetadata(){
		World w = this.worldObj;
		return w.getBlockMetadata(xCoord, yCoord, zCoord);
	}
	
	public static boolean getIsUseful(ItemStack par1){
		return par1 == new ItemStack(Items.gunpowder) || par1 == new ItemStack(Registry.cannonball);
	}
	
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

	public int[] getAccessibleSlotsFromSide(int par1) {
		return par1 == 1 ? left : right;
	}

	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return this.isItemValidForSlot(i, itemstack);
	}
	public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return par3 != 0 || par1 != 1 || par2ItemStack.getItem() == Items.bucket;
    }

	@Override
	public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.customName : "container.cannon";
	}

	@Override
	public boolean hasCustomInventoryName() {
        return this.customName != null && this.customName.length() > 0;
	}

	@Override
	public void openInventory() {		
	}

	@Override
	public void closeInventory() {		
	}
}
