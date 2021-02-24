package me.luligabi.elementalcreepers.client;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.renderer.CookieCreeperRenderer;
import me.luligabi.elementalcreepers.renderer.ElectricCreeperRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class ElementalCreepersClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.ELECTRIC_CREEPER, (entityRenderDispatcher, context) -> new ElectricCreeperRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ElementalCreepers.COOKIE_CREEPER, (entityRenderDispatcher, context) -> new CookieCreeperRenderer(entityRenderDispatcher));
    }
}
