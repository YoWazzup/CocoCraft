package net.minecraft.src.CocoCraft.Blocks;

import java.util.ArrayList;

import net.minecraft.src.*;
import net.minecraft.src.forge.ITextureProvider;


public class CC_MithrilOre extends Block implements ITextureProvider
{
	public CC_MithrilOre(int i, int j)
	{
		super(i,j,Material.iron);
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