package me.luligabi.elementalcreepers;

import me.luligabi.elementalcreepers.entity.CookieCreeperEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ElementalCreepers implements ModInitializer {

    public static final EntityType<CookieCreeperEntity> COOKIE_CREEPER =
            Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "cookie_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CookieCreeperEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build());

    @Override
    public void onInitialize() {
        System.out.print("ElementalCreepers debug message");
        FabricDefaultAttributeRegistry.register(COOKIE_CREEPER, CookieCreeperEntity.createMobAttributes());
    }
}
