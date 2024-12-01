package de.tjorven.lidlmod.item.tools;

import de.tjorven.lidlmod.misc.tooltiers.LidlTiers;
import net.minecraft.world.item.*;

public class LidlPickaxe extends PickaxeItem {
    public LidlPickaxe() {
        super(LidlTiers.SUPER_TIER, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 2.0F, -2.8F)));
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return super.getEnchantmentValue(stack);
    }
}
