package ninjapancakes87.civilwar.block;

import javax.swing.Icon;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ninjapancakes87.civilwar.CivilWar;
import ninjapancakes87.civilwar.Registry;
import ninjapancakes87.civilwar.Strings;
import ninjapancakes87.civilwar.tileentity.TileEntityMucket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMucket extends BlockContainer{
	TileEntityMucket te = new TileEntityMucket();
	
	@SideOnly(Side.CLIENT)
	private Icon itemIcon;

	public BlockMucket() {
		super(Material.rock);
		this.setCreativeTab((CreativeTabs)null);
		this.setResistance(50.0F);
		this.setHardness(5.0F);
	}

	 @Override
	 public void setBlockBoundsBasedOnState(IBlockAccess iba, int par2, int par3, int par4){
		 this.setBlockBounds((float)0.1, 0, (float)0.1, (float)0.9, (float)0.9, (float)0.9);
	 }
	
	@Override
	public TileEntity createNewTileEntity(World world, int par1) {
		return new TileEntityMucket();
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
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
	 	if(!par1World.isRemote){
	 		par5EntityPlayer.openGui(CivilWar.instance, 8, par1World, par2, par3, par4);
	 		return true;
	 	}
        return false;
    }
}
