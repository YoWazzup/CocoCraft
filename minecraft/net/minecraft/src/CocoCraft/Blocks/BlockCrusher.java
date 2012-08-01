package net.minecraft.src.CocoCraft.Blocks;

import net.minecraft.src.*;
import net.minecraft.src.CocoCraft.Misc.*;

import java.util.ArrayList;
import java.util.Random;

public class BlockCrusher extends BlockContainer {

	 private Random crusherRand = new Random();
	
	public BlockCrusher(int i, boolean flag)
	{
		super(i, Material.rock);
		
		isActive = flag;
	}
	public int idDropped(int i, Random random)
	{
		return mod_CocoCraft.Crusher.blockID;
	}
	public void onBlockAdded(World world, int i, int j, int k)
	{
		super.onBlockAdded(world, i, j, k);
		setDefaultDirection(world, i, j, k);
	}
	public void setDefaultDirection(World world, int i, int j, int k)
	{
		if(world.isRemote)
        {
            return;
        }
        int l = world.getBlockId(i, j, k - 1);
        int i1 = world.getBlockId(i, j, k + 1);
        int j1 = world.getBlockId(i - 1, j, k);
        int k1 = world.getBlockId(i + 1, j, k);
        byte byte0 = 3;
        if(Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
        {
            byte0 = 3;
        }
        if(Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
        {
            byte0 = 2;
        }
        if(Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
        {
            byte0 = 5;
        }
        if(Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
        {
            byte0 = 4;
        }
        world.setBlockMetadataWithNotify(i, j, k, byte0);
	}
	public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
		if(l == 1)
		{
			return mod_CocoCraft.CrusherSide;
		}
		if(l == 0)
		{
			return mod_CocoCraft.CrusherSide;
		}
		int i1 = iblockaccess.getBlockMetadata(i, j, k);
        if(l != i1)
        {
            return mod_CocoCraft.CrusherSide;
        }
        else
        {
            return mod_CocoCraft.CrusherFront;
        }
	}
	public int getBlockTextureFromSide(int side)
    {
		if (side == 3)
		{
			return mod_CocoCraft.CrusherFront;
		}
		else
		{
			return mod_CocoCraft.CrusherSide;
		}
    }
	/**
	 * calles when the block is right clicked by
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
            entityplayer.openGui(mod_CocoCraft.getInstance(), 0, world, i, j, k);
            return true;
        }
        return true;
    }
   
	
	public TileEntity getBlockEntity()
    {
        return new TileEntityCrusher();
    }

    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        if(l == 0)
        {
            world.setBlockMetadataWithNotify(i, j, k, 2);
        }
        if(l == 1)
        {
            world.setBlockMetadataWithNotify(i, j, k, 5);
        }
        if(l == 2)
        {
            world.setBlockMetadataWithNotify(i, j, k, 3);
        }
        if(l == 3)
        {
            world.setBlockMetadataWithNotify(i, j, k, 4);
        }
    }
    public void onBlockRemoval(World par1World, int par2, int par3, int par4)
    {
        if (!keepCrusherInventory)
        {
            TileEntityCrusher var5 = (TileEntityCrusher)par1World.getBlockTileEntity(par2, par3, par4);

            if (var5 != null)
            {
                for (int var6 = 0; var6 < var5.getSizeInventory(); ++var6)
                {
                    ItemStack var7 = var5.getStackInSlot(var6);

                    if (var7 != null)
                    {
                        float var8 = this.crusherRand.nextFloat() * 0.8F + 0.1F;
                        float var9 = this.crusherRand.nextFloat() * 0.7F + 0.2F;
                        float var10 = this.crusherRand.nextFloat() * 0.6F + 0.3F;

                        while (var7.stackSize > 0)
                        {
                            int var11 = this.crusherRand.nextInt(21) + 10;

                            if (var11 > var7.stackSize)
                            {
                                var11 = var7.stackSize;
                            }

                            var7.stackSize -= var11;
                            EntityItem var12 = new EntityItem(par1World, (double)((float)par2 + var8), (double)((float)par3 + var9), (double)((float)par4 + var10), new ItemStack(var7.itemID, var11, var7.getItemDamage()));

                            if (var7.hasTagCompound())
                            {
                                var12.item.setTagCompound((NBTTagCompound)var7.getTagCompound().copy());
                            }

                            float var13 = 0.05F;
                            var12.motionX = (double)((float)this.crusherRand.nextGaussian() * var13);
                            var12.motionY = (double)((float)this.crusherRand.nextGaussian() * var13 + 0.2F);
                            var12.motionZ = (double)((float)this.crusherRand.nextGaussian() * var13);
                            par1World.spawnEntityInWorld(var12);
                        }
                    }
                }
            }
        }

        super.onBlockRemoval(par1World, par2, par3, par4);
    }
    public void addCreativeItems(ArrayList itemList)
	{
		itemList.add(new ItemStack(this));
	}

    private final boolean isActive;
    private static boolean keepCrusherInventory = false;

}
	


