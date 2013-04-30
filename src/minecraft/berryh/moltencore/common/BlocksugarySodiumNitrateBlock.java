package berryh.moltencore.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlocksugarySodiumNitrateBlock extends Block{
	
	public BlocksugarySodiumNitrateBlock(int i, int j)
	{
		super(i,j,Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
		setLightValue(1F);
	}
	
	public String getTextureFile()
	{
		return MoltenCoreCommonProxy.BLOCK;
	}
	
	public boolean isFireSource(World world, int x, int y, int z, int metadata, ForgeDirection side)
	{
		world.setBlock(x, y, z, MoltenCoreMain.burnedSugarySodiumNitrateBlock.blockID);
		return true;
	}
	
	public boolean canCreatureSpawn(EnumCreatureType type, World world, int x, int y, int z)
	{
		return false;
	}
	
}
