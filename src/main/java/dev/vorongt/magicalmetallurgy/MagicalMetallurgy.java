package dev.vorongt.magicalmetallurgy;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static dev.vorongt.magicalmetallurgy.register.RegisterBlocks.ModBlocks;
import static dev.vorongt.magicalmetallurgy.register.RegisterItems.ModItems;
import static dev.vorongt.magicalmetallurgy.register.RegisterTabs.ModTabs;


@Mod(MagicalMetallurgy.MODID)
public class MagicalMetallurgy
{
    public static final String MODID = "magicalmetallurgy";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MagicalMetallurgy(FMLJavaModLoadingContext eventBus) {
        ModBlocks.register(eventBus.getModEventBus());
        ModItems.register(eventBus.getModEventBus());
        ModTabs.register(eventBus.getModEventBus());
    }
}