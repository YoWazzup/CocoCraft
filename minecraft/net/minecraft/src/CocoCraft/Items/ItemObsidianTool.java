package net.minecraft.src.CocoCraft.Items;

import net.minecraft.src.*;
import net.minecraft.src.forge.*;

public class ItemObsidianTool extends ItemTool implements ITextureProvider
{
private static Block blocksEffectiveAgainst[];

public String getTextureFile()
{
return "/CC/Items.png";
}

public ItemObsidianTool(int par1, EnumToolMaterial par2EnumToolMaterial)
{
super(par1, 1, par2EnumToolMaterial, blocksEffectiveAgainst);

}

public boolean canHarvestBlock(Block par1Block)
{
if (par1Block == Block.obsidian)
{
return toolMaterial.getHarvestLevel() == 3;
}

if (par1Block == Block.blockDiamond || par1Block == Block.oreDiamond)
{
return toolMaterial.getHarvestLevel() >= 2;
}

if (par1Block == Block.blockGold || par1Block == Block.oreGold)
{
return toolMaterial.getHarvestLevel() >= 2;
}

if (par1Block == Block.blockSteel || par1Block == Block.oreIron)
{
return toolMaterial.getHarvestLevel() >= 1;
}

if (par1Block == Block.blockLapis || par1Block == Block.oreLapis)
{
return toolMaterial.getHarvestLevel() >= 1;
}

if (par1Block == Block.oreRedstone || par1Block == Block.oreRedstoneGlowing)
{
return toolMaterial.getHarvestLevel() >= 2;
}
if(par1Block == Block.stone || par1Block == Block.cobblestone || par1Block == Block.cobblestoneMossy)
{
	return toolMaterial.getHarvestLevel() >= 2;
}

if (par1Block.blockMaterial == Material.rock)
{
return true;
}
if (par1Block.blockMaterial == Material.iron)
{
return true;
}
if (par1Block == Block.snow)
{
return true;
}

return par1Block == Block.blockSnow;
}


public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
{
if (par2Block != null && (par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.rock))
{
return efficiencyOnProperMaterial;
}
if (par2Block != null && par2Block.blockMaterial == Material.wood)
{
return efficiencyOnProperMaterial;
}
else
{
return super.getStrVsBlock(par1ItemStack, par2Block);
}
}

static
{
blocksEffectiveAgainst = (new Block[]
{
Block.cobblestone, Block.stairDouble, Block.stairSingle, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold,
Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail,
Block.railDetector, Block.railPowered, Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium,
Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stairDouble, Block.stairSingle, Block.pumpkin, Block.pumpkinLantern
});
}
}