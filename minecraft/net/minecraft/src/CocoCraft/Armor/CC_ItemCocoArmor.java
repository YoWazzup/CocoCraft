package net.minecraft.src.CocoCraft.Armor;

import java.util.ArrayList;
import net.minecraft.src.*;
import net.minecraft.src.forge.*;

public class CC_ItemCocoArmor extends ItemArmor implements ITextureProvider, IArmorTextureProvider
{

    public CC_ItemCocoArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
    {
        super(i, enumarmormaterial, j, k);
    }
    
    public String getTextureFile()
    {
        return "/CC/Items.png";
    }
    public String getArmorTextureFile(ItemStack itemstack)
    {
        if(itemstack.itemID == mod_CocoCraft.CocoHelmet.shiftedIndex || itemstack.itemID == mod_CocoCraft.CocoPlate.shiftedIndex || itemstack.itemID == mod_CocoCraft.CocoBoots.shiftedIndex)
        {
                return "/CC/Armor/coco_1.png";
        }
        if(itemstack.itemID == mod_CocoCraft.CocoLegs.shiftedIndex)
        {
                return "/CC/Armor/coco_2.png";
        }
        return  "/CC/Armor/coco_2.png";
    }
    
    public void addCreativeItems(ArrayList itemList)
    {
    	itemList.add(new ItemStack(this));
    }
}

