package net.minecraft.src.CocoCraft.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.*;

public class CC_BookOfLightning extends Item{

	
	public CC_BookOfLightning(int i)
	{
		super(i);
		setMaxDamage(75);
		maxStackSize = 1;
	}
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
            if(itemstack.getItemDamage() == 0)
            {
            	 MovingObjectPosition movingobjectposition = entityplayer.rayTrace(100.0D, 1.0F);
                 if(movingobjectposition == null)
                 {
                         return itemstack;
                 }
                 Vec3D vec3d = movingobjectposition.hitVec;
                 double x = vec3d.xCoord;
                 double y = vec3d.yCoord;
                 double z = vec3d.zCoord;
                 int i = MathHelper.floor_double(x);
                 int j = MathHelper.floor_double(y);
                 int k = MathHelper.floor_double(z);
                 
                 if(world.canBlockSeeTheSky(i, j, k) == false)
                 {
                         return itemstack;
                 }
                 
                 EntityLightningBolt entitybolt = new EntityLightningBolt(world, 0D, 0D, 0D);
                 entitybolt.setLocationAndAngles(x, y, z, 0, 0.0F);
                 world.spawnEntityInWorld(entitybolt);
                    itemstack.setItemDamage(74);
                            }
            return itemstack;
    }
	 public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
     {
             if(itemstack.getItemDamage() > 0)
             {
                     itemstack.damageItem(-1, (EntityLiving)entity);
             }
     }

	public void addInformation(ItemStack itemstack, List list) {
		list.add("Spawns Lightning at the pos. you are looking at!");
		
	}
	
	public String getTextureFile()
	{
		return "/CC/Items.png";
	}
	public void addCreativeItems(ArrayList itemList)
	{
		itemList.add(new ItemStack(this));
	}
}
