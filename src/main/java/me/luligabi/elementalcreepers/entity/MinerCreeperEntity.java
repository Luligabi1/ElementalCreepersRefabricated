package me.luligabi.elementalcreepers.entity;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.SimpleConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Arrays;


public class MinerCreeperEntity extends ElementalCreeperEntity {

    public MinerCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    SimpleConfig config = new ElementalCreepers().getConfig();

    @Override
    public void onExplode() {
        this.world.createExplosion(this,
                this.getX(), this.getY(), this.getZ(),
                0, Explosion.DestructionType.NONE);
        double radius = !this.shouldRenderOverlay() ? config.getOrDefault("minerCreeperRadius", 3.75) : config.getOrDefault("minerCreeperRadius", 3.75)*1.5;
        for (int x = (int) -radius; x <= radius; x++) {
            for (int y = (int) -radius; y <= radius; y++) {
                for (int z = (int) -radius; z <= radius; z++) {
                    BlockPos blockPos = new BlockPos(this.getX() + x, this.getY() + y, this.getZ() + z);
                    BlockState state = world.getBlockState(blockPos);

                    if (state != null && state.getBlock() != null) {
                        Block stoneBlock = state.getBlock();
                        Block[] stoneBlockList = {Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE};

                        if (stoneBlock != null && Arrays.asList(stoneBlockList).contains(stoneBlock) && Math.sqrt(Math.pow(x, 2.0D) + Math.pow(y, 2.0D) + Math.pow(z, 2.0D)) <= radius) {
                            this.world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
                            this.world.spawnEntity(new ItemEntity(this.world,
                                    this.getX(), this.getY(), this.getZ(), new ItemStack(stoneBlock.asItem(), 1)));
                        }
                    }
                }
            }
        }
        super.onExplode();
    }
}