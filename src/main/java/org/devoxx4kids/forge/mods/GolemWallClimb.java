package org.devoxx4kids.forge.mods;

import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GolemWallClimb {
	@SubscribeEvent
	public void climbWall(LivingUpdateEvent event) {
		if (!(event.entity instanceof EntitySnowman)
				&& !(event.entity instanceof EntityIronGolem)) {
			return;
		}
		if (!event.entity.isCollidedHorizontally) {
			return;
		}
		event.entity.motionY = 0.5;
	}
}