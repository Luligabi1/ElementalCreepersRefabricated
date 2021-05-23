package me.luligabi.elementalcreepers.common.registry;

import me.luligabi.elementalcreepers.common.ElementalCreepers;
import me.luligabi.elementalcreepers.common.SimpleConfig;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;

public class NaturalSpawningRegistry {

    private static final SimpleConfig CONFIG = new ElementalCreepers().getConfig();

    public static void register() {
        // Water Creeper
        if(CONFIG.getOrDefault("waterCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.RIVER ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.BEACH ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP, SpawnGroup.MONSTER, CreeperRegistry.WATER_CREEPER, CONFIG.getOrDefault("waterCreeperSpawnRate", 20), 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.WATER_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Fire Creeper
        if(CONFIG.getOrDefault("fireCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.DESERT ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.MESA, SpawnGroup.MONSTER, CreeperRegistry.FIRE_CREEPER, CONFIG.getOrDefault("fireCreeperSpawnRate", 25), 1, 2);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.FIRE_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Earth Creeper
        if(CONFIG.getOrDefault("earthCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, CreeperRegistry.EARTH_CREEPER, CONFIG.getOrDefault("earthCreeperSpawnRate", 15), 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.EARTH_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Air Creeper
        if(CONFIG.getOrDefault("airCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.EXTREME_HILLS, SpawnGroup.MONSTER, CreeperRegistry.AIR_CREEPER, CONFIG.getOrDefault("airCreeperSpawnRate", 20), 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.AIR_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Electric Creeper
        if(CONFIG.getOrDefault("electricCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, CreeperRegistry.ELECTRIC_CREEPER, CONFIG.getOrDefault("electricCreeperSpawnRate", 7), 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.ELECTRIC_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Light Creeper
        if(CONFIG.getOrDefault("lightCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, CreeperRegistry.LIGHT_CREEPER, CONFIG.getOrDefault("lightCreeperSpawnRate", 12), 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.LIGHT_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Dark Creeper
        if(CONFIG.getOrDefault("darkCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, CreeperRegistry.DARK_CREEPER, CONFIG.getOrDefault("darkCreeperSpawnRate", 12), 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.DARK_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Ice Creeper
        if(CONFIG.getOrDefault("iceCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.ICY ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.EXTREME_HILLS, SpawnGroup.MONSTER, CreeperRegistry.ICE_CREEPER, CONFIG.getOrDefault("iceCreeperSpawnRate", 20), 1, 2);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.ICE_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Magma Creeper
        if(CONFIG.getOrDefault("magmaCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.NETHER, SpawnGroup.MONSTER, CreeperRegistry.MAGMA_CREEPER, CONFIG.getOrDefault("magmaCreeperSpawnRate", 25), 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.MAGMA_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Hydrogen Creeper
        if(CONFIG.getOrDefault("hydrogenCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, CreeperRegistry.HYDROGEN_CREEPER, CONFIG.getOrDefault("hydrogenCreeperSpawnRate", 3), 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.HYDROGEN_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Reverse Creeper
        if(CONFIG.getOrDefault("reverseCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, CreeperRegistry.REVERSE_CREEPER, CONFIG.getOrDefault("reverseCreeperSpawnRate", 10), 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.REVERSE_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Miner Creeper
        if(CONFIG.getOrDefault("minerCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.EXTREME_HILLS, SpawnGroup.MONSTER, CreeperRegistry.MINER_CREEPER, CONFIG.getOrDefault("minerCreeperSpawnRate", 15), 1, 2);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.MINER_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Illusion Creeper
        if(CONFIG.getOrDefault("illusionCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, CreeperRegistry.ILLUSION_CREEPER, CONFIG.getOrDefault("illusionCreeperSpawnRate", 10), 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.ILLUSION_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

        }
        // Firework Creeper
        if(CONFIG.getOrDefault("fireworkCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, CreeperRegistry.FIREWORK_CREEPER, CONFIG.getOrDefault("fireworkCreeperSpawnRate", 4), 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.FIREWORK_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Cookie Creeper
        if(CONFIG.getOrDefault("cookieCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, CreeperRegistry.COOKIE_CREEPER, CONFIG.getOrDefault("cookieCreeperSpawnRate", 2), 1, 2);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.COOKIE_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Rainbow Creeper
        if(CONFIG.getOrDefault("rainbowCreeperEnabled", true)) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiome().getCategory() == Biome.Category.PLAINS ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.FOREST ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.TAIGA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SAVANNA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.DESERT ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.MESA ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.SWAMP ||
                            biomeSelector.getBiome().getCategory() == Biome.Category.JUNGLE, SpawnGroup.MONSTER, CreeperRegistry.HYDROGEN_CREEPER, CONFIG.getOrDefault("rainbowCreeperSpawnRate", 1), 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.RAINBOW_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
    }
}
