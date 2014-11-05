package ninjapancakes87.civilwar.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;

public class TileEntityMucket extends TileEntity implements ISidedInventory{
	
	private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};
    
	protected ItemStack[] itemStack = new ItemStack[3];
	public int burnTime;
	public int currentItemBurnTime;
	public int cookTime;

	@Override
	public int getSizeInventory() {
		return 64;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return this.itemStack[i];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if (this.itemStack[par1] != null)
        {
            ItemStack itemstack;

            if (this.itemStack[par1].stackSize <= par2)
            {
                itemstack = this.itemStack[par1];
                this.itemStack[par1] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.itemStack[par1].splitStack(par2);

                if (this.itemStack[par1].stackSize == 0)
                {
                    this.itemStack[par1] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		if (this.itemStack[par1] != null)
        {
            ItemStack itemstack = this.itemStack[par1];
            this.itemStack[par1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
		this.itemStack[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) {
        return par1 == 2 ? false : (par1 == 1 ? TileEntityFurnace.isItemFuel(par2ItemStack) : true);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int par1) {
        return par1 == 0 ? slotsBottom : (par1 == 1 ? slotsTop : slotsSides);
	}

	@Override
	public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3) {
        return this.isItemValidForSlot(par1, par2ItemStack);
	}

	@Override
	public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3) {
        return par3 != 0 || par1 != 1 || par2ItemStack.getItem() == Items.bucket;
	}
	@Override
	public void updateEntity()
    {
        boolean flag = this.burnTime > 0;
        boolean flag1 = false;

        if (this.burnTime > 0)
        {
            --this.burnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.burnTime == 0 && this.canSmelt())
            {
                this.currentItemBurnTime = this.burnTime = TileEntityFurnace.getItemBurnTime(this.itemStack[1]);
                if(this.worldObj.getBlock(xCoord, yCoord - 1, zCoord) == Blocks.fire && itemStack[1] == null){
                	this.currentItemBurnTime = this.burnTime = 1600;
                }

                if (this.burnTime > 0)
                {
                    flag1 = true;

                    if (this.itemStack[1] != null)
                    {
                        --this.itemStack[1].stackSize;

                        if (this.itemStack[1].stackSize == 0)
                        {
                            this.itemStack[1] = this.itemStack[1].getItem().getContainerItem(itemStack[1]);
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt())
            {
                ++this.cookTime;

                if (this.cookTime == 200)
                {
                    this.cookTime = 0;
                    this.smeltItem();
                    flag1 = true;
                }
            }
            else
            {
                this.cookTime = 0;
            }

            if (flag != this.burnTime > 0)
            {
                flag1 = true;            
               }
        }
    }
	private void smeltItem() {	
		if (this.canSmelt())
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.itemStack[0]);

            if (this.itemStack[2] == null)
            {
                this.itemStack[2] = itemstack.copy();
            }
            else if (this.itemStack[2].getItem() == itemstack.getItem())
            {
                this.itemStack[2].stackSize += itemstack.stackSize;
            }

            --this.itemStack[0].stackSize;

            if (this.itemStack[0].stackSize <= 0)
            {
                this.itemStack[0] = null;
            }
        }
	}

	public boolean isBurning() {
        return this.burnTime > 0;
	}

	protected boolean canSmelt(){
		if (this.itemStack[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.itemStack[0]);
            if(itemstack == null) return false;
            if (this.itemStack[2] == null) return true;
    		if(worldObj.getBlock(this.xCoord, this.yCoord - 1, this.xCoord) == Blocks.fire && this.itemStack[1] == null) return true;
    		if (!this.itemStack[2].isItemEqual(itemstack)) return false;
            int result = itemStack[2].stackSize + itemstack.stackSize;
            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        }
	}
	public String getInventoryName()
    {
        return "container.mucket";
    }

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public void openInventory() {		
	}

	@Override
	public void closeInventory() {
	}

	@SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int par1)
    {
        return this.cookTime * par1 / 200;
    }

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int par1)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 200;
        }

        return this.burnTime * par1 / this.currentItemBurnTime;
    }
}
