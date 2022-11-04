package me.luligabi.elementalcreepers.common.entity.tnt;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface TntBuilder {
    ElementalTntEntity create(World world, double x, double y, double z, @Nullable LivingEntity livingEntity);
}