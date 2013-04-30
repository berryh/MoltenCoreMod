package berryh.moltencore.common;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class MoltenCoreCommonProxy {
	public static String BLOCK = "/berryh/moltencore/client/gfx/terrain.png";
	public static String ITEM = "/berryh/moltencore/client/gfx/items.png";
	
	public void registerRenderInformation(){
		
	}
	
	public void registerHandlers(){
		
		//GameRegistry.registerCraftingHandler(new MoltenCoreCraftingHandler());
		//MinecraftForge.EVENT_BUS.register(new MoltenCoreEventHandler());
		//GameRegistry.registerFuelHandler(new MoltenCoreFuelHandler());
	}
	
	public void registerTextureFX(){
		
	}

	public void checkCompatibility() {
		
		/*
		try {
			Class ic2api = Class.forName("ic2.core.IC2");
			MoltenCoreMain.ic2 = true;
			MoltenCoreMain.logger.fine("IC2 Found. Compatibility Enabled");
		} catch (ClassNotFoundException e) {
			MoltenCoreMain.ic2 = false;
			MoltenCoreMain.logger.fine("IC2 Not Found. Compatibility Disabled");
		}
		
		try {
			Class forestryapi = Class.forName("forestry.core.ForestryCore");
			MoltenCoreMain.forestry = true;
			MoltenCoreMain.logger.fine("Forestry Found. Compatibility Enabled");
		} catch (ClassNotFoundException e) {
			MoltenCoreMain.forestry = false;
			MoltenCoreMain.logger.fine("Forestry Not Found. Compatibility Disabled");
		}
		*/
		
		if(Loader.isModLoaded("IC2")) {
			MoltenCoreMain.ic2 = true;
			MoltenCoreMain.logger.fine("IC2 Found. Compatibility Enabled");
		} else {
			MoltenCoreMain.ic2 = false;
			MoltenCoreMain.logger.fine("IC2 Not Found. Compatibility Disabled");
		}
		
		if(Loader.isModLoaded("Forestry")) {
			MoltenCoreMain.forestry = true;
			MoltenCoreMain.logger.fine("Forestry Found. Compatibility Enabled");
		} else {
			MoltenCoreMain.forestry = false;
			MoltenCoreMain.logger.fine("Forestry Not Found. Compatibility Disabled");
		}
		
		if(Loader.isModLoaded("BuildCraft|Core")) {
			MoltenCoreMain.buildcraft = true;
			MoltenCoreMain.logger.fine("BuildCraft Found. Compatibility Enabled");
		} else {
			MoltenCoreMain.buildcraft = false;
			MoltenCoreMain.logger.fine("BuildCraft Not Found. Compatibility Disabled");
		}
		
	}
	
}
