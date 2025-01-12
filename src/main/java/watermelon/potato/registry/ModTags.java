package watermelon.potato.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import watermelon.potato.WatermelonAndPotato;

public class ModTags {
    public static final TagKey<Item> POTATO = of("potato");

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, WatermelonAndPotato.makeID(id));
    }

    public static void initialize() {
        WatermelonAndPotato.LOGGER.debug("OH GOD I DON'T KNOW WHAT THINGS I CAN PUT HERE");
    }
}
