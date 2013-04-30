package berryh.moltencore.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class ToolMoltenCorePickaxe extends ItemPickaxe {
	
	protected ToolMoltenCorePickaxe(int i, EnumToolMaterial enumtoolmaterial) {
		super(i, enumtoolmaterial);
		setCreativeTab(CreativeTabs.tabTools);
	}
	
	public String getTextureFile()
	{
		return "/berryh/moltencore/client/gfx/items.png";
	}
	
}
	