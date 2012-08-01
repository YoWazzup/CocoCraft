package net.minecraft.src.CocoCraft.Misc;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.src.forge.ForgeHooks;
import net.minecraft.src.forge.ISidedInventory;
import net.minecraft.src.*;

public class TileEntityCrusher extends TileEntity implements IInventory, ISidedInventory{
	
	private ItemStack[] crusherItemStacks = new ItemStack[3];
	public int crusherBurnTime = 0;
	public int currentItemBurnTime = 0;
	public int crusherCookTime = 0;
	
	public int getSizeInventory()
    {
        return this.crusherItemStacks.length;
    }
	public ItemStack getStackInSlot(int par1)
    {
        return this.crusherItemStacks[par1];
    }
	public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.crusherItemStacks[par1] != null)
        {
            ItemStack var3;

            if (this.crusherItemStacks[par1].stackSize <= par2)
            {
                var3 = this.crusherItemStacks[par1];
                this.crusherItemStacks[par1] = null;
                return var3;
            }
            else
            {
                var3 = this.crusherItemStacks[par1].splitStack(par2);

                if (this.crusherItemStacks[par1].stackSize == 0)
                {
                    this.crusherItemStacks[par1] = null;
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
    }
	public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.crusherItemStacks[par1] != null)
        {
            ItemStack var2 = this.crusherItemStacks[par1];
            this.crusherItemStacks[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.crusherItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }
	public String getInvName()
    {
        return "Crusher";
    }
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
        this.crusherItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.crusherItemStacks.length)
            {
                this.crusherItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.crusherBurnTime = par1NBTTagCompound.getShort("BurnTime");
        this.crusherCookTime = par1NBTTagCompound.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.crusherItemStacks[1]);
    }
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short)this.crusherBurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)this.crusherCookTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.crusherItemStacks.length; ++var3)
        {
            if (this.crusherItemStacks[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.crusherItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        par1NBTTagCompound.setTag("Items", var2);
    }
	public int getInventoryStackLimit()
    {
        return 64;
    }
	public int getCookProgressScaled(int par1)
    {
        return this.crusherCookTime * par1 / 200;
    }
	public int getBurnTimeRemainingScaled(int par1)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 200;
        }

        return this.crusherBurnTime * par1 / this.currentItemBurnTime;
    }
	public boolean isBurning()
    {
        return this.crusherBurnTime > 0;
    }
	public void updateEntity()
    {
        boolean var1 = this.crusherBurnTime > 0;
        boolean var2 = false;

        if (this.crusherBurnTime > 0)
        {
            --this.crusherBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.crusherBurnTime == 0 && this.canSmelt())
            {
                this.currentItemBurnTime = this.crusherBurnTime = getItemBurnTime(this.crusherItemStacks[1]);

                if (this.crusherBurnTime > 0)
                {
                    var2 = true;

                    if (this.crusherItemStacks[1] != null)
                    {
                        if (this.crusherItemStacks[1].getItem().func_46003_i())
                        {
                            this.crusherItemStacks[1] = new ItemStack(this.crusherItemStacks[1].getItem().setFull3D());
                        }
                        else
                        {
                            --this.crusherItemStacks[1].stackSize;
                        }

                        if (this.crusherItemStacks[1].stackSize == 0)
                        {
                            this.crusherItemStacks[1] = null;
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt())
            {
                ++this.crusherCookTime;

                if (this.crusherCookTime == 200)
                {
                    this.crusherCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            }
            else
            {
                this.crusherCookTime = 0;
            }

            if (var1 != this.crusherBurnTime > 0)
            {
                var2 = true;
                
            }
        }

        if (var2)
        {
            this.onInventoryChanged();
        }
    }
	private boolean canSmelt()
    {
        if (this.crusherItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = CrusherRecipes.smelting().getSmeltingResult(this.crusherItemStacks[0]);
            if (var1 == null) return false;
            if (this.crusherItemStacks[2] == null) return true;
            if (!this.crusherItemStacks[2].isItemEqual(var1)) return false;
            int result = crusherItemStacks[2].stackSize + var1.stackSize;
            return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
        }
    }
	public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack var1 = CrusherRecipes.smelting().getSmeltingResult(this.crusherItemStacks[0]);

            if (this.crusherItemStacks[2] == null)
            {
                this.crusherItemStacks[2] = var1.copy();
            }
            else if (this.crusherItemStacks[2].isItemEqual(var1))
            {
                this.crusherItemStacks[2].stackSize += var1.stackSize;
            }

            if (this.crusherItemStacks[0].getItem().func_46003_i())
            {
                this.crusherItemStacks[0] = new ItemStack(this.crusherItemStacks[0].getItem().setFull3D());
            }
            else
            {
                --this.crusherItemStacks[0].stackSize;
            }

            if (this.crusherItemStacks[0].stackSize <= 0)
            {
                this.crusherItemStacks[0] = null;
            }
        }
    }
	public static int getItemBurnTime(ItemStack par1ItemStack)
    {
        if (par1ItemStack == null)
        {
            return 0;
        }
        else
        {
        	int var1 = par1ItemStack.getItem().shiftedIndex;
            if (var1 < 256 && Block.blocksList[var1].blockMaterial == Material.air) return 0;
            if (var1 == mod_CocoCraft.MagicDust.shiftedIndex) return 1800;
            int ret = ForgeHooks.getItemBurnTime(par1ItemStack);
            if (ret > 0) 
            {
                return ret;
            }
            return FMLCommonHandler.instance().fuelLookup(var1, par1ItemStack.getItemDamage());}
    }

    public static boolean func_52005_b(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }
	@Override
	public int getStartInventorySide(int side) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getSizeInventorySide(int side) {
		if (side == 0) return 1;
        if (side == 1) return 0;
        return 2;
	}
	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void openChest() {}
	@Override
	public void closeChest() {}
	
	
	
	
	
	
	
	
	
}
