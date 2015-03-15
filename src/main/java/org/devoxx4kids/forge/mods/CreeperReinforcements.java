package org.devoxx4kids.forge.mods;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CreeperReinforcements {

	@SubscribeEvent
	public void spawnReinforcements(LivingDeathEvent event) {
		if (!(event.entity instanceof EntityCreeper)) {
			return;
		}
		for (int i = 0; i < 5; i++) {
			EntityCreeper creeper = new EntityCreeper(event.entity.worldObj);
			creeper.setLocationAndAngles(event.entity.posX, event.entity.posY,
					event.entity.posZ, 0, 0);
			if (!event.entity.worldObj.isRemote) {
				event.entity.worldObj.spawnEntityInWorld(creeper);
			}
		}
	}

}
