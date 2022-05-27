package me.luligabi.elementalcreepers.client;

import me.luligabi.elementalcreepers.client.renderer.*;
import me.luligabi.elementalcreepers.common.entity.creeper.CreeperRegistry;
import me.luligabi.elementalcreepers.common.block.TntRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ElementalCreepersClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(CreeperRegistry.WATER_CREEPER, WaterCreeperRenderer::new);
        EntityRendererRegistry.register(CreeperRegistry.FIRE_CREEPER, FireCreeperRenderer::new);
        EntityRendererRegistry.register(CreeperRegistry.EARTH_CREEPER, EarthCreeperRenderer::new);
        EntityRendererRegistry.register(CreeperRegistry.AIR_CREEPER, AirCreeperRenderer::new);
        EntityRendererRegistry.register(CreeperRegistry.ELECTRIC_CREEPER, ElectricCreeperRenderer::new);
        EntityRendererRegistry.register(CreeperRegistry.LIGHT_CREEPER, LightCreeperRenderer::new);
        EntityRendererRegistry.register(CreeperRegistry.DARK_CREEPER, DarkCreeperRenderer::new);
        EntityRendererRegistry.register(CreeperRegistry.ICE_CREEPER, IceCreeperRenderer::new);
        EntityRendererRegistry.register(CreeperRegistry.MAGMA_CREEPER, MagmaCreeperRenderer::new);
        EntityRendererRegistry.register(CreeperRegistry.HYDROGEN_CREEPER, HydrogenCreeperRenderer::new);

        EntityRendererRegistry.register(CreeperRegistry.REVERSE_CREEPER, ReverseCreeperRenderer::new);
        EntityRendererRegistry.register(CreeperRegistry.MINER_CREEPER, MinerCreeperRenderer::new);
        EntityRendererRegistry.register(CreeperRegistry.ILLUSION_CREEPER, IllusionCreeperRenderer::new);
        EntityRendererRegistry.register(CreeperRegistry.FIREWORK_CREEPER, FireworkCreeperRenderer::new);
        EntityRendererRegistry.register(CreeperRegistry.COOKIE_CREEPER, CookieCreeperRenderer::new);
        EntityRendererRegistry.register(CreeperRegistry.RAINBOW_CREEPER, RainbowCreeperRenderer::new);

        EntityRendererRegistry.register(CreeperRegistry.FAKE_ILLUSION_CREEPER, IllusionCreeperRenderer::new);

        EntityRendererRegistry.register(TntRegistry.WATER_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.WATER_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(TntRegistry.FIRE_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.FIRE_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(TntRegistry.EARTH_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.EARTH_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(TntRegistry.AIR_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.AIR_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(TntRegistry.ELECTRIC_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.ELECTRIC_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(TntRegistry.LIGHT_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.LIGHT_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(TntRegistry.DARK_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.DARK_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(TntRegistry.ICE_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.ICE_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(TntRegistry.MAGMA_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.MAGMA_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(TntRegistry.HYDROGEN_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.HYDROGEN_TNT_BLOCK.getDefaultState()));

        EntityRendererRegistry.register(TntRegistry.REVERSE_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.REVERSE_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(TntRegistry.MINER_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.MINER_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(TntRegistry.ILLUSION_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.ILLUSION_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(TntRegistry.FIREWORK_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.FIREWORK_TNT_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(TntRegistry.COOKIE_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.COOKIE_TNT_BLOCK.getDefaultState()));

        EntityRendererRegistry.register(TntRegistry.FAKE_ILLUSION_TNT_ENTITY, (context) -> new ElementalTntRenderer(context, TntRegistry.FAKE_ILLUSION_TNT_BLOCK.getDefaultState()));
    }
}