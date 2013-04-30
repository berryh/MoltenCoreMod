package berryh.moltencore.common;

import forestry.api.core.ItemInterface;
import forestry.api.fuels.EngineCopperFuel;
import forestry.api.fuels.FuelManager;
import forestry.api.recipes.RecipeManagers;
import ic2.api.Ic2Recipes;
import ic2.api.Items;
import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.liquids.LiquidContainerData;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;


@Mod(modid = "MoltenCoreMod", name = "Molten Core Mod", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)


public class MoltenCoreMain {
	
	public static Item hardenedtin;
	public static Item unmoltencorecenter;
	public static Item unmoltencore;
	public static Item moltencore;
	public static Item moltencorePickaxe;
	public static Item moltencoreShovel;
	public static Item stabilizedBottle;
	public static Item mysticalBottle;
	public static Item teleporter;
	public static Item sugarySodiumNitrate;
	public static Item sodiumNitrate;
	public static Item sugarBeetRoot;
	public static Item moltencoreSword;
	public static Item moltencoreHoe;
	public static Item moltencoreAxe;
	public static Item kerogenBucket;
	public static Item kerogen;
	
	//public static Item moltencoreSapler;
	public static Item moltencoreMultiTool;
	
	public static Block sodiumNitrateOre;
	public static Block sugarySodiumNitrateBlock;
	public static Block sugarBeetBlock;
	public static Block burnedSugarySodiumNitrateBlock;

	public static int moltencorePickaxeID;
	public static int moltencoreShovelID;
	public static int moltencoreID;
	public static int unmoltencoreID;
	public static int unmoltencorecenterID;
	public static int hardenedtinID;
	public static int stabilizedBottleID;
	public static int mysticalBottleID;
	public static int teleporterID;
	public static int sodiumNitrateOreID;
	public static int sugarySodiumNitrateID;
	public static int sodiumNitrateID;
	public static int sugarySodiumNitrateBlockID;
	public static int sugarBeetRootID;
	public static int sugarBeetBlockID;
	public static int burnedSugarySodiumNitrateBlockID;
	public static int moltencoreSwordID;
	public static int moltencoreHoeID;
	public static int moltencoreAxeID;
	public static int kerogenID;
	public static int kerogenBucketID;
	
	//public static int moltencoreSaplerID;
	public static int moltencoreMultiToolID;
	
	public static boolean ic2 = false;
	public static boolean forestry = false;
	public static boolean buildcraft = false;

	public static ChunkCoordinates current;
	
	public static Logger logger;
	
	public static LiquidStack kerogenLiquid;
	
	
	
	final EnumToolMaterial MoltenCore = EnumHelper.addToolMaterial("MOLTENCORE", 3, 15000, 30F, 50, 250);
	
	//Beta
	final EnumToolMaterial ADJ = EnumHelper.addToolMaterial("ADJ", 1, 500, 8F, 20, 125);
	
	
	@Instance("MoltenCoreMod")
	public static MoltenCoreMain instance;
	
	@SidedProxy(clientSide="berryh.moltencore.client.MoltenCoreClientProxy", serverSide="berryh.moltencore.common.MoltenCoreCommonProxy")
	public static MoltenCoreCommonProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		
		//Register The Textures
		proxy.registerRenderInformation();
		
		//Register The Handlers
		proxy.registerHandlers();
		
		//Getting The Logger
		logger = Logger.getLogger("MoltenCoreMod");
		logger.setParent(FMLLog.getLogger());
		
