package ninjapancakes87.civilwar.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ninjapancakes87.civilwar.Registry;
import ninjapancakes87.civilwar.Strings;

public class BlockGhost extends BlockDefault{

	public BlockGhost() {
		super();
		this.setCreativeTab((CreativeTabs)null);
		this.setHardness(15.0F);

	}
	public int quantityDropped(Random par1Random){
		return 0;
	}
	public boolean isOpaqueCube(){
		return false;
	}
	protected boolean canSilkHarvest(){
		return false;
	}
	/*public void registerIcons(IIconRegister iconRegister)
	{
	if(this == Registry.ghost)
	{
		this.blockIcon = iconRegister.registerIcon(Strings.GHOST);
	}
	}*/
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
    	boolean flag = par1World.getBlock(par2 + 1, par3, par4) == Registry.cannon;
    	boolean flag2 = par1World.getBlock(par2 - 1, par3, par4) == Registry.cannon; 
    	boolean flag3 = par1World.getBlock(par2, par3, par4 + 1) == Registry.cannon; 
    	boolean flag4 = par1World.getBlock(par2, par3, par4 - 1) == Registry.cannon; 
    	if(flag){
    		par1World.setBlockToAir(par2 + 1, par3, par4);
    	}
    	if(flag2){
    		par1World.setBlockToAir(par2 - 1, par3, par4);
    	}
    	if(flag3){
    		par1World.setBlockToAir(par2, par3, par4 + 1);
    	}
    	if(flag4){
    		par1World.setBlockToAir(par2, par3, par4 - 1);
    	}
    }
    /*@Override
    public Item getItemDropped(int par1, Random random, int zero) {
       return Registry.cannon;
}*/
    @Override
	 public void setBlockBoundsBasedOnState(IBlockAccess iba, int par2, int par3, int par4){
		 int par5 = iba.getBlockMetadata(par2, par3, par4);
		 //South
		 if(par5 == 3){
			 this.setBlockBounds(0, 0, 0, 1, 1, 2);
		 }
		 //North
		 if(par5 == 2){
			 this.setBlockBounds(0, 0, -1, 1, 1, 1);
		 }
		 //East
		 if(par5 == 5){
			 this.setBlockBounds(0, 0, 0, 2, 1, 1);
		 }
		 //West
		 if(par5 == 4){
			 this.setBlockBounds(-1, 0, 0, 1, 1, 1);
		 }
	 }
}
