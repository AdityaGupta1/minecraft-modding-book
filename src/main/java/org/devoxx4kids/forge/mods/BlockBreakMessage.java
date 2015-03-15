package org.devoxx4kids.forge.mods;


import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockBreakMessage {
	@SubscribeEvent
	public void sendMessage(BreakEvent event) {
		event.getPlayer().addChatMessage(
				new ChatComponentText(EnumChatFormatting.GOLD
						+ "You broke a block!"));
	}
}