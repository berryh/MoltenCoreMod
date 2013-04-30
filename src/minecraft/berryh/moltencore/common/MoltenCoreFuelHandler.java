package berryh.moltencore.common;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class MoltenCoreFuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		
		if(fuel.itemID == MoltenCoreMain.sodiumNitrateOre.blockID){
			return 1600;
		}
		if(fuel.itemID == MoltenCoreMain.sodiumNitrate.itemID){
			return 1600;
		}
		if(fuel.itemID == MoltenCoreMain.sugarySodiumNitrate.itemID){
			return 3200;
		}
		if(fuel.itemID == MoltenCoreMain.sugarySodiumNitrateBlock.blockID){
			return 28800;
		}
		
		return 0;
	}

}
