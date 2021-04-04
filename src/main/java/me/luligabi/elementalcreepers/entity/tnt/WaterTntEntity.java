package me.luligabi.elementalcreepers.entity.tnt;

import me.luligabi.elementalcreepers.ExplosionEffects;
import me.luligabi.elementalcreepers.registry.TntRegistry;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WaterTntEntity extends ElementalTntEntity implements DispenserBehavior {

    public WaterTntEntity(EntityType<? extends ElementalTntEntity> entityType, World world) {
        super(entityType, world);

        DispenserBlock.registerBehavior(TntRegistry.WATER_TNT_BLOCK, new ItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer blockPointer, ItemStack itemStack) {
                World world = blockPointer.getWorld();
                BlockPos blockPos = blockPointer.getBlockPos().offset(blockPointer.getBlockState().get(DispenserBlock.FACING));
                WaterTntEntity tntEntity = new WaterTntEntity(TntRegistry.WATER_TNT_ENTITY, world);
                tntEntity.refreshPositionAfterTeleport((double) blockPos.getX() + 0.5D, (double) blockPos.getY(), (double) blockPos.getZ() + 0.5D);
                world.spawnEntity(tntEntity);
                tntEntity.setVelocity(-Math.sin(world.random.nextDouble() * 6.2831854820251465) * 0.02, 0.20000000298023224, -Math.cos(world.random.nextDouble() * 6.2831854820251465) * 0.02);
                world.playSound(null, tntEntity.getX(), tntEntity.getY(), tntEntity.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
                itemStack.decrement(1);
                return itemStack;
            }
        });
    }

    @Override
    public void explode() {
        new ExplosionEffects().waterExplosionEffect(this, this.world, this.getX(), this.getY(), this.getZ());
    }

    @Override
    public ItemStack dispense(BlockPointer blockPointer, ItemStack itemStack) {
        return null;
    }
}