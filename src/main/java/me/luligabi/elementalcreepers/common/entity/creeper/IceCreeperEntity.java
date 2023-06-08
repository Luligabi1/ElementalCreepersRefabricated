package me.luligabi.elementalcreepers.common.entity.creeper;

import me.luligabi.elementalcreepers.common.entity.ExplosionEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class IceCreeperEntity extends ElementalCreeperEntity {

    public IceCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    boolean generateSnow = true;

    @Override
    public void tickMovement() {
        super.tickMovement();
        if(!this.getWorld().isClient) {
            if(generateSnow) {
                if (!this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) return;
                int posX = MathHelper.floor(this.getX());
                int posY = MathHelper.floor(this.getY());
                int posZ = MathHelper.floor(this.getZ());
                /*if (this.getWorld().getBiome(new BlockPos(posX, posY, posZ)).value().getTemperature() > 1.0F) {
                    this.damage(DamageSources.onFire(), 1.0F);
                }*/
                BlockState blockState = Blocks.SNOW.getDefaultState();

                for (int i = 0; i < 4; ++i) {
                    posX = MathHelper.floor(this.getX() + (double) ((float) (i % 2 * 2 - 1) * 0.25F));
                    posY = MathHelper.floor(this.getY());
                    posZ = MathHelper.floor(this.getZ() + (double) ((float) (i / 2 % 2 * 2 - 1) * 0.25F));
                    BlockPos blockPos = new BlockPos(posX, posY, posZ);
                    if (this.getWorld().getBlockState(blockPos).isAir() && this.getWorld().getBiome(blockPos).value().getTemperature() < 0.8F && blockState.canPlaceAt(this.getWorld(), blockPos)) {
                        this.getWorld().setBlockState(blockPos, blockState);
                    }
                }
            }
        }
    }

    @Override
    public void onExplode() {
        generateSnow = false;
        ExplosionEffects.iceExplosionEffect(this, getWorld(), getX(), getY(), getZ());
        super.onExplode();
        generateSnow = true;
    }
}
