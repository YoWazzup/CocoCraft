package net.minecraft.src.CocoCraft.Armor;

import java.util.ArrayList;

import net.minecraft.src.forge.*;
import net.minecraft.src.*;

public class CC_ItemAmethystArmor extends ItemArmor implements ITextureProvider//, IArmorTextureProvider
{

    public CC_ItemAmethystArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
    {
        super(i, enumarmormaterial, j, k);
    }
    
    public String getTextureFile()
    {
        return "/CC/Items.png";
    }
    /*public String getArmorTextureFile(ItemStack itemstack)
    {
        if(itemstack.itemID == mod_CocoCraft.AmethystHelmet.shiftedIndex || itemstack.itemID == mod_CocoCraft.AmethystPlate.shiftedIndex || itemstack.itemID == mod_CocoCraft.AmethystBoots.shiftedIndex)
        {
                return "/CC/Armor/amethyst_1.png";
        }
        if(itemstack.itemID == mod_CocoCraft.AmethystLegs.shiftedIndex)
        {
                return "/CC/Armor/amethyst_2.png";
        }
        return  "/CC/Armor/amethyst_2.png";
    }*/
    
    public void addCreativeItems(ArrayList itemList)
    {
    	itemList.add(new ItemStack(this));
    }
}

