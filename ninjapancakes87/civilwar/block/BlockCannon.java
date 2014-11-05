package ninjapancakes87.civilwar.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockSourceImpl;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.Registry;
import ninjapancakes87.civilwar.tileentity.TileEntityCannon;

public class BlockCannon extends BlockContainer {
	
	public TileEntityCannon te;
	
	public BlockCannon() {
		super(Material.iron);
		this.setCreativeTab(CivilWar.tabCivilWar);
		this.setHardness(15.0F);
		this.setResistance(2000.0F);
	}
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack)
	{
		if(par5EntityLiving == null)
		{
			return;
		}
		int par7 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		TileEntityCannon tile = (TileEntityCannon)par1World.getTileEntity(par2, par3, par4);
        if(tile != null){
            //South
            if(par7 == 0){
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
                if(par1World.getBlock(par2, par3, par4 + 1) == Blocks.air){
                	//par1World.setBlock(par2, par3, par4 + 1, Registry.ghost);
                }
                else{
                	par1World.setBlockToAir(par2, par3, par4);
                }
            }
            //West
            if(par7 == 1){
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
                if(par1World.getBlock(par2 - 1, par3, par4) == Blocks.air){
                	//par1World.setBlock(par2 - 1, par3, par4, Registry.ghost);
                }
                else{
                	par1World.setBlockToAir(par2, par3, par4);
                }
            }
            //North
            if(par7 == 2){
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
                if(par1World.getBlock(par2, par3, par4 - 1) == Blocks.air){
                	//par1World.setBlock(par2, par3, par4 - 1, Registry.ghost);
                }
                else{
                	par1World.setBlockToAir(par2, par3, par4);
                }
            }
            //East
            if(par7 == 3){
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
                if(par1World.getBlock(par2 + 1, par3, par4) == Blocks.air){
                	//par1World.setBlock(par2 + 1, par3, par4, Registry.ghost);
                }
                else{
                	par1World.setBlockToAir(par2, par3, par4);
                }
            }
        }
	}
	 public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	    {
		 	if(!par1World.isRemote){
		 		//this.fire(par1World, par2, par3, par4);
		 		par5EntityPlayer.openGui(CivilWar.instance, 6, par1World, par2, par3, par4);
		 		return true;
		 	}
	        return false;
	    }
	 @Override
	 public void setBlockBoundsBasedOnState(IBlockAccess iba, int par2, int par3, int par4){
		 int par5 = iba.getBlockMetadata(par2, par3, par4);
		 if(par5 == 3){
			 this.setBlockBounds(0, 0, 0, 1, 1, 2);
		 }
		 if(par5 == 2){
			 this.setBlockBounds(0, 0, -1, 1, 1, 1);
		 }
		 if(par5 == 5){
			 this.setBlockBounds(0, 0, 0, 2, 1, 1);
		 }
		 if(par5 == 4){
			 this.setBlockBounds(-1, 0, 0, 1, 1, 1);
		 }
	 }
	/*protected void fire(EntityLivingBase entity, World par1World, int par2, int par3, int par4)
    {
        BlockSourceImpl blocksourceimpl = new BlockSourceImpl(par1World, par2, par3, par4);
        TileEntityCannon tileentitycannon = (TileEntityCannon)blocksourceimpl.getBlockTileEntity();
        if (tileentitycannon != null)
        	{
             	ItemStack itemstack = new ItemStack(Registry.cannonball);
             	//if(tileentitycannon.getStackInSlot(1).getItem() == Items.gunpowder){
             	par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "Civil War:cannon", 1.0F, par1World.rand.nextFloat() * 0.1F +  0.9F);
             	BehaviorDefaultDispenseItem.d
             	//this.spawnTNT(par1World, par2, par3, par4, itemstack, entity);
             	//tileentitycannon.getStackInSlot(1).splitStack(1);
             	//}
        	}
        }
	protected void spawnTNT(World par1World, int par2, int par3, int par4, ItemStack par2ItemStack, EntityLivingBase entity){
		EnumFacing enumfacing = BlockDispenser.func_149937_b(par1IBlockSource.getBlockMetadata());
		IPosition iposition = BlockDispenser.func_149939_a(par1IBlockSource);
	    BehaviorDefaultDispenseItem.doDispense(par1IBlockSource.getWorld(), new ItemStack(Block), 6, enumfacing, iposition);
		System.out.println("x: " + motionX + " y: " + motionY + "z: " + motionZ);
		EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(par1World, (double)((float)par2 + 0.5F), (double)((float)par3 + 1.5F), (double)((float)par4 + 0.5F), entity);
		par1World.spawnEntityInWorld(entitytntprimed);
		entitytntprimed.setVelocity(motionX, motionY, motionZ);
	}*/
	
	public TileEntity createNewTileEntity(World par1, int par2)
	{
	  return new TileEntityCannon();
	}

	@Override
    public int getRenderType()
    {
        return Registry.realrender;
    }
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	 /*public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
		 Block id = Registry.ghost;
	    	if(par1World.getBlock(par2 + 1, par3, par4) == id){
	    		par1World.setBlockToAir(par2 + 1, par3, par4);
	    	}
	    	if(par1World.getBlock(par2 - 1, par3, par4) == id){
	    		par1World.setBlockToAir(par2 - 1, par3, par4);
	    	}
	    	if(par1World.getBlock(par2, par3, par4 + 1) == id){
	    		par1World.setBlockToAir(par2, par3, par4 + 1);
	    	}
	    	if(par1World.getBlock(par2, par3, par4 - 1) == id){
	    		par1World.setBlockToAir(par2, par3, par4 - 1);
	    	}
	    	this.dropBlockAsItem(par1World, par2, par3, par4, par5, 1);
	    }*/
	    @Override
	    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block block)
	    {
	        if (!par1World.isRemote){
	            boolean flag = par1World.isBlockIndirectlyGettingPowered(par2, par3, par4);
	            if(flag){
	            	par1World.scheduleBlockUpdate(par2, par3, par4, this, this.tickRate(par1World));            
	            }
	        }
	    }
	    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	    {
	        if (!par1World.isRemote)
	        {
	        	System.out.println("Firing");
	            //this.fire((EntityLivingBase)null,par1World, par2, par3, par4);
	        }
	    }
	    public int tickRate(World par1World)
	    {
	        return 4;
	    }
}
