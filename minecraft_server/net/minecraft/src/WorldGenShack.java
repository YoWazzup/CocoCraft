
/*
===== MADE BY HAXMAN2'S .SCHEMATIC TO JAVA CONVERTING TOOLv0.2 ====
There is a tutorial on the forum thread on how to use this tool.
NOTE: The Block limit is 19,500 at the moment, meaning if your file is bigger then 20,000 lines, it MIGHT crash...
*/
package net.minecraft.src;
import java.util.Random;
public class WorldGenShack extends WorldGenerator
{
    public WorldGenShack()
    {
    }
    public boolean generate(World world, Random rand, int i, int j, int k)
    {
int bID = 2;  /*2 is the block id for grass, so the structure going to spawn on grass*/
        if(world.getBlockId(i, j, k) != bID || world.getBlockId(i, j + 1, k) != 0 || world.getBlockId(i + 7, j, k) != bID || world.getBlockId(i + 7, j, k + 7) != bID || world.getBlockId(i, j, k + 7) != bID || world.getBlockId(i + 7, j + 1, k) != 0 || world.getBlockId(i + 7, j + 1, k + 7) != 0 || world.getBlockId(i, j + 1, k + 7) != 0)
        {
            return false;
        }
            world.setBlock(i + 0, j + 0, k + 6, 5);
            world.setBlock(i + 0, j + 0, k + 5, 5);
            world.setBlock(i + 0, j + 0, k + 4, 5);
            world.setBlock(i + 0, j + 0, k + 3, 5);
            world.setBlock(i + 0, j + 0, k + 2, 5);
            world.setBlock(i + 0, j + 0, k + 1, 5);
            world.setBlock(i + 0, j + 0, k + 0, 5);
            world.setBlock(i + 1, j + 0, k + 6, 5);
            world.setBlock(i + 1, j + 0, k + 5, 5);
            world.setBlock(i + 1, j + 0, k + 4, 5);
            world.setBlock(i + 1, j + 0, k + 3, 5);
            world.setBlock(i + 1, j + 0, k + 2, 5);
            world.setBlock(i + 1, j + 0, k + 1, 5);
            world.setBlock(i + 1, j + 0, k + 0, 5);
            world.setBlock(i + 2, j + 0, k + 6, 5);
            world.setBlock(i + 2, j + 0, k + 5, 5);
            world.setBlock(i + 2, j + 0, k + 4, 5);
            world.setBlock(i + 2, j + 0, k + 3, 5);
            world.setBlock(i + 2, j + 0, k + 2, 5);
            world.setBlock(i + 2, j + 0, k + 1, 5);
            world.setBlock(i + 2, j + 0, k + 0, 5);
            world.setBlock(i + 3, j + 0, k + 6, 5);
            world.setBlock(i + 3, j + 0, k + 5, 5);
            world.setBlock(i + 3, j + 0, k + 4, 5);
            world.setBlock(i + 3, j + 0, k + 3, 5);
            world.setBlock(i + 3, j + 0, k + 2, 5);
            world.setBlock(i + 3, j + 0, k + 1, 5);
            world.setBlock(i + 3, j + 0, k + 0, 5);
            world.setBlock(i + 4, j + 0, k + 6, 5);
            world.setBlock(i + 4, j + 0, k + 5, 5);
            world.setBlock(i + 4, j + 0, k + 4, 5);
            world.setBlock(i + 4, j + 0, k + 3, 5);
            world.setBlock(i + 4, j + 0, k + 2, 5);
            world.setBlock(i + 4, j + 0, k + 1, 5);
            world.setBlock(i + 4, j + 0, k + 0, 5);
            world.setBlock(i + 5, j + 0, k + 6, 5);
            world.setBlock(i + 5, j + 0, k + 5, 5);
            world.setBlock(i + 5, j + 0, k + 4, 5);
            world.setBlock(i + 5, j + 0, k + 3, 5);
            world.setBlock(i + 5, j + 0, k + 2, 5);
            world.setBlock(i + 5, j + 0, k + 1, 5);
            world.setBlock(i + 5, j + 0, k + 0, 5);
            world.setBlock(i + 6, j + 0, k + 6, 5);
            world.setBlock(i + 6, j + 0, k + 5, 5);
            world.setBlock(i + 6, j + 0, k + 4, 5);
            world.setBlock(i + 6, j + 0, k + 3, 5);
            world.setBlock(i + 6, j + 0, k + 2, 5);
            world.setBlock(i + 6, j + 0, k + 1, 5);
            world.setBlock(i + 6, j + 0, k + 0, 5);
            world.setBlock(i + 0, j + 1, k + 6, 5);
            world.setBlock(i + 0, j + 1, k + 5, 5);
            world.setBlock(i + 0, j + 1, k + 4, 5);
            world.setBlock(i + 0, j + 1, k + 3, 5);
            world.setBlock(i + 0, j + 1, k + 2, 5);
            world.setBlock(i + 0, j + 1, k + 1, 5);
            world.setBlock(i + 0, j + 1, k + 0, 5);
            world.setBlock(i + 1, j + 1, k + 6, 5);
            world.setBlockWithNotify(i + 1, j + 1, k + 5, Block.chest.blockID);
            world.setBlock(i + 1, j + 1, k + 4, 58);
            world.setBlock(i + 1, j + 1, k + 3, 61);
            world.setBlockWithNotify(i + 1, j + 1, k + 2, Block.chest.blockID);
            world.setBlockWithNotify(i + 1, j + 1, k + 1, Block.chest.blockID);
            world.setBlock(i + 1, j + 1, k + 0, 5);
            world.setBlock(i + 2, j + 1, k + 6, 5);
            world.setBlock(i + 2, j + 1, k + 0, 5);
            world.setBlock(i + 3, j + 1, k + 6, 5);
            world.setBlock(i + 3, j + 1, k + 0, 5);
            world.setBlock(i + 4, j + 1, k + 6, 5);
            world.setBlock(i + 4, j + 1, k + 0, 5);
            world.setBlock(i + 5, j + 1, k + 6, 5);
            world.setBlock(i + 5, j + 1, k + 0, 5);
            world.setBlock(i + 6, j + 1, k + 6, 5);
            world.setBlock(i + 6, j + 1, k + 5, 5);
            world.setBlock(i + 6, j + 1, k + 4, 5);
            world.setBlock(i + 6, j + 1, k + 2, 5);
            world.setBlock(i + 6, j + 1, k + 1, 5);
            world.setBlock(i + 6, j + 1, k + 0, 5);
            world.setBlock(i + 0, j + 2, k + 6, 4);
            world.setBlock(i + 0, j + 2, k + 5, 4);
            world.setBlock(i + 0, j + 2, k + 4, 4);
            world.setBlock(i + 0, j + 2, k + 3, 4);
            world.setBlock(i + 0, j + 2, k + 2, 4);
            world.setBlock(i + 0, j + 2, k + 1, 4);
            world.setBlock(i + 0, j + 2, k + 0, 4);
            world.setBlock(i + 1, j + 2, k + 6, 4);
            world.setBlock(i + 1, j + 2, k + 0, 4);
            world.setBlock(i + 2, j + 2, k + 6, 4);
            world.setBlock(i + 2, j + 2, k + 0, 4);
            world.setBlock(i + 3, j + 2, k + 6, 4);
            world.setBlock(i + 3, j + 2, k + 0, 4);
            world.setBlock(i + 4, j + 2, k + 6, 4);
            world.setBlock(i + 4, j + 2, k + 0, 4);
            world.setBlock(i + 5, j + 2, k + 6, 4);
            world.setBlock(i + 5, j + 2, k + 0, 4);
            world.setBlock(i + 6, j + 2, k + 6, 4);
            world.setBlock(i + 6, j + 2, k + 5, 4);
            world.setBlock(i + 6, j + 2, k + 4, 4);
            world.setBlock(i + 6, j + 2, k + 2, 4);
            world.setBlock(i + 6, j + 2, k + 1, 4);
            world.setBlock(i + 6, j + 2, k + 0, 4);
            world.setBlock(i + 0, j + 3, k + 6, 5);
            world.setBlock(i + 0, j + 3, k + 5, 5);
            world.setBlock(i + 0, j + 3, k + 4, 5);
            world.setBlock(i + 0, j + 3, k + 3, 5);
            world.setBlock(i + 0, j + 3, k + 2, 5);
            world.setBlock(i + 0, j + 3, k + 1, 5);
            world.setBlock(i + 0, j + 3, k + 0, 5);
            world.setBlock(i + 1, j + 3, k + 6, 5);
            world.setBlock(i + 1, j + 4, k + 3, 50);
            world.setBlock(i + 1, j + 3, k + 0, 5);
            world.setBlock(i + 2, j + 3, k + 6, 5);
            world.setBlock(i + 2, j + 3, k + 0, 5);
            world.setBlock(i + 3, j + 3, k + 6, 5);
            world.setBlock(i + 3, j + 3, k + 0, 5);
            world.setBlock(i + 4, j + 3, k + 6, 5);
            world.setBlock(i + 4, j + 3, k + 0, 5);
            world.setBlock(i + 5, j + 3, k + 6, 5);
            world.setBlock(i + 5, j + 4, k + 3, 50);
            world.setBlock(i + 5, j + 3, k + 0, 5);
            world.setBlock(i + 6, j + 3, k + 6, 5);
            world.setBlock(i + 6, j + 3, k + 5, 5);
            world.setBlock(i + 6, j + 3, k + 4, 5);
            world.setBlock(i + 6, j + 3, k + 3, 5);
            world.setBlock(i + 6, j + 3, k + 2, 5);
            world.setBlock(i + 6, j + 3, k + 1, 5);
            world.setBlock(i + 6, j + 3, k + 0, 5);
            world.setBlock(i + 0, j + 4, k + 5, 5);
            world.setBlock(i + 0, j + 4, k + 4, 5);
            world.setBlock(i + 0, j + 4, k + 3, 5);
            world.setBlock(i + 0, j + 4, k + 2, 5);
            world.setBlock(i + 0, j + 4, k + 1, 5);
            world.setBlock(i + 1, j + 4, k + 5, 5);
            world.setBlock(i + 1, j + 4, k + 1, 5);
            world.setBlock(i + 2, j + 4, k + 5, 5);
            world.setBlock(i + 2, j + 4, k + 1, 5);
            world.setBlock(i + 3, j + 4, k + 5, 5);
            world.setBlock(i + 3, j + 4, k + 1, 5);
            world.setBlock(i + 4, j + 4, k + 5, 5);
            world.setBlock(i + 4, j + 4, k + 1, 5);
            world.setBlock(i + 5, j + 4, k + 5, 5);
            world.setBlock(i + 5, j + 4, k + 1, 5);
            world.setBlock(i + 6, j + 4, k + 5, 5);
            world.setBlock(i + 6, j + 4, k + 4, 5);
            world.setBlock(i + 6, j + 4, k + 3, 5);
            world.setBlock(i + 6, j + 4, k + 2, 5);
            world.setBlock(i + 6, j + 4, k + 1, 5);
            world.setBlock(i + 0, j + 5, k + 4, 5);
            world.setBlock(i + 0, j + 5, k + 3, 5);
            world.setBlock(i + 0, j + 5, k + 2, 5);
            world.setBlock(i + 1, j + 5, k + 4, 5);
            world.setBlock(i + 1, j + 5, k + 2, 5);
            world.setBlock(i + 2, j + 5, k + 4, 5);
            world.setBlock(i + 2, j + 5, k + 2, 5);
            world.setBlock(i + 3, j + 5, k + 4, 5);
            world.setBlock(i + 3, j + 5, k + 2, 5);
            world.setBlock(i + 4, j + 5, k + 4, 5);
            world.setBlock(i + 4, j + 5, k + 2, 5);
            world.setBlock(i + 5, j + 5, k + 4, 5);
            world.setBlock(i + 5, j + 5, k + 2, 5);
            world.setBlock(i + 6, j + 5, k + 4, 5);
            world.setBlock(i + 6, j + 5, k + 3, 5);
            world.setBlock(i + 6, j + 5, k + 2, 5);
            world.setBlock(i + 0, j + 6, k + 3, 5);
            world.setBlock(i + 1, j + 6, k + 3, 5);
            world.setBlock(i + 2, j + 6, k + 3, 5);
            world.setBlock(i + 3, j + 6, k + 3, 5);
            world.setBlock(i + 4, j + 6, k + 3, 5);
            world.setBlock(i + 5, j + 6, k + 3, 5);
            world.setBlock(i + 6, j + 6, k + 3, 5);

  return true;
  }
    
} /*=====End of Code=====*/
