package berryh.moltencore.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;

public class ToolMoltenCoreHoe extends ItemHoe{
	
	protected ToolMoltenCoreHoe(int i, EnumToolMaterial enumtoolmaterial){
		super(i, enumtoolmaterial);
		setCreativeTab(CreativeTabs.tabTools);
	}
	
	public String getTextureFile()
	{
		return MoltenCoreCommonProxy.ITEM;
	}
	
	
}