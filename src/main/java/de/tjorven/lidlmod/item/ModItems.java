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
    public static final RegistryObject<Item> LIDL_BOTTLE = ITEMS.register("lidlbottle", () -> new LidlBottle(new Item.Properties()));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

}
