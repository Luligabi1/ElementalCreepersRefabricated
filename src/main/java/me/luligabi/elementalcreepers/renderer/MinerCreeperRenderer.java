package me.luligabi.elementalcreepers.renderer;

import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;

public class MinerCreeperRenderer extends CreeperEntityRenderer {

    public MinerCreeperRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    @Override
    public Identifier getTexture(CreeperEntity entity) {
        return new Identifier("elementalcreepers:textures/entity/miner_creeper/creeper.png");
    }
}
