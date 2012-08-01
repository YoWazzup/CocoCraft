package net.minecraft.src.CocoCraft.Items;

import java.util.ArrayList;

import net.minecraft.src.*;
import net.minecraft.src.forge.ITextureProvider;

public class CC_ItemShard extends Item implements ITextureProvider
{
	public CC_ItemShard(int i)
	{
		super(i);
	}
	public String getTextureFile()
	{
		return "/CC/Items.png";
	}
	public void addCreativeItems(ArrayList itemList)
	{
		itemList.add(new ItemStack(this));
	}
	public boolean hasEffect(ItemStack itemstack)
	{
		return true;
	}
}







