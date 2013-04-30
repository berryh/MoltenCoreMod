package berryh.moltencore.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.common.FMLCommonHandler;

public class ItemMoltenCoreSapler extends Item {
	
	public ItemMoltenCoreSapler(int i){
		super(i);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block){
		
		Random rnd = new Random();
		if(par2Block instanceof BlockLeavesBase){
			
			int id = par2Block.idDropped(0, rnd , 2);
			ItemStack sapling = new ItemStack(id,1,par2Block.damageDropped(5));
			return 50.0f;
			
		}
		return 1.0f;
		
	}

}
