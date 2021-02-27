package me.luligabi.elementalcreepers.mixin;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.enchantment.FrostWalkerEnchantment;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.WorldView;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Random;

@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin {

    CreeperEntity creeperEntity = ((CreeperEntity) (Object) this);
    //CreeperEntityRenderer creeperEntityRenderer = new CreeperEntityRenderer(creeperEntity)
    LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(creeperEntity.world);
    double posX, posY, posZ;
    /**
     * @author Luligabi
     */
    @Overwrite
    private void explode() throws CommandSyntaxException {
        if(creeperEntity.world.isClient) return;
        //((CreeperEntityRendererInvoker) creeperEntityRenderer).invokerScale(creeperEntity, new MatrixStack(), 0.5F);
        posX = creeperEntity.getX();
        posY = creeperEntity.getY();
        posZ = creeperEntity.getZ();
        switch(this.getClass().getSimpleName()) {
            case "WaterCreeperEntity":
                double radiusWater = 3; //TODO: Add config to change radius
                for (int x = (int) -radiusWater - 1; x <= radiusWater; x++)
                    for (int y = (int) -radiusWater - 1; y <= radiusWater; y++)
                        for (int z = (int) -radiusWater - 1; z <= radiusWater; z++)
                            if (creeperEntity.world.getBlockState(new BlockPos((int) posX + x, (int) posY + y, (int) posZ + z)).isAir() && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) <= radiusWater)
                                creeperEntity.world.setBlockState(new BlockPos((int) posX + x, (int) posY + y, (int) posZ + z), Blocks.WATER.getDefaultState());
                break;
            case "ElectricCreeperEntity":
                lightningEntity.refreshPositionAfterTeleport(
                        posX, posY, posZ);
                creeperEntity.getEntityWorld().spawnEntity(lightningEntity);
                break;
            case "HydrogenCreeperEntity":
                creeperEntity.getEntityWorld().createExplosion(creeperEntity,
                        posX, posY, posZ,
                        9, creeperEntity.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ?
                                Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE);
                break;
            case "IceCreeperEntity":
                creeperEntity.world.createExplosion(creeperEntity,
                        posX, posY, posZ, 0, Explosion.DestructionType.NONE);
                if (creeperEntity.getAttacker() != null) { //TODO: Change effect apply to area rather than attacker.
                    creeperEntity.getAttacker().applyStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 20, 1));
                    creeperEntity.getAttacker().applyStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 10 * 20, 1));
                }
                double radiusIce = 4;
                for (int x = (int) -radiusIce - 1; x <= radiusIce; x++)
                    for (int y = (int) -radiusIce - 1; y <= radiusIce; y++)
                        for (int z = (int) -radiusIce - 1; z <= radiusIce; z++)
                            if (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) <= radiusIce) {
                                BlockPos blockPos = new BlockPos((int) posX + x, (int) posY + y, (int) posZ + z);
                                if (creeperEntity.world.getBlockState(blockPos).isAir() && !creeperEntity.world.getBlockState(new BlockPos((int) posX + x, (int) (posY + y) - 1, (int) posZ + z)).isAir()) {
                                    if ((new Random().nextInt(10 - 1 + 1) + 1) >= 5) {
                                        creeperEntity.world.setBlockState(blockPos, Blocks.SNOW_BLOCK.getDefaultState());
                                    } else {
                                        creeperEntity.world.setBlockState(blockPos, Blocks.SNOW.getDefaultState());
                                    }
                                } else if (creeperEntity.world.getBlockState(blockPos) == Blocks.WATER.getDefaultState()) {
                                    creeperEntity.world.setBlockState(blockPos, Blocks.ICE.getDefaultState());
                                } else if (creeperEntity.world.getBlockState(blockPos) == Blocks.LAVA.getDefaultState()) {
                                    creeperEntity.world.setBlockState(blockPos, Blocks.OBSIDIAN.getDefaultState());
                                }
                            }
                break;
            case "FireworkCreeperEntity":
                ItemStack fireWork = new ItemStack(Items.FIREWORK_ROCKET);
                fireWork.putSubTag("Fireworks", StringNbtReader.parse("{Explosions:[{Type:3,Flicker:1,Colors:[I;4312372],FadeColors:[I;4312372]}],Flight:1}"));
                FireworkRocketEntity fireworkEntity = new FireworkRocketEntity(
                        creeperEntity.world, posX, posY, posZ, fireWork);
                fireworkEntity.refreshPositionAfterTeleport(
                    posX, posY, posZ);
                creeperEntity.world.spawnEntity(fireworkEntity);
                break;
            case "CookieCreeperEntity":
                creeperEntity.world.createExplosion(creeperEntity,
                        posX, posY, posZ,
                        0, Explosion.DestructionType.NONE);
                creeperEntity.world.spawnEntity(new ItemEntity(creeperEntity.world,
                        posX, posY, posZ, new ItemStack(Items.COOKIE, new Random().nextInt(4 - 2 + 1) + 2)));
                break;
            default:
                creeperEntity.world.createExplosion(creeperEntity,
                        posX, posY, posZ,
                        (float) 3*(creeperEntity.shouldRenderOverlay() ? 2.0F : 1.0F), creeperEntity.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ?
                                Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE);
                break;
        }
        ((LivingEntityAccessor) creeperEntity).setDead(true);
        creeperEntity.remove();
        ((CreeperEntityInvoker) creeperEntity).invokeSpawnEffectsCloud();
    }
}
