package me.luligabi.elementalcreepers.renderer;

import me.luligabi.elementalcreepers.entity.CookieCreeperEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.util.Identifier;

public class CookieCreeperRenderer extends MobEntityRenderer<CookieCreeperEntity, CreeperEntityModel<CookieCreeperEntity>> {

    public CookieCreeperRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new CreeperEntityModel<>(), 0.5F);
    }

    @Override
    public Identifier getTexture(CookieCreeperEntity entity) {
        return new Identifier("elementalcreepers:textures/entity/cookie_creeper/creeper.png");
    }
}
