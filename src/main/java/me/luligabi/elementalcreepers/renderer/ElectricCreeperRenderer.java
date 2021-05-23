package me.luligabi.elementalcreepers.renderer;

import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;

public class ElectricCreeperRenderer extends CreeperEntityRenderer {

    public ElectricCreeperRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(CreeperEntity entity) {
        return new Identifier("elementalcreepers:textures/entity/electric_creeper/creeper.png");
    }
}
