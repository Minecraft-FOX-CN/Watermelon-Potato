package watermelon.potato.registry;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import watermelon.potato.WatermelonAndPotato;
import watermelon.potato.common.entity.render.WatermelonPotatoEntityRenderer;

public class ModEntityRenderer {
    public static void initialize() {
        EntityRendererRegistry.register(ModEntityTypes.WATERMELON_POTATO_ENTITY_TYPE, ctx -> new WatermelonPotatoEntityRenderer(ctx, 1f));
        WatermelonAndPotato.LOGGER.debug("OH GOD I DON'T KNOW WHAT THINGS I CAN PUT HERE");
    }
}
