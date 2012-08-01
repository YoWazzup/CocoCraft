package net.minecraft.src.CocoCraft.Items; 
 
import java.util.ArrayList;

import net.minecraft.src.*;
import net.minecraft.src.forge.*; 
 
public class CC_Food extends ItemFood implements ITextureProvider 
{ 
 
    public CC_Food(int i, int j, float f, boolean flag)
    {
        super(i, j, flag);
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
