package berryh.moltencore.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerMoltenCoreRepairer extends Container {

	protected TileEntityMoltenCoreRepairer tileEntity;

	public ContainerMoltenCoreRepairer(InventoryPlayer inventoryPlayer, TileEntityMoltenCoreRepairer te) {
		tileEntity = te;

		// the Slot constructor takes the IInventory and the slot number in that
		// it binds to
		// and the x-y coordinates it resides on-screen
		// for (int i = 0; i < 3; i++) {
		// for (int j = 0; j < 3; j++) {
		addSlotToContainer(new Slot(tileEntity, 1, 80, 18));
		// }
		// }

		// commonly used vanilla code that adds the player's inventory
		bindPlayerInventory(inventoryPlayer);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return tileEntity.isUseableByPlayer(player);
	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 71 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 129));
		}
	}

	/*
	 * The Original Code
	 * 
	 * protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) { for
	 * (int i = 0; i < 3; i++) { for (int j = 0; j < 9; j++) {
	 * addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18,
	 * 84 + i * 18)); } }
	 * 
	 * for (int i = 0; i < 9; i++) { addSlotToContainer(new
	 * Slot(inventoryPlayer, i, 8 + i * 18, 142)); } }
	 */

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		ItemStack stack = null;
		Slot slotObject = (Slot) inventorySlots.get(slot);

		// null checks and checks if the item can be stacked (maxStackSize > 1)
		if (slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();

			// merges the item into player inventory since its in the tileEntity
			if (slot < 1) {
				if (!this.mergeItemStack(stackInSlot, 1, 36, true)) {
					return null;
				}
			}
			// places it into the tileEntity is possible since its in the player
			// inventory
			else if (!this.mergeItemStack(stackInSlot, 0, 1, false)) {
				return null;
			}

			if (stackInSlot.stackSize == 0) {
				slotObject.putStack(null);
			} else {
				slotObject.onSlotChanged();
			}

			if (stackInSlot.stackSize == stack.stackSize) {
				return null;
			}
			slotObject.onPickupFromSlot(player, stackInSlot);
		}
		return stack;
	}

}
