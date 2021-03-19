package me.luligabi.elementalcreepers.entity;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.SimpleConfig;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Random;

public class LightCreeperEntity extends ElementalCreeperEntity {

    public LightCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    SimpleConfig config = new ElementalCreepers().getConfig();

    @Override
    public void onExplode() {
        this.world.createExplosion(this,
                this.getX(), this.getY(), this.getZ(), 0, Explosion.DestructionType.NONE);
        if(this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            double radius = config.getOrDefault("lightCreeperRadius", 4);
            for (int x = (int) -radius - 1; x <= radius; x++) {
                for (int y = (int) -radius - 1; y <= radius; y++) {
                    for (int z = (int) -radius - 1; z <= radius; z++) {
                        BlockPos blockPos = new BlockPos((int) this.getX() + x, (int) this.getY() + y, (int) this.getZ() + z);
                        if (this.world.getBlockState(blockPos).isAir() && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) <= radius) {
                            switch (new Random().nextInt(5 - 1 + 1) + 1) {
                                case 1: case 2:
                                    this.world.setBlockState(blockPos, Blocks.GLOWSTONE.getDefaultState());
                                    break;
                                case 3: case 4: case 5:
                                    this.world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
                                    break;
                            }
                        }
                    }
                }
            }
        }
        for(Entity entity : this.world.getOtherEntities(null, new Box(this.getX()-5, this.getY()-5, this.getZ()-5, this.getX()+5, this.getY()+5, this.getZ()+5))) {
            if(entity instanceof LivingEntity) {
                // TODO: Add "white blindness" effect
                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 40 * 20, 0));
            }
        }
        super.onExplode();
    }
}
