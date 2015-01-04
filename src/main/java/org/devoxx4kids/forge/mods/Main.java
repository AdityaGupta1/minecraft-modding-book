package org.devoxx4kids.forge.mods;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
	public static final String MODID = "MyMods";
	public static final String VERSION = "2.0";

	public static Block ender_block;
	public static Item ender_ingot;

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

		MinecraftForge.EVENT_BUS.register(new Parachute());
		MinecraftForge.EVENT_BUS.register(new GolemWallClimb());
		MinecraftForge.EVENT_BUS.register(new BlockFillerPositionSelector());

		ender_block = new EnderBlock();
		// ender_block = new GlassStairs();
		// ender_block = new TheMajesticEnderiumBlock();
		// ender_block = new EnderIngotFromEnderBlock();
		GameRegistry.registerBlock(ender_block, "Block of Enderium");

		ender_ingot = new EnderIngot();
		// ender_ingot = new EndermanSpawner();
		// ender_ingot = new EdibleIngot();
		GameRegistry.registerItem(ender_ingot, "Enderium Ingot");

		GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone), "dd", "dd",
				'd', Blocks.dirt);

		GameRegistry.addRecipe(new ItemStack(ender_block), "iii", "iii", "iii",
				'i', ender_ingot);

		GameRegistry.addRecipe(new ItemStack(ender_block), "e e", " o ", "e e",
				'o', Blocks.obsidian, 'e', Items.ender_eye);

		GameRegistry.addShapelessRecipe(new ItemStack(ender_ingot, 9),
				new ItemStack(ender_block));

		GameRegistry.addShapelessRecipe(new ItemStack(ender_ingot, 12),
				new ItemStack(ender_block, 1), new ItemStack(Items.iron_ingot),
				new ItemStack(Items.gold_ingot));

		GameRegistry.addSmelting(Items.ender_pearl, new ItemStack(ender_ingot,
				1), 1.0F);
		
		Items.cake.setPotionEffect(PotionHelper.blazePowderEffect);
	}

	@EventHandler
	public void registerCommands(FMLServerStartingEvent event) {
		event.registerServerCommand(new FlamingPigs());
		event.registerServerCommand(new BlockFillCommand());
	}
}