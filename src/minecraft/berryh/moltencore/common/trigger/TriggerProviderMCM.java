package berryh.moltencore.common.trigger;

import java.util.LinkedList;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import berryh.moltencore.common.MoltenCoreMain;
import berryh.moltencore.common.TileEntityMoltenCoreRepairer;
import buildcraft.api.gates.ITrigger;
import buildcraft.api.gates.ITriggerProvider;
import buildcraft.api.transport.IPipe;

public class TriggerProviderMCM implements ITriggerProvider{
	
	//TriggerProviderMCM instance = new TriggerProviderMCM();
	
	
	@Override
	public LinkedList<ITrigger> getPipeTriggers(IPipe pipe) {
		return null;
	}

	@Override
	public LinkedList<ITrigger> getNeighborTriggers(Block block, TileEntity tile) {
		LinkedList<ITrigger> triggers = new LinkedList<ITrigger>();
		
		if ((tile instanceof TileEntityMoltenCoreRepairer)){
			triggers.add(MoltenCoreMain.triggerItemDamaged);
			triggers.add(MoltenCoreMain.triggerItemRepaired);
			}
		
		
		return triggers;
	}
	

}
