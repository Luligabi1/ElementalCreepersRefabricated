package me.luligabi.elementalcreepers;

import me.luligabi.elementalcreepers.entity.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class ElementalCreepers implements ModInitializer {

    @Override
    public void onInitialize() {
        registerCreeperEntities();
        registerCreeperSpawnEggItems();
        registerNaturalSpawning();
    }

    private void registerCreeperEntities() {
        FabricDefaultAttributeRegistry.register(WATER_CREEPER, WaterCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(FIRE_CREEPER, FireCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(EARTH_CREEPER, EarthCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(AIR_CREEPER, AirCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(ELECTRIC_CREEPER, ElectricCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(ICE_CREEPER, IceCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(MAGMA_CREEPER, MagmaCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(HYDROGEN_CREEPER, HydrogenCreeperEntity.createCreeperAttributes());

        FabricDefaultAttributeRegistry.register(REVERSE_CREEPER, ReverseCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(MINER_CREEPER, MinerCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(ILLUSION_CREEPER, IllusionCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(FAKE_ILLUSION_CREEPER, FakeIllusionCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(FIREWORK_CREEPER, FireworkCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(COOKIE_CREEPER, CookieCreeperEntity.createCreeperAttributes());
    }

    private void registerNaturalSpawning() {
        // Water Creeper
        BiomeModifications.addSpawn(biomeSelector ->
                biomeSelector.getBiome().getCategory() == Biome.Category.OCEAN ||
                biomeSelector.getBiome().getCategory() == Biome.Category.RIVER ||
                biomeSelector.getBiome().getCategory() == Biome.Category.BEACH ||
                biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP, SpawnGroup.MONSTER, WATER_CREEPER, 90, 1, 3);

        // Fire Creeper
        BiomeModifications.addSpawn(biomeSelector ->
                biomeSelector.getBiome().getCategory() == Biome.Category.DESERT ||
                biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                biomeSelector.getBiome().getCategory() == Biome.Category.MESA, SpawnGroup.MONSTER, FIRE_CREEPER, 100, 1, 4);

        // Earth Creeper
        BiomeModifications.addSpawn(biomeSelector ->
                biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE ||
                biomeSelector.getBiome().getCategory() == Biome.Category.MUSHROOM, SpawnGroup.MONSTER, EARTH_CREEPER, 80, 1, 2);

        // Air Creeper
        BiomeModifications.addSpawn(biomeSelector ->
                biomeSelector.getBiome().getCategory() == Biome.Category.EXTREME_HILLS, SpawnGroup.MONSTER, EARTH_CREEPER, 70, 1, 2);

        // Electric Creeper
        BiomeModifications.addSpawn(biomeSelector ->
                biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE ||
                biomeSelector.getBiome().getCategory() == Biome.Category.MUSHROOM, SpawnGroup.MONSTER, ELECTRIC_CREEPER, 30, 1, 3);

        // Ice Creeper
        BiomeModifications.addSpawn(biomeSelector ->
                biomeSelector.getBiome().getCategory() == Biome.Category.ICY ||
                biomeSelector.getBiome().getCategory() == Biome.Category.EXTREME_HILLS, SpawnGroup.MONSTER, ICE_CREEPER, 40, 1, 4);

        // Magma Creeper
        BiomeModifications.addSpawn(biomeSelector ->
                biomeSelector.getBiome().getCategory() == Biome.Category.NETHER, SpawnGroup.MONSTER, MAGMA_CREEPER, 60, 1, 2);

        // Hydrogen Creeper
        BiomeModifications.addSpawn(biomeSelector ->
                biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE ||
                biomeSelector.getBiome().getCategory() == Biome.Category.MUSHROOM, SpawnGroup.MONSTER, HYDROGEN_CREEPER, 20, 1, 1);

        // Reverse Creeper
        BiomeModifications.addSpawn(biomeSelector ->
                biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE ||
                biomeSelector.getBiome().getCategory() == Biome.Category.MUSHROOM, SpawnGroup.MONSTER, REVERSE_CREEPER, 45, 1, 1);

        // Miner Creeper
        BiomeModifications.addSpawn(biomeSelector ->
                biomeSelector.getBiome().getCategory() == Biome.Category.EXTREME_HILLS, SpawnGroup.MONSTER, MINER_CREEPER, 60, 1, 2);

        // Illusion Creeper
        BiomeModifications.addSpawn(biomeSelector ->
                biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE ||
                biomeSelector.getBiome().getCategory() == Biome.Category.MUSHROOM, SpawnGroup.MONSTER, ILLUSION_CREEPER, 25, 1, 1);

        BiomeModifications.addSpawn(biomeSelector ->
                biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE ||
                biomeSelector.getBiome().getCategory() == Biome.Category.MUSHROOM, SpawnGroup.MONSTER, FIREWORK_CREEPER, 5, 1, 1);

        // Cookie Creeper
        BiomeModifications.addSpawn(biomeSelector ->
                biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE ||
                biomeSelector.getBiome().getCategory() == Biome.Category.MUSHROOM, SpawnGroup.MONSTER, COOKIE_CREEPER, 2, 1, 2);
    }

    private void registerCreeperSpawnEggItems() {
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "water_creeper_spawn_egg"), new SpawnEggItem(WATER_CREEPER, 0x415DB3, 0XA4A4CC, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "fire_creeper_spawn_egg"), new SpawnEggItem(FIRE_CREEPER, 0xC4814F, 0xA65F0A, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "earth_creeper_spawn_egg"), new SpawnEggItem(EARTH_CREEPER, 0x7A583C, 0x64A444, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "air_creeper_spawn_egg"), new SpawnEggItem(AIR_CREEPER, 0x52C671, 0x348349, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "electric_creeper_spawn_egg"), new SpawnEggItem(ELECTRIC_CREEPER, 0xF2DB47, 0xEED111, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "ice_creeper_spawn_egg"), new SpawnEggItem(ICE_CREEPER, 0x7CACFC, 0x8CC4FC, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "magma_creeper_spawn_egg"), new SpawnEggItem(MAGMA_CREEPER, 0xA50B0E, 0xD599A5, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "hydrogen_creeper_spawn_egg"), new SpawnEggItem(HYDROGEN_CREEPER, 0x0D5F04, 0x242C24, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));

        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "reverse_creeper_spawn_egg"), new SpawnEggItem(REVERSE_CREEPER, 0x0c9e0a, 0x000000, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "miner_creeper_spawn_egg"), new SpawnEggItem(MINER_CREEPER, 0xA4A4A4, 0xCBCBCB, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "illusion_creeper_spawn_egg"), new SpawnEggItem(ILLUSION_CREEPER, 0x4319A2, 0x8274C6, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "firework_creeper_spawn_egg"), new SpawnEggItem(FIREWORK_CREEPER, 0xD73939, 0xE4E4E4, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "cookie_creeper_spawn_egg"), new SpawnEggItem(COOKIE_CREEPER, 0xE88E3F, 0x8A4929, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
    }

    public static final EntityType<WaterCreeperEntity> WATER_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "water_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WaterCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<FireCreeperEntity> FIRE_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "fire_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FireCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<EarthCreeperEntity> EARTH_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "earth_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EarthCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<AirCreeperEntity> AIR_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "air_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AirCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<ElectricCreeperEntity> ELECTRIC_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "electric_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ElectricCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<IceCreeperEntity> ICE_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "ice_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, IceCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<MagmaCreeperEntity> MAGMA_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "magma_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MagmaCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<HydrogenCreeperEntity> HYDROGEN_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "hydrogen_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HydrogenCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<ReverseCreeperEntity> REVERSE_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "reverse_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ReverseCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<MinerCreeperEntity> MINER_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "miner_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MinerCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<IllusionCreeperEntity> ILLUSION_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "illusion_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, IllusionCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<FakeIllusionCreeperEntity> FAKE_ILLUSION_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "fake_illusion_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FakeIllusionCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<FireworkCreeperEntity> FIREWORK_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "firework_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FireworkCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<CookieCreeperEntity> COOKIE_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "cookie_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CookieCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final ItemGroup SPAWN_EGGS = FabricItemGroupBuilder.create(
            new Identifier("elementalcreepers", "category"))
            .icon(() -> new ItemStack(Items.CREEPER_SPAWN_EGG))
            .build();
}