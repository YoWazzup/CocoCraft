package net.minecraft.src.CocoCraft.Items; 
 
import java.util.ArrayList;

import net.minecraft.src.forge.*; 
import net.minecraft.src.*; 
 
public class CC_ObsidianTool extends ItemObsidianTool  implements ITextureProvider 
{ 
 
    public CC_ObsidianTool(int i, EnumToolMaterial enumtoolmaterial) 
    { 
        super(i, enumtoolmaterial); 
    } 
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block.blockID == Block.stone.blockID;
    }
    //FIX SO IT CAN MINE SANDSTONE!
    public String getTextureFile() 
    { 
        return "/CC/Items.png"; 
    } 
    public void addCreativeItems(ArrayList itemList)
    {
    	itemList.add(new ItemStack(this));
    }
}
