package berryh.moltencore.client;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
import berryh.moltencore.common.*;

public class MoltenCoreKeyBindingHandler extends KeyHandler {

	static KeyBinding setCurrentPos = new KeyBinding("SetCurrentPos", Keyboard.KEY_HOME);

	public MoltenCoreKeyBindingHandler() {
		super(new KeyBinding[] { setCurrentPos }, new boolean[] { false });
	}

	@Override
	public String getLabel() {
		return "teleportKeyBinding";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
		if (kb == setCurrentPos) {
			EntityPlayer player = ((EntityPlayer) Minecraft.getMinecraft().thePlayer);
			MoltenCoreMain.setCurrentPos(player);
		}
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT);
	}

}
