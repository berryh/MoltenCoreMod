package berryh.moltencore.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MoltenCoreEventHandler {
	@ForgeSubscribe
	public void bonemealUsed(BonemealEvent event) {
		if (event.world.getBlockId(event.X, event.Y, event.Z) == MoltenCoreMain.sugarBeetBlock.blockID) {
			((BlocksugarBeetBlock) MoltenCoreMain.sugarBeetBlock).fertilize(
					event.world, event.X, event.Y, event.Z);
			ItemStack bonemealitem = event.entityPlayer.inventory
					.getCurrentItem();
			--bonemealitem.stackSize;
			// event.setResult(Result.ALLOW);
		}
	}

	/*
	public void falling(LivingFallEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			ItemStack req = new ItemStack(MoltenCoreMain.teleporter);
			if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
				player.sendChatToPlayer("Falling " + event.distance);
			}
			// if(player.inventory.hasItem((new
			// ItemStack(MoltenCoreMain.moltencorePickaxe)).itemID)){
			// event.setCanceled(true);
			// }
			if (event.distance > 3) {
				if (player.inventory.hasItem(req.itemID)) {
					event.setCanceled(true);
				}
			}
		}
	}
	*/
	
	@ForgeSubscribe
	public void hurt(LivingHurtEvent event) {
		if (event.entity instanceof EntityPlayer) {
			if (event.source == DamageSource.outOfWorld) {
				event.setCanceled(true);
			}
		}
	}

	/*
	 * @ForgeSubscribe public void drops(LivingDropsEvent event) { if
	 * (event.entityLiving instanceof EntityPig) { if
	 * (event.source.getDamageType().equals("player")) {
	 * event.entityLiving.dropItem(Item.netherStar.itemID, 64); } } }
	 */

}
