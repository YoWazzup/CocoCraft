package net.minecraft.src.CocoCraft.Misc;

import java.util.List;
import net.minecraft.src.*;
import net.minecraft.src.forge.ISidedInventory;

public class TileEntityDuplicator extends TileEntity
    implements ISidedInventory
{
    private ItemStack furnaceItemStacks[];
    public int furnaceBurnTime;
    public int currentItemBurnTime;
    public int furnaceCookTime;

    public TileEntityDuplicator()
    {
        furnaceItemStacks = new ItemStack[4];
        furnaceBurnTime = 0;
        currentItemBurnTime = 0;
        furnaceCookTime = 0;
    }

    public int getSizeInventory()
    {
        return furnaceItemStacks.length;
    }

    public ItemStack getStackInSlot(int i)
    {
        return furnaceItemStacks[i];
    }

    public ItemStack decrStackSize(int i, int j)
    {
        if (furnaceItemStacks[i] != null)
        {
            if (furnaceItemStacks[i].stackSize <= j)
            {
                ItemStack itemstack = furnaceItemStacks[i];
                furnaceItemStacks[i] = null;
                return itemstack;
            }
            ItemStack itemstack1 = furnaceItemStacks[i].splitStack(j);
            if (furnaceItemStacks[i].stackSize == 0)
            {
                furnaceItemStacks[i] = null;
            }
            return itemstack1;
        }
        else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        furnaceItemStacks[i] = itemstack;
        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }
    }

    public String getInvName()
    {
        return "Duplicator";
    }

    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
        furnaceItemStacks = new ItemStack[getSizeInventory()];
        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            byte byte0 = nbttagcompound1.getByte("Slot");
            if (byte0 >= 0 && byte0 < furnaceItemStacks.length)
            {
                furnaceItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        furnaceBurnTime = nbttagcompound.getShort("BurnTime");
        furnaceCookTime = nbttagcompound.getShort("CookTime");
        currentItemBurnTime = getItemBurnTime(furnaceItemStacks[1]);
    }

    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setShort("BurnTime", (short)furnaceBurnTime);
        nbttagcompound.setShort("CookTime", (short)furnaceCookTime);
        NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < furnaceItemStacks.length; i++)
        {
            if (furnaceItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                furnaceItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        nbttagcompound.setTag("Items", nbttaglist);
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public int getCookProgressScaled(int i)
    {
        return (furnaceCookTime * i) / 200;
    }

    public int getBurnTimeRemainingScaled(int i)
    {
        if (currentItemBurnTime == 0)
        {
            currentItemBurnTime = 200;
        }
        return (furnaceBurnTime * i) / currentItemBurnTime;
    }

    public boolean isBurning()
    {
        return furnaceBurnTime > 0;
    }

    public void updateEntity()
    {
        boolean flag = furnaceBurnTime > 0;
        boolean flag1 = false;
        if (furnaceBurnTime > 0)
        {
            furnaceBurnTime-= 2;
        }
        if (!worldObj.isRemote)
        {
            if (furnaceBurnTime == 0 && canSmelt())
            {
                currentItemBurnTime = furnaceBurnTime = getItemBurnTime(furnaceItemStacks[1]);
                if (furnaceBurnTime > 0)
                {
                    flag1 = true;
                    if (furnaceItemStacks[1] != null)
                    {
                        if (furnaceItemStacks[1].getItem().func_46056_k())
                        {
                            furnaceItemStacks[1] = new ItemStack(furnaceItemStacks[1].getItem().setFull3D());
                        }
                        else
                        {
                            furnaceItemStacks[1].stackSize--;
                        }
                        if (furnaceItemStacks[1].stackSize == 0)
                        {
                            furnaceItemStacks[1] = null;
                        }
                    }
                }
            }
            if (isBurning() && canSmelt())
            {
                furnaceCookTime+= 2;
                if (furnaceCookTime == 200)
                {
                    furnaceCookTime = 0;
                    smeltItem();
                    flag1 = true;
                }
            }
            else
            {
                furnaceCookTime = 0;
            }
        }
        if (flag1)
        {
            onInventoryChanged();
        }
    }

    private boolean canSmelt()
    {
        ItemStack result = getRecipe(furnaceItemStacks[0], furnaceItemStacks[3]);
        if(result == null) return false;
        if(furnaceItemStacks[2] == null) return true;
        if(furnaceItemStacks[2] != null && furnaceItemStacks[2].itemID == result.itemID&& furnaceItemStacks[2].stackSize < (furnaceItemStacks[2].getMaxStackSize() - (result.stackSize-1))) return true;
        return false;
    }

    public void smeltItem()
    {
        if (!canSmelt())
        {
            return;
        }
        ItemStack itemstack = getRecipe(furnaceItemStacks[0], furnaceItemStacks[3]);
        if (furnaceItemStacks[2] == null)
        {
            furnaceItemStacks[2] = itemstack.copy();
        }
        else if (furnaceItemStacks[2].itemID == itemstack.itemID)
        {
            furnaceItemStacks[2].stackSize+= itemstack.stackSize;
        }
        if(furnaceItemStacks[0] != null){
                furnaceItemStacks[0].stackSize--;
            if (furnaceItemStacks[0].stackSize <= 0)
            {
                furnaceItemStacks[0] = null;
            }
        }
        if(furnaceItemStacks[3] != null){
                furnaceItemStacks[3].stackSize--;
            if (furnaceItemStacks[3].stackSize <= 0)
            {
                furnaceItemStacks[3] = null;
            }
        }
    }

    private int getItemBurnTime(ItemStack itemstack)
    {
        if (itemstack == null)
        {
            return 0;
        }
        int i = itemstack.getItem().shiftedIndex;
        if (i == Block.blockSteel.blockID)
        {
            return 200;
        }
        else
        {
            return 0;
        }
    }

    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        }
        return entityplayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
    }

    public void openChest()
    {
    }

    public void closeChest()
    {
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int var1) {
        return null;
    }

    private ItemStack getRecipe(ItemStack itemStack, ItemStack itemStack0) {
        int i1;
        int i2;
        if(itemStack == null) i1 = 0; else i1 = itemStack.itemID;
        if(itemStack0 == null) i2 = 0; else i2 = itemStack0.itemID;

        
        if(i1 == Block.blockDiamond.blockID && i2 == Block.blockGold.blockID) return new ItemStack(Block.blockDiamond, 2);
        if(i2 == Block.blockDiamond.blockID && i1 == Block.blockGold.blockID) return new ItemStack(Block.blockDiamond, 2);
        
        
        return null;
    }

	@Override
	public int getStartInventorySide(int side) {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getSizeInventorySide(int side) {
		// TODO Auto-generated method stub
		return 1;
	}

    
}
