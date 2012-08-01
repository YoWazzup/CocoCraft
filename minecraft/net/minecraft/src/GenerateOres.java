package net.minecraft.src;

import java.util.Random;


public class GenerateOres {
	
	
	public GenerateOres()
	{
		
	}
	
	public void generateStuff(World world, Random rand, int baseX, int baseZ)
	{
	for(int x=0; x <8; x++)
	{
		int Xcoord = baseX + rand.nextInt(16);
		int Ycoord = rand.nextInt(20);
		int Zcoord = baseZ + rand.nextInt(16);
		(new WorldGenMinable(mod_CocoCraft.CocoStone.blockID, 3)).generate(world,rand, Xcoord, Ycoord, Zcoord);
	}
	for(int x=0; x <11; x++)
	{
		int Xcoord = baseX + rand.nextInt(16);
		int Ycoord = rand.nextInt(48);
		int Zcoord = baseZ + rand.nextInt(16);
		(new WorldGenMinable(mod_CocoCraft.MithrilOre.blockID, 5)).generate(world,rand, Xcoord, Ycoord, Zcoord);
	}
	for(int x=0; x <11; x++)
	{
		int Xcoord = baseX + rand.nextInt(16);
		int Ycoord = rand.nextInt(40);
		int Zcoord = baseZ + rand.nextInt(16);
		(new WorldGenMinable(mod_CocoCraft.SilverOre.blockID, 6)).generate(world,rand, Xcoord, Ycoord, Zcoord);
	}
	for(int x=0; x <9; x++)
	{
		int Xcoord = baseX + rand.nextInt(16);
		int Ycoord = rand.nextInt(15);
		int Zcoord = baseZ + rand.nextInt(16);
		(new WorldGenMinable(mod_CocoCraft.Amethyst.blockID, 3)).generate(world,rand, Xcoord, Ycoord, Zcoord);
	}
	for(int x=0; x <50; x++)
	{
		int Xcoord = baseX + rand.nextInt(16);
		int Ycoord = rand.nextInt(52);
		int Zcoord = baseZ + rand.nextInt(16);
		(new WorldGenMinable(mod_CocoCraft.Essence.blockID, 5)).generate(world,rand, Xcoord, Ycoord, Zcoord);
	}
	
	//Shack
	for(int k = 0; k < 20; k++)
	{
		int Xcoord = baseX + rand.nextInt(16);
		int Ycoord = rand.nextInt(64);
		int Zcoord = baseZ + rand.nextInt(16);
		(new WorldGenShack()).generate(world, rand, Xcoord, Ycoord, Zcoord);
		
	}
	{
		int var5;
		int var6;
		int var7;
		int var8;
			for(var5 =0; var5 < 9; ++var5)
			{
				var6 = baseX + rand.nextInt(16) + 8;
	            var7 = rand.nextInt(128);
	            var8 = baseZ + rand.nextInt(16) + 8;
	            (new WorldGenFlowers(mod_CocoCraft.CocoaFlower.blockID)).generate(world, rand, var6, var7, var8);
			}
		}
        if(rand.nextInt(20) == 0)
        {
            for(int k = 0; k < 16; k++)
            {
                for(int l = 0; l < 16; l++)
                {
                    int i1 = rand.nextInt(200);
                    if(world.getBlockId(baseX + l, i1, baseZ + k) != Block.grass.blockID || !world.isAirBlock(baseX + l, i1 + 1, baseZ + k))
                    {
                        continue;
                    }
                    int j1 = rand.nextInt(2);
                    if(j1 == 0)
                    {
                        world.setBlock(baseX + l, i1 + 1, baseZ + k, mod_CocoCraft.CocoReed.blockID);
                    }
                    if(j1 == 1)
                    {
                        world.setBlock(baseX + l, i1 + 1, baseZ + k, mod_CocoCraft.CocoReed.blockID);
                        world.setBlock(baseX + l, i1 + 2, baseZ + k, mod_CocoCraft.CocoReed.blockID);
                    }
                    if(j1 == 2)
                    {
                        world.setBlock(baseX + l, i1 + 1, baseZ + k, mod_CocoCraft.CocoReed.blockID);
                        world.setBlock(baseX + l, i1 + 2, baseZ + k, mod_CocoCraft.CocoReed.blockID);
                        world.setBlock(baseX + l, i1 + 3, baseZ + k, mod_CocoCraft.CocoReed.blockID);
                    }
                                        if(j1 == 3)
                    {
                        world.setBlock(baseX + l, i1 + 1, baseZ + k, mod_CocoCraft.CocoReed.blockID);
                        world.setBlock(baseX + l, i1 + 2, baseZ + k, mod_CocoCraft.CocoReed.blockID);
                        world.setBlock(baseX + l, i1 + 3, baseZ + k, mod_CocoCraft.CocoReed.blockID);
                                                world.setBlock(baseX + l, i1 + 4, baseZ + k, mod_CocoCraft.CocoReed.blockID);
                    }
                }

            }

        }
  
        
    }
}
