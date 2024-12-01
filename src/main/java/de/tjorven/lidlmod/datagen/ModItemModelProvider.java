package de.tjorven.lidlmod.datagen;

import de.tjorven.lidlmod.LidlMod;
import de.tjorven.lidlmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LidlMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.LIDL_BOTTLE.get());
        basicItem(ModItems.RAW_LIDL_CHUNK.get());
        basicItem(ModItems.LIDL_INGOT.get());
        basicItem(ModItems.LIDL_GEM.get());
        basicItem(ModItems.LIDL_PICKAXE.get());
    }
}
