package berryh.moltencore.common;

import berryh.moltencore.client.GuiMoltenCoreRepairer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class MoltenCoreGuiHandler implements IGuiHandler{
	
	@Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof TileEntityMoltenCoreRepairer){
                    return new ContainerMoltenCoreRepairer(player.inventory, (TileEntityMoltenCoreRepairer) tileEntity);
            }
            return null;
    }

    //returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof TileEntityMoltenCoreRepairer){
                    return new GuiMoltenCoreRepairer(player.inventory, (TileEntityMoltenCoreRepairer) tileEntity);
            }
            return null;

    }

}
