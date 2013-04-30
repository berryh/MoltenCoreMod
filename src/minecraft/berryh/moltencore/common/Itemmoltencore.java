package berryh.moltencore.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Itemmoltencore extends Item
{
        public Itemmoltencore(int i)
        {
                super(i);
                setCreativeTab(CreativeTabs.tabMaterials);
        }
        
        public String getTextureFile()
    	{
    		return MoltenCoreCommonProxy.ITEM;
    	}
}