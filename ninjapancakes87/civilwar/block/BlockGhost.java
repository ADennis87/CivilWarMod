package ninjapancakes87.civilwar.block;

import java.util.Random;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.Registry;

public class BlockGhost extends BlockDefault{

	public BlockGhost(int par1) {
		super(par1);
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
	public void registerIcons(IconRegister iconRegister)
	{
	if(blockID == Registry.ghost.blockID)
	{
		this.blockIcon = iconRegister.registerIcon("Civil War:ghost");
	}
	}
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
    	boolean flag = par1World.getBlockId(par2 + 1, par3, par4) == Registry.cannon.blockID;
    	boolean flag2 = par1World.getBlockId(par2 - 1, par3, par4) == Registry.cannon.blockID; 
    	boolean flag3 = par1World.getBlockId(par2, par3, par4 + 1) == Registry.cannon.blockID; 
    	boolean flag4 = par1World.getBlockId(par2, par3, par4 - 1) == Registry.cannon.blockID; 
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
    @Override
    public int idDropped(int par1, Random random, int zero) {
       return 0;
}
}
