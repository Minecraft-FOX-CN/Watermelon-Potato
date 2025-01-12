package watermelon.potato.registry;

import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import watermelon.potato.WatermelonAndPotato;

public interface ModEquipmentAssetKeys {
    RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    RegistryKey<EquipmentAsset> MELON_POTATO = register("melon_potato");

    static RegistryKey<EquipmentAsset> register(String name) {
        return RegistryKey.of(REGISTRY_KEY, WatermelonAndPotato.makeID(name));
    }
}
