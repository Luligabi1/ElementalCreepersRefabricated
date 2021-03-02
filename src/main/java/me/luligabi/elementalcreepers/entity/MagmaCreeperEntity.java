package me.luligabi.elementalcreepers.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class MagmaCreeperEntity extends ElementalCreeperEntity {

    public MagmaCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    //TODO: Disable fire damage.

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

    @Override
    public void onExplode() {
        double radius = 3; //TODO: Add config to change radius and charged value.
        this.world.createExplosion(this,
                this.getX(), this.getY(), this.getZ(), 0, Explosion.DestructionType.NONE);
        for (int x = (int) -radius - 1; x <= radius; x++) {
            for (int y = (int) -radius - 1; y <= radius; y++) {
                for (int z = (int) -radius - 1; z <= radius; z++) {
                    BlockPos blockPos = new BlockPos((int) this.getX() + x, (int) this.getY() + y, (int) this.getZ() + z);
                    if (this.world.getBlockState(blockPos).isAir() && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) <= radius) {
                        this.world.setBlockState(blockPos, Blocks.LAVA.getDefaultState());
                    }
                }
            }
        }
        super.onExplode();
    }
}