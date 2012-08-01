package net.minecraft.src.CocoCraft.Armor;

import java.util.ArrayList;
import net.minecraft.src.*;
import net.minecraft.src.forge.*;

public class CC_ItemSilverArmor extends ItemArmor implements ITextureProvider, IArmorTextureProvider
{

    public CC_ItemSilverArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
    {
        super(i, enumarmormaterial, j, k);
    }
    
    public String getTextureFile()
    {
        return "/CC/Items.png";
    }
    public String getArmorTextureFile(ItemStack itemstack)
    {
        if(itemstack.itemID == mod_CocoCraft.SilverHelmet.shiftedIndex || itemstack.itemID == mod_CocoCraft.SilverPlate.shiftedIndex || itemstack.itemID == mod_CocoCraft.SilverBoots.shiftedIndex)
        {
                return "/CC/Armor/silver_1.png";
        }
        if(itemstack.itemID == mod_CocoCraft.SilverLegs.shiftedIndex)
        {
                return "/CC/Armor/silver_2.png";
        }
        return  "/CC/Armor/silver_2.png";
    }
    
    public void addCreativeItems(ArrayList itemList)
    {
    	itemList.add(new ItemStack(this));
    }
}

