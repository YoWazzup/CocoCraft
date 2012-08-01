package net.minecraft.src.CocoCraft.Items;

import net.minecraft.src.*;

public class ItemObsidianTool extends ItemTool
{
    /** an array of the blocks this pickaxe is effective against */
    private static Block[] blocksEffectiveAgainst = new Block[] {
    					Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium,
    					Block.cobblestone, Block.stairDouble, Block.stairSingle, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, 
    					Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, 
    					Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered,
    					Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stairDouble, Block.stairSingle, Block.pumpkin, Block.pumpkinLantern
    };
    
    
    protected ItemObsidianTool(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, 2, par2EnumToolMaterial, blocksEffectiveAgainst);
    }
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block.blockID == Block.stone.blockID;
    }


    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        return par2Block != null && (par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.rock) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
    }
}
