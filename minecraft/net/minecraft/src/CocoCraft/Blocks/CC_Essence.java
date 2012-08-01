package net.minecraft.src.CocoCraft.Blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.*;
import net.minecraft.src.forge.ITextureProvider;


public class CC_Essence extends Block implements ITextureProvider
{

	public CC_Essence(int i, int j)
	{
		super(i,j,Material.rock);
	}
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return mod_CocoCraft.WindEssence.shiftedIndex;
    }
	public String getTextureFile()
	{
		return "/CC/Blocks.png";
	}
	public void addCreativeItems(ArrayList itemList)
	{
		itemList.add(new ItemStack(this));
	}
	
}