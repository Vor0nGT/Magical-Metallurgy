package dev.vorongt.magicalmetallurgy.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static dev.vorongt.magicalmetallurgy.MagicalMetallurgy.MODID;

public class RegisterTabs {
    public static final DeferredRegister<CreativeModeTab> ModTabs =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> MAGICAL_METALLURGY_TAB = ModTabs.register("magical_metallurgy_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(RegisterItems.SHINESTEEL_INGOT.get()))
                    .title(Component.translatable("magical_metallurgy_tab"))
                    .displayItems((pParameters, pOutput) -> {


                        pOutput.accept(RegisterItems.SHINESTEEL_INGOT.get());

                        pOutput.accept(RegisterBlocks.SHINESTEEL_BLOCK.get());

                        pOutput.accept(RegisterItems.TRAVELING_BOOTS.get());
                        pOutput.accept(RegisterItems.NIGHTVISION_GLASSES.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        ModTabs.register(eventBus);
    }
}
