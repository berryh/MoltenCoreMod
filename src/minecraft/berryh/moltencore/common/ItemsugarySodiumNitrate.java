package berryh.moltencore.common;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockStem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class ItemsugarySodiumNitrate extends Item {

	public ItemsugarySodiumNitrate(int i) {
		super(i);
		setCreativeTab(CreativeTabs.tabMaterials);
	}

	public String getTextureFile() {
		return MoltenCoreCommonProxy.ITEM;
	}
}
