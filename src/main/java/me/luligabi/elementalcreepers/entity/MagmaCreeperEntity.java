package me.luligabi.elementalcreepers.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class MagmaCreeperEntity extends ElementalCreeperEntity {

    public MagmaCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    //TODO: Disable fire damage.

    @Override
    public void tickMovement() {
        super.tickMovement();
        if(!this.world.isClient) {
            if (!this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) return;
            BlockState blockState = Blocks.FIRE.getDefaultState();

            for (int i = 0; i < 4; ++i) {
                int posX = MathHelper.floor(this.getX() + (double) ((float) (i % 2 * 2 - 1) * 0.25F));
                int posY = MathHelper.floor(this.getY());
                int posZ = MathHelper.floor(this.getZ() + (double) ((float) (i / 2 % 2 * 2 - 1) * 0.25F));
                BlockPos blockPos = new BlockPos(posX, posY, posZ);
                if (blockState.canPlaceAt(this.world, blockPos)) {
                    this.world.setBlockState(blockPos, blockState);
                }
            }
        }
    }

    @Override
    public void onExplode() {
        double radiusLava = 3; //TODO: Add config to change radius
        for (int x = (int) -radiusLava - 1; x <= radiusLava; x++)
            for (int y = (int) -radiusLava - 1; y <= radiusLava; y++)
                for (int z = (int) -radiusLava - 1; z <= radiusLava; z++)
                    if (this.world.getBlockState(new BlockPos((int) this.getX() + x, (int) this.getY() + y, (int) this.getZ() + z)).isAir() && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) <= radiusLava)
                        this.world.setBlockState(new BlockPos((int) this.getX() + x, (int) this.getY() + y, (int) this.getZ() + z), Blocks.LAVA.getDefaultState());
        super.onExplode();
    }
}