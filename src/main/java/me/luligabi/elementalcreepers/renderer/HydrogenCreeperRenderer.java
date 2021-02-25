package me.luligabi.elementalcreepers.renderer;

import me.luligabi.elementalcreepers.entity.ElectricCreeperEntity;
import me.luligabi.elementalcreepers.entity.HydrogenCreeperEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.util.Identifier;

public class HydrogenCreeperRenderer extends MobEntityRenderer<HydrogenCreeperEntity, CreeperEntityModel<HydrogenCreeperEntity>> {

    public HydrogenCreeperRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new CreeperEntityModel<>(), 0.5F);
    }

    @Override
    public Identifier getTexture(HydrogenCreeperEntity entity) {
        return new Identifier("elementalcreepers:textures/entity/electric_creeper/creeper.png"); //TODO: Add proper texture

    }
}