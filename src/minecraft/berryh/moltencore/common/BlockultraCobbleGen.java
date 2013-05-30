package berryh.moltencore.common;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import berryh.moltencore.client.MoltenCoreClientProxy;

public class BlockultraCobbleGen extends BlockContainer {

	protected BlockultraCobbleGen(int id, int t) {
		super(id, t, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	public String getTextureFile() {
		return MoltenCoreClientProxy.BLOCK;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk, float what, float these, float are) {
		return false;
		/*
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (tileEntity == null || player.isSneaking()) {
			return false;
		}
		// code to open gui explained later
		player.openGui(MoltenCoreMain.instance, 0, world, x, y, z);
		return true;
		*/
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		super.breakBlock(world, x, y, z, par5, par6);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityUltraCobbleGen();
	}
}