		//Load The Configs And ID's
		logger.fine("Loading Configurations");
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		moltencorePickaxeID = config.getItem(Configuration.CATEGORY_ITEM,"MoltenCorePickaxe",22000).getInt();
		moltencoreShovelID = config.getItem(Configuration.CATEGORY_ITEM,"MoltenCoreShovel",22001).getInt();
		moltencoreID = config.getItem(Configuration.CATEGORY_ITEM,"MoltenCore",22002).getInt();
		unmoltencoreID = config.getItem(Configuration.CATEGORY_ITEM,"UnmoltenCore",22003).getInt();
		unmoltencorecenterID = config.getItem(Configuration.CATEGORY_ITEM,"UnmoltenCoreCenter",22004).getInt();
		hardenedtinID = config.getItem(Configuration.CATEGORY_ITEM,"HardenedTin",22005).getInt();
		stabilizedBottleID = config.getItem(Configuration.CATEGORY_ITEM,"StabilizedBottle",22006).getInt();
		mysticalBottleID = config.getItem(Configuration.CATEGORY_ITEM,"MysticalBottle",22007).getInt();
		teleporterID = config.getItem(Configuration.CATEGORY_ITEM,"Teleporter",22008).getInt();
		sugarySodiumNitrateID = config.getItem(Configuration.CATEGORY_ITEM,"SugarySodiumNitrate",22009).getInt();
		sodiumNitrateID = config.getItem(Configuration.CATEGORY_ITEM,"SodiumNitrate",22010).getInt();
		sugarBeetRootID = config.getItem(Configuration.CATEGORY_ITEM,"SugarBeetRoot",22011).getInt();
		moltencoreSwordID = config.getItem(Configuration.CATEGORY_ITEM, "MoltenCoreSword",22012).getInt();
		moltencoreHoeID = config.getItem(Configuration.CATEGORY_ITEM, "MoltenCoreHoe",22013).getInt();
		moltencoreAxeID = config.getItem(Configuration.CATEGORY_ITEM, "MoltenCoreAxe",22014).getInt();
		kerogenID = config.getItem(Configuration.CATEGORY_ITEM, "Kerogen", 22015).getInt();
		kerogenBucketID = config.getItem(Configuration.CATEGORY_ITEM, "KerogenBucket", 22016).getInt();
		//moltencoreSaplerID = config.getItem(Configuration.CATEGORY_ITEM, "MoltenCoreSapler",22015).getInt();
		moltencoreMultiToolID = config.getItem(Configuration.CATEGORY_ITEM, "MoltenCoreMultiTool", 22017).getInt();
		
		sodiumNitrateOreID = config.getBlock(Configuration.CATEGORY_BLOCK,"SodiumNitrateOre",1000).getInt();
		sugarySodiumNitrateBlockID = config.getBlock(Configuration.CATEGORY_BLOCK,"SugarySodiumNitrateBlock",1001).getInt();
		sugarBeetBlockID = config.getBlock(Configuration.CATEGORY_BLOCK,"SugarBeet",1002).getInt();
		burnedSugarySodiumNitrateBlockID = config.getBlock(Configuration.CATEGORY_BLOCK, "BurnedSugarySodiumNitrateBlock",1003).getInt();
		//Property forestryconfig = config.get("AdditionalRecipes", "ForestryRecipes", false);
		//Property ic2config = config.get("AdditionalRecipes", "IC2Recipes", false);
		
		//forestryconfig.comment = "Extra Forestry Crafting Options";
		//ic2config.comment = "Extra IC2 Crafting Options";
		
		config.save();
		logger.fine("Configurations Loaded");
		
		//forestry = Boolean.parseBoolean(forestryconfig.value);
		//ic2 = Boolean.parseBoolean(ic2config.value);		
		
		//Create The Items
		hardenedtin = (new Itemhardenedtin(hardenedtinID)).setIconIndex(0).setItemName("hardenedtin");
		unmoltencorecenter = (new Itemunmoltencorecenter(unmoltencorecenterID)).setIconIndex(1).setItemName("unmoltencorecenter");
		unmoltencore = (new Itemunmoltencore(unmoltencoreID)).setIconIndex(2).setItemName("unmoltencore");
		moltencore = (new Itemmoltencore(moltencoreID)).setIconIndex(3).setItemName("moltencore");
		moltencorePickaxe = (new ToolMoltenCorePickaxe(moltencorePickaxeID, MoltenCore)).setIconIndex(4).setItemName("moltencorePickaxe");
		moltencoreShovel = (new ToolMoltenCoreSpade(moltencoreShovelID, MoltenCore)).setIconIndex(5).setItemName("moltencoreShovel");
		stabilizedBottle = (new ItemstabilizedBottle(stabilizedBottleID)).setIconIndex(9).setItemName("stabilizedBottle");
		mysticalBottle = (new ItemmysticalBottle(mysticalBottleID)).setIconIndex(10).setItemName("mysticalBottle");
		teleporter = (new Itemteleporter(teleporterID)).setIconIndex(11).setItemName("teleporter");
		sugarySodiumNitrate = (new ItemsugarySodiumNitrate(sugarySodiumNitrateID)).setIconIndex(13).setItemName("sugarySodiumNitrate");
		sodiumNitrate = (new ItemsodiumNitrate(sodiumNitrateID)).setIconIndex(12).setItemName("sodiumNitrate");
		moltencoreSword = (new ToolMoltenCoreSword(moltencoreSwordID, MoltenCore)).setIconIndex(15).setItemName("moltencoreSword");
		moltencoreHoe = (new ToolMoltenCoreHoe(moltencoreHoeID, MoltenCore)).setIconIndex(17).setItemName("moltencoreHoe");
		moltencoreAxe = (new ToolMoltenCoreAxe(moltencoreAxeID, MoltenCore)).setIconIndex(16).setItemName("moltencoreAxe");
		kerogen = (new Itemkerogen(kerogenID)).setIconIndex(18).setItemName("kerogen");
		kerogenBucket = (new ItemkerogenBucket(kerogenBucketID)).setIconIndex(19).setItemName("kerogenBucket");
		//moltencoreSapler = (new ItemMoltenCoreSapler(moltencoreSaplerID)).setIconIndex(18).setItemName("moltencoreSapler");
		moltencoreMultiTool = (new ToolMoltenCoreMultiTool(moltencoreMultiToolID, ADJ)).setIconIndex(20).setFull3D();
		
