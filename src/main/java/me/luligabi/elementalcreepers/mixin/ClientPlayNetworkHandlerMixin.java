package me.luligabi.elementalcreepers.mixin;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.entity.tnt.*;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {

    @Shadow
    private ClientWorld world;

    @Inject(at = @At("RETURN"), method = "onEntitySpawn", cancellable = true)
    private void injectOnEntitySpawn(EntitySpawnS2CPacket packet, CallbackInfo info) {
        double x = packet.getX();
        double y = packet.getY();
        double z = packet.getZ();
        EntityType<?> entityType = packet.getEntityTypeId();
        Entity entity = null;
        
        if (entityType == ElementalCreepers.WATER_TNT_ENTITY) {
            WaterTntEntity waterTnt = new WaterTntEntity(ElementalCreepers.WATER_TNT_ENTITY, this.world);
            ElementalTntEntity.update(waterTnt, this.world, x, y, z, null);
            entity = waterTnt;
        }

        if (entityType == ElementalCreepers.FIRE_TNT_ENTITY) {
            FireTntEntity fireTnt = new FireTntEntity(ElementalCreepers.FIRE_TNT_ENTITY, this.world);
            ElementalTntEntity.update(fireTnt, this.world, x, y, z, null);
            entity = fireTnt;
        }

        if (entityType == ElementalCreepers.EARTH_TNT_ENTITY) {
            EarthTntEntity earthTnt = new EarthTntEntity(ElementalCreepers.EARTH_TNT_ENTITY, this.world);
            ElementalTntEntity.update(earthTnt, this.world, x, y, z, null);
            entity = earthTnt;
        }

        if (entityType == ElementalCreepers.ELECTRIC_TNT_ENTITY) {
            ElectricTntEntity electricTnt = new ElectricTntEntity(ElementalCreepers.ELECTRIC_TNT_ENTITY, this.world);
            ElementalTntEntity.update(electricTnt, this.world, x, y, z, null);
            entity = electricTnt;
        }

        if (entityType == ElementalCreepers.LIGHT_TNT_ENTITY) {
            LightTntEntity lightTnt = new LightTntEntity(ElementalCreepers.LIGHT_TNT_ENTITY, this.world);
            ElementalTntEntity.update(lightTnt, this.world, x, y, z, null);
            entity = lightTnt;
        }

        if (entityType == ElementalCreepers.DARK_TNT_ENTITY) {
            DarkTntEntity darkTnt = new DarkTntEntity(ElementalCreepers.DARK_TNT_ENTITY, this.world);
            ElementalTntEntity.update(darkTnt, this.world, x, y, z, null);
            entity = darkTnt;
        }

        if (entityType == ElementalCreepers.ICE_TNT_ENTITY) {
            IceTntEntity iceTnt = new IceTntEntity(ElementalCreepers.ICE_TNT_ENTITY, this.world);
            ElementalTntEntity.update(iceTnt, this.world, x, y, z, null);
            entity = iceTnt;
        }

        if (entityType == ElementalCreepers.MAGMA_TNT_ENTITY) {
            MagmaTntEntity magmaTnt = new MagmaTntEntity(ElementalCreepers.MAGMA_TNT_ENTITY, this.world);
            ElementalTntEntity.update(magmaTnt, this.world, x, y, z, null);
            entity = magmaTnt;
        }

        if (entityType == ElementalCreepers.HYDROGEN_TNT_ENTITY) {
            HydrogenTntEntity hydrogenTnt = new  HydrogenTntEntity(ElementalCreepers.HYDROGEN_TNT_ENTITY, this.world);
            ElementalTntEntity.update(hydrogenTnt, this.world, x, y, z, null);
            entity = hydrogenTnt;
        }

        if (entityType == ElementalCreepers.REVERSE_TNT_ENTITY) {
            ReverseTntEntity reverseTnt = new ReverseTntEntity(ElementalCreepers.REVERSE_TNT_ENTITY, this.world);
            ElementalTntEntity.update(reverseTnt, this.world, x, y, z, null);
            entity = reverseTnt;
        }

        if (entityType == ElementalCreepers.MINER_TNT_ENTITY) {
            MinerTntEntity minerTnt = new MinerTntEntity(ElementalCreepers.MINER_TNT_ENTITY, this.world);
            ElementalTntEntity.update(minerTnt, this.world, x, y, z, null);
            entity = minerTnt;
        }

        if (entityType == ElementalCreepers.COOKIE_TNT_ENTITY) {
            CookieTntEntity cookieTnt = new CookieTntEntity(ElementalCreepers.COOKIE_TNT_ENTITY, this.world);
            ElementalTntEntity.update(cookieTnt, this.world, x, y, z, null);
            entity = cookieTnt;
        }

        if (entity != null) {
            final int i = packet.getId();
            entity.updateTrackedPosition(x, y, z);
            entity.refreshPositionAfterTeleport(x, y, z);
            entity.pitch = packet.getPitch() * 360 / 256.0f;
            entity.yaw = packet.getYaw() * 360 / 256.0f;
            entity.setEntityId(i);
            entity.setUuid(packet.getUuid());
            this.world.addEntity(i, entity);
        }
    }
}