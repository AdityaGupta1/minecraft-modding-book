package org.devoxx4kids.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class EdibleIngot extends ItemFood {
	public EdibleIngot() {
		super(5, 1.0F, true);
		// TODO: this still needs to be fixed for Forge 1.9
//		this.setPotionEffect(1, 60, 2, 0.5F);
		this.setAlwaysEdible();
		this.setUnlocalizedName("enderIngot");
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
