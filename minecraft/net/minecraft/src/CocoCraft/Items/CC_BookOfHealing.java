package net.minecraft.src.CocoCraft.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.*;
import net.minecraft.src.forge.ITextureProvider;

public class CC_BookOfHealing extends Item implements ITextureProvider{

	public int switcher = 0;
	
	
	
	
	public CC_BookOfHealing(int i)
	{
		super(i);
		maxStackSize = 1;
		setMaxDamage(20);
	}
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer){
		if(switcher == 0){
			ModLoader.getMinecraftInstance().thePlayer.heal(4);
			switcher = 1;
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Healed!");
			itemstack.damageItem(1, entityplayer);
		}else{
			ModLoader.getMinecraftInstance().thePlayer.heal(4);
			switcher = 0;
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Healed!");
			itemstack.damageItem(1, entityplayer);
		}
		
		return itemstack;
		
	}
	public void addInformation(ItemStack itemstack, List list) {
		list.add("Heals You!");
		
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
