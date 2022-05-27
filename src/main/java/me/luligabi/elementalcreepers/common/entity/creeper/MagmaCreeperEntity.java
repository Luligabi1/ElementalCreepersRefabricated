package me.luligabi.elementalcreepers.common.entity.creeper;

import me.luligabi.elementalcreepers.common.entity.ExplosionEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class MagmaCreeperEntity extends ElementalCreeperEntity {

    public MagmaCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if(!this.world.isClient) {
            if (!this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) return;
            BlockState blockState = Blocks.FIRE.getDefaultState();

            for (int i = 0; i < 4; ++i) {
                int posX = MathHelper.floor(this.getX() + (double) ((float) (i % 2 * 2 - 1) * 0.25F));
                int posY = MathHelper.floor(this.getY());
                int posZ = MathHelper.floor(this.getZ() + (double) ((float) (i / 2 % 2 * 2 - 1) * 0.25F));
                BlockPos blockPos = new BlockPos(posX, posY, posZ);
                if (blockState.canPlaceAt(this.world, blockPos)) {
                    this.world.setBlockState(blockPos, blockState);
                }
            }
        }
    }
    public boolean hurtByWater() {
        return true;
    }

    @Override
    public void onExplode() {
        new ExplosionEffects().magmaExplosionEffect(this, this.world, this.getX(), this.getY(), this.getZ());
        super.onExplode();
    }
}