package berryh.moltencore.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlocksodiumNitrate extends Block{

	public BlocksodiumNitrate(int i, int j) {
		super(i,j,Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setLightValue(0.5F);
	}
	
	public String getTextureFile()
	{
		return MoltenCoreCommonProxy.BLOCK;
	}

    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return MathHelper.clamp_int(this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1), 1, 4);
    }


    public int quantityDropped(Random par1Random)
    {
        return 1;
    }


    public int idDropped(int par1, Random par2Random, int par3)
    {
        return MoltenCoreMain.sodiumNitrate.itemID;
    }
    
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote)
        {
                int var6 = 5;
                par1World.spawnEntityInWorld(new EntityXPOrb(par1World, (double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, var6));
        }
    }

}
