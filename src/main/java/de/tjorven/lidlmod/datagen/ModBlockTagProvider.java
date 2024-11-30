package de.tjorven.lidlmod.datagen;

import de.tjorven.lidlmod.LidlMod;
import de.tjorven.lidlmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LidlMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.LIDL_ORE.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.DEEPSLATE_LIDL_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.LIDL_ORE.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.DEEPSLATE_LIDL_ORE.get());
    }
}
