package de.tjorven.lidlmod.item.tools;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class LidlPickaxe extends PickaxeItem {
    public LidlPickaxe() {
        super(Tiers.DIAMOND, new Item.Properties().durability(1000));
    }
}
