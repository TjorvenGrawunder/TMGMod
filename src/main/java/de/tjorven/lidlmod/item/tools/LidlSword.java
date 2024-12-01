package de.tjorven.lidlmod.item.tools;

import de.tjorven.lidlmod.misc.tooltiers.LidlTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class LidlSword extends SwordItem {
    public LidlSword() {
        super(LidlTiers.SUPER_TIER, new Item.Properties().attributes(PickaxeItem.createAttributes(LidlTiers.SUPER_TIER, 6.0F, -2.8F)));
    }

    @Override
    public int getEnchantmentValue() {
        return super.getEnchantmentValue();
    }
}
