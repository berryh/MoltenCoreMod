package berryh.moltencore.common;

import ic2.api.IReactor;
import ic2.api.IReactorComponent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemMoltenCoreCoolingCell extends Item implements IReactorComponent {

	private static int maxHeat = 0;
	private static int curHeat = 0;

	public ItemMoltenCoreCoolingCell(int par1, int maxHeat) {
		super(par1);
		this.maxHeat = maxHeat;
		this.setMaxDamage(50);
		this.setCreativeTab(CreativeTabs.tabMisc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processChamber(IReactor reactor, ItemStack yourStack, int x, int y) {
		if (!reactor.produceEnergy()) {
			if (curHeat >= 1000) {
				curHeat = curHeat - 1000;
			} else {
				curHeat = 0;
			}
			setHeatForStack(yourStack, curHeat);
		} else {
			reactor.setHeat(0);
		}

	}

	@Override
	public boolean acceptUraniumPulse(IReactor reactor, ItemStack yourStack, ItemStack pulsingStack, int youX, int youY, int pulseX, int pulseY) {
		return false;
	}

	@Override
	public boolean canStoreHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
		return true;
	}

	@Override
	public int getMaxHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
		return maxHeat;
	}

	@Override
	public int getCurrentHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
		return getHeatOfStack(yourStack);
	}

	@Override
	public int alterHeat(IReactor reactor, ItemStack yourStack, int x, int y, int heat) {
		int myHeat = getHeatOfStack(yourStack);
		myHeat += heat;
		if (myHeat > this.maxHeat)
		{
			reactor.setItemAt(x, y, null);
			heat = this.maxHeat - myHeat + 1;
		}
		else
		{
			if (myHeat < 0)
			{
				heat = myHeat;
				myHeat = 0;
			}
			else {
				heat = 0;
			}
			setHeatForStack(yourStack, myHeat);
		}
		return heat;
	}

	@Override
	public float influenceExplosion(IReactor reactor, ItemStack yourStack) {
		return 0.0F;
	}

	private void setHeatForStack(ItemStack stack, int heat)
	{
		NBTTagCompound nbtData = MoltenCoreNBTHelper.getOrCreateNbtData(stack);
		nbtData.setInteger("heat", heat);
		if (this.maxHeat > 0)
		{
			double p = heat / this.maxHeat;
			int newDmg = (int) (stack.getMaxDamage() * p);
			if (newDmg >= stack.getMaxDamage())
				newDmg = stack.getMaxDamage() - 1;
			stack.setItemDamage(newDmg);
		}
	}

	private int getHeatOfStack(ItemStack stack) {
		NBTTagCompound nbtData = MoltenCoreNBTHelper.getOrCreateNbtData(stack);
		return nbtData.getInteger("heat");
	}

	@Override
	public String getTextureFile() {
		return MoltenCoreCommonProxy.ITEM;
	}

}
