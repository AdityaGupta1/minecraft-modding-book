package org.devoxx4kids.forge.mods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BouncySponges {
	@SubscribeEvent
	public void makeJumpHigher(LivingJumpEvent event) {
		if (!(event.entity instanceof EntityPlayer)) {
			return;
		}

		if (event.entity.worldObj.getBlock(
				((int) Math.floor(event.entity.posX)),
				((int) Math.floor(event.entity.posY)) - 2,
				((int) Math.floor(event.entity.posZ))) != Blocks.sponge) {
			return;
		}

		event.entity.motionY *= 5;
	}
}