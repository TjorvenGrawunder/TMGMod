package de.tjorven.lidlmod.misc.tooltiers;

import de.tjorven.lidlmod.item.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public enum LidlTiers implements Tier {

    SUPER_TIER(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2500, 20.0F, 4.0F, 30, Ingredient.of(ModItems.LIDL_INGOT.get()));


    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final Ingredient repairIngredient;

    LidlTiers(TagKey<Block> incorrectBlocksForDrops, int uses, float speed, float attackDamageBonus, int enchantmentValue, Ingredient repairIngredient) {
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getUses() { return uses; }

    @Override
    public float getSpeed() { return speed; }

    @Override
    public float getAttackDamageBonus() { return attackDamageBonus; }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() { return enchantmentValue; }

    @Override
    public Ingredient getRepairIngredient() { return repairIngredient; }
}
