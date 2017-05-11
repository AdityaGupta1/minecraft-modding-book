package org.devoxx4kids.forge.mods;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
	public static final String MODID = "MyMods";
	public static final String VERSION = "2.0";

	public static Block enderBlock;
	public static Item enderIngot;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());
		MinecraftForge.EVENT_BUS.register(new ExplodingMinecarts());
		MinecraftForge.EVENT_BUS.register(new ExplodingAnvils());
		MinecraftForge.EVENT_BUS.register(new DiamondOreTrap());
		MinecraftForge.EVENT_BUS.register(new BiggerTNTExplosionsWithFuse());
		// MinecraftForge.EVENT_BUS.register(new
		// BiggerTNTExplosionsWithoutFuse());

		MinecraftForge.EVENT_BUS.register(new PigsDroppingDiamonds());
		MinecraftForge.EVENT_BUS.register(new ZombieKnights());
		MinecraftForge.EVENT_BUS.register(new CreeperReinforcements());

		// MinecraftForge.EVENT_BUS.register(new SuperJump());
		MinecraftForge.EVENT_BUS.register(new BouncySponges());

		FMLCommonHandler.instance().bus().register(new Parachute());
		MinecraftForge.EVENT_BUS.register(new Parachute());
		MinecraftForge.EVENT_BUS.register(new GolemWallClimb());
		MinecraftForge.EVENT_BUS.register(new BlockFillerPositionSelector());

		enderBlock = new EnderBlock();
		// enderBlock = new BlockChanger();
		// enderBlock = new TheMajesticEnderiumBlock();
		// enderBlock = new EnderIngotFromEnderBlock();
		ModelResourceLocation resource = new ModelResourceLocation("enderBlock");
		GameRegistry.register(enderBlock, resource);
		Item enderBlockItem = GameRegistry.findItem("mymods", "enderBlock");
		ModelResourceLocation enderBlockModel = new ModelResourceLocation(
				"mymods:enderBlock", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				.register(enderBlockItem, 0, enderBlockModel);

		enderIngot = new EnderIngot();
		// enderIngot = new EndermanSpawner();
		// enderIngot = new EdibleIngot();
		resource = new ModelResourceLocation("enderIngot");
		GameRegistry.register(enderIngot, resource);
		Item enderIngotItem = GameRegistry.findItem("mymods", "enderIngot");
		ModelResourceLocation enderIngotModel = new ModelResourceLocation(
				"mymods:enderIngot", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				.register(enderIngot, 0, enderIngotModel);

		GameRegistry.addRecipe(new ItemStack(Blocks.COBBLESTONE), "dd", "dd",
				'd', Blocks.DIRT);

		GameRegistry.addRecipe(new ItemStack(enderBlock), "iii", "iii", "iii",
				'i', enderIngot);

		GameRegistry.addRecipe(new ItemStack(enderBlock), "e e", " o ", "e e",
				'o', Blocks.OBSIDIAN, 'e', Items.ENDER_EYE);

		GameRegistry.addShapelessRecipe(new ItemStack(enderIngot, 9),
				new ItemStack(enderBlock));

		GameRegistry.addShapelessRecipe(new ItemStack(enderIngot, 12),
				new ItemStack(enderBlock, 1), new ItemStack(Items.IRON_INGOT),
				new ItemStack(Items.GOLD_INGOT));

		GameRegistry.addSmelting(Items.ENDER_PEARL,
				new ItemStack(enderIngot, 1), 1.0F);

		Items.CAKE.setPotionEffect(PotionHelper.blazePowderEffect);
	}

	@EventHandler
	public void registerCommands(FMLServerStartingEvent event) {
		event.registerServerCommand(new FlamingPigs());
		event.registerServerCommand(new BlockFillCommand());
	}
}
