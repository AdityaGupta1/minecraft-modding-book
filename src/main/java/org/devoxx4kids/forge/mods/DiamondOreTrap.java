package org.devoxx4kids.forge.mods;

import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DiamondOreTrap {
	@SubscribeEvent
	public void explode(BreakEvent event) {
		if (event.state.getBlock() != Blocks.diamond_ore) {
			return;
		}
		event.world.createExplosion(null, event.pos.getX(), event.pos.getY(),
				event.pos.getZ(), 10, true);
	}
}