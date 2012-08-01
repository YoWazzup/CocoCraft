package net.minecraft.src.CocoCraft.Items; 
 
import java.util.ArrayList;

import net.minecraft.src.*;
import net.minecraft.src.forge.*; 
 
public class CC_Sword extends ItemSword implements ITextureProvider 
{ 
 
  


    
    public CC_Sword(int i, EnumToolMaterial enumtoolmaterial) 
    { 
        super(i, enumtoolmaterial); 
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
