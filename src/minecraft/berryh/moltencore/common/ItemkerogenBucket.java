package berryh.moltencore.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemkerogenBucket extends Item{
	
	public ItemkerogenBucket(int i){
		super(i);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setMaxStackSize(1);
	}
	
	public String getTextureFile(){
		return MoltenCoreCommonProxy.ITEM;
	}

}
