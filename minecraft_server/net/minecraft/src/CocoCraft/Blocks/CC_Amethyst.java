package net.minecraft.src.CocoCraft.Blocks;


import java.util.ArrayList;
import java.util.Random;
import net.minecraft.src.*;
import net.minecraft.src.forge.ITextureProvider;

public class CC_Amethyst extends Block implements ITextureProvider
{
	public CC_Amethyst(int i, int j)
	{
		super(i,j, Material.iron);
	}
	public String getTextureFile()
	{
		return "/CC/Blocks.png";
	}
	public void addCreativeItems(ArrayList itemList)
	{
		itemList.add(new ItemStack(this));
	}
	public int idDropped(int par1, Random par2Random, int par3)
	{
	    return mod_CocoCraft.AmethystGem.shiftedIndex;
	}	
}




