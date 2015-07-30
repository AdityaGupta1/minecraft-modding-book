package org.devoxx4kids.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EndermanSpawner extends Item {
	public EndermanSpawner() {
		super();
		this.setUnlocalizedName("enderIngot");
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		EntityEnderman enderman = new EntityEnderman(world);
		enderman.setLocationAndAngles(player.posX, player.posY, player.posZ, 0,
				0);
		world.spawnEntityInWorld(enderman);
		if (!player.capabilities.isCreativeMode) {
			stack.stackSize--;
		}
		return stack;
	}
}