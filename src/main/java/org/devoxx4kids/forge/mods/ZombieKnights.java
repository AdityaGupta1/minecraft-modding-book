package org.devoxx4kids.forge.mods;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
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
		zombie.setsetCurrentItemOrArmor(0, new ItemStack(Items.DIAMOND_AXE));
		zombie.setCurrentItemOrArmor(1, new ItemStack(Items.DIAMOND_CHESTPLATE));
		zombie.setCurrentItemOrArmor(2, new ItemStack(Items.DIAMOND_LEGGINGS));
		zombie.setCurrentItemOrArmor(3, new ItemStack(Items.DIAMOND_BOOTS));
		zombie.setCurrentItemOrArmor(4, new ItemStack(Items.DIAMOND_HELMET));
	}
}