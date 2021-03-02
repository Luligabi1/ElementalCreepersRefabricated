package me.luligabi.elementalcreepers.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Random;

public class FireCreeperEntity extends ElementalCreeperEntity {

    public FireCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
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
                    if (this.world.getBlockState(blockPos).isAir() && !this.world.getBlockState(new BlockPos((int) this.getX() + x, (int) (this.getY() + y) - 1, (int) this.getZ() + z)).isAir()) {
                        if(new Random().nextBoolean()) this.world.setBlockState(blockPos, Blocks.FIRE.getDefaultState());
                    }
                }
            }
        }
        super.onExplode();
    }
}
