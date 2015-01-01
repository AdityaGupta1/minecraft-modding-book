package org.devoxx4kids.forge.mods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class Parachute {
	@SubscribeEvent
	public void deployParachute(LivingUpdateEvent event) {
		if (!(event.entity instanceof EntityPlayer)) {
			return;
		}
		if (!((EntityPlayer) event.entity).isAirBorne
				|| !((EntityPlayer) event.entity).isSneaking()) {
			return;
		}
		event.entity.motionY = -0.05;
		event.entity.fallDistance = 0;
	}
}
