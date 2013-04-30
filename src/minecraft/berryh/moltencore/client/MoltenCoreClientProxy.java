package berryh.moltencore.client;

import net.minecraft.client.renderer.RenderEngine;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import berryh.moltencore.common.MoltenCoreCommonProxy;
import berryh.moltencore.common.MoltenCoreMain;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;

public class MoltenCoreClientProxy extends MoltenCoreCommonProxy{
	
	@Override
	public void registerRenderInformation(){
	
		MinecraftForgeClient.preloadTexture("/berryh/moltencore/client/gfx/items.png");
		MinecraftForgeClient.preloadTexture("/berryh/moltencore/client/gfx/terrain.png");
		
		
		
	}
	
	@Override
	public void registerHandlers(){
		
		KeyBindingRegistry.registerKeyBinding(new MoltenCoreKeyBindingHandler());
		
	}
	
	@Override
	public void registerTextureFX(){
		RenderEngine rEngine = FMLClientHandler.instance().getClient().renderEngine;
		rEngine.registerTextureFX(new TextureKerogenFX());
	}

}
