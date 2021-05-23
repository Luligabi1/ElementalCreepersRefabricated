package me.luligabi.elementalcreepers;

import me.luligabi.elementalcreepers.registry.CreeperRegistry;
import me.luligabi.elementalcreepers.registry.TntRegistry;
import me.luligabi.elementalcreepers.renderer.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class ElementalCreepersClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.WATER_CREEPER, WaterCreeperRenderer::new);
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.FIRE_CREEPER, FireCreeperRenderer::new);
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.EARTH_CREEPER, EarthCreeperRenderer::new);
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.AIR_CREEPER, AirCreeperRenderer::new);
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.ELECTRIC_CREEPER, ElectricCreeperRenderer::new);
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.LIGHT_CREEPER, LightCreeperRenderer::new);
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.DARK_CREEPER, DarkCreeperRenderer::new);
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.ICE_CREEPER, IceCreeperRenderer::new);
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.MAGMA_CREEPER, MagmaCreeperRenderer::new);
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.HYDROGEN_CREEPER, HydrogenCreeperRenderer::new);

        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.REVERSE_CREEPER, ReverseCreeperRenderer::new);
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.MINER_CREEPER, MinerCreeperRenderer::new);
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.ILLUSION_CREEPER, IllusionCreeperRenderer::new);
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.FIREWORK_CREEPER, FireworkCreeperRenderer::new);
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.COOKIE_CREEPER, CookieCreeperRenderer::new);
        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.RAINBOW_CREEPER, RainbowCreeperRenderer::new);

        EntityRendererRegistry.INSTANCE.register(CreeperRegistry.FAKE_ILLUSION_CREEPER, IllusionCreeperRenderer::new);

        EntityRendererRegistry.INSTANCE.register(TntRegistry.WATER_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.WATER_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.FIRE_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.FIRE_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.EARTH_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.EARTH_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.AIR_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.AIR_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.ELECTRIC_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.ELECTRIC_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.LIGHT_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.LIGHT_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.DARK_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.DARK_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.ICE_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.ICE_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.MAGMA_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.MAGMA_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.HYDROGEN_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.HYDROGEN_TNT_BLOCK.getDefaultState()));

        EntityRendererRegistry.INSTANCE.register(TntRegistry.REVERSE_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.REVERSE_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.MINER_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.MINER_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.ILLUSION_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.ILLUSION_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.FIREWORK_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.FIREWORK_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.INSTANCE.register(TntRegistry.COOKIE_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.COOKIE_TNT_BLOCK.getDefaultState()));

        EntityRendererRegistry.INSTANCE.register(TntRegistry.FAKE_ILLUSION_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.FAKE_ILLUSION_TNT_BLOCK.getDefaultState()));
    }
}