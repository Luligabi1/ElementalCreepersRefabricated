package me.luligabi.elementalcreepers.common.misc;

import me.luligabi.elementalcreepers.common.block.TntRegistry;
import me.luligabi.elementalcreepers.common.entity.tnt.*;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DispenserLogicRegistry implements DispenserBehavior {

    public static void init() {
        DispenserBlock.registerBehavior(TntRegistry.WATER_TNT_BLOCK, new ItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer blockPointer, ItemStack itemStack) {
                BlockPos blockPos = blockPointer.getPos().offset(blockPointer.getBlockState().get(DispenserBlock.FACING));
                WaterTntEntity tntEntity = new WaterTntEntity(TntRegistry.WATER_TNT_ENTITY, blockPointer.getWorld());
                spawnTnt(tntEntity, blockPos, blockPointer.getWorld(), itemStack);
                return itemStack;
            }
        });

        DispenserBlock.registerBehavior(TntRegistry.FIRE_TNT_BLOCK, new ItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer blockPointer, ItemStack itemStack) {
                BlockPos blockPos = blockPointer.getPos().offset(blockPointer.getBlockState().get(DispenserBlock.FACING));
                FireTntEntity tntEntity = new FireTntEntity(TntRegistry.FIRE_TNT_ENTITY, blockPointer.getWorld());
                spawnTnt(tntEntity, blockPos, blockPointer.getWorld(), itemStack);
                return itemStack;
            }
        });

        DispenserBlock.registerBehavior(TntRegistry.EARTH_TNT_BLOCK, new ItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer blockPointer, ItemStack itemStack) {
                BlockPos blockPos = blockPointer.getPos().offset(blockPointer.getBlockState().get(DispenserBlock.FACING));
                EarthTntEntity tntEntity = new EarthTntEntity(TntRegistry.EARTH_TNT_ENTITY, blockPointer.getWorld());
                spawnTnt(tntEntity, blockPos, blockPointer.getWorld(), itemStack);
                return itemStack;
            }
        });

        DispenserBlock.registerBehavior(TntRegistry.AIR_TNT_BLOCK, new ItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer blockPointer, ItemStack itemStack) {
                BlockPos blockPos = blockPointer.getPos().offset(blockPointer.getBlockState().get(DispenserBlock.FACING));
                AirTntEntity tntEntity = new AirTntEntity(TntRegistry.AIR_TNT_ENTITY, blockPointer.getWorld());
                spawnTnt(tntEntity, blockPos, blockPointer.getWorld(), itemStack);
                return itemStack;
            }
        });

        DispenserBlock.registerBehavior(TntRegistry.ELECTRIC_TNT_BLOCK, new ItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer blockPointer, ItemStack itemStack) {
                BlockPos blockPos = blockPointer.getPos().offset(blockPointer.getBlockState().get(DispenserBlock.FACING));
                ElectricTntEntity tntEntity = new ElectricTntEntity(TntRegistry.ELECTRIC_TNT_ENTITY, blockPointer.getWorld());
                spawnTnt(tntEntity, blockPos, blockPointer.getWorld(), itemStack);
                return itemStack;
            }
        });

        DispenserBlock.registerBehavior(TntRegistry.LIGHT_TNT_BLOCK, new ItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer blockPointer, ItemStack itemStack) {
                BlockPos blockPos = blockPointer.getPos().offset(blockPointer.getBlockState().get(DispenserBlock.FACING));
                LightTntEntity tntEntity = new LightTntEntity(TntRegistry.LIGHT_TNT_ENTITY, blockPointer.getWorld());
                spawnTnt(tntEntity, blockPos, blockPointer.getWorld(), itemStack);
                return itemStack;
            }
        });

        DispenserBlock.registerBehavior(TntRegistry.DARK_TNT_BLOCK, new ItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer blockPointer, ItemStack itemStack) {
                BlockPos blockPos = blockPointer.getPos().offset(blockPointer.getBlockState().get(DispenserBlock.FACING));
                DarkTntEntity tntEntity = new DarkTntEntity(TntRegistry.DARK_TNT_ENTITY, blockPointer.getWorld());
                spawnTnt(tntEntity, blockPos, blockPointer.getWorld(), itemStack);
                return itemStack;
            }
        });

        DispenserBlock.registerBehavior(TntRegistry.ICE_TNT_BLOCK, new ItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer blockPointer, ItemStack itemStack) {
                BlockPos blockPos = blockPointer.getPos().offset(blockPointer.getBlockState().get(DispenserBlock.FACING));
                IceTntEntity tntEntity = new IceTntEntity(TntRegistry.ICE_TNT_ENTITY, blockPointer.getWorld());
                spawnTnt(tntEntity, blockPos, blockPointer.getWorld(), itemStack);
                return itemStack;
            }
        });

        DispenserBlock.registerBehavior(TntRegistry.MAGMA_TNT_BLOCK, new ItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer blockPointer, ItemStack itemStack) {
                BlockPos blockPos = blockPointer.getPos().offset(blockPointer.getBlockState().get(DispenserBlock.FACING));
                MagmaTntEntity tntEntity = new MagmaTntEntity(TntRegistry.MAGMA_TNT_ENTITY, blockPointer.getWorld());
                spawnTnt(tntEntity, blockPos, blockPointer.getWorld(), itemStack);
                return itemStack;
            }
        });

        DispenserBlock.registerBehavior(TntRegistry.HYDROGEN_TNT_BLOCK, new ItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer blockPointer, ItemStack itemStack) {
                BlockPos blockPos = blockPointer.getPos().offset(blockPointer.getBlockState().get(DispenserBlock.FACING));
                HydrogenTntEntity tntEntity = new HydrogenTntEntity(TntRegistry.HYDROGEN_TNT_ENTITY, blockPointer.getWorld());
                spawnTnt(tntEntity, blockPos, blockPointer.getWorld(), itemStack);
                return itemStack;
            }
        });

        DispenserBlock.registerBehavior(TntRegistry.REVERSE_TNT_BLOCK, new ItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer blockPointer, ItemStack itemStack) {
                BlockPos blockPos = blockPointer.getPos().offset(blockPointer.getBlockState().get(DispenserBlock.FACING));
                ReverseTntEntity tntEntity = new ReverseTntEntity(TntRegistry.REVERSE_TNT_ENTITY, blockPointer.getWorld());
                spawnTnt(tntEntity, blockPos, blockPointer.getWorld(), itemStack);
                return itemStack;
            }
        });

        DispenserBlock.registerBehavior(TntRegistry.MINER_TNT_BLOCK, new ItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer blockPointer, ItemStack itemStack) {
                BlockPos blockPos = blockPointer.getPos().offset(blockPointer.getBlockState().get(DispenserBlock.FACING));
                MinerTntEntity tntEntity = new MinerTntEntity(TntRegistry.MINER_TNT_ENTITY, blockPointer.getWorld());
                spawnTnt(tntEntity, blockPos, blockPointer.getWorld(), itemStack);
                return itemStack;
            }
        });

        DispenserBlock.registerBehavior(TntRegistry.ILLUSION_TNT_BLOCK, new ItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer blockPointer, ItemStack itemStack) {
                BlockPos blockPos = blockPointer.getPos().offset(blockPointer.getBlockState().get(DispenserBlock.FACING));
                IllusionTntEntity tntEntity = new IllusionTntEntity(TntRegistry.ILLUSION_TNT_ENTITY, blockPointer.getWorld());
                spawnTnt(tntEntity, blockPos, blockPointer.getWorld(), itemStack);
                return itemStack;
            }
        });

        DispenserBlock.registerBehavior(TntRegistry.FIREWORK_TNT_BLOCK, new ItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer blockPointer, ItemStack itemStack) {
                BlockPos blockPos = blockPointer.getPos().offset(blockPointer.getBlockState().get(DispenserBlock.FACING));
                FireworkTntEntity tntEntity = new FireworkTntEntity(TntRegistry.FIREWORK_TNT_ENTITY, blockPointer.getWorld());
                spawnTnt(tntEntity, blockPos, blockPointer.getWorld(), itemStack);
                return itemStack;
            }
        });

        DispenserBlock.registerBehavior(TntRegistry.COOKIE_TNT_BLOCK, new ItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer blockPointer, ItemStack itemStack) {
                BlockPos blockPos = blockPointer.getPos().offset(blockPointer.getBlockState().get(DispenserBlock.FACING));
                CookieTntEntity tntEntity = new CookieTntEntity(TntRegistry.COOKIE_TNT_ENTITY, blockPointer.getWorld());
                spawnTnt(tntEntity, blockPos, blockPointer.getWorld(), itemStack);
                return itemStack;
            }
        });
    }

    private static void spawnTnt(Entity tntEntity, BlockPos blockPos, World world, ItemStack itemStack) {
        tntEntity.refreshPositionAfterTeleport((double) blockPos.getX() + 0.5D, blockPos.getY(), (double) blockPos.getZ() + 0.5D);
        world.spawnEntity(tntEntity);
        tntEntity.setVelocity(-Math.sin(world.random.nextDouble() * 6.2831854820251465) * 0.02, 0.20000000298023224, -Math.cos(world.random.nextDouble() * 6.2831854820251465) * 0.02);
        world.playSound(null, tntEntity.getX(), tntEntity.getY(), tntEntity.getZ(),
                SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
        itemStack.decrement(1);
    }

    @Override
    public ItemStack dispense(BlockPointer blockPointer, ItemStack itemStack) {
        return null;
    }
}
