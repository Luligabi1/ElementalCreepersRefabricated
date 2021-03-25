package me.luligabi.elementalcreepers;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Arrays;
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
    public void hydrogenExplosionEffect(Entity entity, World entityWorld, double entityX, double entityY, double entityZ) {
        entityWorld.createExplosion(entity, entityX, entityY, entityZ,
                (float) config.getOrDefault("hydrogenCreeperRadius", 7F), entityWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ?
                        Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE);
    }
    public void reverseExplosionEffect(Entity entity, World entityWorld, double entityX, double entityY, double entityZ) {
        double radius = config.getOrDefault("reverseCreeperRadius", 3.75);

        entityWorld.createExplosion(entity,
                entityX, entityY, entityZ, 0, Explosion.DestructionType.NONE);
        if(entityWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            BlockState[][][] states = new BlockState[(int) (radius * 2 + 2)][(int) (radius * 2 + 2)][(int) (radius * 2 + 2)];
            for (int x = (int) -radius - 1; x <= radius; x++) {
                for (int y = (int) -radius - 1; y <= radius; y++) {
                    for (int z = (int) -radius - 1; z <= radius; z++) {
                        int ax = (int) (x + radius + 1);
                        int ay = (int) (y + radius + 1);
                        int az = (int) (z + radius + 1);
                        double ex = entityX + x;
                        double ey = entityY + y;
                        double ez = entityZ + z;
                        BlockPos blockPos = new BlockPos(ex, ey, ez);
                        BlockState state = entityWorld.getBlockState(blockPos);

                        if (state != null && state.getBlock() != null) {
                            Block id = state.getBlock();

                            if (id != Blocks.BEDROCK) {
                                states[ax][ay][az] = null;

                                if (id != null && Math.sqrt(Math.pow(x, 2.0D) + Math.pow(y, 2.0D) + Math.pow(z, 2.0D)) <= radius && ey > -1) {
                                    states[ax][ay][az] = state;
                                }
                            }
                        }
                    }
                }
            }
            for (int x = (int) (-radius - 1); x <= radius; x++) {
                for (int y = (int) (-radius - 1); y <= radius; y++) {
                    for (int z = (int) (-radius - 1); z <= radius; z++) {
                        BlockPos blockPos = new BlockPos(entityX + x, entityY + y, entityZ + z);
                        BlockState state = states[(int) (x + radius + 1)][(int) (2 * radius - (y + radius))][(int) (z + radius + 1)];

                        if (state != null && state.getBlock() != null && entityY + y > 5) {
                            entityWorld.setBlockState(blockPos, state, 3);
                        }
                    }
                }
            }
        }
    }
    public void minerExplosionEffect(Entity entity, World entityWorld, double entityX, double entityY, double entityZ) {
        entityWorld.createExplosion(entity, entityX, entityY, entityZ,
                0, Explosion.DestructionType.NONE);
        if(entityWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            double radius = config.getOrDefault("minerCreeperRadius", 3.75);
            for (int x = (int) -radius; x <= radius; x++) {
                for (int y = (int) -radius; y <= radius; y++) {
                    for (int z = (int) -radius; z <= radius; z++) {
                        BlockPos blockPos = new BlockPos(entityX + x, entityY+ y, entityZ + z);
                        BlockState state = entityWorld.getBlockState(blockPos);

                        if (state != null && state.getBlock() != null) {
                            Block stoneBlock = state.getBlock();
                            Block[] stoneBlockList = {Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.GRAVEL, Blocks.CLAY};

                            if (stoneBlock != null && Arrays.asList(stoneBlockList).contains(stoneBlock) && Math.sqrt(Math.pow(x, 2.0D) + Math.pow(y, 2.0D) + Math.pow(z, 2.0D)) <= radius) {
                                entityWorld.setBlockState(blockPos, Blocks.AIR.getDefaultState());
                                if(new Random().nextBoolean()) {
                                    entityWorld.spawnEntity(new ItemEntity(entityWorld,
                                            entityX, entityY, entityZ, new ItemStack(stoneBlock.asItem(), 1)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    // Missing illusion Creeper is intentional, as it's the same as vanilla creeper.

    public void fireworkExplosionEffect(World entityWorld, double entityX, double entityY, double entityZ) {
        ItemStack fireWork = new ItemStack(Items.FIREWORK_ROCKET);
        try {
            fireWork.putSubTag("Fireworks", StringNbtReader.parse("{Explosions:[{Type:3,Flicker:1,Colors:[I;4312372],FadeColors:[I;4312372]}],Flight:1}"));
        } catch(CommandSyntaxException ignored) {}
        FireworkRocketEntity fireworkEntity = new FireworkRocketEntity(entityWorld,
                entityX, entityY, entityZ, fireWork);
        fireworkEntity.refreshPositionAfterTeleport(entityX, entityY, entityZ);
        entityWorld.spawnEntity(fireworkEntity);
    }

    public void cookieExplosionEffect(Entity entity, World entityWorld, double entityX, double entityY, double entityZ) {
        entityWorld.createExplosion(entity,
                entityX, entityY, entityZ,
                0, Explosion.DestructionType.NONE);
        int randomCookie = new Random().nextInt(4 - 2 + 1) + 2;
        entityWorld.spawnEntity(new ItemEntity(entityWorld,
                entityX, entityY, entityZ, new ItemStack(Items.COOKIE, randomCookie)));
    }
    public void rainbowExplosionEffect(Entity entity, World entityWorld, double entityX, double entityY, double entityZ) {
        switch (new Random().nextInt(14 - 1 + 1) + 1) {
            case 1:
                waterExplosionEffect(entity, entityWorld, entityX, entityY, entityZ);
                break;
            case 2:
                fireExplosionEffect(entity, entityWorld, entityX, entityY, entityZ);
                break;
            case 3:
                earthExplosionEffect(entity, entityWorld, entityX, entityY, entityZ);
                break;
            case 4:
                airExplosionEffect(entity, entityWorld, entityX, entityY, entityZ);
                break;
            case 5:
                electricExplosionEffect(entityWorld, entityX, entityY, entityZ);
                break;
            case 6:
                lightExplosionEffect(entity, entityWorld, entityX, entityY, entityZ);
                break;
            case 7:
                darkExplosionEffect(entity, entityWorld, entityX, entityY, entityZ);
                break;
            case 8:
                iceExplosionEffect(entity, entityWorld, entityX, entityY, entityZ);
                break;
            case 9:
                magmaExplosionEffect(entity, entityWorld, entityX, entityY, entityZ);
                break;
            case 10:
                hydrogenExplosionEffect(entity, entityWorld, entityX, entityY, entityZ);
                break;
            case 11:
                reverseExplosionEffect(entity, entityWorld, entityX, entityY, entityZ);
                break;
            case 12:
                minerExplosionEffect(entity, entityWorld, entityX, entityY, entityZ);
                break;
            case 13:
                fireworkExplosionEffect(entityWorld, entityX, entityY, entityZ);
                break;
            case 14:
                cookieExplosionEffect(entity, entityWorld, entityX, entityY, entityZ);
                break;
            default:
                break;
        }
    }
}
