package berryh.moltencore.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMoltenCorePlate extends Item{
	
	public ItemMoltenCorePlate(int i){
		super(i);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public String getTextureFile(){
		return MoltenCoreCommonProxy.ITEM;
	}

}
