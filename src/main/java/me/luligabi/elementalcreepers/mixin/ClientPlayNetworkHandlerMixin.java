package me.luligabi.elementalcreepers.mixin;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.entity.tnt.CookieTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.FireTntEntity;
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


        if (entityType == ElementalCreepers.FIRE_TNT_ENTITY) {
            FireTntEntity fireTnt = new FireTntEntity(ElementalCreepers.FIRE_TNT_ENTITY, this.world);
            ElementalTntEntity.update(fireTnt, this.world, x, y, z, null);
            entity = fireTnt;
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