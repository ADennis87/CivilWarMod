package ninjapancakes87.civilwar.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRevolver extends ItemMusket{
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;
	
	public static final String[] bowPullIconNameArray = new String[] {"Civil War:revolver", "Civil War:revolver", "Civil War:revolver"};

	public ItemRevolver(int par1) {
		super(par1);
	}
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("Civil War:revolver");
        this.iconArray = new Icon[bowPullIconNameArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(bowPullIconNameArray[i]);
        }
    }
}