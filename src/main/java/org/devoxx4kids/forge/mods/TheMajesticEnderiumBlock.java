package org.devoxx4kids.forge.mods;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class TheMajesticEnderiumBlock extends Block {
	public TheMajesticEnderiumBlock() {
		super(Material.iron);
		this.setUnlocalizedName("enderBlock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setResistance(5.0F);
		this.setHardness(10.0F);
		this.setLightLevel(1.0F);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote)
			return false;
		player.addChatMessage(new ChatComponentText(
				EnumChatFormatting.DARK_PURPLE
						+ "You have clicked on the majestic ENDERIUM BLOCK!!!!!"));
		EntityEnderEye eye = new EntityEnderEye(world, pos.getX() + 0.5, pos.getY() + 1.5,
				pos.getZ() + 0.5);
		eye.motionY = 0.1;
		world.spawnEntityInWorld(eye);
		return true;
	}
}