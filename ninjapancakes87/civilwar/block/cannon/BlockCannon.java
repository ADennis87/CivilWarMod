package ninjapancakes87.civilwar.block.cannon;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockSourceImpl;
import net.minecraft.block.material.Material;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.PositionImpl;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.Extras;
import ninjapancakes87.civilwar.Registry;

public class BlockCannon extends BlockContainer {
	
	 public DispenserBehaviorCannon dbc = new DispenserBehaviorCannon();
	 
	public TileEntityCannon te;
	
	public BlockCannon(int id) {
		super(id, Material.iron);
		this.setCreativeTab(CivilWar.tabCivilWar);
		this.setHardness(3.0F);
		this.setResistance(2000.0F);
		this.setBurnProperties(id, 0, 100);
		this.setBlockBounds(0F, 0F, 0F, 2F, 1F, 2F);
	}
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
		super.updateTick(par1World, par2, par3, par4, par5Random);
    }
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack)
	{
		if(par5EntityLiving == null)
		{
			return;
		}
		int par7 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		TileEntityCannon tile = (TileEntityCannon)par1World.getBlockTileEntity(par2, par3, par4);

        if(tile != null){
            //South
            if(par7 == 0){
                tile.setRotation((byte)2);
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
            }
            //West
            if(par7 == 1){
                tile.setRotation((byte)5);
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
            }
            //North
            if(par7 == 2){
                tile.setRotation((byte)3);
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
            }
            //East
            if(par7 == 3){
                tile.setRotation((byte)4);
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
            }
        }

	}
	 public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	    {
		 	if(!par1World.isRemote){
		 		this.fire(par1World, par2, par3, par4);
		 		return true;
		 	}
	        return false;
	    }
	protected void fire(World par1World, int par2, int par3, int par4)
    {
        BlockSourceImpl blocksourceimpl = new BlockSourceImpl(par1World, par2, par3, par4);
        TileEntityCannon tileentitydispenser = (TileEntityCannon)blocksourceimpl.getBlockTileEntity();

        if (tileentitydispenser != null)
        	{
             	ItemStack itemstack = new ItemStack(Registry.cannonball);
             	par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "Civil War:cannon", 1.0F, par1World.rand.nextFloat() * 0.1F +  0.9F);
             	this.fireStack(blocksourceimpl, itemstack);
        	}
        }
	protected ItemStack fireStack(IBlockSource par1IBlockSource, ItemStack par2ItemStack){
		World world = par1IBlockSource.getWorld();
        IPosition iposition = BlockCannon.getIPositionFromBlockSource(par1IBlockSource);
        EnumFacing enumfacing = BlockCannon.getFacing(par1IBlockSource.getBlockMetadata());
        IProjectile iprojectile = dbc.getProjectileEntity(world, iposition);
        setProjectileHeading(iprojectile, enumfacing);
        world.spawnEntityInWorld((Entity)iprojectile);
        //par2ItemStack.splitStack(1);
        return par2ItemStack;
	}
	public void setProjectileHeading(IProjectile iprojectile, EnumFacing enumfacing){
		iprojectile.setThrowableHeading((double)enumfacing.getFrontOffsetX(), (double)((float)enumfacing.getFrontOffsetY()), (double)enumfacing.getFrontOffsetZ(), Extras.func_82500_b(), Extras.func_82498_a());
	}
	public static IPosition getIPositionFromBlockSource(IBlockSource par0IBlockSource)
    {
        EnumFacing enumfacing = getFacing(par0IBlockSource.getBlockMetadata());
        double d0 = par0IBlockSource.getX() + 0.7D * (double)enumfacing.getFrontOffsetX() + 15.0D;
        double d1 = par0IBlockSource.getY() + 0.7D * (double)enumfacing.getFrontOffsetY() + 10.0D;
        double d2 = par0IBlockSource.getZ() + 0.7D * (double)enumfacing.getFrontOffsetZ();
        return new PositionImpl(d0, d1, d2);
    }
	public static EnumFacing getFacing(int par0)
    {
        return EnumFacing.getFront(par0 & 7);
    }
	
	public TileEntity createNewTileEntity(World var1)
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
}
