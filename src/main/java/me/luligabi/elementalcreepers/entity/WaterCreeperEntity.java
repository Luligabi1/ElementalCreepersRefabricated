package me.luligabi.elementalcreepers.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WaterCreeperEntity extends ElementalCreeperEntity {

    public WaterCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    public void onExplode() {
        double radiusWater = 3; //TODO: Add config to change radius
        for (int x = (int) -radiusWater - 1; x <= radiusWater; x++)
            for (int y = (int) -radiusWater - 1; y <= radiusWater; y++)
                for (int z = (int) -radiusWater - 1; z <= radiusWater; z++)
                    if (this.world.getBlockState(new BlockPos((int) this.getX() + x, (int) this.getY() + y, (int) this.getZ() + z)).isAir() && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) <= radiusWater)
                        this.world.setBlockState(new BlockPos((int) this.getX() + x, (int) this.getY() + y, (int) this.getZ() + z), Blocks.WATER.getDefaultState());
        super.onExplode();
    }
}