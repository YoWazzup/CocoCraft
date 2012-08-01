package net.minecraft.src.CocoCraft.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.*;
import net.minecraft.src.forge.ITextureProvider;

public class CC_ItemHammer extends Item implements ITextureProvider
{
	public CC_ItemHammer(int i)
	{
		super(i);
		setMaxStackSize(1);
		setMaxDamage(12);
	}
	
	public void addInformation(ItemStack itemstack, List list) {
		list.add("Not Thor's");
	}
	public String getTextureFile()
	{
		return "/CC/Items.png";
	}
	public void addCreativeItems(ArrayList itemList)
	{
		itemList.add(new ItemStack(this));
	}
}







