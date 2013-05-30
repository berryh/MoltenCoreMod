package berryh.moltencore.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.ForgeHooksClient;

import org.lwjgl.LWJGLUtil;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import org.lwjgl.input.Mouse;


import berryh.moltencore.common.ContainerMoltenCoreRepairer;
import berryh.moltencore.common.TileEntityMoltenCoreRepairer;

public class GuiMoltenCoreRepairer extends GuiContainer {

	TileEntityMoltenCoreRepairer tile;
	public static int mouseX;
	public static int mouseY;
	

	public GuiMoltenCoreRepairer(InventoryPlayer inventoryPlayer, TileEntityMoltenCoreRepairer tileEntity) {
		super(new ContainerMoltenCoreRepairer(inventoryPlayer, tileEntity));
		tile = tileEntity;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		fontRenderer.drawString("Molten Core Repairer", 32, 6, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 - 10, 4210752);
		
		this.mouseX = param1;
		this.mouseY = param2;
		List<String> tooltips = new ArrayList<String>();
		tooltips.add("Energy Stored: " + this.tile.getPowerProvider().getEnergyStored());
		drawToolTip(tooltips, this.mouseX, this.mouseY);

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		ForgeHooksClient.bindTexture("/berryh/moltencore/client/gfx/gui/guirepairer2.png", 0);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, 153);
		int l = tile.getScaledEnergyStored(42.0F);
		if (l > 0) {
			this.drawTexturedModalRect(x + 8, y + 8 + 42 - l, 176, 32 + 42 - l, 16, l);
		}

		int m = tile.getScaledProgress(124);
		if (m > 0) {
			System.out.println(m);
			this.drawTexturedModalRect(x + 26, y + 45, 26, 153, m, 16);
		}		
		
		
	
	}
	
	protected void drawToolTip(List tooltip, int par2, int par3)
    {
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);

        if (!tooltip.isEmpty())
        {
            int var5 = 0;
            Iterator var6 = tooltip.iterator();

            while (var6.hasNext())
            {
                String var7 = (String)var6.next();
                int var8 = this.fontRenderer.getStringWidth(var7);

                if (var8 > var5)
                {
                    var5 = var8;
                }
            }

            int var15 = par2 + 12;
            int var16 = par3 - 12;
            int var9 = 8;

            if (tooltip.size() > 1)
            {
                var9 += 2 + (tooltip.size() - 1) * 10;
            }

            int var10 = -267386864;
            this.drawGradientRect(var15 - 3, var16 - 4, var15 + var5 + 3, var16 - 3, var10, var10);
            this.drawGradientRect(var15 - 3, var16 + var9 + 3, var15 + var5 + 3, var16 + var9 + 4, var10, var10);
            this.drawGradientRect(var15 - 3, var16 - 3, var15 + var5 + 3, var16 + var9 + 3, var10, var10);
            this.drawGradientRect(var15 - 4, var16 - 3, var15 - 3, var16 + var9 + 3, var10, var10);
            this.drawGradientRect(var15 + var5 + 3, var16 - 3, var15 + var5 + 4, var16 + var9 + 3, var10, var10);
            int var11 = 1347420415;
            int var12 = (var11 & 16711422) >> 1 | var11 & -16777216;
            this.drawGradientRect(var15 - 3, var16 - 3 + 1, var15 - 3 + 1, var16 + var9 + 3 - 1, var11, var12);
            this.drawGradientRect(var15 + var5 + 2, var16 - 3 + 1, var15 + var5 + 3, var16 + var9 + 3 - 1, var11, var12);
            this.drawGradientRect(var15 - 3, var16 - 3, var15 + var5 + 3, var16 - 3 + 1, var11, var11);
            this.drawGradientRect(var15 - 3, var16 + var9 + 2, var15 + var5 + 3, var16 + var9 + 3, var12, var12);

            for (int var13 = 0; var13 < tooltip.size(); ++var13)
            {
                String var14 = (String)tooltip.get(var13);

                this.fontRenderer.drawStringWithShadow(var14, var15, var16, -1);

                if (var13 == 0)
                {
                    var16 += 2;
                }

                var16 += 10;
            }
        }
    }
	
	
}
