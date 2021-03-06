package me.luligabi.elementalcreepers.entity;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.SimpleConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Random;

public class IceCreeperEntity extends ElementalCreeperEntity {

    public IceCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    SimpleConfig config = new ElementalCreepers().getConfig();

    @Override
    public void tickMovement() {
        super.tickMovement();
        if(!this.world.isClient) {
            if (!this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) return;
            int posX = MathHelper.floor(this.getX());
            int posY = MathHelper.floor(this.getY());
            int posZ = MathHelper.floor(this.getZ());
            if (this.world.getBiome(new BlockPos(posX, 0, posZ)).getTemperature(new BlockPos(posX, posY, posZ)) > 1.0F) {
                this.damage(DamageSource.ON_FIRE, 1.0F);
            }
            BlockState blockState = Blocks.SNOW.getDefaultState();

            for (int i = 0; i < 4; ++i) {
                posX = MathHelper.floor(this.getX() + (double) ((float) (i % 2 * 2 - 1) * 0.25F));
                posY = MathHelper.floor(this.getY());
                posZ = MathHelper.floor(this.getZ() + (double) ((float) (i / 2 % 2 * 2 - 1) * 0.25F));
                BlockPos blockPos = new BlockPos(posX, posY, posZ);
                if (this.world.getBlockState(blockPos).isAir() && this.world.getBiome(blockPos).getTemperature(blockPos) < 0.8F && blockState.canPlaceAt(this.world, blockPos)) {
                    this.world.setBlockState(blockPos, blockState);
                }
            }
        }
    }
    @Override
    public void onExplode() {
        this.world.createExplosion(this,
                this.getX(), this.getY(), this.getZ(), 0, Explosion.DestructionType.NONE);
        for(Entity entity : this.world.getOtherEntities(null, new Box(this.getX()-5, this.getY()-5, this.getZ()-5, this.getX()+5, this.getY()+5, this.getZ()+5))) {
            if(entity.isLiving()) {
                ((LivingEntity) entity).applyStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40 * 20, 1));
            }
        }
        double radius = !this.shouldRenderOverlay() ? config.getOrDefault("iceCreeperRadius", 4) : config.getOrDefault("iceCreeperRadius", 4)*1.5;
        for (int x = (int) -radius - 1; x <= radius; x++)  {
            for (int y = (int) -radius - 1; y <= radius; y++) {
                for (int z = (int) -radius - 1; z <= radius; z++) {
                    if (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) <= radius) {
                        BlockPos blockPos = new BlockPos((int) this.getX() + x, (int) this.getY() + y, (int) this.getZ() + z);
                        if (this.world.getBlockState(blockPos).isAir() && !this.world.getBlockState(new BlockPos((int) this.getX() + x, (int) (this.getY() + y) - 1, (int) this.getZ() + z)).isAir()) {
                            if (new Random().nextBoolean()) {
                                this.world.setBlockState(blockPos, Blocks.SNOW_BLOCK.getDefaultState());
                            } else {
                                this.world.setBlockState(blockPos, Blocks.SNOW.getDefaultState());
                            }
                        } else if (this.world.getBlockState(blockPos) == Blocks.WATER.getDefaultState()) {
                            this.world.setBlockState(blockPos, Blocks.ICE.getDefaultState());
                        } else if (this.world.getBlockState(blockPos) == Blocks.LAVA.getDefaultState()) {
                            this.world.setBlockState(blockPos, Blocks.OBSIDIAN.getDefaultState());
                        }
                    }
                }
            }
        }
        super.onExplode();
    }
}
