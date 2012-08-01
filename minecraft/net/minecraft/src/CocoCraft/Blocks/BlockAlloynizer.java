package net.minecraft.src.CocoCraft.Blocks;

import net.minecraft.src.CocoCraft.Misc.*;
import net.minecraft.src.*;

import java.util.ArrayList;
import java.util.Random;

public class BlockAlloynizer extends BlockContainer
{
    private Random rand = new Random();
    private final boolean isActive;
    
     private static boolean keepFurnaceInventory = false;

    public BlockAlloynizer(int id, boolean flag)
    {
        super(id, Material.rock);
        isActive = flag;
    }
    public boolean isOpaqueCube() {
        return false;
    }
    
    public void addCreativeItems(ArrayList itemList) {
        itemList.add(new ItemStack(this));
    }

    public boolean renderAsNormalBlock() {
        return true;
    }
    
    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }

    /**
     * set a blocks direction
     */
    private void setDefaultDirection(World world, int x, int y, int z)
    {
        if (!world.isRemote)
        {
            int var5 = world.getBlockId(x, y, z - 1);
            int var6 = world.getBlockId(x, y, z + 1);
            int var7 = world.getBlockId(x - 1, y, z);
            int var8 = world.getBlockId(x + 1, y, z);
            byte var9 = 3;

            if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6])
            {
                var9 = 3;
            }

            if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5])
            {
                var9 = 2;
            }

            if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8])
            {
                var9 = 5;
            }

            if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7])
            {
                var9 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, var9);
        }
    }

   
    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
		if(l == 1)
		{
			return mod_CocoCraft.DuplicatorSide;
		}
		if(l == 0)
		{
			return mod_CocoCraft.DuplicatorSide;
		}
		int i1 = iblockaccess.getBlockMetadata(i, j, k);
        if(l != i1)
        {
            return mod_CocoCraft.DuplicatorSide;
        }
        else
        {
            return mod_CocoCraft.DuplicatorFront;
        }
	}
    public int getBlockTextureFromSide(int side)
    {
		if (side == 3)
		{
			return mod_CocoCraft.DuplicatorFront;
		}
		else
		{
			return mod_CocoCraft.DuplicatorSide;
		}
    }
    /**
	 * called when the block is right clicked by
	 * player.
	 */
	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
		if(entityplayer.isSneaking())
		{
			return false;
		}
        if(!world.isRemote)
        {
            entityplayer.openGui(mod_CocoCraft.getInstance(), 4, world, i, j, k);
            return true;
        }
        return true;
    }

    /**

    /**
     * Returns the TileEntity used by this block.
     */
    public TileEntity getBlockEntity()
    {
        return new TileEntityAlloynizer();
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity)
    {
        int var6 = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var6 == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2);
        }

        if (var6 == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5);
        }

        if (var6 == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3);
        }

        if (var6 == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4);
        }
    }

    /**
     * Called whenever the block is removed.
     */
    public void onBlockRemoval(World world, int x, int y, int z)
    {
        if (!keepFurnaceInventory)
        {
        	TileEntityAlloynizer tile = (TileEntityAlloynizer)world.getBlockTileEntity(x, y, z);

            if (tile != null)
            {
                for (int var6 = 0; var6 < tile.getSizeInventory(); ++var6)
                {
                    ItemStack var7 = tile.getStackInSlot(var6);

                    if (var7 != null)
                    {
                        float var8 = this.rand.nextFloat() * 0.8F + 0.1F;
                        float var9 = this.rand.nextFloat() * 0.8F + 0.1F;
                        float var10 = this.rand.nextFloat() * 0.8F + 0.1F;

                        while (var7.stackSize > 0)
                        {
                            int var11 = this.rand.nextInt(21) + 10;

                            if (var11 > var7.stackSize)
                            {
                                var11 = var7.stackSize;
                            }

                            var7.stackSize -= var11;
                            EntityItem var12 = new EntityItem(world, (double)((float)x + var8), (double)((float)y + var9), (double)((float)z + var10), new ItemStack(var7.itemID, var11, var7.getItemDamage()));

                            if (var7.hasTagCompound())
                            {
                                var12.item.setTagCompound((NBTTagCompound)var7.getTagCompound().copy());
                            }

                            float var13 = 0.05F;
                            var12.motionX = (double)((float)this.rand.nextGaussian() * var13);
                            var12.motionY = (double)((float)this.rand.nextGaussian() * var13 + 0.2F);
                            var12.motionZ = (double)((float)this.rand.nextGaussian() * var13);
                            world.spawnEntityInWorld(var12);
                        }
                    }
                }
            }
        }

        super.onBlockRemoval(world, x, y, z);
    }
}
