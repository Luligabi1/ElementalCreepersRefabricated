package me.luligabi.elementalcreepers.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Random;

public class CookieCreeperEntity extends ElementalCreeperEntity {

    public CookieCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onExplode() {
        this.world.createExplosion(this,
                this.getX(), this.getY(), this.getZ(),
                0, Explosion.DestructionType.NONE);
        int randomCookie = !this.shouldRenderOverlay() ? new Random().nextInt(4 - 2 + 1) + 2 : new Random().nextInt(6 - 4 + 1) + 4;
        this.world.spawnEntity(new ItemEntity(this.world,
                this.getX(), this.getY(), this.getZ(), new ItemStack(Items.COOKIE, randomCookie)));
        super.onExplode();
    }
}