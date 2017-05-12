package org.devoxx4kids.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EdibleIngot extends ItemFood {
	public EdibleIngot() {
		super(5, 1.0F, true);
		PotionEffect potion = new PotionEffect(Potion.getPotionById(1), 60, 2);
		this.setPotionEffect(potion, 0.5F);
		this.setAlwaysEdible();
		this.setUnlocalizedName("enderIngot");
		this.setCreativeTab(CreativeTabs.MATERIALS);
	}
}
