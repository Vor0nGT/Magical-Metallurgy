package dev.vorongt.magicalmetallurgy.register;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static dev.vorongt.magicalmetallurgy.register.RegisterArmorMaterial.ModArmorMaterials;
import static dev.vorongt.magicalmetallurgy.MagicalMetallurgy.MODID;

public class RegisterItems {
    public static final DeferredRegister<Item> ModItems = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Default
    public static final RegistryObject<Item> SHINESTEEL_INGOT = ModItems.register("shinesteel_ingot", () ->
            new Item(new Item.Properties()));

    // Armor
    public static final RegistryObject<Item> TRAVELING_BOOTS = ModItems.register("traveling_boots",
            () -> new ArmorItem(ModArmorMaterials.TRAVELING_BOOTS, ArmorItem.Type.BOOTS, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ModItems.register(eventBus);
    }
}
