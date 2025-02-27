package watermelon.potato;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import watermelon.potato.registry.*;

public class WatermelonAndPotato implements ModInitializer {
	public static final String MOD_ID = "wap";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Identifier makeID(String name) {
		return Identifier.of(MOD_ID,name);
	}

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModBlocks.initialize();
		ModItems.initialize();
		ModItemGroups.initialize();
		ModEntityTypes.initialize();
		ModSoundEvents.initialize();
		ModEntityRenderer.initialize();
		ModTags.initialize();
	}
}