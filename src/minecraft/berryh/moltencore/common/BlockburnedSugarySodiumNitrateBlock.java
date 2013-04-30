package berryh.moltencore.common;

import ic2.api.Items;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockburnedSugarySodiumNitrateBlock extends Block {
	
	public BlockburnedSugarySodiumNitrateBlock(int i, int j){
		super(i,j, Material.rock);
		this.setStepSound(Block.soundClothFootstep);
	}
	
	public String getTextureFile()
	{
		return MoltenCoreCommonProxy.BLOCK;
	}
	
	public boolean isFireSource(World world, int x, int y, int z, int metadata, ForgeDirection side)
	{
		return true;
	}
	
    public int quantityDropped(Random par1Random)
    {
    	return 1;
    }


    public int idDropped(int par1, Random par2Random, int par3)
    {
    	if(MoltenCoreMain.ic2){
    		ItemStack sR = Items.getItem("resin");
    		return sR.itemID;
    	}else{
    		return this.blockID;
    	}
    }
    
    public boolean canCreatureSpawn(EnumCreatureType type, World world, int x, int y, int z)
    {
		return false;
	}
    
    public boolean canSilkHarvest(){
    	return true;
    }
    
    /*public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	if(MoltenCoreMain.ic2){
    		if(par5EntityPlayer.inventory.getCurrentItem().itemID == (Items.getItem("treetap")).itemID || par5EntityPlayer.inventory.getCurrentItem().itemID == (Items.getItem("electricTreetap")).itemID){
    			Random r = new Random();
    			ItemStack resinDropStack = (Items.getItem("resin"));
    			resinDropStack.stackSize = 2 + r.nextInt(5);
    			EntityItem resin = (new EntityItem(par1World,par2,par3,par4,resinDropStack));
    			par1World.spawnEntityInWorld(resin);
    			if(par5EntityPlayer.inventory.getCurrentItem().getItemDamage()+1 != par5EntityPlayer.inventory.getCurrentItem().getMaxDamage() && par5EntityPlayer.inventory.getCurrentItem() != null){
    				par5EntityPlayer.inventory.getCurrentItem().damageItem(1, par5EntityPlayer);
    			}else{
    				ItemStack treetap = par5EntityPlayer.inventory.getCurrentItem();
    				treetap = null;
    			}
    			par1World.setBlockWithNotify(par2, par3, par4, 0);
    			return true;
    		}
    		return true;
    	}else{
    		return true;
    	}
    }*/

}
