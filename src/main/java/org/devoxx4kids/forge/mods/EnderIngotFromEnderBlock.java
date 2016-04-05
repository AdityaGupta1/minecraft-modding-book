package org.devoxx4kids.forge.mods;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EnderIngotFromEnderBlock extends Block {
	public EnderIngotFromEnderBlock() {
		super(Material.iron);
		this.setUnlocalizedName("enderBlock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setResistance(5.0F);
		this.setHardness(10.0F);
		this.setLightLevel(1.0F);
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Main.enderIngot;
	}
	public int quantityDropped(Random random) {
		return random.nextInt(2) + 3;
	}
}