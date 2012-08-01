package net.minecraft.src.CocoCraft.Items; 
 
import java.util.ArrayList;

import net.minecraft.src.forge.*; 
import net.minecraft.src.*; 
 
public class CC_Axe extends ItemAxe implements ITextureProvider 
{ 
 
    public CC_Axe(int i, EnumToolMaterial enumtoolmaterial) 
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
