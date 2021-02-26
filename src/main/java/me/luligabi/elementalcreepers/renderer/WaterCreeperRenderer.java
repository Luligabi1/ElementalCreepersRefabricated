package me.luligabi.elementalcreepers.renderer;

import me.luligabi.elementalcreepers.entity.CookieCreeperEntity;
import me.luligabi.elementalcreepers.entity.WaterCreeperEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.util.Identifier;

public class WaterCreeperRenderer extends MobEntityRenderer<WaterCreeperEntity, CreeperEntityModel<WaterCreeperEntity>> {

    public WaterCreeperRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new CreeperEntityModel<>(), 0.5F);
    }

    @Override
    public Identifier getTexture(WaterCreeperEntity entity) {
        return new Identifier("elementalcreepers:textures/entity/water_creeper/creeper.png");
    }
}
