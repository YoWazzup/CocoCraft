package net.minecraft.src.CocoCraft.Misc;

import net.minecraft.src.*;

import org.lwjgl.opengl.GL11;

public class GuiCrusher extends GuiContainer{

	private TileEntityCrusher crusherInventory;
	
	public GuiCrusher(InventoryPlayer inventoryplayer, TileEntityCrusher tile)
	{
		super(new ContainerCrusher(inventoryplayer, tile));
		crusherInventory = tile;
	}
	protected void drawGuiContainerForegroundLayer()
	{
		fontRenderer.drawString("Crusher", 60, 6, 0x404040);
        fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
  }
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		int k = this.mc.renderEngine.getTexture("/CC/Gui/Crusher.png");
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    mc.renderEngine.bindTexture(k);
	    int l = (this.width - this.xSize) / 2;
	    int i1 = (this.height - this.ySize) / 2;
	    this.drawTexturedModalRect(l, i1, 0, 0, this.xSize, this.ySize);
	    int j1;

	    if (this.crusherInventory.isBurning())
	    {
	        j1 = this.crusherInventory.getBurnTimeRemainingScaled(12);
	        this.drawTexturedModalRect(l + 56, i1 + 36 + 12 - j1, 176, 12 - j1, 14, j1 + 2);
	    }

	    j1 = this.crusherInventory.getCookProgressScaled(24);
	    this.drawTexturedModalRect(l + 79, i1 + 34, 176, 14, j1 + 1, 16);
	}
}
