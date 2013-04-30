package berryh.moltencore.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Itemunmoltencorecenter extends Item
{
        public Itemunmoltencorecenter(int i)
        {
                super(i);
                setCreativeTab(CreativeTabs.tabMaterials);
        }
        
        public String getTextureFile()
    	{
    		return MoltenCoreCommonProxy.ITEM;
    	}
}