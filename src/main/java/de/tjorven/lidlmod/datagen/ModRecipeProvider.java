package de.tjorven.lidlmod.datagen;

import de.tjorven.lidlmod.LidlMod;
import de.tjorven.lidlmod.block.ModBlocks;
import de.tjorven.lidlmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        List<ItemLike> LIDL_SMELTABLES = List.of(ModItems.RAW_LIDL_CHUNK.get(), ModBlocks.LIDL_ORE.get());

        // Shaped Recipe for Lidl Bottle
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LIDL_BOTTLE.get())
                .pattern(" G ")
                .pattern("GLG")
                .pattern(" G ")
                .define('G', Items.GLASS)
                .define('L', ModItems.LIDL_INGOT.get())
                .unlockedBy(getHasName(ModItems.LIDL_INGOT.get()), has(ModItems.LIDL_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LIDL_GEM.get())
                .pattern("LLL")
                .pattern("DED")
                .pattern("LLL")
                .define('D', Items.DIAMOND)
                .define('E', Items.EMERALD)
                .define('L', ModItems.LIDL_INGOT.get())
                .unlockedBy(getHasName(ModItems.LIDL_INGOT.get()), has(ModItems.LIDL_INGOT.get())).save(pRecipeOutput);

        // Shaped Recipe for Lidl Pickaxe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LIDL_PICKAXE.get())
                .pattern("LLL")
                .pattern(" S ")
                .pattern(" S ")
                .define('L', ModItems.LIDL_GEM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.LIDL_GEM.get()), has(ModItems.LIDL_GEM.get())).save(pRecipeOutput);

        // Axe Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LIDL_AXE.get())
                .pattern("LL")
                .pattern("LS")
                .pattern(" S")
                .define('L', ModItems.LIDL_GEM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.LIDL_GEM.get()), has(ModItems.LIDL_GEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LIDL_AXE.get())
                .pattern("LL")
                .pattern("SL")
                .pattern("S ")
                .define('L', ModItems.LIDL_GEM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.LIDL_GEM.get()), has(ModItems.LIDL_GEM.get())).save(pRecipeOutput, LidlMod.MODID + ":lidl_axe_v2");


        // Sword Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LIDL_SWORD.get())
                .pattern("L")
                .pattern("L")
                .pattern("S")
                .define('L', ModItems.LIDL_GEM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.LIDL_GEM.get()), has(ModItems.LIDL_GEM.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BEDROCK, 1)
                .requires(Items.DIAMOND_BLOCK, 9).unlockedBy(getHasName(Items.DIAMOND_BLOCK), has(Items.DIAMOND_BLOCK)).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, LIDL_SMELTABLES, RecipeCategory.MISC, ModItems.LIDL_INGOT.get(), 1.0F, 200, "lidlingot");
        oreBlasting(pRecipeOutput, LIDL_SMELTABLES, RecipeCategory.MISC, ModItems.LIDL_INGOT.get(), 1.0F, 100, "lidlingot");


    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, LidlMod.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
