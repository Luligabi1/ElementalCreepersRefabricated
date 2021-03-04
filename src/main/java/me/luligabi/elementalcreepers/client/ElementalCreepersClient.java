package me.luligabi.elementalcreepers.client;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.renderer.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class ElementalCreepersClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.WATER_CREEPER, (entityRenderDispatcher, context) -> new WaterCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.FIRE_CREEPER, (entityRenderDispatcher, context) -> new FireCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.EARTH_CREEPER, (entityRenderDispatcher, context) -> new EarthCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.AIR_CREEPER, (entityRenderDispatcher, context) -> new AirCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.ELECTRIC_CREEPER, (entityRenderDispatcher, context) -> new ElectricCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.ICE_CREEPER, (entityRenderDispatcher, context) -> new IceCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.MAGMA_CREEPER, (entityRenderDispatcher, context) -> new MagmaCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.HYDROGEN_CREEPER, (entityRenderDispatcher, context) -> new HydrogenCreeperRenderer(entityRenderDispatcher));

        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.REVERSE_CREEPER, (entityRenderDispatcher, context) -> new ReverseCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.ILLUSION_CREEPER, (entityRenderDispatcher, context) -> new IllusionCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.FAKE_ILLUSION_CREEPER, (entityRenderDispatcher, context) -> new IllusionCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.FIREWORK_CREEPER, (entityRenderDispatcher, context) -> new FireworkCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.COOKIE_CREEPER, (entityRenderDispatcher, context) -> new CookieCreeperRenderer(entityRenderDispatcher));
    }
}
