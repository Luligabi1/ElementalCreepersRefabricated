package me.luligabi.elementalcreepers.entity;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.SimpleConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;


public class DarkCreeperEntity extends ElementalCreeperEntity {

    public DarkCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    SimpleConfig config = new ElementalCreepers().getConfig();



    @Override
    public void onExplode() {
        this.world.createExplosion(this,
                this.getX(), this.getY(), this.getZ(),
                0, Explosion.DestructionType.NONE);
        if(this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            double radius = config.getOrDefault("darkCreeperRadius", 4);
            for (int x = (int) -radius; x <= radius; x++) {
                for (int y = (int) -radius; y <= radius; y++) {
                    for (int z = (int) -radius; z <= radius; z++) {
                        BlockPos blockPos = new BlockPos(this.getX() + x, this.getY() + y, this.getZ() + z);
                        BlockState state = world.getBlockState(blockPos);
                        if (state != null && state.getBlock() != null) {
                            Block lightBlock = state.getBlock();
                            if (lightBlock != null && !lightBlock.hasBlockEntity() && state.getLuminance() > 7.5F &&
                                    Math.sqrt(Math.pow(x, 2.0D) + Math.pow(y, 2.0D) + Math.pow(z, 2.0D)) <= radius) {
                                this.world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
                                this.world.spawnEntity(new ItemEntity(this.world,
                                        this.getX(), this.getY(), this.getZ(), new ItemStack(lightBlock.asItem(), 1)));
                            }
                        }
                    }
                }
            }
        }
        for(Entity entity : this.world.getOtherEntities(null, new Box(this.getX()-5, this.getY()-5, this.getZ()-5, this.getX()+5, this.getY()+5, this.getZ()+5))) {
            if(entity instanceof LivingEntity) {
                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 15 * 20, 0));
            }
        }
        super.onExplode();
    }
}