package me.luligabi.elementalcreepers.entity;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.SimpleConfig;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Random;

public class EarthCreeperEntity extends ElementalCreeperEntity {

    public EarthCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    SimpleConfig config = new ElementalCreepers().getConfig();

    @Override
    public void onExplode() {
        this.world.createExplosion(this,
                this.getX(), this.getY(), this.getZ(), 0, Explosion.DestructionType.NONE);
        if(this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            double radius = config.getOrDefault("earthCreeperRadius", 5);
            for (int x = (int) -radius - 1; x <= radius; x++) {
                for (int y = (int) -radius - 1; y <= radius; y++) {
                    for (int z = (int) -radius - 1; z <= radius; z++) {
                        BlockPos blockPos = new BlockPos((int) this.getX() + x, (int) this.getY() + y, (int) this.getZ() + z);
                        if (this.world.getBlockState(blockPos).isAir() && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) <= radius) {
                            switch (new Random().nextInt(5 - 1 + 1) + 1) {
                                case 1:
                                    this.world.setBlockState(blockPos, Blocks.DIRT.getDefaultState());
                                    break;
                                case 2:
                                    this.world.setBlockState(blockPos, Blocks.COARSE_DIRT.getDefaultState());
                                    break;
                                case 3:
                                case 4:
                                case 5:
                                    this.world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
                                    break;
                            }
                        }
                    }
                }
            }
        }
        super.onExplode();
    }
}
