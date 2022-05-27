package me.luligabi.elementalcreepers.common.block;

import me.luligabi.elementalcreepers.common.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.common.entity.tnt.TntBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

public abstract class ElementalTntBlock extends Block {

    public ElementalTntBlock(AbstractBlock.Settings settings, final TntBuilder creator) {
        super(settings);
        this.setDefaultState(getDefaultState().with(ElementalTntBlock.UNSTABLE, false));
        this.creator = creator;
    }

    public static final BooleanProperty UNSTABLE;
    private final TntBuilder creator;

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!oldState.isOf(state.getBlock()) && world.isReceivingRedstonePower(pos)) {
            this.primeTnt(world, pos);
            world.removeBlock(pos, false);
        }
    }

    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (world.isReceivingRedstonePower(pos)) {
            this.primeTnt(world, pos);
            world.removeBlock(pos, false);
        }
    }

    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient() && !player.isCreative() && (boolean) state.get((Property) ElementalTntBlock.UNSTABLE)) {
            this.primeTnt(world, pos);
        }
        super.onBreak(world, pos, state, player);
    }

    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        if (!world.isClient) {
            final ElementalTntEntity tntEntity = this.creator.create(world, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, explosion.getCausingEntity());
            tntEntity.setFuse((short) (world.random.nextInt(tntEntity.getFuseTimer() / 4) + tntEntity.getFuseTimer() / 8));
            world.spawnEntity(tntEntity);
        }
    }

    public void primeTnt(World world, BlockPos pos) {
        this.primeTnt(world, pos, null);
    }

    public void primeTnt(World world, BlockPos pos, @Nullable LivingEntity livingEntity) {
        if (!world.isClient) {
            final ElementalTntEntity tntEntity = this.creator.create(world, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, livingEntity);
            world.spawnEntity(tntEntity);
            world.playSound(null, tntEntity.getX(), tntEntity.getY(), tntEntity.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();
        if (item != Items.FLINT_AND_STEEL && item != Items.FIRE_CHARGE) {
            return super.onUse(state, world, pos, player, hand, hit);
        }
        this.primeTnt(world, pos, player);
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
        if (!player.isCreative()) {
            if (item == Items.FLINT_AND_STEEL) {
                itemStack.damage(1, player, playerEntity -> playerEntity.sendToolBreakStatus(hand));
            } else {
                itemStack.decrement(1);
            }
        }
        return ActionResult.success(world.isClient);
    }

    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (!world.isClient) {
            Entity projectileOwner = projectile.getOwner();
            if (projectile.isOnFire()) {
                BlockPos blockPos = hit.getBlockPos();
                this.primeTnt(world, blockPos, (projectileOwner instanceof LivingEntity) ? (LivingEntity) projectileOwner : null);
                world.removeBlock(blockPos, false);
            }
        }
    }

    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ElementalTntBlock.UNSTABLE);
    }

    static {
        UNSTABLE = Properties.UNSTABLE;
    }
}