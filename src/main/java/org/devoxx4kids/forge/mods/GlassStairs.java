package org.devoxx4kids.forge.mods;

import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class GlassStairs extends BlockStairs {
	public GlassStairs() {
		super(Blocks.glass, 0);
		this.setBlockName("glassStairs");
		this.setLightOpacity(0);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setResistance(5.0F);
		this.setHardness(10.0F);
		this.setLightLevel(1.0F);
	}
}