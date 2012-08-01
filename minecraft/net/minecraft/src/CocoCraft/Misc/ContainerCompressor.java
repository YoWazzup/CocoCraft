package net.minecraft.src.CocoCraft.Misc;

import net.minecraft.src.*;

public class ContainerCompressor extends Container
{
    private TileEntityCompressor Compressor;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;

    public ContainerCompressor(InventoryPlayer par1InventoryPlayer, TileEntityCompressor par2TileEntityCompressor)
    {
        this.Compressor = par2TileEntityCompressor;
        this.addSlot(new Slot(par2TileEntityCompressor, 0, 56, 17));
        this.addSlot(new Slot(par2TileEntityCompressor, 1, 56, 53));
        this.addSlot(new SlotFurnace(par1InventoryPlayer.player, par2TileEntityCompressor, 2, 116, 35));
        int var3;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlot(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            this.addSlot(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
        }
    }
    public void updateCraftingResults()
    {
        super.updateCraftingResults();

        for (int var1 = 0; var1 < this.crafters.size(); ++var1)
        {
            ICrafting var2 = (ICrafting)this.crafters.get(var1);

            if (this.lastCookTime != this.Compressor.CompressorCookTime)
            {
                var2.updateCraftingInventoryInfo(this, 0, this.Compressor.CompressorCookTime);
            }

            if (this.lastBurnTime != this.Compressor.CompressorBurnTime)
            {
                var2.updateCraftingInventoryInfo(this, 1, this.Compressor.CompressorBurnTime);
            }

            if (this.lastItemBurnTime != this.Compressor.currentItemBurnTime)
            {
                var2.updateCraftingInventoryInfo(this, 2, this.Compressor.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.Compressor.CompressorCookTime;
        this.lastBurnTime = this.Compressor.CompressorBurnTime;
        this.lastItemBurnTime = this.Compressor.currentItemBurnTime;
    }

    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.Compressor.CompressorCookTime = par2;
        }

        if (par1 == 1)
        {
            this.Compressor.CompressorBurnTime = par2;
        }

        if (par1 == 2)
        {
            this.Compressor.currentItemBurnTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.Compressor.isUseableByPlayer(par1EntityPlayer);
    }
    public ItemStack transferStackInSlot(int par1)
    {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.inventorySlots.get(par1);

        if (var3 != null && var3.getHasStack())
        {
            ItemStack var4 = var3.getStack();
            var2 = var4.copy();

            if (par1 == 2)
            {
                if (!this.mergeItemStack(var4, 3, 39, true))
                {
                    return null;
                }

                var3.func_48433_a(var4, var2);
            }
            else if (par1 != 1 && par1 != 0)
            {
                if (CompressorRecipes.smelting().getCompressingResult(var4.getItem().shiftedIndex) != null)
                {
                    if (!this.mergeItemStack(var4, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityCompressor.func_52005_b(var4))
                {
                    if (!this.mergeItemStack(var4, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (par1 >= 3 && par1 < 30)
                {
                    if (!this.mergeItemStack(var4, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par1 >= 30 && par1 < 39 && !this.mergeItemStack(var4, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var4, 3, 39, false))
            {
                return null;
            }

            if (var4.stackSize == 0)
            {
                var3.putStack((ItemStack)null);
            }
            else
            {
                var3.onSlotChanged();
            }

            if (var4.stackSize == var2.stackSize)
            {
                return null;
            }

            var3.onPickupFromSlot(var4);
        }

        return var2;
    }
}