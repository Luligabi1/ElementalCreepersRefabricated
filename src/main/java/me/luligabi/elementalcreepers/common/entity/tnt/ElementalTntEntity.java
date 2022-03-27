package me.luligabi.elementalcreepers.common.entity.tnt;

import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public abstract class ElementalTntEntity extends Entity {

    private static final TrackedData<Integer> FUSE;

    private int fuseTimer;

    public ElementalTntEntity(EntityType<? extends ElementalTntEntity> entityType, World world) {
        super(entityType, world);
        this.fuseTimer = 80;
        this.intersectionChecked = true;
    }

    public static void update(ElementalTntEntity entity, World world, double x, double y, double z) {
        entity.updatePosition(x, y, z);
        final double d = world.random.nextDouble() * 6.2831854820251465;
        entity.setVelocity(-Math.sin(d) * 0.02, 0.20000000298023224, -Math.cos(d) * 0.02);
        entity.setFuse(80);
        entity.prevX = x;
        entity.prevY = y;
        entity.prevZ = z;
    }

    protected void initDataTracker() {
        this.dataTracker.startTracking(ElementalTntEntity.FUSE, 4*20);
    }

    public boolean collides() {
        return !this.isRemoved();
    }

    public void tick() {
        if (!this.hasNoGravity()) {
            this.setVelocity(this.getVelocity().add(0.0, -0.04, 0.0));
        }
        this.move(MovementType.SELF, this.getVelocity());
        this.setVelocity(this.getVelocity().multiply(0.98));
        if (this.onGround) {
            this.setVelocity(this.getVelocity().multiply(0.7, -0.5, 0.7));
        }
        --this.fuseTimer;
        if (this.fuseTimer <= 0) {
            this.discard();
            if (!this.world.isClient && !(this instanceof AirTntEntity)) {
                this.explode();
            }
            if(this instanceof AirTntEntity) {
                if(!world.isClient) {
                    this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 0, Explosion.DestructionType.NONE);
                }
                this.explode();
            }
        } else {
            this.updateWaterState();
            if (this.world.isClient) {
                this.world.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.5, this.getZ(), 0.0, 0.0, 0.0);
            }
        }
    }

    public void explode() { // Don't call this on custom TNT's, unless it's meant to explode as vanilla TNT. Instead, override it.
        this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625), this.getZ(), 4, Explosion.DestructionType.BREAK);
    }

    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putShort("Fuse", (short)this.getFuse());
    }

    protected void readCustomDataFromNbt(NbtCompound nbt) {
        this.setFuse(nbt.getShort("Fuse"));
    }

    protected float getEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.15f;
    }

    public void onTrackedDataSet(TrackedData<?> data) {
        if (ElementalTntEntity.FUSE.equals(data)) {
            this.fuseTimer = this.getFuse();
        }
    }

    public int getFuse() {
        return this.dataTracker.get(ElementalTntEntity.FUSE);
    }

    public void setFuse(final int fuse) {
        this.dataTracker.set(ElementalTntEntity.FUSE, fuse);
        this.fuseTimer = fuse;
    }

    public int getFuseTimer() {
        return this.fuseTimer;
    }

    public Packet<?> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    static {
        FUSE = DataTracker.registerData(TntEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }
}
