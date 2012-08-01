package net.minecraft.src.CocoCraft.Blocks;

import java.util.ArrayList;

import net.minecraft.src.*;
import net.minecraft.src.forge.ITextureProvider;


public class CC_SilverBlock extends Block implements ITextureProvider
{
	public CC_SilverBlock(int i, int j)
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