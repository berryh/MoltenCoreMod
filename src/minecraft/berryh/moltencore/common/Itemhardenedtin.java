package berryh.moltencore.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Itemhardenedtin extends Item
{
	public Itemhardenedtin(int i)
    {
		super(i);
        setCreativeTab(CreativeTabs.tabMaterials);
    }
	
	public String getTextureFile()
	{
		return MoltenCoreCommonProxy.ITEM;
	}
	
}