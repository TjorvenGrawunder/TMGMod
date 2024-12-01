package de.tjorven.lidlmod.datagen;

import de.tjorven.lidlmod.LidlMod;
import de.tjorven.lidlmod.item.ModItems;
import de.tjorven.lidlmod.item.tools.LidlSword;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LidlMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(ModItems.LIDL_BOTTLE);
        basicItem(ModItems.RAW_LIDL_CHUNK.get());
        basicItem(ModItems.LIDL_INGOT.get());
        basicItem(ModItems.LIDL_GEM.get());
        handheldItem(ModItems.LIDL_PICKAXE);
        handheldItem(ModItems.LIDL_SWORD);
        handheldItem(ModItems.LIDL_AXE);
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(LidlMod.MODID,"item/" + item.getId().getPath()));
    }
}
