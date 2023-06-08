package me.luligabi.elementalcreepers.common.entity.tnt;

import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;

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
        double d = world.random.nextDouble() * 6.2831854820251465;
        entity.setVelocity(-Math.sin(d) * 0.02, 0.20000000298023224, -Math.cos(d) * 0.02);
        entity.setFuse(80);
        entity.prevX = x;
        entity.prevY = y;
        entity.prevZ = z;
    }

    protected void initDataTracker() {
        this.dataTracker.startTracking(ElementalTntEntity.FUSE, 4*20);
    }

    public void tick() {
        if (!hasNoGravity()) {
            setVelocity(getVelocity().add(0.0, -0.04, 0.0));
        }
        move(MovementType.SELF, getVelocity());
        setVelocity(getVelocity().multiply(0.98));
        if (isOnGround()) {
            setVelocity(getVelocity().multiply(0.7, -0.5, 0.7));
        }
        --fuseTimer;
        if (fuseTimer <= 0) {
            discard();
            if (!getWorld().isClient() && !(this instanceof AirTntEntity)) {
                explode();
            }
            if(this instanceof AirTntEntity) {
                if(!getWorld().isClient()) {
                    getWorld().createExplosion(this, getX(), getY(), getZ(), 0, World.ExplosionSourceType.NONE);
                }
                this.explode();
            }
        } else {
            updateWaterState();
            if(getWorld().isClient()) {
                getWorld().addParticle(ParticleTypes.SMOKE, getX(), getY() + 0.5, getZ(), 0.0, 0.0, 0.0);
            }
        }
    }

    public abstract void explode();

    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putShort("Fuse", (short) getFuse());
    }

    protected void readCustomDataFromNbt(NbtCompound nbt) {
        setFuse(nbt.getShort("Fuse"));
    }

    protected float getEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.15f;
    }

    public void onTrackedDataSet(TrackedData<?> data) {
        if (ElementalTntEntity.FUSE.equals(data)) {
            this.fuseTimer = getFuse();
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

    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    static {
        FUSE = DataTracker.registerData(ElementalTntEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }
}
