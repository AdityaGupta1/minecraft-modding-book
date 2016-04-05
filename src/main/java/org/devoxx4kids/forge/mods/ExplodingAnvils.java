package org.devoxx4kids.forge.mods;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ExplodingAnvils {
	@SubscribeEvent
	public void explode(LivingHurtEvent event) {
		if (event.getSource() != DamageSource.anvil) {
			return;
		}
		Entity entity = event.getEntity();
		event.getEntity().worldObj.createExplosion(entity, entity.posX,
				entity.posY, entity.posZ, 2, false);
	}
}
