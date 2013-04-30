package berryh.moltencore.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemstabilizedBottle extends Item{
	
	public ItemstabilizedBottle(int i)
	{
		super(i);
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		int originalSize = itemstack.stackSize;
		int levelsRequired = originalSize * 30;
		if(entityplayer.experienceLevel >= levelsRequired){
			entityplayer.experienceLevel = entityplayer.experienceLevel - levelsRequired;
			return new ItemStack(MoltenCoreMain.mysticalBottle,originalSize);
		}else{
			entityplayer.sendChatToPlayer("Not enough experience levels to do this. Please decrease the stack size and try again");
			return itemstack;
		}
		
		
		
	}
	
	public String getTextureFile()
	{
		return MoltenCoreCommonProxy.ITEM;
	}
	
}
