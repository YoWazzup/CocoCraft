package net.minecraft.src.CocoCraft.Armor;

import java.util.ArrayList;
import net.minecraft.src.*;

import net.minecraft.src.forge.*;

public class CC_ItemAlloyArmor extends ItemArmor implements ITextureProvider//, IArmorTextureProvider
{

    public CC_ItemAlloyArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
    {
        super(i, enumarmormaterial, j, k);
    }
    
    public String getTextureFile()
    {
        return "/CC/Items.png";
    }
    /*public String getArmorTextureFile(ItemStack itemstack)
    {
        if(itemstack.itemID == mod_CocoCraft.AlloyHelmet.shiftedIndex || itemstack.itemID == mod_CocoCraft.AlloyPlate.shiftedIndex || itemstack.itemID == mod_CocoCraft.AlloyBoots.shiftedIndex)
        {
                return "/CC/Armor/alloy_1.png";
        }
        if(itemstack.itemID == mod_CocoCraft.AlloyLegs.shiftedIndex)
        {
                return "/CC/Armor/alloy_2.png";
        }
        return  "/CC/Armor/alloy_2.png";
    }*/
    
    public void addCreativeItems(ArrayList itemList)
    {
    	itemList.add(new ItemStack(this));
    }
}

