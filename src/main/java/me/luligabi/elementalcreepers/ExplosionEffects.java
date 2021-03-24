package me.luligabi.elementalcreepers;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class ExplosionEffects {

    SimpleConfig config = new ElementalCreepers().getConfig();

    public void waterExplosionEffect(Entity entity, World entityWorld, double entityX, double entityY, double entityZ) {
        entityWorld.createExplosion(entity,
                entityX, entityY, entityZ, 0, Explosion.DestructionType.NONE);
        if(entityWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            double radius = config.getOrDefault("waterCreeperRadius", 3);
            for (int x = (int) -radius - 1; x <= radius; x++) {
                for (int y = (int) -radius - 1; y <= radius; y++) {
                    for (int z = (int) -radius - 1; z <= radius; z++) {
                        BlockPos blockPos = new BlockPos(entityX + x,entityY + y,entityZ + z);
                        if (entityWorld.getBlockState(blockPos).isAir() && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) <= radius) {
                            entityWorld.setBlockState(blockPos, Blocks.WATER.getDefaultState());
                        }
                    }
                }
            }
        }
    }


}
