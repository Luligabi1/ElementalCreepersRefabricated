package me.luligabi.elementalcreepers.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class WaterCreeperEntity extends ElementalCreeperEntity {

    public WaterCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    public void onExplode() {
        double radiusWater = 3; //TODO: Add config to change radius and charged value.
        this.world.createExplosion(this,
                this.getX(), this.getY(), this.getZ(), 0, Explosion.DestructionType.NONE);
        for (int x = (int) -radiusWater - 1; x <= radiusWater; x++) {
            for (int y = (int) -radiusWater - 1; y <= radiusWater; y++) {
                for (int z = (int) -radiusWater - 1; z <= radiusWater; z++) {
                    BlockPos blockPos = new BlockPos((int) this.getX() + x, (int) this.getY() + y, (int) this.getZ() + z);
                    if (this.world.getBlockState(blockPos).isAir() && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) <= radiusWater) {
                        this.world.setBlockState(blockPos, Blocks.WATER.getDefaultState());
                    }
                }
            }
        }
        super.onExplode();
    }
}