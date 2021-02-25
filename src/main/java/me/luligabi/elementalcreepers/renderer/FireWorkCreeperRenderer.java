package me.luligabi.elementalcreepers.renderer;

import me.luligabi.elementalcreepers.entity.FireWorkCreeperEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.util.Identifier;

public class FireWorkCreeperRenderer extends MobEntityRenderer<FireWorkCreeperEntity, CreeperEntityModel<FireWorkCreeperEntity>> {

    public FireWorkCreeperRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new CreeperEntityModel<>(), 0.5F);
    }

    @Override
    public Identifier getTexture(FireWorkCreeperEntity entity) {
        return new Identifier("elementalcreepers:textures/entity/firework_creeper/creeper.png");
    }
}
