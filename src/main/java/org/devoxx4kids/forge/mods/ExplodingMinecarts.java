package org.devoxx4kids.forge.mods;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraftforge.event.entity.minecart.MinecartCollisionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ExplodingMinecarts {
	@SubscribeEvent
	public void explode(MinecartCollisionEvent event) {
		EntityMinecart minecart = event.getMinecart();
		minecart.worldObj.createExplosion(minecart, minecart.posX,
				minecart.posY, minecart.posZ, 2, false);
	}
}
