package me.luligabi.elementalcreepers.common.entity.creeper;

import me.luligabi.elementalcreepers.common.ElementalCreepers;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CreeperRegistry {

    public static void init() {
        FabricDefaultAttributeRegistry.register(WATER_CREEPER, WaterCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(FIRE_CREEPER, FireCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(EARTH_CREEPER, EarthCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(AIR_CREEPER, AirCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(ELECTRIC_CREEPER, ElectricCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(LIGHT_CREEPER, LightCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(DARK_CREEPER, DarkCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(ICE_CREEPER, IceCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(MAGMA_CREEPER, MagmaCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(HYDROGEN_CREEPER, HydrogenCreeperEntity.createCreeperAttributes());

        FabricDefaultAttributeRegistry.register(REVERSE_CREEPER, ReverseCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(MINER_CREEPER, MinerCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(ILLUSION_CREEPER, IllusionCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(FAKE_ILLUSION_CREEPER, FakeIllusionCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(FIREWORK_CREEPER, FireworkCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(COOKIE_CREEPER, CookieCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(RAINBOW_CREEPER, RainbowCreeperEntity.createCreeperAttributes());
    }
    private static final EntityDimensions CREEPER_DIMENSIONS = EntityDimensions.fixed(0.6F, 1.7F);


    public static final EntityType<WaterCreeperEntity> WATER_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "water_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WaterCreeperEntity::new).dimensions(CREEPER_DIMENSIONS).build());

    public static final EntityType<FireCreeperEntity> FIRE_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "fire_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FireCreeperEntity::new).dimensions(CREEPER_DIMENSIONS).fireImmune().build());

    public static final EntityType<EarthCreeperEntity> EARTH_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "earth_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EarthCreeperEntity::new).dimensions(CREEPER_DIMENSIONS).build());

    public static final EntityType<AirCreeperEntity> AIR_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "air_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AirCreeperEntity::new).dimensions(CREEPER_DIMENSIONS).build());

    public static final EntityType<ElectricCreeperEntity> ELECTRIC_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "electric_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ElectricCreeperEntity::new).dimensions(CREEPER_DIMENSIONS).build());

    public static final EntityType<LightCreeperEntity> LIGHT_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "light_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, LightCreeperEntity::new).dimensions(CREEPER_DIMENSIONS).build());

    public static final EntityType<DarkCreeperEntity> DARK_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "dark_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DarkCreeperEntity::new).dimensions(CREEPER_DIMENSIONS).build());

    public static final EntityType<IceCreeperEntity> ICE_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "ice_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, IceCreeperEntity::new).dimensions(CREEPER_DIMENSIONS).build());

    public static final EntityType<MagmaCreeperEntity> MAGMA_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "magma_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MagmaCreeperEntity::new).dimensions(CREEPER_DIMENSIONS).fireImmune().build());

    public static final EntityType<HydrogenCreeperEntity> HYDROGEN_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "hydrogen_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HydrogenCreeperEntity::new).dimensions(CREEPER_DIMENSIONS).build());

    public static final EntityType<ReverseCreeperEntity> REVERSE_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "reverse_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ReverseCreeperEntity::new).dimensions(CREEPER_DIMENSIONS).build());

    public static final EntityType<MinerCreeperEntity> MINER_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "miner_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MinerCreeperEntity::new).dimensions(CREEPER_DIMENSIONS).build());

    public static final EntityType<IllusionCreeperEntity> ILLUSION_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "illusion_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, IllusionCreeperEntity::new).dimensions(CREEPER_DIMENSIONS).build());

    public static final EntityType<FakeIllusionCreeperEntity> FAKE_ILLUSION_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "fake_illusion_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FakeIllusionCreeperEntity::new).dimensions(CREEPER_DIMENSIONS).build());

    public static final EntityType<FireworkCreeperEntity> FIREWORK_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "firework_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FireworkCreeperEntity::new).dimensions(CREEPER_DIMENSIONS).build());

    public static final EntityType<CookieCreeperEntity> COOKIE_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "cookie_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CookieCreeperEntity::new).dimensions(CREEPER_DIMENSIONS).build());

    public static final EntityType<RainbowCreeperEntity> RAINBOW_CREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "rainbow_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, RainbowCreeperEntity::new).fireImmune().dimensions(CREEPER_DIMENSIONS).build());

}