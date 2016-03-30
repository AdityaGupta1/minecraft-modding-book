package org.devoxx4kids.forge.mods;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockFillerPositionSelector {
	
	static List<Integer> pos1 = new ArrayList();
	static List<Integer> pos2 = new ArrayList();

	@SubscribeEvent
	public void choosePositions(PlayerInteractEvent event) {
		EntityPlayer entityPlayer = event.getEntityPlayer();
		BlockPos pos = event.getPos();

		if (entityPlayer.getHeldItem(EnumHand.MAIN_HAND) == null
				|| entityPlayer.getHeldItem(EnumHand.MAIN_HAND).getItem()
						!= Items.wooden_axe
				|| !entityPlayer.capabilities.isCreativeMode) {
			return;
		}
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			pos1.clear();
			pos1.add(pos.getX());
			pos1.add(pos.getY());
			pos1.add(pos.getZ());
			event.getEntityPlayer().addChatMessage(new TextComponentString(
					TextFormatting.GREEN + "Position 1 set to "
							+ event.getPos().getX() + ", "
							+ event.getPos().getY() + ", "
							+ event.getPos().getZ() + "."));
			event.setCanceled(true);
		} else if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
			pos2.clear();
			pos2.add(pos.getX());
			pos2.add(pos.getY());
			pos2.add(pos.getZ());
			event.getEntityPlayer().addChatMessage(new TextComponentString(
					TextFormatting.GREEN + "Position 2 set to "
							+ event.getPos().getX() + ", "
							+ event.getPos().getY() + ", "
							+ event.getPos().getZ() + "."));
			event.setCanceled(true);
		}
	}

}
