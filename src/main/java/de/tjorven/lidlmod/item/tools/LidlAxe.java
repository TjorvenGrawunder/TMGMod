package de.tjorven.lidlmod.item.tools;

import de.tjorven.lidlmod.misc.tooltiers.LidlTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;

public class LidlAxe extends AxeItem {
    public LidlAxe() {
        super(LidlTiers.SUPER_TIER, new Item.Properties().attributes(PickaxeItem.createAttributes(LidlTiers.SUPER_TIER, 8.0F, -3.0F)));
    }
}
