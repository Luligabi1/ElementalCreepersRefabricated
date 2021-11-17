package me.luligabi.elementalcreepers.mixin;

import me.luligabi.elementalcreepers.common.entity.tnt.*;
import me.luligabi.elementalcreepers.common.block.TntRegistry;
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
        
        if (entityType == TntRegistry.WATER_TNT_ENTITY) {
            WaterTntEntity waterTnt = new WaterTntEntity(TntRegistry.WATER_TNT_ENTITY, this.world);
            ElementalTntEntity.update(waterTnt, this.world, x, y, z);
            entity = waterTnt;
        }
        if (entityType == TntRegistry.FIRE_TNT_ENTITY) {
            FireTntEntity fireTnt = new FireTntEntity(TntRegistry.FIRE_TNT_ENTITY, this.world);
            ElementalTntEntity.update(fireTnt, this.world, x, y, z);
            entity = fireTnt;
        }
        if (entityType == TntRegistry.EARTH_TNT_ENTITY) {
            EarthTntEntity earthTnt = new EarthTntEntity(TntRegistry.EARTH_TNT_ENTITY, this.world);
            ElementalTntEntity.update(earthTnt, this.world, x, y, z);
            entity = earthTnt;
        }
        if (entityType == TntRegistry.AIR_TNT_ENTITY) {
            AirTntEntity airTnt = new AirTntEntity(TntRegistry.AIR_TNT_ENTITY, this.world);
            ElementalTntEntity.update(airTnt, this.world, x, y, z);
            entity = airTnt;
        }
        if (entityType == TntRegistry.ELECTRIC_TNT_ENTITY) {
            ElectricTntEntity electricTnt = new ElectricTntEntity(TntRegistry.ELECTRIC_TNT_ENTITY, this.world);
            ElementalTntEntity.update(electricTnt, this.world, x, y, z);
            entity = electricTnt;
        }
        if (entityType == TntRegistry.LIGHT_TNT_ENTITY) {
            LightTntEntity lightTnt = new LightTntEntity(TntRegistry.LIGHT_TNT_ENTITY, this.world);
            ElementalTntEntity.update(lightTnt, this.world, x, y, z);
            entity = lightTnt;
        }
        if (entityType == TntRegistry.DARK_TNT_ENTITY) {
            DarkTntEntity darkTnt = new DarkTntEntity(TntRegistry.DARK_TNT_ENTITY, this.world);
            ElementalTntEntity.update(darkTnt, this.world, x, y, z);
            entity = darkTnt;
        }
        if (entityType == TntRegistry.ICE_TNT_ENTITY) {
            IceTntEntity iceTnt = new IceTntEntity(TntRegistry.ICE_TNT_ENTITY, this.world);
            ElementalTntEntity.update(iceTnt, this.world, x, y, z);
            entity = iceTnt;
        }
        if (entityType == TntRegistry.MAGMA_TNT_ENTITY) {
            MagmaTntEntity magmaTnt = new MagmaTntEntity(TntRegistry.MAGMA_TNT_ENTITY, this.world);
            ElementalTntEntity.update(magmaTnt, this.world, x, y, z);
            entity = magmaTnt;
        }
        if (entityType == TntRegistry.HYDROGEN_TNT_ENTITY) {
            HydrogenTntEntity hydrogenTnt = new  HydrogenTntEntity(TntRegistry.HYDROGEN_TNT_ENTITY, this.world);
            ElementalTntEntity.update(hydrogenTnt, this.world, x, y, z);
            entity = hydrogenTnt;
        }
        if (entityType == TntRegistry.REVERSE_TNT_ENTITY) {
            ReverseTntEntity reverseTnt = new ReverseTntEntity(TntRegistry.REVERSE_TNT_ENTITY, this.world);
            ElementalTntEntity.update(reverseTnt, this.world, x, y, z);
            entity = reverseTnt;
        }
        if (entityType == TntRegistry.MINER_TNT_ENTITY) {
            MinerTntEntity minerTnt = new MinerTntEntity(TntRegistry.MINER_TNT_ENTITY, this.world);
            ElementalTntEntity.update(minerTnt, this.world, x, y, z);
            entity = minerTnt;
        }
        if (entityType == TntRegistry.ILLUSION_TNT_ENTITY) {
            IllusionTntEntity illusionTnt = new IllusionTntEntity(TntRegistry.ILLUSION_TNT_ENTITY, this.world);
            ElementalTntEntity.update(illusionTnt, this.world, x, y, z);
            entity = illusionTnt;
        }
        if (entityType == TntRegistry.FIREWORK_TNT_ENTITY) {
            FireworkTntEntity fireworkTnt = new FireworkTntEntity(TntRegistry.FIREWORK_TNT_ENTITY, this.world);
            ElementalTntEntity.update(fireworkTnt, this.world, x, y, z);
            entity = fireworkTnt;
        }
        if (entityType == TntRegistry.COOKIE_TNT_ENTITY) {
            CookieTntEntity cookieTnt = new CookieTntEntity(TntRegistry.COOKIE_TNT_ENTITY, this.world);
            ElementalTntEntity.update(cookieTnt, this.world, x, y, z);
            entity = cookieTnt;
        }

        if (entityType == TntRegistry.FAKE_ILLUSION_TNT_ENTITY) {
            FakeIllusionTntEntity fakeIllusionTnt = new FakeIllusionTntEntity(TntRegistry.FAKE_ILLUSION_TNT_ENTITY, this.world);
            ElementalTntEntity.update(fakeIllusionTnt, this.world, x, y, z);
            entity = fakeIllusionTnt;
        }
        if (entity != null) {
            final int i = packet.getId();
            entity.updateTrackedPosition(x, y, z);
            entity.refreshPositionAfterTeleport(x, y, z);
            ((EntityAccessor) entity).setPitch(packet.getPitch() * 360 / 256.0f);
            ((EntityAccessor) entity).setYaw(packet.getYaw() * 360 / 256.0f);
            entity.setId(i);
            entity.setUuid(packet.getUuid());
            this.world.addEntity(i, entity);
        }
    }
}