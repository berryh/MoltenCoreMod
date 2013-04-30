package berryh.moltencore.common;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class Itemteleporter extends Item{
	
	public Itemteleporter(int i){
		super(i);
		setCreativeTab(CreativeTabs.tabTransport);
		setMaxStackSize(1);
	}
	/*
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
		
		if(!entityplayer.isSneaking()){
			MoltenCoreMain.goHome(world, entityplayer);
			return itemstack;
		}
		if(entityplayer.isSneaking()){
			MoltenCoreMain.goCurrent(world, entityplayer);
			return itemstack;
		}
		return itemstack;
		
		
		
		
    }
    */
	/*
	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {
		
		int x = par4;
		int y = par5;
		int z = par6;
		
		Block block1 = Block.blocksList[par3World.getBlockId(z, y, z)];
		Block block2 = Block.blocksList[par3World.getBlockId(z, y +1, z)];
		
		par3World.setBlock(x, y, z, 0);
		par3World.setBlock(x, y+1, z, 0);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		par3World.setBlock(x, y, z, block1.blockID);
		par3World.setBlock(x, y+1, z, block2.blockID);
		return false;
		
	}
	*/
	public String getTextureFile()
	{
		return MoltenCoreCommonProxy.ITEM;
	}
	
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemstack){
		return EnumRarity.epic;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack itemstack){
		return true;
	}
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
	{
		
		par3List.add("Set the position you want to save by pressing the Home key");
		par3List.add("Press the right-mouse button to go home (your spawn point)");
		par3List.add("Hold the shift-key and press the right-mouse button to go to your set position");
		
	}
	
}
