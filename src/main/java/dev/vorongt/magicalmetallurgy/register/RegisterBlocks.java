package dev.vorongt.magicalmetallurgy.register;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static dev.vorongt.magicalmetallurgy.MagicalMetallurgy.MODID;
import static dev.vorongt.magicalmetallurgy.register.RegisterItems.ModItems;

public class RegisterBlocks {
    public static final DeferredRegister<Block> ModBlocks = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> SHINESTEEL_BLOCK = registerBlock("shinesteel_block", () ->
            new Block(BlockBehaviour.Properties.of()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> blockRegistryObject = ModBlocks.register(name, block);

        ModItems.register(name, () ->
                new BlockItem(blockRegistryObject.get(), new Item.Properties()));

        return blockRegistryObject;
    }

    public static void register(IEventBus eventBus) {
        ModBlocks.register(eventBus);
    }
}
