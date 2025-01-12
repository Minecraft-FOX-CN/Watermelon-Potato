package watermelon.potato.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import org.jetbrains.annotations.Nullable;
import watermelon.potato.WatermelonAndPotato;
import watermelon.potato.common.block.WatermelonPotatoBlock;

import java.util.function.Function;

public class ModBlocks {
    public static final Block POTATO_BLOCK = register("potato_block", WatermelonPotatoBlock::new, AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(1f, 0f)
                    .requiresTool(),
            new Item.Settings().food(ModFoodComponents.POTATO_BLOCK));

    public static final Block POTATO_MELON_CORE = register("potato_melon_core", WatermelonPotatoBlock::new, AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(16f, 8f)
                    .requiresTool(),
            new Item.Settings().food(ModFoodComponents.COOKED_POTATO_BLOCK));

    public static final Block COOKED_POTATO_BLOCK = register("cooked_potato_block", WatermelonPotatoBlock::new, AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(4f, 2f)
                    .requiresTool(),
            new Item.Settings().food(ModFoodComponents.COOKED_POTATO_BLOCK));


    private static Block register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings, @Nullable Item.Settings item_settings) {
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, WatermelonAndPotato.makeID(name));
        final Block block = Blocks.register(registryKey, factory, settings);
        if (item_settings != null) Items.register(block, item_settings);
        return block;
    }

    public static void initialize() {
        WatermelonAndPotato.LOGGER.debug("OH GOD I DON'T KNOW WHAT THINGS I CAN PUT HERE");
    }
}
