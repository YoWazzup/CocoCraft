package net.minecraft.src.CocoCraft.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.*;
import net.minecraft.src.forge.ITextureProvider;

public class CC_BookOfTime extends Item implements ITextureProvider{

	public int switcher = 0;
	public String changed = "Changed";
	
	
	
	public CC_BookOfTime(int i)
	{
		super(i);
		maxStackSize = 1;
		setMaxDamage(20);
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer){
		if(switcher == 0){
			ModLoader.getMinecraftInstance().theWorld.setWorldTime(0);
			switcher = 1;
			changed= "Day";
			itemstack.damageItem(1, entityplayer);
		}else{
			ModLoader.getMinecraftInstance().theWorld.setWorldTime(14000);
			switcher = 0;
			changed = "Night";
			itemstack.damageItem(1, entityplayer);
		
		
		}
		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("The Time has been changed to " +changed+"!");
		
		return itemstack;
		
	}
	public void addInformation(ItemStack itemstack, List list) {
		list.add("Changes The Time");
		
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
