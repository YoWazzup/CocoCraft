package net.minecraft.src.CocoCraft.Items; 
 
import java.util.ArrayList;

import net.minecraft.src.*;
import net.minecraft.src.forge.*; 
 
public class CC_Pickaxe extends ItemPickaxe implements ITextureProvider 
{ 
 
  


    
    public CC_Pickaxe(int i, EnumToolMaterial enumtoolmaterial) 
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
