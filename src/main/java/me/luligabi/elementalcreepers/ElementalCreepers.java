package me.luligabi.elementalcreepers;

import me.luligabi.elementalcreepers.entity.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;

public class ElementalCreepers implements ModInitializer {

    private static final String NAME_SPACE = "elementalcreepers";
    SimpleConfig config = SimpleConfig.of(NAME_SPACE).provider(this::provider).request();

    private String provider(String filename) {
        return "# Elemental Creepers: Refabricated Configuration File\n\n" +

                "# enabled - If creeper can naturally spawn | true for yes, false for no.\n" +
                "# radius - Radius of the explosion effect and/or effect applied | Number\n" +
                "# spawnRate - Rate of spawn | The smaller the number, more rarely it spawns. Vanilla Creeper's 100.\n\n" +

                "# Water Creeper\n" +
                "waterCreeperEnabled=true\n" +
                "waterCreeperRadius=3\n" +
                "waterCreeperSpawnRate=20\n\n" +

                "# Fire Creeper\n" +
                "fireCreeperEnabled=true\n" +
                "fireCreeperRadius=3\n" +
                "fireCreeperSpawnRate=25\n\n" +

                "# Earth Creeper\n" +
                "earthCreeperEnabled=true\n" +
                "earthCreeperRadius=5\n" +
                "earthCreeperSpawnRate=15\n\n" +

                "# Air Creeper\n" +
                "airCreeperEnabled=true\n" +
                "airCreeperRadius=1.75\n" +
                "airCreeperSpawnRate=20\n\n" +

                "# Electric Creeper\n" +
                "electricCreeperEnabled=true\n" +
                "electricCreeperSpawnRate=7\n\n" +

                "# Light Creeper\n" +
                "lightCreeperEnabled=true\n" +
                "lightCreeperRadius=4\n" +
                "lightCreeperSpawnRate=12\n\n" +

                "# Dark Creeper\n" +
                "darkCreeperEnabled=true\n" +
                "darkCreeperRadius=4\n" +
                "darkCreeperSpawnRate=12\n\n" +

                "# Ice Creeper\n" +
                "iceCreeperEnabled=true\n" +
                "iceCreeperRadius=4\n" +
                "iceCreeperSpawnRate=20\n\n" +

                "# Magma Creeper\n" +
                "magmaCreeperEnabled=true\n" +
                "magmaCreeperRadius=4\n" +
                "magmaCreeperSpawnRate=25\n\n" +

                "# Hydrogen Creeper\n" +
                "hydrogenCreeperEnabled=true\n" +
                "hydrogenCreeperRadius=7\n" +
                "hydrogenCreeperSpawnRate=3\n\n" +

                "# Reverse Creeper\n" +
                "reverseCreeperEnabled=true\n" +
                "reverseCreeperRadius=3.75\n" +
                "reverseCreeperSpawnRate=10\n\n" +

                "# Miner Creeper\n" +
                "minerCreeperEnabled=true\n" +
                "minerCreeperRadius=3.75\n" +
                "minerCreeperSpawnRate=15\n\n" +

                "# Illusion Creeper\n" +
                "illusionCreeperEnabled=true\n" +
                "illusionCreeperSpawnRate=10\n\n" +

                "# Firework Creeper\n" +
                "fireworkCreeperEnabled=true\n" +
                "fireworkCreeperSpawnRate=4\n\n" +

                "# Cookie Creeper\n" +
                "cookieCreeperEnabled=true\n" +
                "cookieCreeperSpawnRate=2";
    }

    @Override
    public void onInitialize() {
        registerCreeperEntities();
        registerNaturalSpawning();
        registerCreeperSpawnEggItems();
    }

    private void registerCreeperEntities() {
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
    }

