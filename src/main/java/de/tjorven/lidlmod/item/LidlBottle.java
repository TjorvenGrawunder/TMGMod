package de.tjorven.lidlmod.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BottleItem;
import net.minecraft.world.item.Item;

public class LidlBottle extends Item {

    public LidlBottle(Properties properties) {
        super(properties.food(Foods.BEEF));
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }
}
