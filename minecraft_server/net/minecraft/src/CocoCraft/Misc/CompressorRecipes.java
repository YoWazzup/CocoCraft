package net.minecraft.src.CocoCraft.Misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.src.*;


public class CompressorRecipes
{
    private static final CompressorRecipes smeltingBase = new CompressorRecipes();

    /** The list of smelting results. */
    private Map compressingList = new HashMap();
    private Map metaCompressingList = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final CompressorRecipes smelting()
    {
        return smeltingBase;
    }

    public CompressorRecipes()
    {
        //this.addCrushing(Block.oreIron.blockID, new ItemStack(Item.ingotIron));
      //  this.addCompressing(mod_CocoCraft.CocoaMesh.shiftedIndex, new ItemStack(mod_CocoCraft.CocoaPowder, 1));
      //  this.addCompressing(mod_CocoCraft.MithrilOre.blockID, new ItemStack(mod_CocoCraft.MithrilDust, 2));
      //  this.addCompressing(mod_CocoCraft.SilverOre.blockID, new ItemStack(mod_CocoCraft.SilverDust, 2));
      //  this.addCompressing(Block.oreIron.blockID, new ItemStack(mod_CocoCraft.IronDust, 2));
      //  this.addCompressing(Block.oreGold.blockID, new ItemStack(mod_CocoCraft.GoldDust, 2));
      this.addCompressing(mod_CocoCraft.Alloy.shiftedIndex, new ItemStack(mod_CocoCraft.CompressedAlloy, 1));  
      this.addCompressing(mod_CocoCraft.UncExtremeAlloy.shiftedIndex, new ItemStack(mod_CocoCraft.ExtremeAlloy, 1));  
       
        
    }

    /**
     * Adds a smelting recipe.
     */
    public void addCompressing(int par1, ItemStack par2ItemStack)
    {
        this.compressingList.put(Integer.valueOf(par1), par2ItemStack);
    }

    /**
     * Returns the smelting result of an item.
     * Deprecated in favor of a metadata sensitive version
     */
    @Deprecated
    public ItemStack getCompressingResult(int par1)
    {
        return (ItemStack)this.compressingList.get(Integer.valueOf(par1));
    }

    public Map getSmeltingList()
    {
        return this.compressingList;
    }
    
    /**
     * Add a metadata-sensitive furnace recipe
     * @param itemID The Item ID
     * @param metadata The Item Metadata
     * @param itemstack The ItemStack for the result
     */
    public void addCrushing(int itemID, int metadata, ItemStack itemstack)
    {
        metaCompressingList.put(Arrays.asList(itemID, metadata), itemstack);
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
        ItemStack ret = (ItemStack)metaCompressingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)compressingList.get(Integer.valueOf(item.itemID));
    }
}