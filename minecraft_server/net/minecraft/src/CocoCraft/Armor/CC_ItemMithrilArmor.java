package net.minecraft.src.CocoCraft.Armor;

import java.util.ArrayList;
import net.minecraft.src.*;
import net.minecraft.src.forge.*;

public class CC_ItemMithrilArmor extends ItemArmor implements ITextureProvider//, IArmorTextureProvider
{

    public CC_ItemMithrilArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
    {
        super(i, enumarmormaterial, j, k);
    }
    
    public String getTextureFile()
    {
        return "/CC/Items.png";
    }
    /*public String getArmorTextureFile(ItemStack itemstack)
    {
        if(itemstack.itemID == mod_CocoCraft.MithrilHelmet.shiftedIndex || itemstack.itemID == mod_CocoCraft.MithrilPlate.shiftedIndex || itemstack.itemID == mod_CocoCraft.MithrilBoots.shiftedIndex)
        {
                return "/CC/Armor/mithril_1.png";
        }
        if(itemstack.itemID == mod_CocoCraft.MithrilLegs.shiftedIndex)
        {
                return "/CC/Armor/mithril_2.png";
        }
        return  "/CC/Armor/coco_2.png";
    }*/
    
    public void addCreativeItems(ArrayList itemList)
    {
    	itemList.add(new ItemStack(this));
    }
}

