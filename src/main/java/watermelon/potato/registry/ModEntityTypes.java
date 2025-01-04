package watermelon.potato.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import watermelon.potato.WatermelonAndPotato;
import watermelon.potato.common.entity.object.WatermelonPotatoEntity;

public class ModEntityTypes {
    public static final EntityType<WatermelonPotatoEntity> WATERMELON_POTATO_ENTITY_TYPE = register("melon_potato",
            EntityType.Builder.create(WatermelonPotatoEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6F, 1.95F)
                    .eyeHeight(1.74F)
                    .passengerAttachments(2.0125F)
                    .vehicleAttachment(-0.7F)
                    .maxTrackingRange(8));

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, WatermelonAndPotato.makeID(id));
        return Registry.register(Registries.ENTITY_TYPE, key, type.build(key));
    }

    public static void initialize() {
        FabricDefaultAttributeRegistry.register(WATERMELON_POTATO_ENTITY_TYPE, WatermelonPotatoEntity.createHostileAttributes()
                .add(EntityAttributes.MAX_HEALTH, 120)
                .add(EntityAttributes.ATTACK_DAMAGE, 4)
                .add(EntityAttributes.ATTACK_SPEED, 1)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.2f)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 2)
                .add(EntityAttributes.FOLLOW_RANGE, 24));

        WatermelonAndPotato.LOGGER.debug("OH GOD I DON'T KNOW WHAT THINGS I CAN PUT HERE");
    }
}
