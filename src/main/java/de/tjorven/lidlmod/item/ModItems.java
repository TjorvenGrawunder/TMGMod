package de.tjorven.lidlmod.item;

import de.tjorven.lidlmod.LidlMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LidlMod.MODID);


    // Register items here
    public static final RegistryObject<Item> LIDL_BOTTLE = ITEMS.register("lidl_bottle", () -> new LidlBottle(new Item.Properties()));
    public static final RegistryObject<Item> RAW_LIDL_CHUNK = ITEMS.register("raw_lidl_chunk", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIDL_INGOT = ITEMS.register("lidl_ingot", () -> new Item(new Item.Properties()));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

}
