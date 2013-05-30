package berryh.moltencore.common;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityUltraCobbleGen extends TileEntity implements IInventory{
	
	public ItemStack inv;
	
	public TileEntityUltraCobbleGen(){
		
	}
	
	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return inv;
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize <= amount) {
				setInventorySlotContents(slot, null);
			} else {
				stack = stack.splitStack(amount);
				if (stack.stackSize == 0) {
					setInventorySlotContents(slot, null);
				}
			}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		ItemStack stack = getStackInSlot(var1);
		if (stack != null) {
			setInventorySlotContents(var1, null);
		}
		return stack;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		inv = var2;
		
	}

	@Override
	public String getInvName() {
		return "moltencoremod.tileentityultracobblegen";
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return false;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}
	
	public void updateEntity() {
		this.inv = new ItemStack(Block.cobblestone,64);
	}
	

}
