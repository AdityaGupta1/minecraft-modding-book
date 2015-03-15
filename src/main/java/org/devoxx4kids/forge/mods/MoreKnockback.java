package org.devoxx4kids.forge.mods;

import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MoreKnockback {

	@SubscribeEvent
	public void addKnockback(LivingHurtEvent event) {
		event.entity.motionX *= 10;
		// event.entity.motionY *= 10;
		event.entity.motionZ *= 10;
	}
}
