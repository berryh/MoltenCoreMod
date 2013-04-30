package berryh.moltencore.common;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

public class ToolMoltenCoreAxe extends ItemAxe {

	protected ToolMoltenCoreAxe(int i, EnumToolMaterial enumtoolmaterial) {
		super(i, enumtoolmaterial);
		setCreativeTab(CreativeTabs.tabTools);
	}

	public String getTextureFile() {
		return MoltenCoreCommonProxy.ITEM;
	}

	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		if (par2Block.blockMaterial == Material.wood) {
			return 30.0F;
		}
		if (par2Block.blockMaterial == Material.leaves) {
			return 50.0F;
		}
		if (par2Block.blockMaterial == Material.vine) {
			return 50.0F;
		}
		if (par2Block.stepSound == Block.soundWoodFootstep) {
			return 30.0F;
		}
		if (par2Block.stepSound == Block.soundGrassFootstep) {
			if(par2Block.blockID != Block.grass.blockID){
				return 50.0F;
			}
		}
		return 1.0F;
	}

	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {
		/*
		 * int l = 1; int i = par4;//x leftright int j = par5;//y height int k =
		 * par6;//z forwardbackward for (int i1 = -l; i1 <= l; i1++) { for (int
		 * k1 = -l; k1 <= l; k1++) { for (int j1 = 0; j1 <= 50; j1++) { int l1 =
		 * par3World.getBlockId(i + i1, j + k1, k + j1);
		 * 
		 * if (!checkWood(l1)){ continue; }
		 * 
		 * 
		 * Block block = Block.blocksList[par3World.getBlockId(i + i1, j + k1, k
		 * + j1)]; int i2 = par3World.getBlockMetadata(i + i1, j + k1, k + j1);
		 * 
		 * if (block != null && par3World.setBlockWithNotify(i + i1, j + k1, k +
		 * j1, 0)) block.dropBlockAsItem(par3World, i + i1, j + k1, k + j1, i2,
		 * 0); } } }
		 */
		
		//TileEntity te = par3World.getBlockTileEntity(par4, par5, par6);
		/*
		if(te !=null){
			TileEntityChest tec = (TileEntityChest)te;
			
			int invSize;
			
			invSize = tec.getSizeInventory();
			if(invSize != 0){
				tec.
			}
		}
		*/
		for (int h = 0; h <= 50; h++) {
			int id = par3World.getBlockId(par4, par5 + h, par6);

			Block block = Block.blocksList[par3World.getBlockId(par4, par5 + h,
					par6)];
			if (!checkWood(block)) {
				continue;
			}
			int i2 = par3World.getBlockMetadata(par4, par5 + h, par6);

			if (block != null
					&& par3World.setBlockWithNotify(par4, par5 + h, par6, 0)) {
				block.dropBlockAsItem(par3World, par4, par5 + h, par6, i2, 0);
				int originaldamage = par1ItemStack.getItemDamage();
				if (par1ItemStack.getMaxDamage() >= originaldamage + 1) {
					par1ItemStack.setItemDamage(originaldamage + 1);
				} else {
					par1ItemStack = null;
				}
			}

		}

		return true;
	}

	public boolean checkWood(Block block) {
		if (block != null) {
			if (block.blockMaterial == Material.wood) {
				return true;
			}
			if (block.stepSound == Block.soundWoodFootstep) {
				return true;
			}
		}
		return false;
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
	{
		
		par3List.add("Right-click for TreeCapitator functionality");
		
	}

}
