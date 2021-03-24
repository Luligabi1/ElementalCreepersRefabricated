package me.luligabi.elementalcreepers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Random;

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
    public void fireExplosionEffect(Entity entity, World entityWorld, double entityX, double entityY, double entityZ) {
        entityWorld.createExplosion(entity,
                entityX, entityY, entityZ, 0, Explosion.DestructionType.NONE);
        if(entityWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            double radius = config.getOrDefault("fireCreeperRadius", 3);
            for (int x = (int) -radius - 1; x <= radius; x++) {
                for (int y = (int) -radius - 1; y <= radius; y++) {
                    for (int z = (int) -radius - 1; z <= radius; z++) {
                        BlockPos blockPos = new BlockPos(entityX + x, entityY + y, entityZ + z);
                        if (entityWorld.getBlockState(blockPos).isAir() && !entityWorld.getBlockState(new BlockPos(entityX + x, (entityY + y) - 1, entityZ + z)).isAir()) {
                            if (new Random().nextBoolean())
                                entityWorld.setBlockState(blockPos, Blocks.FIRE.getDefaultState());
                        }
                    }
                }
            }
        }
    }
    public void earthExplosionEffect(Entity entity, World entityWorld, double entityX, double entityY, double entityZ) {
        entityWorld.createExplosion(entity,
                entityX, entityY, entityZ, 0, Explosion.DestructionType.NONE);
        if(entityWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            double radius = config.getOrDefault("earthCreeperRadius", 5);
            for (int x = (int) -radius - 1; x <= radius; x++) {
                for (int y = (int) -radius - 1; y <= radius; y++) {
                    for (int z = (int) -radius - 1; z <= radius; z++) {
                        BlockPos blockPos = new BlockPos(entityX + x, entityY + y, entityZ + z);
                        if (entityWorld.getBlockState(blockPos).isAir() && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) <= radius) {
                            switch (new Random().nextInt(5 - 1 + 1) + 1) {
                                case 1:
                                    entityWorld.setBlockState(blockPos, Blocks.DIRT.getDefaultState());
                                    break;
                                case 2:
                                    entityWorld.setBlockState(blockPos, Blocks.COARSE_DIRT.getDefaultState());
                                    break;
                                default:
                                    entityWorld.setBlockState(blockPos, Blocks.AIR.getDefaultState());
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    public void airExplosionEffect(Entity entity, World entityWorld, double entityX, double entityY, double entityZ) {
        entityWorld.createExplosion(entity,
                entityX, entityY, entityZ,
                0, Explosion.DestructionType.NONE);
        for(Entity entities : entityWorld.getOtherEntities(null, new Box(entityX-5, entityY-5, entityZ-5, entityX+5, entityY+5, entityZ+5))) {
            entities.setVelocity(0, config.getOrDefault("airCreeperRadius", 1.75D), 0);
        }
    }
    public void electricExplosionEffect(World entityWorld, double entityX, double entityY, double entityZ) {
        LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(entityWorld);
        lightningEntity.setCosmetic(!entityWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING));
        lightningEntity.refreshPositionAfterTeleport(entityX, entityY, entityZ);
        entityWorld.spawnEntity(lightningEntity);
    }
    public void lightExplosionEffect(Entity entity, World entityWorld, double entityX, double entityY, double entityZ) {
        entityWorld.createExplosion(entity,
                entityX, entityY, entityZ, 0, Explosion.DestructionType.NONE);
        if(entityWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            double radius = config.getOrDefault("lightCreeperRadius", 4);
            for (int x = (int) -radius - 1; x <= radius; x++) {
                for (int y = (int) -radius - 1; y <= radius; y++) {
                    for (int z = (int) -radius - 1; z <= radius; z++) {
                        BlockPos blockPos = new BlockPos(entityX + x, entityY + y, entityZ + z);
                        if (entityWorld.getBlockState(blockPos).isAir() && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) <= radius) {
                            switch (new Random().nextInt(5 - 1 + 1) + 1) {
                                case 1: case 2:
                                    entityWorld.setBlockState(blockPos, Blocks.GLOWSTONE.getDefaultState());
                                    break;
                                case 3: case 4: case 5:
                                    entityWorld.setBlockState(blockPos, Blocks.AIR.getDefaultState());
                                    break;
                            }
                        }
                    }
                }
            }
        }
        for(Entity entities : entityWorld.getOtherEntities(null, new Box(entityX-5, entityY-5, entityZ-5, entityX+5, entityY+5, entityZ+5))) {
            if(entities instanceof LivingEntity) {
                // TODO: Add "white blindness" effect
                ((LivingEntity) entities).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 40 * 20, 0));
            }
        }
    }
    public void darkExplosionEffect(Entity entity, World entityWorld, double entityX, double entityY, double entityZ) {
        entityWorld.createExplosion(entity,
                entityX, entityY, entityZ,
                0, Explosion.DestructionType.NONE);
        if(entityWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            double radius = config.getOrDefault("darkCreeperRadius", 4);
            for (int x = (int) -radius; x <= radius; x++) {
                for (int y = (int) -radius; y <= radius; y++) {
                    for (int z = (int) -radius; z <= radius; z++) {
                        BlockPos blockPos = new BlockPos(entityX + x, entityY + y, entityZ + z);
                        BlockState state = entityWorld.getBlockState(blockPos);
                        if (state != null && state.getBlock() != null) {
                            Block lightBlock = state.getBlock();
                            if (lightBlock != null && !lightBlock.hasBlockEntity() && state.getLuminance() > 7.5F &&
                                    Math.sqrt(Math.pow(x, 2.0D) + Math.pow(y, 2.0D) + Math.pow(z, 2.0D)) <= radius) {
                                entityWorld.setBlockState(blockPos, Blocks.AIR.getDefaultState());
                                entityWorld.spawnEntity(new ItemEntity(entityWorld,
                                        entityX, entityY, entityZ, new ItemStack(lightBlock.asItem(), 1)));
                            }
                        }
                    }
                }
            }
        }
        for(Entity entities : entityWorld.getOtherEntities(null, new Box(entityX-5, entityY-5, entityZ-5, entityX+5, entityY+5, entityZ+5))) {
            if(entities instanceof LivingEntity) {
                ((LivingEntity) entities).addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 15 * 20, 0));
            }
        }
    }
    public void iceExplosionEffect(Entity entity, World entityWorld, double entityX, double entityY, double entityZ) {
        entityWorld.createExplosion(entity,
                entityX, entityY, entityZ, 0, Explosion.DestructionType.NONE);
        if(entityWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            double radius = config.getOrDefault("iceCreeperRadius", 4);
            for (int x = (int) -radius - 1; x <= radius; x++) {
                for (int y = (int) -radius - 1; y <= radius; y++) {
                    for (int z = (int) -radius - 1; z <= radius; z++) {
                        if (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) <= radius) {
                            BlockPos blockPos = new BlockPos(entityX + x, entityY + y, entityZ + z);
                            if (entityWorld.getBlockState(blockPos).isAir() && !entityWorld.getBlockState(new BlockPos(entityX + x,(entityY + y) - 1, entityZ + z)).isAir()) {
                                if (new Random().nextBoolean()) {
                                    entityWorld.setBlockState(blockPos, Blocks.SNOW_BLOCK.getDefaultState());
                                } else {
                                    entityWorld.setBlockState(blockPos, Blocks.SNOW.getDefaultState());
                                }
                            } else if (entityWorld.getBlockState(blockPos) == Blocks.WATER.getDefaultState()) {
                                entityWorld.setBlockState(blockPos, Blocks.ICE.getDefaultState());
                            } else if (entityWorld.getBlockState(blockPos) == Blocks.LAVA.getDefaultState()) {
                                entityWorld.setBlockState(blockPos, Blocks.OBSIDIAN.getDefaultState());
                            }
                        }
                    }
                }
            }
        }
        for(Entity entities : entityWorld.getOtherEntities(null, new Box(entityX-5, entityY-5, entityZ-5, entityX+5, entityY+5, entityZ+5))) {
            if(entities instanceof LivingEntity) {
                ((LivingEntity) entities).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40 * 20, 1));
            }
        }
    }
    public void magmaExplosionEffect(Entity entity, World entityWorld, double entityX, double entityY, double entityZ) {
        entityWorld.createExplosion(entity,
                entityX, entityY, entityZ, 0, Explosion.DestructionType.NONE);
        if(entityWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            double radius = config.getOrDefault("magmaCreeperRadius", 4);
            for (int x = (int) -radius - 1; x <= radius; x++) {
                for (int y = (int) -radius - 1; y <= radius; y++) {
                    for (int z = (int) -radius - 1; z <= radius; z++) {
                        BlockPos blockPos = new BlockPos(entityX + x, entityY + y, entityZ + z);
                        if (entityWorld.getBlockState(blockPos).isAir() && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) <= radius) {
                            entityWorld.setBlockState(blockPos, Blocks.LAVA.getDefaultState());
                        }
                    }
                }
            }
        }
    }
}
