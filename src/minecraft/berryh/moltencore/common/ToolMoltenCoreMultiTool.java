package berryh.moltencore.common;

import java.util.List;

import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import berryh.moltencore.client.MoltenCoreClientProxy;

public class ToolMoltenCoreMultiTool extends ItemPickaxe {
	
	EnumToolMaterial mat = null;
	
	public ToolMoltenCoreMultiTool(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.mat = par2EnumToolMaterial;
	}
	
	public String getTextureFile(){
		return MoltenCoreClientProxy.ITEM;
	}
	
	public void Setup(ItemStack item){
		String NBTName = MoltenCoreNBTHelper.getString(item, "Name");
		if(NBTName == ""){
			NBTName = "Molten Core MultiTool";
		}
		this.setItemName(NBTName);
		LanguageRegistry.addName(item, NBTName);
		
		int NBTHarvestLevel = MoltenCoreNBTHelper.getInteger(item, "HL");
		System.out.println(NBTHarvestLevel);
		if(NBTHarvestLevel == 0){
			NBTHarvestLevel = 1;
		}
		System.out.println(NBTHarvestLevel);
		MinecraftForge.setToolClass(this, "pickaxe", NBTHarvestLevel);
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer){
		this.Setup(itemstack);
		return itemstack;
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
		int HL = MoltenCoreNBTHelper.getInteger(par1ItemStack, "HL");
		par3List.add("Harvest Level: " + HL);
	}
	
}
