package net.minecraft.src.CocoCraft.Misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.src.*;


public class CrusherRecipes
{
    private static final CrusherRecipes smeltingBase = new CrusherRecipes();

    /** The list of smelting results. */
    private Map crushingList = new HashMap();
    private Map metaCrushingList = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final CrusherRecipes smelting()
    {
        return smeltingBase;
    }

    public CrusherRecipes()
    {
        //this.addCrushing(Block.oreIron.blockID, new ItemStack(Item.ingotIron));
        this.addCrushing(mod_CocoCraft.CocoaMesh.shiftedIndex, new ItemStack(mod_CocoCraft.CocoaPowder, 1));
        this.addCrushing(mod_CocoCraft.MithrilOre.blockID, new ItemStack(mod_CocoCraft.MithrilDust, 2));
        this.addCrushing(mod_CocoCraft.SilverOre.blockID, new ItemStack(mod_CocoCraft.SilverDust, 2));
        this.addCrushing(Block.oreIron.blockID, new ItemStack(mod_CocoCraft.IronDust, 2));
        this.addCrushing(Block.oreGold.blockID, new ItemStack(mod_CocoCraft.GoldDust, 2));
        this.addCrushing(Item.coal.shiftedIndex, new ItemStack(mod_CocoCraft.CoalDust, 1));
        this.addCrushing(Block.obsidian.blockID, new ItemStack(mod_CocoCraft.ObsidianDust, 1));
        
    }

    /**
     * Adds a smelting recipe.
     */
    public void addCrushing(int par1, ItemStack par2ItemStack)
    {
        this.crushingList.put(Integer.valueOf(par1), par2ItemStack);
    }

    /**
     * Returns the smelting result of an item.
     * Deprecated in favor of a metadata sensitive version
     */
    @Deprecated
    public ItemStack getCrushingResult(int par1)
    {
        return (ItemStack)this.crushingList.get(Integer.valueOf(par1));
    }

    public Map getSmeltingList()
    {
        return this.crushingList;
    }
    
    /**
     * Add a metadata-sensitive furnace recipe
     * @param itemID The Item ID
     * @param metadata The Item Metadata
     * @param itemstack The ItemStack for the result
     */
    public void addCrushing(int itemID, int metadata, ItemStack itemstack)
    {
        metaCrushingList.put(Arrays.asList(itemID, metadata), itemstack);
    }
    
    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
    public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaCrushingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)crushingList.get(Integer.valueOf(item.itemID));
    }
}