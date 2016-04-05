package org.devoxx4kids.forge.mods;

import java.util.Random;

import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PigsDroppingDiamonds {
	
	@SubscribeEvent
	public void dropDiamonds(LivingDeathEvent event) {
		if (!(event.getEntity() instanceof EntityPig)) {
			return;
		}
		
		Random random = new Random();
		
		if (!event.getEntity().worldObj.isRemote) {
			event.getEntity().dropItem(Items.diamond, random.nextInt(3));
		}
	}
}
