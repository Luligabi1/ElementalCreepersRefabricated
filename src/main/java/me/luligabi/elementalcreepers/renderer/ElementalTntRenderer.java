package me.luligabi.elementalcreepers.renderer;

import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.TntMinecartEntityRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

public class ElementalTntRenderer extends EntityRenderer<ElementalTntEntity> {
    private final BlockState blockState;

    public ElementalTntRenderer(EntityRendererFactory.Context context, BlockState blockState) {
        super(context);
        this.shadowRadius = 0.5f;
        this.blockState = blockState;
    }

    public void render(ElementalTntEntity tntEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.translate(0.0, 0.5, 0.0);
        if (tntEntity.getFuseTimer() - g + 1.0f < 10.0f) {
            float h = 1.0f - (tntEntity.getFuseTimer() - g + 1.0f) / 10.0f;
            h = MathHelper.clamp(h, 0.0f, 1.0f);
            h *= h;
            h *= h;
            final float j = 1.0f + h * 0.3f;
            matrixStack.scale(j, j, j);
        }
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(-90.0f));
        matrixStack.translate(-0.5, -0.5, 0.5);
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(90.0f));
        TntMinecartEntityRenderer.renderFlashingBlock(this.blockState, matrixStack, vertexConsumerProvider, i, tntEntity.getFuseTimer() / 5 % 2 == 0);
        matrixStack.pop();
        super.render(tntEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    public Identifier getTexture(ElementalTntEntity tntEntity) {
        return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
    }
}