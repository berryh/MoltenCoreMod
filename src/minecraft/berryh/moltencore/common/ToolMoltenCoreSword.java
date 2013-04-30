package berryh.moltencore.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ToolMoltenCoreSword extends ItemSword{
	
	protected ToolMoltenCoreSword(int i, EnumToolMaterial enumtoolmaterial){
		super(i, enumtoolmaterial);
		setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public String getTextureFile()
	{
		return MoltenCoreCommonProxy.ITEM;
	}
	
	
}
