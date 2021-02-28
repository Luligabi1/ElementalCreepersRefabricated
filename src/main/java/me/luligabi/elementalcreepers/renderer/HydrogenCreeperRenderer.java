package me.luligabi.elementalcreepers.renderer;

import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;

public class HydrogenCreeperRenderer extends CreeperEntityRenderer {

    public HydrogenCreeperRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    @Override
    public Identifier getTexture(CreeperEntity entity) {
        return new Identifier("elementalcreepers:textures/entity/electric_creeper/creeper.png"); //TODO: Add proper texture

    }
}