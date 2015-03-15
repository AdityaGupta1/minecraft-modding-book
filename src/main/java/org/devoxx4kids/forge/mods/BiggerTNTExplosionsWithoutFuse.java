package org.devoxx4kids.forge.mods;


import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BiggerTNTExplosionsWithoutFuse {

	float power = 32.0F;

	@SubscribeEvent
	public void explode(EntityJoinWorldEvent event) {
		if (!(event.entity instanceof EntityTNTPrimed)) {
			return;
		}
		Entity entity = event.entity;
		event.entity.worldObj.createExplosion(entity, entity.posX, entity.posY,
				entity.posZ, power, true);
	}

}