		//Create The Blocks
		sugarBeetBlock = new BlocksugarBeetBlock(sugarBeetBlockID,3).setStepSound(Block.soundGrassFootstep).setHardness(0.0F).setBlockName("sugarBeetBlock");
		sugarBeetRoot = new ItemsugarBeetRoot(sugarBeetRootID,sugarBeetBlock.blockID,Block.tilledField.blockID).setIconIndex(14).setItemName("sugarBeetRoot");
		burnedSugarySodiumNitrateBlock = new BlockburnedSugarySodiumNitrateBlock(burnedSugarySodiumNitrateBlockID,5).setBlockName("burnedSugarySodiumNitrateBlock").setHardness(2F).setResistance(2F);
		sodiumNitrateOre = new BlocksodiumNitrate(sodiumNitrateOreID,1).setHardness(3F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setBlockName("sodiumNitrateOre");
		sugarySodiumNitrateBlock = new BlocksugarySodiumNitrateBlock(sugarySodiumNitrateBlockID,2).setHardness(1.5F).setResistance(20F).setStepSound(Block.soundStoneFootstep).setBlockName("sugarySodiumNitrateBlock");
		
		
		
		//Register The Blocks
		GameRegistry.registerBlock(sodiumNitrateOre);
		GameRegistry.registerBlock(sugarySodiumNitrateBlock);
		GameRegistry.registerBlock(sugarBeetBlock);
		GameRegistry.registerBlock(burnedSugarySodiumNitrateBlock);
		
		//Register Tile Entities

		
		//Register The Names
		LanguageRegistry.addName(moltencorePickaxe, "Molten Core Pickaxe");
		LanguageRegistry.addName(moltencoreShovel, "Molten Core Shovel");
		LanguageRegistry.addName(hardenedtin, "Hardened Tin");
		LanguageRegistry.addName(unmoltencorecenter, "Unmolten Core Center");
		LanguageRegistry.addName(unmoltencore, "Unmolten Core");
		LanguageRegistry.addName(moltencore, "Molten Core");
		LanguageRegistry.addName(stabilizedBottle,"Stabilized Bottle");
		LanguageRegistry.addName(mysticalBottle, "Mystical Bottle");
		LanguageRegistry.addName(teleporter, "Teleporter");
		LanguageRegistry.addName(sodiumNitrateOre, "Sodium Nitrate Ore");
		LanguageRegistry.addName(sugarySodiumNitrate, "Sugary Sodium Nitrate");
		LanguageRegistry.addName(sodiumNitrate, "Sodium Nitrate");
		LanguageRegistry.addName(sugarySodiumNitrateBlock, "Sugary Sodium Nitrate Block");
		LanguageRegistry.addName(sugarBeetBlock,"Sugar Beet");
		LanguageRegistry.addName(sugarBeetRoot, "Sugar Beet Root");
		LanguageRegistry.addName(burnedSugarySodiumNitrateBlock,"Burned Sugary Sodium Nitrate Block");
		LanguageRegistry.addName(moltencoreAxe, "Molten Core Axe");
		LanguageRegistry.addName(moltencoreHoe, "Molten Core Hoe");
		LanguageRegistry.addName(moltencoreSword, "Molten Core Sword");
		//LanguageRegistry.addName(moltencoreSapler, "Molten Core Sapler");
		LanguageRegistry.addName(moltencoreMultiTool, "Molten Core MultiTool");
		LanguageRegistry.addName(kerogen, "Kerogen");
		LanguageRegistry.addName(kerogenBucket, "Bucket of Kerogen");
		
		//Register The Items And Blocks In The Ore Dictionary
		OreDictionary.registerOre("ingotHardenedtin", new ItemStack(hardenedtin));
		OreDictionary.registerOre("ingotUnmoltencorecenter", new ItemStack(unmoltencorecenter));
		OreDictionary.registerOre("ingotUnmoltencore", new ItemStack(unmoltencore));
		OreDictionary.registerOre("ingotMoltencore", new ItemStack(moltencore));
		OreDictionary.registerOre("oreSodiumNitrate", new ItemStack(sodiumNitrateOre));
		OreDictionary.registerOre("sodiumNitrate", new ItemStack(sodiumNitrate));
		OreDictionary.registerOre("lava", new ItemStack(Item.bucketLava));
		
		//Register The Liquids
		kerogenLiquid = LiquidDictionary.getOrCreateLiquid("Kerogen", new LiquidStack(kerogen,1));
		LiquidContainerRegistry.registerLiquid(new LiquidContainerData(LiquidDictionary.getLiquid("Kerogen", LiquidContainerRegistry.BUCKET_VOLUME),new ItemStack(kerogenBucket), new ItemStack(Item.bucketEmpty)));
		
		//Set Special Harvest Levels
		MinecraftForge.setBlockHarvestLevel(sodiumNitrateOre, "pickaxe", 2);
		
		//Register Tools
		MinecraftForge.setToolClass(moltencorePickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(moltencoreShovel, "shovel",3);
		MinecraftForge.setToolClass(moltencoreAxe, "axe", 3);
		
		//Just Testing
		GameRegistry.registerCraftingHandler(new MoltenCoreCraftingHandler());
		MinecraftForge.EVENT_BUS.register(new MoltenCoreEventHandler());
		GameRegistry.registerFuelHandler(new MoltenCoreFuelHandler());
		
		
	}

	@Init
	public void init(FMLInitializationEvent event) {
		
		//Starting Compatibility Check
		proxy.checkCompatibility();
		
		//Register TextureFX
		proxy.registerTextureFX();
		
		//Register Crafting Recipes
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe((new ItemStack(hardenedtin,1)), true, new Object[]{" C ","CTC"," C ", Character.valueOf('C'), Item.coal, Character.valueOf('T'), "ingotTin"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe((new ItemStack(unmoltencorecenter,1)), true, new Object[]{"###","#L#","###", Character.valueOf('#'), hardenedtin, Character.valueOf('L'),"lava"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe((new ItemStack(unmoltencore,1)), true, new Object[]{"###","#L#","###", Character.valueOf('#'), hardenedtin, Character.valueOf('L'),unmoltencorecenter}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(moltencorePickaxe, true, new Object[]{"###"," W "," W ", Character.valueOf('#'), moltencore, Character.valueOf('W'), Item.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(moltencoreShovel, true, new Object[]{" # "," W "," W ", Character.valueOf('#'), moltencore, Character.valueOf('W'), Item.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe((new ItemStack(teleporter,1)),true, new Object[]{"###","#D#","###", Character.valueOf('#'), Item.ingotIron, Character.valueOf('D'), Item.diamond}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe((new ItemStack(stabilizedBottle,1)),true,new Object[]{"#B#"," # ", Character.valueOf('#'), Item.ingotIron, Character.valueOf('B'), Item.glassBottle}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe((new ItemStack(sugarySodiumNitrate,1)),new Object[]{Item.sugar,sodiumNitrate}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe((new ItemStack(Block.torchWood,8)),true,new Object[]{"#","T",Character.valueOf('#'), sugarySodiumNitrate,Character.valueOf('T'), Item.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe((new ItemStack(sugarySodiumNitrateBlock,1)),true,new Object[]{"###","###","###",Character.valueOf('#'), sugarySodiumNitrate}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe((new ItemStack(sugarySodiumNitrate,9)),new Object[]{sugarySodiumNitrateBlock}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe((new ItemStack(sugarBeetRoot,2)),new Object[]{Item.sugar}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe((new ItemStack(moltencoreSword,1)),new Object[]{"M","M","S", Character.valueOf('M'), moltencore, Character.valueOf('S'), Item.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe((new ItemStack(moltencoreAxe,1)),new Object[]{"MM","MS"," S", Character.valueOf('M'), moltencore, Character.valueOf('S'), Item.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe((new ItemStack(moltencoreHoe,1)),new Object[]{"MM"," S"," S", Character.valueOf('M'), moltencore, Character.valueOf('S'), Item.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe((new ItemStack(moltencoreAxe,1)),new Object[]{" MM"," SM"," S ", Character.valueOf('M'), moltencore, Character.valueOf('S'), Item.stick}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe((new ItemStack(moltencoreHoe,1)),new Object[]{" MM"," S "," S ", Character.valueOf('M'), moltencore, Character.valueOf('S'), Item.stick}));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe((new ItemStack(moltencoreMultiTool,1)),new Object[]{"MMM","MSM"," S ", Character.valueOf('M'), moltencore, Character.valueOf('S'), Item.ingotIron}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe((new ItemStack(moltencoreMultiTool,1)),new Object[]{(new ItemStack(moltencoreMultiTool,-1,-1)),Item.diamond}));
		
		//Register Enchanted Version Of Pickaxe
		ItemStack enchantedPickaxe = new ItemStack(moltencorePickaxe);
		enchantedPickaxe.addEnchantment(Enchantment.fortune, 10);
		enchantedPickaxe.addEnchantment(Enchantment.efficiency, 10);
		enchantedPickaxe.addEnchantment(Enchantment.unbreaking, 10);
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(enchantedPickaxe,true,new Object[]{"DBD","DPD","DBD",Character.valueOf('D'),Block.blockDiamond,Character.valueOf('B'),mysticalBottle,Character.valueOf('P'),new ItemStack(moltencorePickaxe,1,-1)}));
		
		//Register Furnace Recipes
		FurnaceRecipes.smelting().addSmelting(this.unmoltencore.itemID, new ItemStack(this.moltencore,1), 150);
		FurnaceRecipes.smelting().addSmelting(this.sugarySodiumNitrateBlock.blockID, new ItemStack(this.burnedSugarySodiumNitrateBlock,1), 150);
		
		//Register Compatibility Recipes
		if(ic2){
			OreDictionary.registerOre(OreDictionary.getOreID("lava"), Items.getItem("lavaCell"));
		}
		if(forestry){
			OreDictionary.registerOre(OreDictionary.getOreID("lava"), ItemInterface.getItem("canLava"));
			OreDictionary.registerOre(OreDictionary.getOreID("lava"), ItemInterface.getItem("refractoryLava"));
			FuelManager.copperEngineFuel.put(new ItemStack(sugarySodiumNitrate),new EngineCopperFuel(new ItemStack(sugarySodiumNitrate),10,60000));
			//FuelManager.fermenterFuel.put(new ItemStack(sodiumNitrate), new FermenterFuel(new ItemStack(sodiumNitrate),500,1000));
			
		}
		GameRegistry.registerWorldGenerator(new WorldGeneratorMoltenCore());
		
		
		
	}

	@PostInit
	public static void postInit(FMLPostInitializationEvent event) {
		
		if(ic2){
			ItemStack Resin = Items.getItem("resin");
			ItemStack recipeResin = Resin.copy();
			recipeResin.stackSize = 9;
			Ic2Recipes.addMatterAmplifier(new ItemStack(sodiumNitrate), 100000);
			Ic2Recipes.addMaceratorRecipe((new ItemStack(burnedSugarySodiumNitrateBlock,1)), recipeResin);
			Ic2Recipes.addCompressorRecipe((new ItemStack(Item.rottenFlesh,8)), (new ItemStack(Item.beefCooked,1)));
		}
		if(forestry){
			RecipeManagers.fermenterManager.addRecipe((new ItemStack(sodiumNitrate)),500,10.0f,(new LiquidStack(ItemInterface.getItem("liquidBiomass").itemID,1)),(new LiquidStack(Block.waterStill,1)));
			RecipeManagers.fermenterManager.addRecipe((new ItemStack(Item.rottenFlesh)),500,1.0f,(new LiquidStack(ItemInterface.getItem("liquidBiomass").itemID,1)),(new LiquidStack(Block.waterStill,1)));
			RecipeManagers.fermenterManager.addRecipe((new ItemStack(Item.rottenFlesh)), 500, 1.0f, (new LiquidStack(kerogen,1)),(new LiquidStack(Block.lavaStill,2)));
			RecipeManagers.fermenterManager.addRecipe((new ItemStack(Item.beefRaw)), 500, 1.0f, (new LiquidStack(kerogen,1)),(new LiquidStack(Block.lavaStill,2)));
			RecipeManagers.fermenterManager.addRecipe((new ItemStack(Item.porkRaw)), 500, 1.0f, (new LiquidStack(kerogen,1)),(new LiquidStack(Block.lavaStill,2)));
			
			RecipeManagers.stillManager.addRecipe(100, (new LiquidStack(kerogen,10)), (LiquidDictionary.getLiquid("Oil", 5)));
		}
		
		
		
		

		//String[] names = OreDictionary.getOreNames();
		//for(int i=0;i<names.length;i++){
		//	System.out.println(names[i]);
		//}
		//System.out.println(OreDictionary.getOreName(17));
		//System.out.println(OreDictionary.getOreID("lava"));
		
	}
	

	public static void goHome(World world, EntityPlayer entityplayer){
		ChunkCoordinates home = entityplayer.getBedLocation();
        if (home == null){
        	home = world.getSpawnPoint();
        }
        Side side = FMLCommonHandler.instance().getEffectiveSide();
		if(side == Side.SERVER){
			EntityPlayerMP player = (EntityPlayerMP)entityplayer;
			int i;
	        for (i = 126; i > 16 && !world.isBlockNormalCube(home.posX, i, home.posZ) && !world.isBlockNormalCube(home.posX, i + 1, home.posZ); i--)
	        {}
	        
	        player.spawnExplosionParticle();
	        player.capabilities.disableDamage = true;
	        player.setPosition(home.posX + 0.5D, i + 3, home.posZ + 0.5D);
	        player.spawnExplosionParticle();
	        player.capabilities.disableDamage = false;
		}else if(side == Side.CLIENT){
			EntityClientPlayerMP player = (EntityClientPlayerMP)entityplayer;
			int i;
	        for (i = 126; i > 16 && !world.isBlockNormalCube(home.posX, i, home.posZ) && !world.isBlockNormalCube(home.posX, i + 1, home.posZ); i--)
	        {}
	        
	        player.spawnExplosionParticle();
	        player.capabilities.disableDamage = true;
	        player.setPosition(home.posX + 0.5D, i + 3, home.posZ + 0.5D);
	        player.spawnExplosionParticle();
	        player.capabilities.disableDamage = false;
		}
	}
	
	public static void goCurrent(World world, EntityPlayer entityplayer){
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		if(side == Side.SERVER){
			EntityPlayerMP player = (EntityPlayerMP)entityplayer;
			if(MoltenCoreMain.current != null){
				player.capabilities.disableDamage = true;
				player.spawnExplosionParticle();
				player.setPosition(MoltenCoreMain.current.posX + 0.5D, MoltenCoreMain.current.posY + 0.5D, MoltenCoreMain.current.posZ + 0.5D);
				player.spawnExplosionParticle();
				player.capabilities.disableDamage = false;
			}
		}else if(side == Side.CLIENT){
			EntityClientPlayerMP player = (EntityClientPlayerMP)entityplayer;
			if(MoltenCoreMain.current != null){
				player.capabilities.disableDamage = true;
				player.spawnExplosionParticle();
				player.setPosition(MoltenCoreMain.current.posX + 0.5D, MoltenCoreMain.current.posY + 0.5D, MoltenCoreMain.current.posZ + 0.5D);
				player.spawnExplosionParticle();
				player.capabilities.disableDamage = false;
			}
		}
	}
	
	public static void setCurrentPos(EntityPlayer entityplayer){
		current = entityplayer.getPlayerCoordinates();
	}
	
	
	
}