package berryh.moltencore.common;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import buildcraft.api.power.IPowerProvider;
import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.power.PowerFramework;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.*;

public class TileEntityMoltenCoreRepairer extends TileEntity implements
		IInventory, IPowerReceptor {

	public ItemStack inv;

	public static IPowerProvider powerProvider;
	private static boolean active = false;
	
	public TileEntityMoltenCoreRepairer() {
		powerProvider = PowerFramework.currentFramework.createPowerProvider();
		powerProvider.configure(0, 10, 200, 100, 5000);
		powerProvider.configurePowerPerdition(0, 0);
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
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inv = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}

	}

	@Override
	public String getInvName() {
		return "moltencoremod.tileentitymoltencorerepairer";
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this
				&& player.getDistanceSq(xCoord + 0.5, yCoord + 0.5,
						zCoord + 0.5) < 64;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);

		NBTTagList tagList = tagCompound.getTagList("Inventory");
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
			byte slot = tag.getByte("Slot");

			inv = ItemStack.loadItemStackFromNBT(tag);

		}
		PowerFramework.currentFramework.loadPowerProvider(this, tagCompound);
		powerProvider.configure(0, 10, 200, 100, 5000);
		powerProvider.configurePowerPerdition(0, 0);

	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);

		NBTTagList itemList = new NBTTagList();
		ItemStack stack = inv;
		if (stack != null) {
			NBTTagCompound tag = new NBTTagCompound();
			tag.setByte("Slot", (byte) 1);
			stack.writeToNBT(tag);
			itemList.appendTag(tag);
		}
		tagCompound.setTag("Inventory", itemList);
		PowerFramework.currentFramework.savePowerProvider(this, tagCompound);

	}

	public void updateEntity() {
		powerProvider.update(this);
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER){
			checkRepair();
		}//else if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT){
			//doRendering();
		//}
	}

	private void doRendering() {
		if(this.inv != null){
		}
	}

	@Override
	public void setPowerProvider(IPowerProvider provider) {
		powerProvider = provider;

	}

	@Override
	public IPowerProvider getPowerProvider() {
		return powerProvider;
	}

	@Override
	public void doWork() {

	}

	@Override
	public int powerRequest() {
		powerProvider.update(this);
		if (this.canStorePower()) {
			// if(this.inv != null && this.inv.isItemDamaged()){
			return (int) Math.ceil(Math.min(getPowerProvider()
					.getMaxEnergyReceived(), getPowerProvider()
					.getMaxEnergyStored()
					- getPowerProvider().getEnergyStored()));
		} else {
			return 0;
		}
	}

	public boolean canStorePower() {
		powerProvider.update(this);
		if (powerProvider.getMaxEnergyStored() > powerProvider
				.getEnergyStored()) {
			return true;
		} else {
			return false;
		}
	}

	public int getScaledEnergyStored(float i) {
		powerProvider.update(this);
		float scale = (powerProvider.getEnergyStored() * i / powerProvider.getMaxEnergyStored());
		return (int) scale;
	}

	public boolean isActive() {
		return active;
	}
	
	public void checkRepair() {
		if (this.inv != null) {
			if (this.inv.isItemDamaged() && this.inv.getItem() instanceof ItemTool) {
				this.active = true;
				if (powerProvider.getEnergyStored() >= 100.0F) {
					float energyUsed = powerProvider.useEnergy(100.0F, 100.0F,true);
					if (energyUsed == 100.0F) {
						this.inv.setItemDamage(this.inv.getItemDamage() - 1);
					}
				}
			} else {
				this.active = false;
			}
		} else {
			this.active = false;
		}
	}

	public int getScaledProgress(int f) {
		
		if(this.inv !=null && this.inv.isItemDamaged()){
			return (int)((this.inv.getMaxDamage() - inv.getItemDamage())* f / inv.getMaxDamage());
		}else if(this.inv != null && !this.inv.isItemDamaged()){
			return 124;
		}else{
			return 0;
		}
	}

}
