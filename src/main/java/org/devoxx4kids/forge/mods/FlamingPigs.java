package org.devoxx4kids.forge.mods;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class FlamingPigs implements ICommand {

	private List aliases = new ArrayList();
	private int numberOfPigs = 0;

	public FlamingPigs() {
		aliases.add("flamingpigs");
		aliases.add("fp");
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/flamingpigs <number of pigs>";
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAliases() {
		return aliases;
	}

	@Override
	public void execute(ICommandSender sender, String[] args)
			throws CommandException {
		if (args.length != 1) {
			sendErrorMessage(sender, "Invalid number of arguments!");
			return;
		}
		try {
			numberOfPigs = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			sendErrorMessage(sender, "The argument \"" + args[0]
					+ "\" is not a valid number!");
			return;
		}
		EntityPlayer player = (EntityPlayer) sender;
		for (int i = 0; i < numberOfPigs; i++) {
			EntityPig pig = new EntityPig(player.worldObj);
			pig.setLocationAndAngles(player.posX, player.posY, player.posZ, 0,
					0);
			pig.setFire(10000);
			player.worldObj.spawnEntityInWorld(pig);
		}
	}

	private void sendErrorMessage(ICommandSender sender, String message) {
		sender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED
				+ message));
	}

	@Override
	public boolean canCommandSenderUse(ICommandSender sender) {
		return sender instanceof EntityPlayer;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] args,
			BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

}
