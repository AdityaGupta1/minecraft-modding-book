	package org.devoxx4kids.forge.mods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BiggerTNTExplosionsWithFuse {
	
	int fuse = 4;
	float power = 32.0F;

	@SubscribeEvent
	public void spawnTNTItem(EntityJoinWorldEvent event) {
		if (!(event.entity instanceof EntityTNTPrimed)) {
			return;
		}
		Entity entity = event.entity;
		EntityItem explosion = new EntityItem(event.world, entity.posX,
				entity.posY, entity.posZ, new ItemStack(Blocks.tnt));
		explosion.setInfinitePickupDelay();
		explosion.motionX = 0;
		explosion.motionY = 0;
		explosion.motionZ = 0;
		explosion.lifespan = fuse * 20;
		if (!event.world.isRemote) {
			event.world.spawnEntityInWorld(explosion);
		}
	}

	@SubscribeEvent
	public void explode(ItemExpireEvent event) {
		if (event.entityItem.getEntityItem().getItem() != Item
				.getItemFromBlock(Blocks.tnt)) {
			return;
		}
		EntityItem explosion = event.entityItem;
		event.entity.worldObj.createExplosion(explosion, explosion.posX,
				explosion.posY, explosion.posZ, power, true);
	}

}
