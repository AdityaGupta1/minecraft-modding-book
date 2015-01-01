package org.devoxx4kids.forge.mods;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
	public static final String MODID = "MyMods";
	public static final String VERSION = "1.0";

	public static Block ender_block;
	public static Item ender_ingot;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());
		MinecraftForge.EVENT_BUS.register(new ExplodingMinecarts());
		MinecraftForge.EVENT_BUS.register(new ExplodingAnvils());
		MinecraftForge.EVENT_BUS.register(new DiamondOreTrap());

		MinecraftForge.EVENT_BUS.register(new BiggerTNTExplosionsWithFuse());
		// MinecraftForge.EVENT_BUS.register(new BiggerTNTExplosionsWithoutFuse());

		MinecraftForge.EVENT_BUS.register(new ZombieKnights());
		MinecraftForge.EVENT_BUS.register(new PigsDroppingDiamonds());
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
	}

	@EventHandler
	public void registerCommands(FMLServerStartingEvent event) {
		event.registerServerCommand(new FlamingPigs());
		event.registerServerCommand(new BlockFillCommand());
	}
}