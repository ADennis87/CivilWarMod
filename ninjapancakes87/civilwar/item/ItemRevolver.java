package ninjapancakes87.civilwar.item;

import javax.swing.Icon;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRevolver extends ItemMusket{
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
	
	public static final String[] bowPullIconNameArray = new String[] {"Civil War:revolver", "Civil War:revolver", "Civil War:revolver"};

	public ItemRevolver() {
		super();
	}
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("Civil War:revolver");
        this.iconArray = new IIcon[bowPullIconNameArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(bowPullIconNameArray[i]);
        }
    }
}