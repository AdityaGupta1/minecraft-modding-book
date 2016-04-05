package org.devoxx4kids.forge.mods;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ZombieKnights {
	@SubscribeEvent
	public void giveArmor(EntityJoinWorldEvent event) {
		if (!(event.getEntity() instanceof EntityZombie)) {
			return;
		}
		EntityZombie zombie = (EntityZombie) event.getEntity();
		zombie.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.diamond_axe));
		zombie.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.diamond_chestplate));
		zombie.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.diamond_leggings));
		zombie.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.diamond_boots));
		zombie.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.diamond_helmet));
	}
}