package org.devoxx4kids.forge.mods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BouncySponges {
	@SubscribeEvent
	public void makeJumpHigher(LivingJumpEvent event) {
		if (!(event.getEntity() instanceof EntityPlayer)) {
			return;
		}

		BlockPos pos = new BlockPos(event.getEntity().posX, event.getEntity().posY - 1,
				event.getEntity().posZ);

		if (event.getEntity().getEntityWorld().getBlockState(pos).getBlock() != Blocks.SPONGE) {
			return;
		}

		event.getEntity().motionY *= 5;
	}
}