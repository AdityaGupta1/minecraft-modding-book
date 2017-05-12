package org.devoxx4kids.forge.mods;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class EnderBlock extends Block {
	public EnderBlock() {
		super(Material.IRON);
		this.setUnlocalizedName("enderBlock");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setResistance(5.0F);
		this.setHardness(10.0F);
		this.setLightLevel(1.0F);
	}
}