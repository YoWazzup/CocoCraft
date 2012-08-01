package net.minecraft.src.CocoCraft.Armor;

import java.util.ArrayList;
import net.minecraft.src.*;
import net.minecraft.src.forge.*;

public class CC_ItemDragonArmor extends ItemArmor implements ITextureProvider, IArmorTextureProvider
{

    public CC_ItemDragonArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
    {
        super(i, enumarmormaterial, j, k);
    }
    
    public String getTextureFile()
    {
        return "/CC/Items.png";
    }
    public String getArmorTextureFile(ItemStack itemstack)
    {
        if(itemstack.itemID == mod_CocoCraft.CocoPlate.shiftedIndex)
        {
                return "/CC/Armor/dragon_1.png";
        }
        if(null != null)
        {
                return null;
        }
        return  "/CC/Armor/dragon_1.png";
    }
    
    public void addCreativeItems(ArrayList itemList)
    {
    	itemList.add(new ItemStack(this));
    }
}

