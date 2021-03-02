package me.luligabi.elementalcreepers.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Random;

public class EarthCreeperEntity extends ElementalCreeperEntity {

    public EarthCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onExplode() {
        this.world.createExplosion(this,
                this.getX(), this.getY(), this.getZ(), 0, Explosion.DestructionType.NONE);
        double radiusEarth = 5;
        for (int x = (int) -radiusEarth - 1; x <= radiusEarth; x++) {
            for (int y = (int) -radiusEarth - 1; y <= radiusEarth; y++) {
                for (int z = (int) -radiusEarth - 1; z <= radiusEarth; z++) {
                    BlockPos blockPos = new BlockPos((int) this.getX() + x, (int) this.getY() + y, (int) this.getZ() + z);
                    if (this.world.getBlockState(blockPos).isAir() && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) <= radiusEarth) {
                        switch(new Random().nextInt(5 - 1 + 1) + 1) {
                            case 1: case 2: case 3:
                                this.world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
                                break;
                            case 4: case 5:
                                this.world.setBlockState(blockPos, Blocks.DIRT.getDefaultState());
                                break;
                        }
                    }
                }
            }
        }
        super.onExplode();
    }
}
