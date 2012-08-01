package net.minecraft.src.CocoCraft.Blocks;

import net.minecraft.src.*;
import net.minecraft.src.forge.ITextureProvider;
import net.minecraft.client.Minecraft;

public class CC_BlockBlock extends Block implements ITextureProvider
{
	public CC_BlockBlock(int i)
	{
		super(i, Material.iron);
	}
	public int getTextureFromSideAndMetadata(int i, int j)
	{
		switch(j)
		{
		case 0 : return 4;
		case 1 : return 5;
		case 2 : return 6;
		case 3 : return 7;
		default : return 4;
		}
	}
	protected int damageDropped(int i)
	{
		return i;
	}
	public String getTextureFile()
	{
		return "/CC/Blocks.png";
	}
}