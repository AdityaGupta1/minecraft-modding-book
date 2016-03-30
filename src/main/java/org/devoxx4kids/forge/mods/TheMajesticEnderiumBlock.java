package org.devoxx4kids.forge.mods;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
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
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state,
			EntityPlayer playerIn, EnumHand hand, ItemStack heldItem,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote)
			return false;
		playerIn.addChatMessage(new TextComponentString(
				TextFormatting.DARK_PURPLE
						+ "You have clicked on the majestic ENDERIUM BLOCK!!!!!"));
		EntityEnderEye eye = new EntityEnderEye(worldIn, pos.getX() + 0.5, pos.getY() + 1.5,
				pos.getZ() + 0.5);
		eye.motionY = 0.1;
		worldIn.spawnEntityInWorld(eye);
		return true;
	}
}