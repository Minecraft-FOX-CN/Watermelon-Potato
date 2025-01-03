package watermelon.potato.registry;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import watermelon.potato.WatermelonAndPotato;
import watermelon.potato.common.Item.PotatoAxe;
import watermelon.potato.common.Item.PotatoPickaxe;
import watermelon.potato.common.Item.PotatoSword;

import java.util.function.Function;

public class ModItems {
    public static final Item WATERMELON_POTATO_SPAWN_EGG = registerItem("watermelon_potato_spawn_egg", settings -> new SpawnEggItem(ModEntityTypes.WATERMELON_POTATO_ENTITY_TYPE, settings), new Item.Settings()
            .maxCount(1));

    public static final Item POTATO_PICKAXE = registerItem("potato_pickaxe", PotatoPickaxe::new, new Item.Settings()
            .food(FoodComponents.COOKED_BEEF));

    public static final Item POTATO_SWORD = registerItem("potato_sword", PotatoSword::new, new Item.Settings()
            .food(FoodComponents.COOKED_CHICKEN));

    public static final Item POTATO_AXE = registerItem("potato_axe", PotatoAxe::new, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)));
    public static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, WatermelonAndPotato.makeID(name));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerFuels() {
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(POTATO_PICKAXE, 300);
            builder.add(POTATO_SWORD, 200);
        });
    }

    public static void initialize() {
        registerFuels();
        WatermelonAndPotato.LOGGER.debug("OH GOD I DON'T KNOW WHAT THINGS I CAN PUT HERE");
    }
}
