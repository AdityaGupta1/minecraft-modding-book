package org.devoxx4kids.forge.mods;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockFillerPositionSelector {
	
	static List<Integer> pos1 = new ArrayList();
	static List<Integer> pos2 = new ArrayList();

	@SubscribeEvent
	public void choosePositions(PlayerInteractEvent event) {
		if (event.getEntityPlayer().getHeldItemMainhand() == null
				|| event.getEntityPlayer().getHeldItemMainhand().getItem() != Items.WOODEN_AXE
				|| !event.getEntityPlayer().capabilities.isCreativeMode) {
			return;
		}
		if (event instanceof PlayerInteractEvent.RightClickBlock) {
			pos1.clear();
			pos1.add(event.getPos().getX());
			pos1.add(event.getPos().getY());
			pos1.add(event.getPos().getZ());
			
			TextComponentString textComponentString = new TextComponentString("Position 1 set to " + event.getPos().getX()
					+ ", " + event.getPos().getY() + ", " + event.getPos().getZ() + ".");
			textComponentString.getStyle().setColor(TextFormatting.GREEN);
			event.getEntityPlayer().sendMessage(textComponentString);
			event.setCanceled(true);
		} else if (event instanceof PlayerInteractEvent.LeftClickBlock) {
			pos2.clear();
			pos2.add(event.getPos().getX());
			pos2.add(event.getPos().getY());
			pos2.add(event.getPos().getZ());
			
			TextComponentString textComponentString = new TextComponentString("Position 2 set to " + event.getPos().getX()
					+ ", " + event.getPos().getY() + ", " + event.getPos().getZ() + ".");
			textComponentString.getStyle().setColor(TextFormatting.GREEN);
			event.getEntityPlayer().sendMessage(textComponentString);
			event.setCanceled(true);
		}
	}

}
