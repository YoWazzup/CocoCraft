package net.minecraft.src.CocoCraft.Misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.mod_CocoCraft;

public class AlloynizerRecipes {

	private ItemStack[] inputs = new ItemStack[5];
	private ItemStack output;
	
	private Map alloynzingList = new HashMap();
	

	
	public AlloynizerRecipes(ItemStack[] in, ItemStack out)
	{
		addAlloynizing(mod_CocoCraft.CocoIngot.shiftedIndex/*, mod_CocoCraft.SilverIngot.shiftedIndex, mod_CocoCraft.MithrilIngot.shiftedIndex, Item.diamond.shiftedIndex*/, new ItemStack(mod_CocoCraft.Alloy, 2));
	}
		
	/**
	public ItemStack getRecipe(ItemStack itemStack, ItemStack itemStack0, ItemStack itemStack1, ItemStack itemStack2, ItemStack itemStack3) {
        int i1, i2, i3, i4, i5;
        
        if(itemStack == null) i1 = 0; else i1 = itemStack.itemID;
        if(itemStack0 == null) i2 = 0; else i2 = itemStack0.itemID;
        if(itemStack1 == null) i3 = 0; else i3 = itemStack1.itemID;
        if(itemStack2 == null) i4 = 0; else i4 = itemStack2.itemID;
        if(itemStack3 == null) i5 = 0; else i5 = itemStack3.itemID;
       
        
        
        if(i1 == Block.blockDiamond.blockID && i2 == Block.blockGold.blockID) return new ItemStack(Block.blockDiamond, 2);
        if(i2 == Block.blockDiamond.blockID && i1 == Block.blockGold.blockID) return new ItemStack(Block.blockDiamond, 2);
        if(i1 == Item.diamond.shiftedIndex && i2 == mod_CocoCraft.CocoIngot.shiftedIndex && i3 == mod_CocoCraft.MithrilIngot.shiftedIndex && i4 == Item.coal.shiftedIndex && i5 == Item.coal.shiftedIndex) return new ItemStack(mod_CocoCraft.Alloy, 2);
        
        return null;
    }**/
	
	public void addAlloynizing(int i, ItemStack itemStack)
	{
		this.alloynzingList.put(Integer.valueOf(i), itemStack);
	}
}