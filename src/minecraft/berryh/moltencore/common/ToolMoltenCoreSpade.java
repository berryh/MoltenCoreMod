package berryh.moltencore.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;

public class ToolMoltenCoreSpade extends ItemSpade{
	
	protected ToolMoltenCoreSpade(int i, EnumToolMaterial enumtoolmaterial){
		super(i, enumtoolmaterial);
		setCreativeTab(CreativeTabs.tabTools);
	}
	
	public String getTextureFile()
	{
		return "/berryh/moltencore/client/gfx/items.png";
	}
	
}