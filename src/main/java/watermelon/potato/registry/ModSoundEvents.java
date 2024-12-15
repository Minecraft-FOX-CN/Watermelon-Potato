package watermelon.potato.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import watermelon.potato.WatermelonAndPotato;

public class ModSoundEvents {
    public static final SoundEvent POTATO_INTRODUCTION = register("potato_introduction");
    public static final SoundEvent POTATO_INTRODUCTION_REVERSAL = register("potato_introduction_reversal");

    private static SoundEvent register(String id) {
        Identifier identifier = WatermelonAndPotato.makeID(id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void initialize() {
        WatermelonAndPotato.LOGGER.debug("OH GOD I DON'T KNOW WHAT THINGS I CAN PUT HERE");
    }
}
