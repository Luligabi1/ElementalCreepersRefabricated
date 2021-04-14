package me.luligabi.elementalcreepers;

import me.luligabi.elementalcreepers.registry.CreeperRegistry;
import me.luligabi.elementalcreepers.registry.TntRegistry;
import me.luligabi.elementalcreepers.renderer.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class ElementalCreepersClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.WATER_CREEPER, (entityRenderDispatcher, context) -> new WaterCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.FIRE_CREEPER, (entityRenderDispatcher, context) -> new FireCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.EARTH_CREEPER, (entityRenderDispatcher, context) -> new EarthCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.AIR_CREEPER, (entityRenderDispatcher, context) -> new AirCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.ELECTRIC_CREEPER, (entityRenderDispatcher, context) -> new ElectricCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.LIGHT_CREEPER, (entityRenderDispatcher, context) -> new LightCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.DARK_CREEPER, (entityRenderDispatcher, context) -> new DarkCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.ICE_CREEPER, (entityRenderDispatcher, context) -> new IceCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.MAGMA_CREEPER, (entityRenderDispatcher, context) -> new MagmaCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.HYDROGEN_CREEPER, (entityRenderDispatcher, context) -> new HydrogenCreeperRenderer(entityRenderDispatcher));

        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.REVERSE_CREEPER, (entityRenderDispatcher, context) -> new ReverseCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.MINER_CREEPER, (entityRenderDispatcher, context) -> new MinerCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.ILLUSION_CREEPER, (entityRenderDispatcher, context) -> new IllusionCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.FIREWORK_CREEPER, (entityRenderDispatcher, context) -> new FireworkCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.COOKIE_CREEPER, (entityRenderDispatcher, context) -> new CookieCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.RAINBOW_CREEPER, (entityRenderDispatcher, context) -> new RainbowCreeperRenderer(entityRenderDispatcher));

        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.FAKE_ILLUSION_CREEPER, (entityRenderDispatcher, context) -> new IllusionCreeperRenderer(entityRenderDispatcher));

        EntityRendererRegistry.INSTANCE.register(TntRegistry.WATER_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, TntRegistry.WATER_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.FIRE_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, TntRegistry.FIRE_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.EARTH_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, TntRegistry.EARTH_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.AIR_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, TntRegistry.AIR_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.ELECTRIC_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, TntRegistry.ELECTRIC_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.LIGHT_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, TntRegistry.LIGHT_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.DARK_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, TntRegistry.DARK_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.ICE_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, TntRegistry.ICE_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.MAGMA_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, TntRegistry.MAGMA_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.HYDROGEN_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, TntRegistry.HYDROGEN_TNT_BLOCK.getDefaultState()));

        EntityRendererRegistry.INSTANCE.register(TntRegistry.REVERSE_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, TntRegistry.REVERSE_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.MINER_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, TntRegistry.MINER_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.ILLUSION_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, TntRegistry.ILLUSION_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.FIREWORK_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, TntRegistry.FIREWORK_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.COOKIE_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, TntRegistry.COOKIE_TNT_BLOCK.getDefaultState()));

        EntityRendererRegistry.INSTANCE.register(TntRegistry.FAKE_ILLUSION_TNT_ENTITY, (entityRenderDispatcher, context) -> new ElementalTntRenderer(entityRenderDispatcher, TntRegistry.FAKE_ILLUSION_TNT_BLOCK.getDefaultState()));
    }
}