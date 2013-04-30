package berryh.moltencore.client;

import net.minecraft.item.ItemStack;
import berryh.moltencore.common.MoltenCoreMain;

public class TextureKerogenFX extends TextureLiquidsFX{
	
	public TextureKerogenFX() {
		super(85, 179, 82, 182, 99, 203, MoltenCoreMain.kerogen.getIconIndex(new ItemStack(MoltenCoreMain.kerogen)), MoltenCoreMain.kerogen.getTextureFile());
	}
	
}
