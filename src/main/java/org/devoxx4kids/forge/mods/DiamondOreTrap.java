package org.devoxx4kids.forge.mods;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class DiamondOreTrap {
	@SubscribeEvent
	public void explode(BreakEvent event) {
		if (event.block != Blocks.diamond_ore) {
			return;
		}
		event.world.createExplosion(null, event.x, event.y, event.z, 10, true);
	}
}