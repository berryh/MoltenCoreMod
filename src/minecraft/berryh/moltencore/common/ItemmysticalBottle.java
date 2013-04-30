package berryh.moltencore.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemmysticalBottle extends Item{
	
	public ItemmysticalBottle(int i){
		super(i);
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		int originalSize = itemstack.stackSize;
		for(int i=0;i<originalSize;i++){
			entityplayer.experienceLevel = entityplayer.experienceLevel + 30;
		}
		return new ItemStack(MoltenCoreMain.stabilizedBottle,originalSize);
	}
	
	public String getTextureFile()
	{
		return MoltenCoreCommonProxy.ITEM;
	}
	
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemstack){
		return EnumRarity.rare;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack itemstack){
		return true;
	}
	
}