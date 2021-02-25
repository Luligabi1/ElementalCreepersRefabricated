package me.luligabi.elementalcreepers.renderer;

import me.luligabi.elementalcreepers.entity.IceCreeperEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.util.Identifier;

public class IceCreeperRenderer extends MobEntityRenderer<IceCreeperEntity, CreeperEntityModel<IceCreeperEntity>> {

    public IceCreeperRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new CreeperEntityModel<>(), 0.5F);
    }

    @Override
    public Identifier getTexture(IceCreeperEntity entity) {
        return new Identifier("elementalcreepers:textures/entity/ice_creeper/creeper.png");
    }
}
