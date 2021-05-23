package me.luligabi.elementalcreepers.common.entity.creeper;

import me.luligabi.elementalcreepers.common.ElementalCreepers;
import me.luligabi.elementalcreepers.common.SimpleConfig;
import me.luligabi.elementalcreepers.common.entity.ExplosionEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class IceCreeperEntity extends ElementalCreeperEntity {

    public IceCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    SimpleConfig config = new ElementalCreepers().getConfig();
    boolean generateSnow = true;

    @Override
    public void tickMovement() {
        super.tickMovement();
        if(!this.world.isClient) {
            if(generateSnow) {
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
    }

    @Override
    public void onExplode() {
        generateSnow = false;
        new ExplosionEffects().iceExplosionEffect(this, this.world, this.getX(), this.getY(), this.getZ());
        super.onExplode();
        generateSnow = true;
    }
}
