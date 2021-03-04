package me.luligabi.elementalcreepers.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class ReverseCreeperEntity extends ElementalCreeperEntity {

    public ReverseCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    public void onExplode() {
        double radius = 3.75; //TODO: Add config to change radius and charged value.
        double posX = this.getX();
        double posY = this.getY();
        double posZ = this.getZ();

        this.world.createExplosion(this,
                this.getX(), this.getY(), this.getZ(), 0, Explosion.DestructionType.NONE);
        BlockState[][][] states = new BlockState[(int) (radius * 2 + 2)][(int) (radius * 2 + 2)][(int) (radius * 2 + 2)];
        BlockEntity[][][] tiles = new BlockEntity[(int) (radius * 2 + 2)][(int) (radius * 2 + 2)][(int) (radius * 2 + 2)];

        for (int x = (int) -radius - 1; x <= radius; x++) {
            for (int y = (int) -radius - 1; y <= radius; y++) {
                for (int z = (int) -radius - 1; z <= radius; z++) {
                    int ax = (int) (x + radius + 1);
                    int ay = (int) (y + radius + 1);
                    int az = (int) (z + radius + 1);
                    double ex = posX + x;
                    double ey = posY + y;
                    double ez = posZ + z;
                    BlockPos blockPos = new BlockPos(ex, ey, ez);
                    BlockState state = world.getBlockState(blockPos);

                    if (state != null && state.getBlock() != null) {
                        Block id = state.getBlock();

                        if (id != Blocks.BEDROCK) { //TODO: Make it so bedrock can't be removed or moved by Reverse Creepers.
                            states[ax][ay][az] = null;

                            if (id != null && Math.sqrt(Math.pow(x, 2.0D) + Math.pow(y, 2.0D) + Math.pow(z, 2.0D)) <= radius && ey > -1) {
                                states[ax][ay][az] = state;
                                tiles[ax][ay][az] = world.getBlockEntity(blockPos);
                            }
                        }
                    }
                }
            }
        }

        for (int x = (int) (-radius - 1); x <= radius; x++) {
            for (int y = (int) (-radius - 1); y <= radius; y++) {
                for (int z = (int) (-radius - 1); z <= radius; z++) {
                    BlockPos blockPos = new BlockPos(posX + x, posY + y, posZ + z);
                    BlockState state = states[(int) (x + radius + 1)][(int) (2 * radius - (y + radius))][(int) (z + radius + 1)];
                    BlockEntity te = tiles[(int) (x + radius + 1)][(int) (2 * radius - (y + radius))][(int) (z + radius + 1)];

                    if (state != null && state.getBlock() != null && posY + y > 0) {
                        world.setBlockState(blockPos, state, 3);
                        if (te != null) {
                            world.setBlockEntity(blockPos, te);
                        }
                    }
                }
            }
        }
        super.onExplode();
    }
}