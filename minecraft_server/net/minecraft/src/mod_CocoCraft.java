package net.minecraft.src;

import java.io.File;
import java.util.*;

import cpw.mods.fml.server.FMLServerHandler;

//import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
import net.minecraft.src.CocoCraft.*;
import net.minecraft.src.CocoCraft.Armor.*;
import net.minecraft.src.CocoCraft.Blocks.*;
import net.minecraft.src.CocoCraft.Items.*;
import net.minecraft.src.CocoCraft.Misc.*;
import net.minecraft.src.CocoCraft.Mobs.EntityChocoCow;
import net.minecraft.src.CocoCraft.Mobs.EntityChocoPig;
import net.minecraft.src.forge.*;

public class mod_CocoCraft extends NetworkMod implements IGuiHandler{

    
	static Configuration configuration = new Configuration(new File(FMLServerHandler.instance().getMinecraftRootDirectory(), "/config/CocoCraft/CocoCraft.cfg"));
	
	static int CocoStoneID = configurationProperties(configuration);
	static int MithrilOreID;
	static int SilverOreID;
	static int AmethystID;
	static int CocoBlockID;
	static int MithrilBlockID;
	static int SilverBlockID;
	static int AmethystBlockID;
	static int CocoaFlowerID;
	static int SuperStoneID;
	static int CocoReedID;
	static int EssenceID;
	static int CrusherID;
	static int CompressorID;
	static int SilverFurnaceID;
	
	
	static int AmethystGemID;
	static int CocoPickaxeID;
	static int CocoAxeID;
	static int CocoShovelID;
	static int CocoSwordID;
	static int CocoHoeID;
	
	static int MithrilPickaxeID;
	static int MithrilAxeID;
	static int MithrilShovelID;
	static int MithrilSwordID;
	static int MithrilHoeID;
	
	static int SilverPickaxeID;
	static int SilverAxeID;
	static int SilverShovelID;
	static int SilverSwordID;
	static int SilverHoeID;
	
	static int AmethystPickaxeID;
	static int AmethystAxeID;
	static int AmethystShovelID;
	static int AmethystSwordID;
	static int AmethystHoeID;
	
	static int CocoIngotID;
	static int MithrilIngotID;
	static int SilverIngotID;
	
	static int CocoHelmetID;
	static int CocoPlateID;
	static int CocoLegsID;
	static int CocoBootsID;
	
	static int MithrilHelmetID;
	static int MithrilPlateID;
	static int MithrilLegsID;
	static int MithrilBootsID;
	
	static int SilverHelmetID;
	static int SilverPlateID;
	static int SilverLegsID;
	static int SilverBootsID;
	
	static int AmethystHelmetID;
	static int AmethystPlateID;
	static int AmethystLegsID;
	static int AmethystBootsID;
	
	static int AlloyID;
	static int CompressedAlloyID;
	static int ExtremeAlloyID;
	static int UncExtremeAlloyID;
	
	static int AlloyHelmetID;
	static int AlloyPlateID;
	static int AlloyLegsID;
	static int AlloyBootsID;
	
	static int ExtremeAlloyHelmetID;
	static int ExtremeAlloyPlateID;
	static int ExtremeAlloyLegsID;
	static int ExtremeAlloyBootsID;
	
	static int ChocoPorkID;
	static int CookedChocoPorkID;
	
	static int CocoaMeshID;
	static int CocoaPowderID;
	
	static int ChocolateMilkID;
	static int HotChocolateMilkID;
	
	static int ChocoBeefID;
	static int ChocoSteakID;
	
	static int BookOfTimeID;
	static int BookOfHealingID;
	static int BookOfExpID;
	
	static int MagicDustID;
	static int EarthEssenceID;
	static int FireEssenceID;
	static int WaterEssenceID;
	static int WindEssenceID;
	
	static int IronDustID;
	static int GoldDustID;
	static int SilverDustID;
	static int MithrilDustID;
	static int CoalDustID;
	
	static int MixedIronDustID;
	static int UnworkedSteelID;
	static int SteelIngotID;
	static int HammerID;
	
	static int SteelPickaxeID;
	static int SteelAxeID;
	static int SteelShovelID;
	static int SteelSwordID;
	static int SteelHoeID;
	
	static int ObsidianDustID;
	static int ObsidianIngotID;
	static int ObsidianToolID;
	static int DiamondStickID;
	
	static int DragonShardID;
	
	static int DragonStonePickaxeID;
	static int DragonStoneAxeID;
	static int DragonStoneShovelID;
	static int DragonStoneSwordID;
	static int DragonStoneHoeID;
	
	static int DragonStoneChestID;
	
	static EnumToolMaterial toolCOCO = EnumHelper.addToolMaterial("COCO", 2, 2500, 15F, 13, 8);
    static EnumToolMaterial toolMITHRIL = EnumHelper.addToolMaterial("MITHRIL", 2, 450, 9F, 7, 4);
    static EnumToolMaterial toolSILVER = EnumHelper.addToolMaterial("SILVER", 2, 650, 7F, 9, 5);
    static EnumToolMaterial toolAMETHYST = EnumHelper.addToolMaterial("AMETHYST", 2, 1900, 13F, 11, 11);
    static EnumToolMaterial toolSTEEL = EnumHelper.addToolMaterial("STEEL", 2, 927, 8F, 7, 2);
    static EnumToolMaterial toolOBSIDIAN = EnumHelper.addToolMaterial("OBSIDIAN", 2, 2012, 10F, 7, 2);
    static EnumToolMaterial toolDRAGON = EnumHelper.addToolMaterial("DRAGON", 3, 5201, 12F, 7, 15);
    
    static EnumArmorMaterial COCO = EnumHelper.addArmorMaterial("COCO", 48, new int[] {4, 8, 6, 2}, 4);
	static EnumArmorMaterial MITHRIL = EnumHelper.addArmorMaterial("MITHRIL", 22, new int[] {2, 5, 4, 2}, 5);
	static EnumArmorMaterial SILVER = EnumHelper.addArmorMaterial("SILVER", 26, new int[] {3, 6, 5, 3}, 5);
	static EnumArmorMaterial AMETHYST = EnumHelper.addArmorMaterial("AMETHYST", 36, new int[] {3, 6, 6, 2}, 5);
	static EnumArmorMaterial ALLOY = EnumHelper.addArmorMaterial("ALLOY", 40, new int[] {4, 6, 6, 2}, 5);
	static EnumArmorMaterial EXTREMEALLOY = EnumHelper.addArmorMaterial("EXTREMEALLOY", 56, new int[] {5, 7, 6, 2}, 5);
	static EnumArmorMaterial DRAGON = EnumHelper.addArmorMaterial("DRAGON", 62, new int[]{5, 7, 6, 2}, 5);
	
	
	public static int CrusherSide = ModLoader.addOverride("/terrain.png", "/CC/Blocks/CrusherSide.png");
	public static int CrusherFront = ModLoader.addOverride("/terrain.png", "/CC/Blocks/CrusherFront.png");
	
	public static int CompressorSide = ModLoader.addOverride("/terrain.png", "/CC/Blocks/CompressorSide.png");
	public static int CompressorFront = ModLoader.addOverride("/terrain.png", "/CC/Blocks/CompressorFront.png");
	
	public static int SilverFurnaceSide = ModLoader.addOverride("/terrain.png", "/CC/Blocks/SilverFurnaceSide.png");
	public static int SilverFurnaceFront = ModLoader.addOverride("/terrain.png", "/CC/Blocks/SilverFurnaceFront.png");
	
	public static int DuplicatorSide = ModLoader.addOverride("/terrain.png", "/CC/Blocks/DuplicatorSide.png");
	public static int DuplicatorFront = ModLoader.addOverride("/terrain.png", "/CC/Blocks/DuplicatorFront.png");
	
	public static final Block CocoStone = (new CC_Ore(CocoStoneID,0).setHardness(2.0F).setResistance(5F).setBlockName("CocoStone"));
	public static final Block MithrilOre = (new CC_Ore(MithrilOreID,1).setHardness(2.0F).setResistance(5F).setBlockName("MithrilOre"));
	public static final Block SilverOre = (new CC_Ore(SilverOreID,2).setHardness(2.0F).setResistance(5F).setBlockName("SilverOre"));
	public static final Block Amethyst = (new CC_Amethyst(AmethystID,3).setHardness(2.0F).setResistance(5F).setBlockName("Amethyst"));
	
	
	public static final Block CocoBlock = (new CC_Block(CocoBlockID,4).setHardness(2.0F).setResistance(5F).setBlockName("CocoBlock"));
	public static final Block MithrilBlock = (new CC_Block(MithrilBlockID,5).setHardness(2.0F).setResistance(5F).setBlockName("MithrilBlock"));
	public static final Block SilverBlock = (new CC_Block(SilverBlockID,6).setHardness(2.0F).setResistance(5F).setBlockName("SilverBlock"));
	public static final Block AmethystBlock = (new CC_Block(AmethystBlockID,7).setHardness(2.0F).setResistance(5F).setBlockName("AmethystBlock"));
	
