package net.minecraft.src.CocoCraft.Armor;

import java.util.ArrayList;
import net.minecraft.src.*;

import net.minecraft.src.forge.*;

public class CC_ItemExtremeAlloyArmor extends ItemArmor implements ITextureProvider//, IArmorTextureProvider
{

    public CC_ItemExtremeAlloyArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
    {
        super(i, enumarmormaterial, j, k);
    }
    
    public String getTextureFile()
    {
        return "/CC/Items.png";
    }
    /*public String getArmorTextureFile(ItemStack itemstack)
    {
        if(itemstack.itemID == mod_CocoCraft.ExtremeAlloyHelmet.shiftedIndex || itemstack.itemID == mod_CocoCraft.ExtremeAlloyPlate.shiftedIndex || itemstack.itemID == mod_CocoCraft.ExtremeAlloyBoots.shiftedIndex)
        {
                return "/CC/Armor/extremeAlloy_1.png";
        }
        if(itemstack.itemID == mod_CocoCraft.ExtremeAlloyLegs.shiftedIndex)
        {
                return "/CC/Armor/extremeAlloy_2.png";
        }
        return  "/CC/Armor/extremeAlloy_2.png";
    }*/
    
    public void addCreativeItems(ArrayList itemList)
    {
    	itemList.add(new ItemStack(this));
    }
}

