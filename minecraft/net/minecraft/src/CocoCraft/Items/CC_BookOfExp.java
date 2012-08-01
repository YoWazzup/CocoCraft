package net.minecraft.src.CocoCraft.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.*;
import net.minecraft.src.forge.ITextureProvider;

public class CC_BookOfExp extends Item implements ITextureProvider{

	public int switcher = 0;
	
	
	
	
	public CC_BookOfExp(int i)
	{
		super(i);
		maxStackSize = 1;
		setMaxDamage(6);
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer){
		if(switcher == 0){
		ModLoader.getMinecraftInstance().thePlayer.addExperience(40);
		switcher = 1;
		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("XP Added!");
		itemstack.damageItem(1, entityplayer);
			}else{
				ModLoader.getMinecraftInstance().thePlayer.addExperience(40);
			switcher = 0;
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage("XP Added!");
			itemstack.damageItem(1, entityplayer);
	}
	
	return itemstack;
	
	}
	public void addInformation(ItemStack itemstack, List list) {
		list.add("Adds 40 Exp!");
		
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
