package watermelon.potato.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import watermelon.potato.WatermelonAndPotato;

public class ModItemGroups {
    public static final ItemGroup POTATO_ITEM_GROUP = register("wap", FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.POTATO))
            .displayName(Text.translatable("itemgroup.wap.potato_item_group"))
            .entries(((displayContext, entries) -> {
                entries.add(ModBlocks.POTATO_BLOCK);
                entries.add(ModBlocks.COOKED_POTATO_BLOCK);
                entries.add(ModItems.POTATO_AXE);
                entries.add(ModItems.POTATO_PICKAXE);
                entries.add(ModItems.POTATO_SWORD);
                entries.add(ModItems.WATERMELON_POTATO_SPAWN_EGG);
            }))
            .build());

    private static ItemGroup register(String name, ItemGroup itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, WatermelonAndPotato.makeID(name), itemGroup);
    }

    public static void initialize() {
        WatermelonAndPotato.LOGGER.debug("OH GOD I DON'T KNOW WHAT THINGS I CAN PUT HERE");
    }
}
