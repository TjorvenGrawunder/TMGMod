package de.tjorven.lidlmod.misc;

import de.tjorven.lidlmod.LidlMod;
import de.tjorven.lidlmod.block.ModBlocks;
import de.tjorven.lidlmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LidlMod.MODID);

    public static final RegistryObject<CreativeModeTab> LIDL_TAB = CREATIVE_MODE_TABS.register("lidl_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LIDL_BOTTLE.get()))
                    .title(Component.translatable("creativetab.lidlmod.lidl_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModItems.LIDL_BOTTLE.get());
                                output.accept(ModBlocks.LIDL_ORE.get());
                                output.accept(ModItems.RAW_LIDL_CHUNK.get());
                                output.accept(ModItems.LIDL_INGOT.get());
                            }).build());


    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
