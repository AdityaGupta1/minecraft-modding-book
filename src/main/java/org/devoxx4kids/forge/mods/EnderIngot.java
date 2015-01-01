package org.devoxx4kids.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EnderIngot extends Item {
	public EnderIngot() {
		super();
		this.setUnlocalizedName("ingotEnder");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setTextureName("myMods:ender_ingot");
	}
}