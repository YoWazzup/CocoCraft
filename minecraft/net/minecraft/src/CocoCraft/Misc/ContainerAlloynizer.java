package net.minecraft.src.CocoCraft.Misc;

import net.minecraft.src.CocoCraft.*;
import net.minecraft.src.CocoCraft.Misc.TileEntityAlloynizer;
import net.minecraft.src.*;
import java.util.Random;

public class ContainerAlloynizer extends Container
{
    private TileEntityAlloynizer furnace;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;

    public ContainerAlloynizer(InventoryPlayer inventoryplayer, TileEntityAlloynizer tile)
    {
        lastCookTime = 0;
        lastBurnTime = 0;
        lastItemBurnTime = 0;
        furnace = tile;
        //Fuel
        //input 6
        this.addSlot(new Slot(tile, 1, 44, 62));
        
        //Inputs
        //input 1
        this.addSlot(new Slot(tile, 0, 11, 17));
        //input 2
        this.addSlot(new Slot(tile, 3, 33, 17));
        //input 3
        this.addSlot(new Slot(tile, 4, 56, 17));
        //input 4
        this.addSlot(new Slot(tile, 5, 22, 36));
        //input 5
        this.addSlot(new Slot(tile, 6, 44, 36));
        
        this.addSlot(new SlotFurnace(inventoryplayer.player, tile, 2, 116, 35));
        for (int i = 0; i < 3; i++)
        {
            for (int k = 0; k < 9; k++)
            {
                addSlot(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }
        }

        for (int j = 0; j < 9; j++)
        {
            addSlot(new Slot(inventoryplayer, j, 8 + j * 18, 142));
        }
    }

    public void updateCraftingResults()
    {
        super.updateCraftingResults();
        for (int i = 0; i < crafters.size(); i++)
        {
            ICrafting icrafting = (ICrafting)crafters.get(i);
            if (lastCookTime != furnace.furnaceCookTime)
            {
                icrafting.updateCraftingInventoryInfo(this, 0, furnace.furnaceCookTime);
            }
            if (lastBurnTime != furnace.furnaceBurnTime)
            {
                icrafting.updateCraftingInventoryInfo(this, 1, furnace.furnaceBurnTime);
            }
            if (lastItemBurnTime != furnace.currentItemBurnTime)
            {
                icrafting.updateCraftingInventoryInfo(this, 2, furnace.currentItemBurnTime);
            }
        }

        lastCookTime = furnace.furnaceCookTime;
        lastBurnTime = furnace.furnaceBurnTime;
        lastItemBurnTime = furnace.currentItemBurnTime;
    }

    public void updateProgressBar(int i, int j)
    {
        if (i == 0)
        {
            furnace.furnaceCookTime = j;
        }
        if (i == 1)
        {
            furnace.furnaceBurnTime = j;
        }
        if (i == 2)
        {
            furnace.currentItemBurnTime = j;
        }
    }

    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return furnace.isUseableByPlayer(entityplayer);
    }

    public ItemStack transferStackInSlot(int i)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)inventorySlots.get(i);
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (i == 2)
            {
                if (!mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }
            }
            else if (i >= 3 && i < 30)
            {
                if (!mergeItemStack(itemstack1, 30, 39, false))
                {
                    return null;
                }
            }
            else if (i >= 30 && i < 39)
            {
                if (!mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }
            if (itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }
            if (itemstack1.stackSize != itemstack.stackSize)
            {
                slot.onPickupFromSlot(itemstack1);
            }
            else
            {
                return null;
            }
        }
        return itemstack;
    }
}
