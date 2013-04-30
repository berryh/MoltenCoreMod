package berryh.moltencore.common;

import ic2.api.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;
import berryh.moltencore.common.*;


public class MoltenCoreCraftingHandler implements ICraftingHandler {

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
		if(MoltenCoreMain.ic2){
			if (item.itemID == (Items.getItem("resin").itemID)) {
				for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
					if (craftMatrix.getStackInSlot(i) != null) {
						ItemStack j = craftMatrix.getStackInSlot(i);
						if (j.getItem() != null && j.getItem() == Item.flintAndSteel) {
							int max = j.getMaxDamage();
							if (j.getItemDamage() + 1 < max) {
								ItemStack k = new ItemStack(Item.flintAndSteel, 2, (j.getItemDamage() + 1));
								craftMatrix.setInventorySlotContents(i, k);
							} else {
								ItemStack k = null;
							}
						}
					}
				}
			}
		}
		if (item.itemID == MoltenCoreMain.moltencorePickaxe.itemID) {
			for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
				if (craftMatrix.getStackInSlot(i) != null) {
					ItemStack j = craftMatrix.getStackInSlot(i);
					if (j.getItem() != null && j.getItem() == MoltenCoreMain.moltencorePickaxe) {
						int damage = j.getItemDamage();
						item.setItemDamage(damage);
					}
				}
			}
		}
		
		if (item.itemID == MoltenCoreMain.moltencoreMultiTool.itemID){
			for (int i=0; i< craftMatrix.getSizeInventory(); i++){
				if (craftMatrix.getStackInSlot(i) != null){
					ItemStack j = craftMatrix.getStackInSlot(i);
					if(j.getItem() != null && j.getItem() == Item.diamond){
						MoltenCoreNBTHelper.setInteger(item, "HL", 3);
						MoltenCoreNBTHelper.setString(item, "Name", "Molten Core MultiTool+");
					}
				}
			}			
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
	}

}
