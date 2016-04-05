package org.devoxx4kids.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EndermanSpawner extends Item {
	public EndermanSpawner() {
		super();
		this.setUnlocalizedName("enderIngot");
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

	public ActionResult<ItemStack> onItemRightClick(ItemStack stack,
			World world, EntityPlayer player, EnumHand hand) {
		if (world.isRemote) {
			return new ActionResult(EnumActionResult.PASS, stack);
		}

		EntityEnderman enderman = new EntityEnderman(world);
		enderman.setLocationAndAngles(player.posX, player.posY, player.posZ, 0,
				0);
		world.spawnEntityInWorld(enderman);
		if (!player.capabilities.isCreativeMode) {
			stack.stackSize--;
		}
		return new ActionResult(EnumActionResult.SUCCESS, stack);
	}
}