package net.minecraft.src.CocoCraft.Items; 
 
import java.util.ArrayList;

import net.minecraft.src.*;
import net.minecraft.src.forge.*; 
 
public class CC_ChoclateMilk extends ItemFood implements ITextureProvider 
{ 
 
    public CC_ChoclateMilk(int i, int j, float f, boolean flag)
    {
        super(i, j, flag);
        maxStackSize = 1;
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
