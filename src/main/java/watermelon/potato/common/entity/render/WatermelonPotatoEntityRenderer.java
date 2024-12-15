package watermelon.potato.common.entity.render;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.util.Identifier;
import watermelon.potato.WatermelonAndPotato;
import watermelon.potato.common.entity.object.WatermelonPotatoEntity;

public class WatermelonPotatoEntityRenderer extends MobEntityRenderer<WatermelonPotatoEntity, PlayerEntityRenderState, PlayerEntityModel> {

    public WatermelonPotatoEntityRenderer(EntityRendererFactory.Context context, float f) {
        super(context, new PlayerEntityModel(context.getPart(EntityModelLayers.PLAYER), false), f);
    }

    @Override
    public Identifier getTexture(PlayerEntityRenderState state) {
        return WatermelonAndPotato.makeID("textures/entity/watermelon_potato.png");
    }

    @Override
    public PlayerEntityRenderState createRenderState() {
        return new PlayerEntityRenderState();
    }
}
