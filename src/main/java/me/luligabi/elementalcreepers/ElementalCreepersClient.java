package me.luligabi.elementalcreepers;

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
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.LIGHT_CREEPER, (entityRenderDispatcher, context) -> new LightCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.DARK_CREEPER, (entityRenderDispatcher, context) -> new DarkCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.ICE_CREEPER, (entityRenderDispatcher, context) -> new IceCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.MAGMA_CREEPER, (entityRenderDispatcher, context) -> new MagmaCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.HYDROGEN_CREEPER, (entityRenderDispatcher, context) -> new HydrogenCreeperRenderer(entityRenderDispatcher));

        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.REVERSE_CREEPER, (entityRenderDispatcher, context) -> new ReverseCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.MINER_CREEPER, (entityRenderDispatcher, context) -> new MinerCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.ILLUSION_CREEPER, (entityRenderDispatcher, context) -> new IllusionCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.FAKE_ILLUSION_CREEPER, (entityRenderDispatcher, context) -> new IllusionCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.FIREWORK_CREEPER, (entityRenderDispatcher, context) -> new FireworkCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.COOKIE_CREEPER, (entityRenderDispatcher, context) -> new CookieCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.RAINBOW_CREEPER, (entityRenderDispatcher, context) -> new RainbowCreeperRenderer(entityRenderDispatcher));

        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.WATER_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, ElementalCreepers.WATER_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.FIRE_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, ElementalCreepers.FIRE_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.EARTH_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, ElementalCreepers.EARTH_TNT_BLOCK.getDefaultState()));
        //air
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.ELECTRIC_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, ElementalCreepers.ELECTRIC_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.LIGHT_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, ElementalCreepers.LIGHT_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.DARK_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, ElementalCreepers.DARK_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.ICE_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, ElementalCreepers.ICE_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.MAGMA_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, ElementalCreepers.MAGMA_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.HYDROGEN_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, ElementalCreepers.HYDROGEN_TNT_BLOCK.getDefaultState()));

        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.REVERSE_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, ElementalCreepers.REVERSE_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.MINER_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, ElementalCreepers.MINER_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.FIREWORK_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, ElementalCreepers.FIREWORK_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.RAINBOW_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, ElementalCreepers.RAINBOW_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.COOKIE_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, ElementalCreepers.COOKIE_TNT_BLOCK.getDefaultState()));
    }
}