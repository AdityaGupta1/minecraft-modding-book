package org.devoxx4kids.forge.mods;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockFillerPositionSelector {
	
	static List<Integer> pos1 = new ArrayList();
	static List<Integer> pos2 = new ArrayList();

	@SubscribeEvent
	public void choosePositions(PlayerInteractEvent event) {
		if (event.entityPlayer.getHeldItem() == null
				|| event.entityPlayer.getHeldItem().getItem() != Items.wooden_axe
				|| !event.entityPlayer.capabilities.isCreativeMode) {
			return;
		}
		if (event.action == Action.RIGHT_CLICK_BLOCK) {
			pos1.clear();
			pos1.add(event.pos.getX());
			pos1.add(event.pos.getY());
			pos1.add(event.pos.getZ());
			event.entityPlayer.addChatMessage(new ChatComponentText(
					EnumChatFormatting.GREEN + "Position 1 set to " + event.pos.getX()
							+ ", " + event.pos.getY() + ", " + event.pos.getZ() + "."));
			event.setCanceled(true);
		} else if (event.action == Action.LEFT_CLICK_BLOCK) {
			pos2.clear();
			pos2.add(event.pos.getX());
			pos2.add(event.pos.getY());
			pos2.add(event.pos.getZ());
			event.entityPlayer.addChatMessage(new ChatComponentText(
					EnumChatFormatting.GREEN + "Position 2 set to " + event.pos.getX()
							+ ", " + event.pos.getY() + ", " + event.pos.getZ() + "."));
			event.setCanceled(true);
		}
	}

}
