package me.luligabi.elementalcreepers.renderer;

import me.luligabi.elementalcreepers.entity.FireworkCreeperEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.util.Identifier;

public class FireworkCreeperRenderer extends MobEntityRenderer<FireworkCreeperEntity, CreeperEntityModel<FireworkCreeperEntity>> {

    public FireworkCreeperRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new CreeperEntityModel<>(), 0.5F);
    }

    @Override
    public Identifier getTexture(FireworkCreeperEntity entity) {
        return new Identifier("elementalcreepers:textures/entity/firework_creeper/creeper.png");
    }
}
