package watermelon.potato.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import watermelon.potato.WatermelonAndPotato;
import watermelon.potato.common.block.PotatoBlock;

import java.util.function.Function;

public class ModBlocks {
    public static final Block POTATO_BLOCK = register("potato_block", PotatoBlock::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.GRASS)
            .strength(1f, 0f)
            .requiresTool());

    private static Block register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, WatermelonAndPotato.makeID(name));
        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }

    public static void initialize() {
        WatermelonAndPotato.LOGGER.debug("OH GOD I DON'T KNOW WHAT THINGS I CAN PUT HERE");
    }
}
