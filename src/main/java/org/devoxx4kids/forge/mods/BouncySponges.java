package org.devoxx4kids.forge.mods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BouncySponges {
	@SubscribeEvent
	public void makeJumpHigher(LivingJumpEvent event) {
		if (!(event.entity instanceof EntityPlayer)) {
			return;
		}

		BlockPos pos = new BlockPos(event.entity.posX, event.entity.posY - 1,
				event.entity.posZ);

		if (event.entity.worldObj.getBlockState(pos).getBlock() != Blocks.sponge) {
			return;
		}

		event.entity.motionY *= 5;
	}
}