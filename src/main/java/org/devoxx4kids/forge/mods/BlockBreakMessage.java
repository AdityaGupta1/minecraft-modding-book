package org.devoxx4kids.forge.mods;


import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockBreakMessage {
	@SubscribeEvent
	public void sendMessage(BreakEvent event) {
		TextComponentString textComponentString = new TextComponentString("You broke a block!");
		textComponentString.getStyle().setColor(TextFormatting.GOLD);
		event.getPlayer().sendMessage(textComponentString);
	}
}