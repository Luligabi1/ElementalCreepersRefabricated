package me.luligabi.elementalcreepers.renderer;

import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;

public class EnderCreeperRenderer extends CreeperEntityRenderer {

    public EnderCreeperRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    @Override
    public Identifier getTexture(CreeperEntity entity) {
        return new Identifier("elementalcreepers:textures/entity/air_creeper/creeper.png"); //TODO: Change texture
    }
}
