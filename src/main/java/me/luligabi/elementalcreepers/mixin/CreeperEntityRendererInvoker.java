package me.luligabi.elementalcreepers.mixin;

import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.CreeperEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(CreeperEntityRenderer.class)
public interface CreeperEntityRendererInvoker {
    @Invoker("scale")
    public void invokerScale(CreeperEntity creeperEntity, MatrixStack matrixStack, float f);
}
