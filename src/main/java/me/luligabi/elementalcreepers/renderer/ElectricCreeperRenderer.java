package me.luligabi.elementalcreepers.renderer;

import me.luligabi.elementalcreepers.entity.ElectricCreeperEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.util.Identifier;

public class ElectricCreeperRenderer extends MobEntityRenderer<ElectricCreeperEntity, CreeperEntityModel<ElectricCreeperEntity>> {

    public ElectricCreeperRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new CreeperEntityModel<>(), 0.5F);
    }

    @Override
    public Identifier getTexture(ElectricCreeperEntity entity) {
        return new Identifier("elementalcreepers:textures/entity/electric_creeper/creeper.png");
    }
}