    @SuppressWarnings("deprecation")
    private void registerNaturalSpawning() {
        // Water Creeper
        if(config.getOrDefault("waterCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.RIVER ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.BEACH ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP, SpawnGroup.MONSTER, WATER_CREEPER, config.getOrDefault("waterCreeperSpawnRate", 20), 1, 1);

            SpawnRestrictionAccessor.callRegister(WATER_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        }
        // Fire Creeper
        if(config.getOrDefault("fireCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.DESERT ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.MESA, SpawnGroup.MONSTER, FIRE_CREEPER, config.getOrDefault("fireCreeperSpawnRate", 25), 1, 2);

            SpawnRestrictionAccessor.callRegister(FIRE_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        }
        // Earth Creeper
        if(config.getOrDefault("earthCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, EARTH_CREEPER, config.getOrDefault("earthCreeperSpawnRate", 15), 1, 1);

            SpawnRestrictionAccessor.callRegister(EARTH_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        }
        // Air Creeper
        if(config.getOrDefault("airCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.EXTREME_HILLS, SpawnGroup.MONSTER, AIR_CREEPER, config.getOrDefault("airCreeperSpawnRate", 20), 1, 1);

            SpawnRestrictionAccessor.callRegister(AIR_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        }
        // Electric Creeper
        if(config.getOrDefault("electricCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, ELECTRIC_CREEPER, config.getOrDefault("electricCreeperSpawnRate", 7), 1, 1);

            SpawnRestrictionAccessor.callRegister(ELECTRIC_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        }
        // Light Creeper
        if(config.getOrDefault("lightCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, LIGHT_CREEPER, config.getOrDefault("lightCreeperSpawnRate", 12), 1, 1);

            SpawnRestrictionAccessor.callRegister(LIGHT_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        }
        // Dark Creeper
        if(config.getOrDefault("darkCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, DARK_CREEPER, config.getOrDefault("darkCreeperSpawnRate", 12), 1, 1);

            SpawnRestrictionAccessor.callRegister(DARK_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        }
        // Ice Creeper
        if(config.getOrDefault("iceCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.ICY ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.EXTREME_HILLS, SpawnGroup.MONSTER, ICE_CREEPER, config.getOrDefault("iceCreeperSpawnRate", 20), 1, 2);

            SpawnRestrictionAccessor.callRegister(ICE_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        }
        // Magma Creeper
        if(config.getOrDefault("magmaCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.NETHER, SpawnGroup.MONSTER, MAGMA_CREEPER, config.getOrDefault("magmaCreeperSpawnRate", 25), 1, 1);

            SpawnRestrictionAccessor.callRegister(MAGMA_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        }
        // Hydrogen Creeper
        if(config.getOrDefault("hydrogenCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, HYDROGEN_CREEPER, config.getOrDefault("hydrogenCreeperSpawnRate", 3), 1, 1);

            SpawnRestrictionAccessor.callRegister(HYDROGEN_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        }
        // Reverse Creeper
        if(config.getOrDefault("reverseCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, REVERSE_CREEPER, config.getOrDefault("reverseCreeperSpawnRate", 10), 1, 1);

            SpawnRestrictionAccessor.callRegister(REVERSE_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        }
        // Miner Creeper
        if(config.getOrDefault("minerCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.EXTREME_HILLS, SpawnGroup.MONSTER, MINER_CREEPER, config.getOrDefault("minerCreeperSpawnRate", 15), 1, 2);

            SpawnRestrictionAccessor.callRegister(MINER_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        }
        // Illusion Creeper
        if(config.getOrDefault("illusionCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, ILLUSION_CREEPER, config.getOrDefault("illusionCreeperSpawnRate", 10), 1, 1);

            SpawnRestrictionAccessor.callRegister(ILLUSION_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        }
        // Firework Creeper
        if(config.getOrDefault("fireworkCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, FIREWORK_CREEPER, config.getOrDefault("fireworkCreeperSpawnRate", 4), 1, 1);

            SpawnRestrictionAccessor.callRegister(FIREWORK_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        }
        // Cookie Creeper
        if(config.getOrDefault("cookieCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                    biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, COOKIE_CREEPER, config.getOrDefault("cookieCreeperSpawnRate", 2), 1, 2);

            SpawnRestrictionAccessor.callRegister(COOKIE_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        }
    }

    private void registerCreeperSpawnEggItems() {
        Registry.register(Registry.ITEM, new Identifier(NAME_SPACE, "water_creeper_spawn_egg"), new SpawnEggItem(WATER_CREEPER, 0x415DB3, 0XA4A4CC, new Item.Settings().group(ElementalCreepers.CATEGORY)));
        Registry.register(Registry.ITEM, new Identifier(NAME_SPACE, "fire_creeper_spawn_egg"), new SpawnEggItem(FIRE_CREEPER, 0xC4814F, 0xA65F0A, new Item.Settings().group(ElementalCreepers.CATEGORY)));
        Registry.register(Registry.ITEM, new Identifier(NAME_SPACE, "earth_creeper_spawn_egg"), new SpawnEggItem(EARTH_CREEPER, 0x7A583C, 0x64A444, new Item.Settings().group(ElementalCreepers.CATEGORY)));
        Registry.register(Registry.ITEM, new Identifier(NAME_SPACE, "air_creeper_spawn_egg"), new SpawnEggItem(AIR_CREEPER, 0x52C671, 0x348349, new Item.Settings().group(ElementalCreepers.CATEGORY)));
        Registry.register(Registry.ITEM, new Identifier(NAME_SPACE, "electric_creeper_spawn_egg"), new SpawnEggItem(ELECTRIC_CREEPER, 0xF2DB47, 0xEED111, new Item.Settings().group(ElementalCreepers.CATEGORY)));
        Registry.register(Registry.ITEM, new Identifier(NAME_SPACE, "light_creeper_spawn_egg"), new SpawnEggItem(LIGHT_CREEPER, 0xECEE29, 0xEBE779, new Item.Settings().group(ElementalCreepers.CATEGORY)));
        Registry.register(Registry.ITEM, new Identifier(NAME_SPACE, "dark_creeper_spawn_egg"), new SpawnEggItem(DARK_CREEPER, 0x343434, 0x747474, new Item.Settings().group(ElementalCreepers.CATEGORY)));
        Registry.register(Registry.ITEM, new Identifier(NAME_SPACE, "ice_creeper_spawn_egg"), new SpawnEggItem(ICE_CREEPER, 0x7CACFC, 0x8CC4FC, new Item.Settings().group(ElementalCreepers.CATEGORY)));
        Registry.register(Registry.ITEM, new Identifier(NAME_SPACE, "magma_creeper_spawn_egg"), new SpawnEggItem(MAGMA_CREEPER, 0xA50B0E, 0xD599A5, new Item.Settings().group(ElementalCreepers.CATEGORY)));
        Registry.register(Registry.ITEM, new Identifier(NAME_SPACE, "hydrogen_creeper_spawn_egg"), new SpawnEggItem(HYDROGEN_CREEPER, 0x0D5F04, 0x242C24, new Item.Settings().group(ElementalCreepers.CATEGORY)));

        Registry.register(Registry.ITEM, new Identifier(NAME_SPACE, "reverse_creeper_spawn_egg"), new SpawnEggItem(REVERSE_CREEPER, 0x0c9e0a, 0x000000, new Item.Settings().group(ElementalCreepers.CATEGORY)));
        Registry.register(Registry.ITEM, new Identifier(NAME_SPACE, "miner_creeper_spawn_egg"), new SpawnEggItem(MINER_CREEPER, 0xA4A4A4, 0xCBCBCB, new Item.Settings().group(ElementalCreepers.CATEGORY)));
        Registry.register(Registry.ITEM, new Identifier(NAME_SPACE, "illusion_creeper_spawn_egg"), new SpawnEggItem(ILLUSION_CREEPER, 0x4319A2, 0x8274C6, new Item.Settings().group(ElementalCreepers.CATEGORY)));
        Registry.register(Registry.ITEM, new Identifier(NAME_SPACE, "firework_creeper_spawn_egg"), new SpawnEggItem(FIREWORK_CREEPER, 0xD73939, 0xE4E4E4, new Item.Settings().group(ElementalCreepers.CATEGORY)));
        Registry.register(Registry.ITEM, new Identifier(NAME_SPACE, "cookie_creeper_spawn_egg"), new SpawnEggItem(COOKIE_CREEPER, 0xE88E3F, 0x8A4929, new Item.Settings().group(ElementalCreepers.CATEGORY)));
    }

    public static final EntityType<WaterCreeperEntity> WATER_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(NAME_SPACE, "water_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WaterCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<FireCreeperEntity> FIRE_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(NAME_SPACE, "fire_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FireCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).fireImmune().build());

    public static final EntityType<EarthCreeperEntity> EARTH_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(NAME_SPACE, "earth_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EarthCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<AirCreeperEntity> AIR_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(NAME_SPACE, "air_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AirCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<ElectricCreeperEntity> ELECTRIC_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(NAME_SPACE, "electric_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ElectricCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<LightCreeperEntity> LIGHT_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(NAME_SPACE, "light_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, LightCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<DarkCreeperEntity> DARK_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(NAME_SPACE, "dark_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DarkCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<IceCreeperEntity> ICE_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(NAME_SPACE, "ice_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, IceCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<MagmaCreeperEntity> MAGMA_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(NAME_SPACE, "magma_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MagmaCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).fireImmune().build());

    public static final EntityType<HydrogenCreeperEntity> HYDROGEN_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(NAME_SPACE, "hydrogen_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HydrogenCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<ReverseCreeperEntity> REVERSE_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(NAME_SPACE, "reverse_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ReverseCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<MinerCreeperEntity> MINER_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(NAME_SPACE, "miner_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MinerCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<IllusionCreeperEntity> ILLUSION_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(NAME_SPACE, "illusion_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, IllusionCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<FakeIllusionCreeperEntity> FAKE_ILLUSION_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(NAME_SPACE, "fake_illusion_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FakeIllusionCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<FireworkCreeperEntity> FIREWORK_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(NAME_SPACE, "firework_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FireworkCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<CookieCreeperEntity> COOKIE_CREEPER =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(NAME_SPACE, "cookie_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CookieCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final ItemGroup CATEGORY = FabricItemGroupBuilder.create(
            new Identifier(NAME_SPACE, "category"))
            .icon(() -> new ItemStack(Items.CREEPER_SPAWN_EGG))
            .build();

    public SimpleConfig getConfig() { return config; }
}