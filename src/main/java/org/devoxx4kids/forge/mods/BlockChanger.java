package org.devoxx4kids.forge.mods;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockChanger extends Block {
	public BlockChanger() {
		super(Material.iron);
		this.setUnlocalizedName("enderBlock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setResistance(5.0F);
		this.setHardness(10.0F);
		this.setLightLevel(1.0F);
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		IBlockState block = world.getBlockState(pos.add(0, -1, 0));
		world.setBlockState(pos, block);
		EntityLightningBolt lightning = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ());
		world.addWeatherEffect(lightning);
	}
}