	public static final BlockFlower CocoaFlower =(BlockFlower) (new CC_Flower(CocoaFlowerID, 8).setHardness(0.0F).setResistance(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("CocoaFlower"));
	public static final Block SuperStone = (new CC_SuperBlock(SuperStoneID, 9).setHardness(320F).setResistance(320000F).setBlockName("SuperStone"));
	public static final Block CocoReed = (new CC_CocoReed(CocoReedID, 10).setHardness(0F).setResistance(0F).setBlockName("CocoReed"));
	public static final Block Essence = (new CC_Essence(EssenceID, 11).setHardness(1.7F).setResistance(0.9F).setBlockName("Essence"));
	
	public static final Block Crusher =  (new BlockCrusher(CrusherID, false).setHardness(1F).setResistance(2F).setBlockName("Crusher"));	
	public static final Block Compressor =  (new BlockCompressor(CompressorID, false).setHardness(1F).setResistance(2F).setBlockName("Compressor"));	
	public static final Block SilverFurnace = (new BlockSilverFurnace(SilverFurnaceID, false).setHardness(1F).setResistance(2F).setBlockName("SilverFurnace"));

	public static final Item AmethystGem = (new CC_Item(AmethystGemID)).setIconCoord(0,0).setItemName("AmethystGem");
	
	public static final Item CocoPickaxe = (new CC_Pickaxe(CocoPickaxeID,toolCOCO)).setIconCoord(1,0).setItemName("Coco1");
	public static final Item CocoAxe = (new CC_Axe(CocoAxeID,toolCOCO)).setIconCoord(2,0).setItemName("Coco2");
	public static final Item CocoShovel = (new CC_Shovel(CocoShovelID, toolCOCO)).setIconCoord(3,0).setItemName("Coco3");
	public static final Item CocoSword = (new CC_Sword(CocoSwordID, toolCOCO)).setIconCoord(4,0).setItemName("Coco4");
	public static final Item CocoHoe = (new CC_Hoe(CocoHoeID,toolCOCO)).setIconCoord(5,0).setItemName("Coco5");
	
	public static final Item MithrilPickaxe = (new CC_Pickaxe(MithrilPickaxeID,toolMITHRIL)).setIconCoord(6,0).setItemName("Mith1");
	public static final Item MithrilAxe = (new CC_Axe(MithrilAxeID,toolMITHRIL)).setIconCoord(7,0).setItemName("Mith2");
	public static final Item MithrilShovel = (new CC_Shovel(MithrilShovelID,toolMITHRIL)).setIconCoord(8,0).setItemName("Mith3");
	public static final Item MithrilSword = (new CC_Sword(MithrilSwordID,toolMITHRIL)).setIconCoord(9,0).setItemName("Mith4");
	public static final Item MithrilHoe = (new CC_Hoe(MithrilHoeID,toolMITHRIL)).setIconCoord(10,0).setItemName("Mith5");
	
	public static final Item SilverPickaxe = (new CC_Pickaxe(SilverPickaxeID,toolSILVER)).setIconCoord(11,0).setItemName("Silver1");
	public static final Item SilverAxe = (new CC_Axe(SilverAxeID,toolSILVER)).setIconCoord(12,0).setItemName("Silver2");
	public static final Item SilverShovel = (new CC_Shovel(SilverShovelID,toolSILVER)).setIconCoord(13,0).setItemName("Silver3");
	public static final Item SilverSword = (new CC_Sword(SilverSwordID,toolSILVER)).setIconCoord(14,0).setItemName("Silver4");
	public static final Item SilverHoe = (new CC_Hoe(SilverHoeID,toolSILVER)).setIconCoord(15,0).setItemName("Silver5");
	
	public static final Item AmethystPickaxe = (new CC_Pickaxe(AmethystPickaxeID,toolAMETHYST)).setIconCoord(0,1).setItemName("Amethyst1");
	public static final Item AmethystAxe = (new CC_Axe(AmethystAxeID,toolAMETHYST)).setIconCoord(1,1).setItemName("Amethyst2");
	public static final Item AmethystShovel = (new CC_Shovel(AmethystShovelID,toolAMETHYST)).setIconCoord(2,1).setItemName("Amethyst3");
	public static final Item AmethystSword = (new CC_Sword(AmethystSwordID,toolAMETHYST)).setIconCoord(3,1).setItemName("Amethyst4");
	public static final Item AmethystHoe = (new CC_Hoe(AmethystHoeID,toolAMETHYST)).setIconCoord(4,1).setItemName("Amethyst");
	
	public static final Item CocoIngot = (new CC_Item(CocoIngotID)).setIconCoord(5,1).setItemName("CocoIngot"); 
	public static final Item MithrilIngot = (new CC_Item(MithrilIngotID)).setIconCoord(6,1).setItemName("SilverIngot");
	public static final Item SilverIngot = (new CC_Item(SilverIngotID)).setIconCoord(7,1).setItemName("MithrilIngot");
	
	public static final Item CocoHelmet = (new CC_ItemCocoArmor(CocoHelmetID, COCO, 5, 0)).setIconCoord(8,1).setItemName("CocoHelmet");
	public static final Item CocoPlate = (new CC_ItemCocoArmor(CocoPlateID, COCO, 5, 1)).setIconCoord(9,1).setItemName("CocoPlate");
	public static final Item CocoLegs = (new CC_ItemCocoArmor(CocoLegsID, COCO, 5, 2)).setIconCoord(10,1).setItemName("CocoLegs");
	public static final Item CocoBoots = (new CC_ItemCocoArmor(CocoBootsID, COCO, 5, 3)).setIconCoord(11,1).setItemName("CocoBoots");
	
	public static final Item MithrilHelmet = (new CC_ItemMithrilArmor(MithrilHelmetID, MITHRIL, 6, 0)).setIconCoord(12,1).setItemName("CocoHelmet1");
	public static final Item MithrilPlate = (new CC_ItemMithrilArmor(MithrilPlateID, MITHRIL, 6, 1)).setIconCoord(13,1).setItemName("CocoPlate2");
	public static final Item MithrilLegs = (new CC_ItemMithrilArmor(MithrilLegsID, MITHRIL, 6, 2)).setIconCoord(14,1).setItemName("CocoLegs3");
	public static final Item MithrilBoots = (new CC_ItemMithrilArmor(MithrilBootsID, MITHRIL, 6, 3)).setIconCoord(15,1).setItemName("CocoBoots4");
	
	public static final Item SilverHelmet = (new CC_ItemSilverArmor(SilverHelmetID, SILVER, 7, 0)).setIconCoord(0,2).setItemName("CocoHelmet12");
	public static final Item SilverPlate = (new CC_ItemSilverArmor(SilverPlateID, SILVER, 7, 1)).setIconCoord(1,2).setItemName("CocoPlate22");
	public static final Item SilverLegs = (new CC_ItemSilverArmor(SilverLegsID, SILVER, 7, 2)).setIconCoord(2,2).setItemName("CocoLegs32");
	public static final Item SilverBoots = (new CC_ItemSilverArmor(SilverBootsID, SILVER, 7, 3)).setIconCoord(3,2).setItemName("CocoBoots42");
	
	public static final Item AmethystHelmet = (new CC_ItemAmethystArmor(AmethystHelmetID, AMETHYST, 8, 0)).setIconCoord(4,2).setItemName("1CocoHelmet12");
	public static final Item AmethystPlate = (new CC_ItemAmethystArmor(AmethystPlateID, AMETHYST, 8, 1)).setIconCoord(5,2).setItemName("1CocoPlate22");
	public static final Item AmethystLegs = (new CC_ItemAmethystArmor(AmethystLegsID, AMETHYST, 8, 2)).setIconCoord(6,2).setItemName("1CocoLegs32");
	public static final Item AmethystBoots = (new CC_ItemAmethystArmor(AmethystBootsID, AMETHYST, 8, 3)).setIconCoord(7,2).setItemName("1CocoBoots42");
	
	public static final Item Alloy = (new CC_Item(AlloyID)).setIconCoord(8,2).setItemName("Alloy");
	public static final Item CompressedAlloy = (new CC_Item(CompressedAlloyID)).setIconCoord(9,2).setItemName("CompressedAlloy");
	public static final Item ExtremeAlloy = (new CC_Item(ExtremeAlloyID)).setIconCoord(10,2).setItemName("ExtremeAlloy");
	public static final Item UncExtremeAlloy = (new CC_Item(UncExtremeAlloyID)).setIconCoord(11,2).setItemName("UncExtremeAlloy");
	
	public static final Item AlloyHelmet = (new CC_ItemAlloyArmor(AlloyHelmetID, ALLOY, 9, 0)).setIconCoord(12,2).setItemName("AlloyHelmet");
	public static final Item AlloyPlate = (new CC_ItemAlloyArmor(AlloyPlateID, ALLOY, 9, 1)).setIconCoord(13,2).setItemName("AlloyChesst");
	public static final Item AlloyLegs = (new CC_ItemAlloyArmor(AlloyLegsID, ALLOY, 9, 2)).setIconCoord(14,2).setItemName("AlloyLegs");
	public static final Item AlloyBoots = (new CC_ItemAlloyArmor(AlloyBootsID, ALLOY, 9, 3)).setIconCoord(15,2).setItemName("AlloyBoots");
	
	public static final Item ExtremeAlloyHelmet = (new CC_ItemExtremeAlloyArmor(ExtremeAlloyHelmetID, EXTREMEALLOY, 10, 0)).setIconCoord(0,3).setItemName("ExtremeAlloyHelmet");
	public static final Item ExtremeAlloyPlate = (new CC_ItemExtremeAlloyArmor(ExtremeAlloyPlateID, EXTREMEALLOY, 10, 1)).setIconCoord(1,3).setItemName("ExtremeAlloyChesst");
	public static final Item ExtremeAlloyLegs = (new CC_ItemExtremeAlloyArmor(ExtremeAlloyLegsID, EXTREMEALLOY, 10, 2)).setIconCoord(2,3).setItemName("ExtremeAlloyLegs");
	public static final Item ExtremeAlloyBoots = (new CC_ItemExtremeAlloyArmor(ExtremeAlloyBootsID, EXTREMEALLOY, 10, 3)).setIconCoord(3,3).setItemName("ExtremeAlloyBoots");
	
	public static final ItemFood ChocoPork = (ItemFood)(new CC_Food(ChocoPorkID, 5, 1, false)).setIconCoord(4,3).setItemName("ChocoPork");
	public static final ItemFood CookedChocoPork = (ItemFood)(new CC_Food(CookedChocoPorkID, 8, 1, false)).setIconCoord(5,3).setItemName("CookedChocoPork");
	
	public static final Item CocoaMesh = (new CC_Item(CocoaMeshID)).setIconCoord(6,3).setItemName("CocoaMesh");
	public static final Item CocoaPowder = (new CC_Item(CocoaPowderID)).setIconCoord(8,3).setItemName("CocoaPowder");
	
	public static final ItemFood ChocolateMilk = (ItemFood)(new CC_ChoclateMilk(ChocolateMilkID, 2, 1, false)).setIconCoord(10,3).setItemName("ChocolateMilk");
	public static final ItemFood HotChocolateMilk = (ItemFood)(new CC_ChoclateMilk(HotChocolateMilkID, 4, 1, false)).setIconCoord(11,3).setItemName("HotChocolateMilk");
	
	public static final ItemFood ChocoBeef = (ItemFood)(new CC_Food(ChocoBeefID, 6, 1, false)).setIconCoord(12,3).setItemName("ChocoSteak");
	public static final ItemFood ChocoSteak = (ItemFood)(new CC_Food(ChocoSteakID, 9, 1, false)).setIconCoord(13,3).setItemName("ChocoCteak");
	
	//public static final Item BookOfTime = (new CC_BookOfTime(BookOfTimeID)).setIconCoord(14,3).setItemName("BookOfTime");
	//public static final Item BookOfHealing = (new CC_BookOfHealing(BookOfHealingID)).setIconCoord(15,3).setItemName("BookOfHealing");
	//public static final Item BookOfExp = (new CC_BookOfExp(BookOfExpID)).setIconCoord(0,4).setItemName("BookOfHunger");
		
	public static final Item MagicDust = (new CC_Item(MagicDustID)).setIconCoord(1,4).setItemName("MagicDust");
	public static final Item EarthEssence = (new CC_Item(EarthEssenceID)).setIconCoord(2,4).setItemName("EarthEssence");
	public static final Item FireEssence = (new CC_Item(FireEssenceID)).setIconCoord(3,4).setItemName("FireEssence");
	public static final Item WaterEssence = (new CC_Item(WaterEssenceID)).setIconCoord(4,4).setItemName("WaterEssence");
	public static final Item WindEssence = (new CC_Item(WindEssenceID)).setIconCoord(5,4).setItemName("WindEssence");

	public static final Item IronDust = (new CC_Item(IronDustID)).setIconCoord(6,4).setItemName("IronDust");
	public static final Item GoldDust = (new CC_Item(GoldDustID)).setIconCoord(7,4).setItemName("GoldDust");
	public static final Item SilverDust = (new CC_Item(SilverDustID)).setIconCoord(8,4).setItemName("SilverDust");
	public static final Item MithrilDust = (new CC_Item(MithrilDustID)).setIconCoord(9,4).setItemName("MithrilDust");
	public static final Item CoalDust = (new CC_Item(CoalDustID)).setIconCoord(10,4).setItemName("CoalDust");
	
	public static final Item MixedIronDust = (new CC_Item(MixedIronDustID)).setIconCoord(11, 4).setItemName("MixedIronDust");
	public static final Item UnworkedSteelIngot = (new CC_Item(UnworkedSteelID)).setIconCoord(12,4).setItemName("UnworkedSteel");
	public static final Item SteelIngot = (new CC_Item(SteelIngotID)).setIconCoord(13,4).setItemName("SteelIngot");
	public static final Item Hammer = (new CC_ItemHammer(HammerID)).setIconCoord(9,3).setItemName("Hammer");
	
	public static final Item SteelPickaxe = (new CC_Pickaxe(SteelPickaxeID, toolSTEEL)).setIconCoord(15, 4).setItemName("SteelPickaxe");
	public static final Item SteelAxe = (new CC_Axe(SteelAxeID, toolSTEEL)).setIconCoord(0, 5).setItemName("SteelAxe");
	public static final Item SteelShovel = (new CC_Shovel(SteelShovelID, toolSTEEL)).setIconCoord(1, 5).setItemName("SteelShovel");
	public static final Item SteelSword = (new CC_Sword(SteelSwordID, toolSTEEL)).setIconCoord(2, 5).setItemName("SteelSWord");
	public static final Item SteelHoe = (new CC_Hoe(SteelHoeID, toolSTEEL)).setIconCoord(3, 5).setItemName("SteelHoe");
	
	public static final Item ObsidianDust = (new CC_Item(ObsidianDustID)).setIconCoord(4, 5).setItemName("ObisidianDust");
	public static final Item ObsidianIngot = (new CC_Item(ObsidianIngotID)).setIconCoord(5, 5).setItemName("ObisidianIngot");
	
	public static final Item ObsidianMultiTool = (new CC_ObsidianTool(ObsidianToolID, toolOBSIDIAN)).setIconCoord(6, 5).setItemName("ObsidianTool").setNoRepair();
	public static final Item DiamondStick = (new CC_Item(DiamondStickID)).setIconCoord(7, 5).setItemName("ObsidianStick");
	
	public static final Item DragonEggShard = (new CC_ItemShard(DragonShardID)).setIconCoord(8, 5).setItemName("DragonEggShard");
	
	public static final Item DragonStonePickaxe = (new CC_Pickaxe(DragonStonePickaxeID, toolDRAGON)).setIconCoord(9, 5).setItemName("DragonStonePickaxe");
	public static final Item DragonStoneAxe = (new CC_Axe(DragonStoneAxeID, toolDRAGON)).setIconCoord(10, 5).setItemName("DragonAxe");
	public static final Item DragonStoneShovel = (new CC_Shovel(DragonStoneShovelID, toolDRAGON)).setIconCoord(11, 5).setItemName("DragonShovel");
	public static final Item DragonStoneSword = (new CC_Sword(DragonStoneSwordID, toolDRAGON)).setIconCoord(12, 5).setItemName("DragonStoneSword");
	public static final Item DragonStoneHoe = (new CC_Hoe(DragonStoneHoeID, toolDRAGON)).setIconCoord(13, 5).setItemName("DragonStoneHoe");
	
	private static mod_CocoCraft instance;
	public static mod_CocoCraft getInstance(){return instance;}
			
	public mod_CocoCraft() {
		
		MinecraftForge.setGuiHandler(this, this);
		ModLoader.setInGameHook(this, true, true);
		
		instance = this;
	
	ModLoader.registerBlock(CocoStone);
	ModLoader.registerBlock(MithrilOre);
	ModLoader.registerBlock(SilverOre);
	ModLoader.registerBlock(Amethyst);
	
	ModLoader.registerBlock(CocoBlock);
	ModLoader.registerBlock(MithrilBlock);
	ModLoader.registerBlock(SilverBlock);
	ModLoader.registerBlock(AmethystBlock);
	
	ModLoader.registerBlock(CocoaFlower);
	ModLoader.registerBlock(SuperStone);
	ModLoader.registerBlock(CocoReed);
	ModLoader.registerBlock(Essence);		
	ModLoader.registerBlock(Crusher);
	ModLoader.registerBlock(Compressor);
	ModLoader.registerBlock(SilverFurnace);
	
	ModLoader.registerTileEntity(net.minecraft.src.CocoCraft.Misc.TileEntityCrusher.class, "Crusher");
	ModLoader.registerTileEntity(net.minecraft.src.CocoCraft.Misc.TileEntityCompressor.class, "Compressor");
	ModLoader.registerTileEntity(net.minecraft.src.CocoCraft.Misc.TileEntitySilverFurnace.class, "SilverFurnace");
	
	Hammer.setContainerItem(Hammer);
	
	
	ModLoader.addRecipe(new ItemStack(CocoBlock, 1), new Object[] {"111", "111", "111", Character.valueOf('1'), CocoIngot});
	ModLoader.addShapelessRecipe(new ItemStack(CocoIngot, 9), new Object[] {CocoBlock});
	ModLoader.addRecipe(new ItemStack(MithrilBlock, 1), new Object[] {"111", "111", "111", Character.valueOf('1'), MithrilIngot});
	ModLoader.addShapelessRecipe(new ItemStack(MithrilIngot, 9), new Object[] {MithrilBlock});
	ModLoader.addRecipe(new ItemStack(SilverBlock, 1), new Object[] {"111", "111", "111", Character.valueOf('1'), SilverIngot});
	ModLoader.addShapelessRecipe(new ItemStack(SilverIngot, 9), new Object[] {SilverBlock});
	ModLoader.addRecipe(new ItemStack(AmethystBlock, 1), new Object[] {"111", "111", "111", Character.valueOf('1'), AmethystGem});
	ModLoader.addShapelessRecipe(new ItemStack(AmethystGem, 9), new Object[] {AmethystBlock});
	
	ModLoader.addShapelessRecipe(new ItemStack(SteelIngot, 1), new Object[]{Hammer, UnworkedSteelIngot});
	ModLoader.addShapelessRecipe(new ItemStack(MixedIronDust, 1), new Object[]{CoalDust, CoalDust, IronDust});
	ModLoader.addShapelessRecipe(new ItemStack(ObsidianIngot, 1), new Object[]{ObsidianDust, ObsidianDust, ObsidianDust});
	ModLoader.addShapelessRecipe(new ItemStack(DragonEggShard, 11), new Object[]{Block.dragonEgg});
	
	ModLoader.addRecipe(new ItemStack(CocoPickaxe, 1), new Object[] {"111", " 2 ", " 2 ", Character.valueOf('1'), CocoIngot, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(CocoSword, 1), new Object[] {" 1 ", " 1 ", " 2 ", Character.valueOf('1'), CocoIngot, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(CocoShovel, 1), new Object[] {" 1 ", " 2 ", " 2 ", Character.valueOf('1'), CocoIngot, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(CocoAxe, 1), new Object[] {" 11", " 21", " 2 ", Character.valueOf('1'), CocoIngot, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(CocoHoe, 1), new Object[] {" 11", " 2 ", " 2 ", Character.valueOf('1'), CocoIngot, Character.valueOf('2'), Item.stick});
	
	ModLoader.addRecipe(new ItemStack(MithrilPickaxe, 1), new Object[] {"111", " 2 ", " 2 ", Character.valueOf('1'), MithrilIngot, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(MithrilSword, 1), new Object[] {" 1 ", " 1 ", " 2 ", Character.valueOf('1'), MithrilIngot, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(MithrilShovel, 1), new Object[] {" 1 ", " 2 ", " 2 ", Character.valueOf('1'), MithrilIngot, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(MithrilAxe, 1), new Object[] {" 11", " 21", " 2 ", Character.valueOf('1'), MithrilIngot, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(MithrilHoe, 1), new Object[] {" 11", " 2 ", " 2 ", Character.valueOf('1'), MithrilIngot, Character.valueOf('2'), Item.stick});
	
	ModLoader.addRecipe(new ItemStack(SilverPickaxe, 1), new Object[] {"111", " 2 ", " 2 ", Character.valueOf('1'), SilverIngot, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(SilverSword, 1), new Object[] {" 1 ", " 1 ", " 2 ", Character.valueOf('1'), SilverIngot, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(SilverShovel, 1), new Object[] {" 1 ", " 2 ", " 2 ", Character.valueOf('1'), SilverIngot, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(SilverAxe, 1), new Object[] {" 11", " 21", " 2 ", Character.valueOf('1'), SilverIngot, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(SilverHoe, 1), new Object[] {" 11", " 2 ", " 2 ", Character.valueOf('1'), SilverIngot, Character.valueOf('2'), Item.stick});
	
	ModLoader.addRecipe(new ItemStack(AmethystPickaxe, 1), new Object[] {"111", " 2 ", " 2 ", Character.valueOf('1'), AmethystGem, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(AmethystSword, 1), new Object[] {" 1 ", " 1 ", " 2 ", Character.valueOf('1'), AmethystGem, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(AmethystShovel, 1), new Object[] {" 1 ", " 2 ", " 2 ", Character.valueOf('1'), AmethystGem, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(AmethystAxe, 1), new Object[] {" 11", " 21", " 2 ", Character.valueOf('1'), AmethystGem, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(AmethystHoe, 1), new Object[] {" 11", " 2 ", " 2 ", Character.valueOf('1'), AmethystGem, Character.valueOf('2'), Item.stick});
	
	ModLoader.addRecipe(new ItemStack(CocoPlate, 1), new Object[] {"1 1", "111", "111", Character.valueOf('1'), CocoIngot});
	ModLoader.addRecipe(new ItemStack(CocoLegs, 1), new Object[] {"111", "1 1", "1 1", Character.valueOf('1'), CocoIngot});
	ModLoader.addRecipe(new ItemStack(CocoBoots, 1), new Object[] {"1 1", "1 1", Character.valueOf('1'), CocoIngot});
	ModLoader.addRecipe(new ItemStack(CocoHelmet, 1), new Object[] {"111", "1 1", Character.valueOf('1'), CocoIngot});
	
	ModLoader.addRecipe(new ItemStack(MithrilPlate, 1), new Object[] {"1 1", "111", "111", Character.valueOf('1'), MithrilIngot});
	ModLoader.addRecipe(new ItemStack(MithrilLegs, 1), new Object[] {"111", "1 1", "1 1", Character.valueOf('1'), MithrilIngot});
	ModLoader.addRecipe(new ItemStack(MithrilBoots, 1), new Object[] {"1 1", "1 1", Character.valueOf('1'), MithrilIngot});
	ModLoader.addRecipe(new ItemStack(MithrilHelmet, 1), new Object[] {"111", "1 1", Character.valueOf('1'), MithrilIngot});
	
	ModLoader.addRecipe(new ItemStack(SilverPlate, 1), new Object[] {"1 1", "111", "111", Character.valueOf('1'), SilverIngot});
	ModLoader.addRecipe(new ItemStack(SilverLegs, 1), new Object[] {"111", "1 1", "1 1", Character.valueOf('1'), SilverIngot});
	ModLoader.addRecipe(new ItemStack(SilverBoots, 1), new Object[] {"1 1", "1 1", Character.valueOf('1'), SilverIngot});
	ModLoader.addRecipe(new ItemStack(SilverHelmet, 1), new Object[] {"111", "1 1", Character.valueOf('1'), SilverIngot});
	
	ModLoader.addRecipe(new ItemStack(AmethystPlate, 1), new Object[] {"1 1", "111", "111", Character.valueOf('1'), AmethystGem});
	ModLoader.addRecipe(new ItemStack(AmethystLegs, 1), new Object[] {"111", "1 1", "1 1", Character.valueOf('1'), AmethystGem});
	ModLoader.addRecipe(new ItemStack(AmethystBoots, 1), new Object[] {"1 1", "1 1", Character.valueOf('1'), AmethystGem});																																														
	ModLoader.addRecipe(new ItemStack(AmethystHelmet, 1), new Object[] {"111", "1 1", Character.valueOf('1'), AmethystGem});
	
	ModLoader.addRecipe(new ItemStack(AlloyPlate, 1), new Object[] {"1 1", "111", "111", Character.valueOf('1'), CompressedAlloy});
	ModLoader.addRecipe(new ItemStack(AlloyLegs, 1), new Object[] {"111", "1 1", "1 1", Character.valueOf('1'), CompressedAlloy});
	ModLoader.addRecipe(new ItemStack(AlloyBoots, 1), new Object[] {"1 1", "1 1", Character.valueOf('1'), CompressedAlloy});																																														
	ModLoader.addRecipe(new ItemStack(AlloyHelmet, 1), new Object[] {"111", "1 1", Character.valueOf('1'), CompressedAlloy});

	ModLoader.addRecipe(new ItemStack(ExtremeAlloyPlate, 1), new Object[] {"1 1", "111", "111", Character.valueOf('1'), ExtremeAlloy});
	ModLoader.addRecipe(new ItemStack(ExtremeAlloyLegs, 1), new Object[] {"111", "1 1", "1 1", Character.valueOf('1'), ExtremeAlloy});
	ModLoader.addRecipe(new ItemStack(ExtremeAlloyBoots, 1), new Object[] {"1 1", "1 1", Character.valueOf('1'), ExtremeAlloy});																																														
	ModLoader.addRecipe(new ItemStack(ExtremeAlloyHelmet, 1), new Object[] {"111", "1 1", Character.valueOf('1'), ExtremeAlloy});

	ModLoader.addRecipe(new ItemStack(Alloy, 2), new Object[] {"123", "454" , "321" ,  Character.valueOf('1'), SilverIngot, Character.valueOf('2'), CocoIngot, Character.valueOf('3'), MithrilIngot, Character.valueOf('4'), AmethystGem, Character.valueOf('5'), Item.diamond});
	ModLoader.addRecipe(new ItemStack(Alloy, 2), new Object[] {"321", "454" , "123" ,  Character.valueOf('1'), SilverIngot, Character.valueOf('2'), CocoIngot, Character.valueOf('3'), MithrilIngot, Character.valueOf('4'), AmethystGem, Character.valueOf('5'), Item.diamond});
	ModLoader.addRecipe(new ItemStack(UncExtremeAlloy, 1), new Object[] {"111", "121" , "111" ,  Character.valueOf('1'), Item.diamond, Character.valueOf('2'), CompressedAlloy});
	
	ModLoader.addRecipe(new ItemStack(CocoaMesh, 2), new Object[] {"111", "111", "111", Character.valueOf('1'), CocoaFlower});
	ModLoader.addRecipe(new ItemStack(SuperStone, 3), new Object[] {"131", " 2 ", "131", Character.valueOf('1'), Block.blockLapis, Character.valueOf('2'), Block.stone, Character.valueOf('3'), Item.diamond});
	
	ModLoader.addRecipe(new ItemStack(ChocolateMilk, 1), new Object[] {"1 ", "2 ", Character.valueOf('1'), CocoaPowder, Character.valueOf('2'), Item.bucketMilk});
	
	ModLoader.addRecipe(new ItemStack(EarthEssence, 2), new Object[]{"131", "323", "131", Character.valueOf('1'), Block.slowSand, Character.valueOf('2'), WindEssence, Character.valueOf('3'), Block.dirt});
	ModLoader.addRecipe(new ItemStack(WaterEssence, 2), new Object[]{" 3 ", "323", " 3 ",  Character.valueOf('2'), WindEssence, Character.valueOf('3'), Item.bucketWater});
	ModLoader.addRecipe(new ItemStack(FireEssence, 2), new Object[]{"131", "323", "131", Character.valueOf('1'), Item.flintAndSteel ,Character.valueOf('2'), WindEssence, Character.valueOf('3'), Item.bucketWater});
	
	ModLoader.addRecipe(new ItemStack(MagicDust, 4), new Object[]{"121", "232", "121", Character.valueOf('1'), Item.redstone, Character.valueOf('2'), Item.gunpowder, Character.valueOf('3'), Item.sugar});
	
	//ModLoader.addRecipe(new ItemStack(BookOfTime, 1), new Object[]{"232", "212", "232", Character.valueOf('1'), Item.book, Character.valueOf('2'), WindEssence, Character.valueOf('3'), Item.gunpowder});
	//ModLoader.addRecipe(new ItemStack(BookOfHealing, 1), new Object[]{"232", "212", "232", Character.valueOf('1'), Item.book, Character.valueOf('2'), EarthEssence, Character.valueOf('3'), MagicDust});
	//ModLoader.addRecipe(new ItemStack(BookOfExp, 1), new Object[]{"232", "212", "232", Character.valueOf('1'), Item.book, Character.valueOf('2'), Item.bucketLava, Character.valueOf('3'), Item.ingotIron});
	
	ModLoader.addRecipe(new ItemStack(Crusher, 1), new Object[]{"121", "131", "141", Character.valueOf('1'), SuperStone, Character.valueOf('2'), Item.flint, Character.valueOf('3'), MagicDust, Character.valueOf('4'), Item.diamond});
	ModLoader.addRecipe(new ItemStack(Compressor, 1), new Object[] {"121", "131", "121", Character.valueOf('1'), SuperStone, Character.valueOf('2'), Item.ingotIron, Character.valueOf('3'), Alloy});
	ModLoader.addRecipe(new ItemStack(SilverFurnace, 1), new Object[] {"111", "121", "111", Character.valueOf('1'), SilverBlock, Character.valueOf('2'), Block.blockSteel});
	
	ModLoader.addRecipe(new ItemStack(Hammer,1 ), new Object[]{"111", "121", " 1 ", Character.valueOf('1'), Block.stone, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(SteelPickaxe, 1), new Object[] {"111", " 2 ", " 2 ", Character.valueOf('1'), SteelIngot, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(SteelSword, 1), new Object[] {" 1 ", " 1 ", " 2 ", Character.valueOf('1'), SteelIngot, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(SteelShovel, 1), new Object[] {" 1 ", " 2 ", " 2 ", Character.valueOf('1'), SteelIngot, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(SteelAxe, 1), new Object[] {" 11", " 21", " 2 ", Character.valueOf('1'), SteelIngot, Character.valueOf('2'), Item.stick});
	ModLoader.addRecipe(new ItemStack(SteelHoe, 1), new Object[] {" 11", " 2 ", " 2 ", Character.valueOf('1'), SteelIngot, Character.valueOf('2'), Item.stick});
	
	ModLoader.addRecipe(new ItemStack(ObsidianMultiTool, 1), new Object[] {"111", "121", "121", Character.valueOf('1'), ObsidianIngot, Character.valueOf('2'), DiamondStick});
	ModLoader.addRecipe(new ItemStack(DiamondStick, 2), new Object[] {"1 ", " 1", Character.valueOf('1'), Item.diamond});
	
	ModLoader.addRecipe(new ItemStack(DragonStonePickaxe, 1), new Object[] {"111", " 2 ", " 2 ", Character.valueOf('1'), DragonEggShard, Character.valueOf('2'), mod_CocoCraft.DiamondStick});
	ModLoader.addRecipe(new ItemStack(DragonStoneSword, 1), new Object[] {" 1 ", " 1 ", " 2 ", Character.valueOf('1'), DragonEggShard, Character.valueOf('2'), mod_CocoCraft.DiamondStick});
	ModLoader.addRecipe(new ItemStack(DragonStoneShovel, 1), new Object[] {" 1 ", " 2 ", " 2 ", Character.valueOf('1'), DragonEggShard, Character.valueOf('2'), mod_CocoCraft.DiamondStick});
	ModLoader.addRecipe(new ItemStack(DragonStoneAxe, 1), new Object[] {" 11", " 21", " 2 ", Character.valueOf('1'), DragonEggShard, Character.valueOf('2'), mod_CocoCraft.DiamondStick});
	ModLoader.addRecipe(new ItemStack(DragonStoneHoe, 1), new Object[] {" 11", " 2 ", " 2 ", Character.valueOf('1'), DragonEggShard, Character.valueOf('2'), mod_CocoCraft.DiamondStick});
	
	
	////Debug
	//ModLoader.addRecipe(new ItemStack(BookOfTime, 1), new Object[]{"1 ", "  ", Character.valueOf('1'), Block.dirt});
	//ModLoader.addRecipe(new ItemStack(BookOfHealing, 1), new Object[]{" 1", "  ", Character.valueOf('1'), Block.planks});
	//ModLoader.addRecipe(new ItemStack(BookOfExp, 1), new Object[]{"11", "1 ", Character.valueOf('1'), Block.planks});	
	//ModLoader.addRecipe(new ItemStack(ObsidianMultiTool, 1), new Object[]{"11", "1 ", Character.valueOf('1'), Block.planks});	
	
		
	ModLoader.addSmelting(CocoStone.blockID, new ItemStack(CocoIngot,1));
	ModLoader.addSmelting(MithrilOre.blockID, new ItemStack(MithrilIngot,1));
	ModLoader.addSmelting(SilverOre.blockID, new ItemStack(SilverIngot,1));
	
	
	ModLoader.addSmelting(ChocoPork.shiftedIndex, new ItemStack(CookedChocoPork,1));
	ModLoader.addSmelting(ChocolateMilk.shiftedIndex, new ItemStack(HotChocolateMilk, 1));
	ModLoader.addSmelting(ChocoBeef.shiftedIndex, new ItemStack(ChocoSteak,1));
	
	ModLoader.addSmelting(IronDust.shiftedIndex, new ItemStack(Item.ingotIron,1));
	ModLoader.addSmelting(GoldDust.shiftedIndex, new ItemStack(Item.ingotGold,1));
	ModLoader.addSmelting(MithrilDust.shiftedIndex, new ItemStack(MithrilIngot,1));
	ModLoader.addSmelting(SilverDust.shiftedIndex, new ItemStack(SilverIngot,1));
	
	ModLoader.registerEntityID(EntityChocoPig.class, "ChocoPig", 104);
	ModLoader.addSpawn(EntityChocoPig.class, 20, 3, 4, EnumCreatureType.creature);
	
	ModLoader.registerEntityID(EntityChocoCow.class, "ChocoCow", 105);
	ModLoader.addSpawn(EntityChocoCow.class, 20, 3, 4, EnumCreatureType.creature);
	
	
	}
	public void generateSurface(World world, Random rand, int baseX, int baseZ)
	{
	for(int x=0; x <8; x++)
	{
		int Xcoord = baseX + rand.nextInt(16);
		int Ycoord = rand.nextInt(20);
		int Zcoord = baseZ + rand.nextInt(16);
		(new WorldGenMinable(CocoStone.blockID, 3)).generate(world,rand, Xcoord, Ycoord, Zcoord);
	}
	for(int x=0; x <11; x++)
	{
		int Xcoord = baseX + rand.nextInt(16);
		int Ycoord = rand.nextInt(48);
		int Zcoord = baseZ + rand.nextInt(16);
		(new WorldGenMinable(MithrilOre.blockID, 5)).generate(world,rand, Xcoord, Ycoord, Zcoord);
	}
	for(int x=0; x <11; x++)
	{
		int Xcoord = baseX + rand.nextInt(16);
		int Ycoord = rand.nextInt(40);
		int Zcoord = baseZ + rand.nextInt(16);
		(new WorldGenMinable(SilverOre.blockID, 6)).generate(world,rand, Xcoord, Ycoord, Zcoord);
	}
	for(int x=0; x <9; x++)
	{
		int Xcoord = baseX + rand.nextInt(16);
		int Ycoord = rand.nextInt(15);
		int Zcoord = baseZ + rand.nextInt(16);
		(new WorldGenMinable(Amethyst.blockID, 3)).generate(world,rand, Xcoord, Ycoord, Zcoord);
	}
	for(int x=0; x <11; x++)
	{
		int Xcoord = baseX + rand.nextInt(16);
		int Ycoord = rand.nextInt(52);
		int Zcoord = baseZ + rand.nextInt(16);
		(new WorldGenMinable(Essence.blockID, 5)).generate(world,rand, Xcoord, Ycoord, Zcoord);
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
                        world.setBlock(baseX + l, i1 + 1, baseZ + k, CocoReed.blockID);
                    }
                    if(j1 == 1)
                    {
                        world.setBlock(baseX + l, i1 + 1, baseZ + k, CocoReed.blockID);
                        world.setBlock(baseX + l, i1 + 2, baseZ + k, CocoReed.blockID);
                    }
                    if(j1 == 2)
                    {
                        world.setBlock(baseX + l, i1 + 1, baseZ + k, CocoReed.blockID);
                        world.setBlock(baseX + l, i1 + 2, baseZ + k, CocoReed.blockID);
                        world.setBlock(baseX + l, i1 + 3, baseZ + k, CocoReed.blockID);
                    }
                                        if(j1 == 3)
                    {
                        world.setBlock(baseX + l, i1 + 1, baseZ + k, CocoReed.blockID);
                        world.setBlock(baseX + l, i1 + 2, baseZ + k, CocoReed.blockID);
                        world.setBlock(baseX + l, i1 + 3, baseZ + k, CocoReed.blockID);
                                                world.setBlock(baseX + l, i1 + 4, baseZ + k, CocoReed.blockID);
                    }
                }

            }

        }
        
        
    
  
    }
	
	//public void addRenderer(Map map)
	//{
	//	map.put(net.minecraft.src.CocoCraft.Mobs.EntityChocoPig.class, new net.minecraft.src.CocoCraft.Mobs.RenderChocoPig(new net.minecraft.src.CocoCraft.Mobs.ModelChocoPig(), null, 0.5F));
	//	map.put(net.minecraft.src.CocoCraft.Mobs.EntityChocoCow.class, new net.minecraft.src.CocoCraft.Mobs.RenderChocoCow(new net.minecraft.src.CocoCraft.Mobs.ModelChocoCow(), 0.5F));
	//}
	
	
    public void load() {
    	
	    MinecraftForge.setToolClass(CocoPickaxe, "pickaxe", 2); 
	    MinecraftForge.setToolClass(CocoShovel, "shovel", 2); 
	    MinecraftForge.setToolClass(CocoAxe, "axe", 2);
	    MinecraftForge.setToolClass(CocoSword, "sword", 2);
	    MinecraftForge.setToolClass(CocoHoe, "hoe", 2);
	    
	    MinecraftForge.setToolClass(MithrilPickaxe, "pickaxe", 2); 
	    MinecraftForge.setToolClass(MithrilShovel, "shovel", 2); 
	    MinecraftForge.setToolClass(MithrilAxe, "axe", 2);
	    MinecraftForge.setToolClass(MithrilSword, "sword", 2);
	    MinecraftForge.setToolClass(MithrilHoe, "hoe", 2);
	    
	    MinecraftForge.setToolClass(SilverPickaxe, "pickaxe", 2); 
	    MinecraftForge.setToolClass(SilverShovel, "shovel", 2); 
	    MinecraftForge.setToolClass(SilverAxe, "axe", 2);
	    MinecraftForge.setToolClass(SilverSword, "sword", 2);
	    MinecraftForge.setToolClass(SilverHoe, "hoe", 2);
	    
	    MinecraftForge.setToolClass(AmethystPickaxe, "pickaxe", 2); 
	    MinecraftForge.setToolClass(AmethystShovel, "shovel", 2); 
	    MinecraftForge.setToolClass(AmethystAxe, "axe", 2);
	    MinecraftForge.setToolClass(AmethystSword, "sword", 2);
	    MinecraftForge.setToolClass(AmethystHoe, "hoe", 2);
	    
	    MinecraftForge.setToolClass(SteelPickaxe, "pickaxe", 2); 
	    MinecraftForge.setToolClass(SteelShovel, "shovel", 2); 
	    MinecraftForge.setToolClass(SteelAxe, "axe", 2);
	    MinecraftForge.setToolClass(SteelSword, "sword", 2);
	    MinecraftForge.setToolClass(SteelHoe, "hoe", 2);
	    
	    MinecraftForge.setToolClass(DragonStonePickaxe, "pickaxe", 2); 
	    MinecraftForge.setToolClass(DragonStoneShovel, "shovel", 2); 
	    MinecraftForge.setToolClass(DragonStoneAxe, "axe", 2);
	    MinecraftForge.setToolClass(DragonStoneSword, "sword", 2);
	    MinecraftForge.setToolClass(DragonStoneHoe, "hoe", 2);
	    
	    MinecraftForge.setToolClass(ObsidianMultiTool, "multitool", 2);
	    
	    
    }    
    
    
    
    
    public static int configurationProperties(Configuration config)
    {
    	configuration.load();
    	CocoStoneID = Integer.parseInt(configuration.getOrCreateBlockIdProperty( "CocoStoneID" , 170).value);	
    	MithrilOreID = Integer.parseInt(configuration.getOrCreateBlockIdProperty( "MithrilOreID" , 171).value);	
    	SilverOreID = Integer.parseInt(configuration.getOrCreateBlockIdProperty( "SilverOreID" , 172).value);	
    	AmethystID = Integer.parseInt(configuration.getOrCreateBlockIdProperty( "AmethystID" , 173).value);	
    	CocoBlockID = Integer.parseInt(configuration.getOrCreateBlockIdProperty( "CocoBlockID" , 174).value);	
    	MithrilBlockID = Integer.parseInt(configuration.getOrCreateBlockIdProperty( "MithrilBlockID" , 175).value);	
    	SilverBlockID = Integer.parseInt(configuration.getOrCreateBlockIdProperty( "SilverBlockID" , 176).value);	
    	AmethystBlockID = Integer.parseInt(configuration.getOrCreateBlockIdProperty( "AmethystBlockID" , 177).value);	
    	CocoaFlowerID = Integer.parseInt(configuration.getOrCreateBlockIdProperty( "CocoaFlowerID" , 178).value);	
    	SuperStoneID = Integer.parseInt(configuration.getOrCreateBlockIdProperty( "SuperStoneID" , 179).value);	
    	CocoReedID = Integer.parseInt(configuration.getOrCreateBlockIdProperty( "CocoReedID" , 180).value);	
    	EssenceID = Integer.parseInt(configuration.getOrCreateBlockIdProperty( "EssenceID" , 181).value);	
    	CrusherID = Integer.parseInt(configuration.getOrCreateBlockIdProperty( "CrusherID" , 182).value);
    	CompressorID = Integer.parseInt(configuration.getOrCreateBlockIdProperty( "CompressorID" , 183).value);
    	SilverFurnaceID = Integer.parseInt(configuration.getOrCreateBlockIdProperty( "SilverFurnaceID" , 184).value);
    	
    	
    	AmethystGemID = Integer.parseInt(configuration.getOrCreateIntProperty("AmethystGemID", config.CATEGORY_ITEM, 450).value);
    	CocoPickaxeID = Integer.parseInt(configuration.getOrCreateIntProperty("CocoPickaxeID", config.CATEGORY_ITEM, 451).value);
    	CocoAxeID = Integer.parseInt(configuration.getOrCreateIntProperty("CocoAxeID", config.CATEGORY_ITEM, 452).value);
    	CocoShovelID = Integer.parseInt(configuration.getOrCreateIntProperty("CocoShovelID", config.CATEGORY_ITEM, 453).value);
    	CocoSwordID = Integer.parseInt(configuration.getOrCreateIntProperty("CocoSwordID", config.CATEGORY_ITEM, 454).value);
    	CocoHoeID = Integer.parseInt(configuration.getOrCreateIntProperty("CocoHoeID", config.CATEGORY_ITEM, 455).value);
    	
    	MithrilPickaxeID = Integer.parseInt(configuration.getOrCreateIntProperty("MithrilPickaxeID", config.CATEGORY_ITEM, 456).value);
    	MithrilAxeID = Integer.parseInt(configuration.getOrCreateIntProperty("MithrilAxeID", config.CATEGORY_ITEM, 457).value);
    	MithrilShovelID = Integer.parseInt(configuration.getOrCreateIntProperty("MithrilShovelID", config.CATEGORY_ITEM, 458).value);
    	MithrilSwordID = Integer.parseInt(configuration.getOrCreateIntProperty("MithrilSwordID", config.CATEGORY_ITEM, 459).value);
    	MithrilHoeID = Integer.parseInt(configuration.getOrCreateIntProperty("MithrilHoeID", config.CATEGORY_ITEM, 460).value);
    	
    	SilverPickaxeID = Integer.parseInt(configuration.getOrCreateIntProperty("SilverPickaxeID", config.CATEGORY_ITEM, 461).value);
    	SilverAxeID = Integer.parseInt(configuration.getOrCreateIntProperty("SilverAxeID", config.CATEGORY_ITEM, 462).value);
    	SilverShovelID = Integer.parseInt(configuration.getOrCreateIntProperty("SilverShovelID", config.CATEGORY_ITEM, 463).value);
    	SilverSwordID = Integer.parseInt(configuration.getOrCreateIntProperty("SilverSwordID", config.CATEGORY_ITEM, 464).value);
    	SilverHoeID = Integer.parseInt(configuration.getOrCreateIntProperty("SilverHoeID", config.CATEGORY_ITEM, 465).value);
    	
    	AmethystPickaxeID = Integer.parseInt(configuration.getOrCreateIntProperty("AmethystPickaxeID", config.CATEGORY_ITEM, 466).value);
    	AmethystAxeID = Integer.parseInt(configuration.getOrCreateIntProperty("AmethystAxeID", config.CATEGORY_ITEM, 467).value);
    	AmethystShovelID = Integer.parseInt(configuration.getOrCreateIntProperty("AmethystShovelID", config.CATEGORY_ITEM, 468).value);
    	AmethystSwordID = Integer.parseInt(configuration.getOrCreateIntProperty("AmethystSwordID", config.CATEGORY_ITEM, 469).value);
    	AmethystHoeID = Integer.parseInt(configuration.getOrCreateIntProperty("AmethystHoeID", config.CATEGORY_ITEM, 470).value);
    	
    	CocoIngotID = Integer.parseInt(configuration.getOrCreateIntProperty("CocoIngotID", config.CATEGORY_ITEM, 471).value);
    	MithrilIngotID = Integer.parseInt(configuration.getOrCreateIntProperty("MithrilIngotID", config.CATEGORY_ITEM, 472).value);
    	SilverIngotID = Integer.parseInt(configuration.getOrCreateIntProperty("SilverIngotID", config.CATEGORY_ITEM, 473).value);
    	
    	CocoHelmetID = Integer.parseInt(configuration.getOrCreateIntProperty("CocoHelmetID", config.CATEGORY_ITEM, 474).value);
    	CocoPlateID = Integer.parseInt(configuration.getOrCreateIntProperty("CocoPlateID", config.CATEGORY_ITEM, 475).value);
    	CocoLegsID = Integer.parseInt(configuration.getOrCreateIntProperty("CocoLegsID", config.CATEGORY_ITEM, 476).value);
    	CocoBootsID = Integer.parseInt(configuration.getOrCreateIntProperty("CocoBootsID", config.CATEGORY_ITEM, 477).value);
    	
    	MithrilHelmetID = Integer.parseInt(configuration.getOrCreateIntProperty("MithrilHelmetID", config.CATEGORY_ITEM, 478).value);
    	MithrilPlateID = Integer.parseInt(configuration.getOrCreateIntProperty("MithrilPlateID", config.CATEGORY_ITEM, 479).value);
    	MithrilLegsID = Integer.parseInt(configuration.getOrCreateIntProperty("MithrilLegsID", config.CATEGORY_ITEM, 480).value);
    	MithrilBootsID = Integer.parseInt(configuration.getOrCreateIntProperty("MithrilBootsID", config.CATEGORY_ITEM, 481).value);
    	
    	SilverHelmetID = Integer.parseInt(configuration.getOrCreateIntProperty("SilverHelmetID", config.CATEGORY_ITEM, 482).value);
    	SilverPlateID = Integer.parseInt(configuration.getOrCreateIntProperty("SilverPlateID", config.CATEGORY_ITEM, 483).value);
    	SilverLegsID = Integer.parseInt(configuration.getOrCreateIntProperty("SilverLegsID", config.CATEGORY_ITEM, 484).value);
    	SilverBootsID = Integer.parseInt(configuration.getOrCreateIntProperty("SilverBootsID", config.CATEGORY_ITEM, 485).value);
    	
    	AmethystHelmetID = Integer.parseInt(configuration.getOrCreateIntProperty("AmethystHelmetID", config.CATEGORY_ITEM, 486).value);																							
    	AmethystPlateID = Integer.parseInt(configuration.getOrCreateIntProperty("AmethystPlateID", config.CATEGORY_ITEM, 487).value);
    	AmethystLegsID = Integer.parseInt(configuration.getOrCreateIntProperty("AmethystLegsID", config.CATEGORY_ITEM, 488).value);
    	AmethystBootsID = Integer.parseInt(configuration.getOrCreateIntProperty("AmethystBootsID", config.CATEGORY_ITEM, 489).value);
    	
    	AlloyID = Integer.parseInt(configuration.getOrCreateIntProperty("AlloyID", config.CATEGORY_ITEM, 490).value);
    	CompressedAlloyID = Integer.parseInt(configuration.getOrCreateIntProperty("CompressedAlloyID", config.CATEGORY_ITEM, 491).value);
    	ExtremeAlloyID = Integer.parseInt(configuration.getOrCreateIntProperty("ExtremeAlloyID", config.CATEGORY_ITEM, 492).value);
    	UncExtremeAlloyID = Integer.parseInt(configuration.getOrCreateIntProperty("UncookedExtrmeAlloyID", config.CATEGORY_ITEM, 493).value);
    	
    	AlloyHelmetID = Integer.parseInt(configuration.getOrCreateIntProperty("AlloyHelmetID", config.CATEGORY_ITEM, 494).value);																							
    	AlloyPlateID = Integer.parseInt(configuration.getOrCreateIntProperty("AlloyPlateID", config.CATEGORY_ITEM, 495).value);
    	AlloyLegsID = Integer.parseInt(configuration.getOrCreateIntProperty("AlloyLegsID", config.CATEGORY_ITEM, 496).value);
    	AlloyBootsID = Integer.parseInt(configuration.getOrCreateIntProperty("AlloyBootsID", config.CATEGORY_ITEM, 497).value);
    	
    	ExtremeAlloyHelmetID = Integer.parseInt(configuration.getOrCreateIntProperty("ExtremeAlloyHelmetID", config.CATEGORY_ITEM, 498).value);																							
    	ExtremeAlloyPlateID = Integer.parseInt(configuration.getOrCreateIntProperty("ExtremeAlloyPlateID", config.CATEGORY_ITEM, 499).value);
    	ExtremeAlloyLegsID = Integer.parseInt(configuration.getOrCreateIntProperty("ExtremeAlloyLegsID", config.CATEGORY_ITEM, 500).value);
    	ExtremeAlloyBootsID = Integer.parseInt(configuration.getOrCreateIntProperty("ExtremeAlloyBootsID", config.CATEGORY_ITEM, 501).value);
    	
    	ChocoPorkID = Integer.parseInt(configuration.getOrCreateIntProperty("ChocoPorkID", config.CATEGORY_ITEM, 502).value);																							
    	CookedChocoPorkID = Integer.parseInt(configuration.getOrCreateIntProperty("CookedChocoPorkID", config.CATEGORY_ITEM, 503).value);
    	
    	CocoaMeshID = Integer.parseInt(configuration.getOrCreateIntProperty("CocoaMeshID", config.CATEGORY_ITEM, 504).value);
    	CocoaPowderID = Integer.parseInt(configuration.getOrCreateIntProperty("CocoaPowderID", config.CATEGORY_ITEM, 505).value);
    	
    	ChocolateMilkID = Integer.parseInt(configuration.getOrCreateIntProperty("ChocolateMilkID", config.CATEGORY_ITEM, 506).value);
    	HotChocolateMilkID = Integer.parseInt(configuration.getOrCreateIntProperty("HotChocolateMilkID", config.CATEGORY_ITEM, 507).value);
    	
    	ChocoBeefID = Integer.parseInt(configuration.getOrCreateIntProperty("ChocoBeefID", config.CATEGORY_ITEM, 508).value);
    	ChocoSteakID = Integer.parseInt(configuration.getOrCreateIntProperty("ChocoSteakID", config.CATEGORY_ITEM, 509).value);
    	
    	BookOfTimeID = Integer.parseInt(configuration.getOrCreateIntProperty("BookOfTimeID", config.CATEGORY_ITEM, 510).value);
    	BookOfHealingID = Integer.parseInt(configuration.getOrCreateIntProperty("BookOfHealingID", config.CATEGORY_ITEM, 511).value);
    	BookOfExpID = Integer.parseInt(configuration.getOrCreateIntProperty("BookOfExpID", config.CATEGORY_ITEM, 512).value);
    	
    	MagicDustID = Integer.parseInt(configuration.getOrCreateIntProperty("MagicDustID", config.CATEGORY_ITEM, 600).value);
    	EarthEssenceID = Integer.parseInt(configuration.getOrCreateIntProperty("EarthEssenceID", config.CATEGORY_ITEM, 601).value);
    	FireEssenceID = Integer.parseInt(configuration.getOrCreateIntProperty("FireEssenceID", config.CATEGORY_ITEM, 602).value);
    	WaterEssenceID = Integer.parseInt(configuration.getOrCreateIntProperty("WaterEssenceID", config.CATEGORY_ITEM, 603).value);
    	WindEssenceID = Integer.parseInt(configuration.getOrCreateIntProperty("WindEssenceID", config.CATEGORY_ITEM, 604).value);
    	
    	IronDustID = Integer.parseInt(configuration.getOrCreateIntProperty("IronDustID", config.CATEGORY_ITEM, 605).value);
    	GoldDustID = Integer.parseInt(configuration.getOrCreateIntProperty("GoldDustID", config.CATEGORY_ITEM, 606).value);
    	SilverDustID = Integer.parseInt(configuration.getOrCreateIntProperty("SilverDustID", config.CATEGORY_ITEM, 607).value);
    	MithrilDustID = Integer.parseInt(configuration.getOrCreateIntProperty("MithrilDustID", config.CATEGORY_ITEM, 608).value);
    	CoalDustID = Integer.parseInt(configuration.getOrCreateIntProperty("CoalDustID", config.CATEGORY_ITEM, 609).value);
    	
    	MixedIronDustID = Integer.parseInt(configuration.getOrCreateIntProperty("MixedIronDustID", config.CATEGORY_ITEM, 610).value);
    	UnworkedSteelID = Integer.parseInt(configuration.getOrCreateIntProperty("UnworkedSteelID", config.CATEGORY_ITEM, 611).value);
    	SteelIngotID = Integer.parseInt(configuration.getOrCreateIntProperty("SteelIngotID", config.CATEGORY_ITEM, 612).value);
    	HammerID = Integer.parseInt(configuration.getOrCreateIntProperty("HammerID", config.CATEGORY_ITEM, 613).value);
    	
    	SteelPickaxeID = Integer.parseInt(configuration.getOrCreateIntProperty("SteelPickaxeID", config.CATEGORY_ITEM, 614).value);
    	SteelAxeID = Integer.parseInt(configuration.getOrCreateIntProperty("SteelAxeID", config.CATEGORY_ITEM, 615).value);
    	SteelShovelID = Integer.parseInt(configuration.getOrCreateIntProperty("SteelShovelID", config.CATEGORY_ITEM, 616).value);
    	SteelSwordID = Integer.parseInt(configuration.getOrCreateIntProperty("SteelSwordID", config.CATEGORY_ITEM, 617).value);
    	SteelHoeID = Integer.parseInt(configuration.getOrCreateIntProperty("SteelHoeID", config.CATEGORY_ITEM, 618).value);
    	
    	ObsidianDustID = Integer.parseInt(configuration.getOrCreateIntProperty("ObsidianDustID", config.CATEGORY_ITEM, 619).value);
    	ObsidianIngotID = Integer.parseInt(configuration.getOrCreateIntProperty("ObsidianIngotID", config.CATEGORY_ITEM, 620).value);
    	ObsidianToolID = Integer.parseInt(configuration.getOrCreateIntProperty("ObsidianToolID", config.CATEGORY_ITEM, 621).value);
    	DiamondStickID = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondStickID", config.CATEGORY_ITEM, 622).value);
    	
    	DragonStonePickaxeID = Integer.parseInt(configuration.getOrCreateIntProperty("DragonStonePickaxeID", config.CATEGORY_ITEM, 623).value);
    	DragonStoneAxeID = Integer.parseInt(configuration.getOrCreateIntProperty("DragonStoneAxeID", config.CATEGORY_ITEM, 624).value);
    	DragonStoneShovelID = Integer.parseInt(configuration.getOrCreateIntProperty("DragonStoneShovelID", config.CATEGORY_ITEM, 625).value);
    	DragonStoneSwordID = Integer.parseInt(configuration.getOrCreateIntProperty("DragonStoneSwordID", config.CATEGORY_ITEM, 626).value);
    	DragonStoneHoeID = Integer.parseInt(configuration.getOrCreateIntProperty("DragonStoneHoeID", config.CATEGORY_ITEM, 627).value);
    	DragonShardID = Integer.parseInt(configuration.getOrCreateIntProperty("DragonShardID", config.CATEGORY_ITEM, 628).value);
    	
    	
    	configuration.save();	
    		return CocoStoneID;

	

    }
    @Override
    public String getVersion(){
    	return "CocoCraft v1.9.7";
    }
    
	@Override
	public boolean clientSideRequired() {
		
		return true;
	}

	@Override
	public Object getGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		
		
		if(tile != null)
		{
			switch(ID)
			{
			case 0 : return new ContainerCrusher(player.inventory, ((net.minecraft.src.CocoCraft.Misc.TileEntityCrusher)tile));
			case 1 : return new ContainerCompressor(player.inventory, ((net.minecraft.src.CocoCraft.Misc.TileEntityCompressor)tile));
			case 2 : return new ContainerSilverFurnace(player.inventory, ((net.minecraft.src.CocoCraft.Misc.TileEntitySilverFurnace)tile));
			}
		}
		
		return null;
	}
}



