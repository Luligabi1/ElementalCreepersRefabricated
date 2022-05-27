package me.luligabi.elementalcreepers.common.misc;

import me.luligabi.elementalcreepers.common.ElementalCreepers;
import me.luligabi.elementalcreepers.common.entity.creeper.CreeperRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.tag.BiomeTags;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;

// TODO: Check if tags using a structure as reference have proper 'IS_[BIOME]' tags now
// Update May 27th, 2022: They don't
public class NaturalSpawningRegistry {


    public static void init() {
        // Water Creeper
        if(ElementalCreepers.CONFIG.waterCreeperEnabled) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiomeRegistryEntry().isIn(BiomeTags.IS_RIVER) ||
                    biomeSelector.getBiomeRegistryEntry().isIn(BiomeTags.IS_BEACH) ||
                    biomeSelector.getBiomeRegistryEntry().isIn(BiomeTags.SWAMP_HUT_HAS_STRUCTURE),
                    SpawnGroup.MONSTER, CreeperRegistry.WATER_CREEPER, ElementalCreepers.CONFIG.waterCreeperSpawnRate, 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.WATER_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Fire Creeper
        if(ElementalCreepers.CONFIG.fireCreeperEnabled) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiomeRegistryEntry().isIn(BiomeTags.DESERT_PYRAMID_HAS_STRUCTURE) ||
                    biomeSelector.getBiomeRegistryEntry().isIn(BiomeTags.VILLAGE_SAVANNA_HAS_STRUCTURE) ||
                    biomeSelector.getBiomeRegistryEntry().isIn(BiomeTags.IS_BADLANDS),
                    SpawnGroup.MONSTER, CreeperRegistry.FIRE_CREEPER, ElementalCreepers.CONFIG.fireCreeperSpawnRate, 1, 2);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.FIRE_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Earth Creeper
        if(ElementalCreepers.CONFIG.earthCreeperEnabled) {
            BiomeModifications.addSpawn(biomeSelector ->
                    isInCommonOverworldBiomes(biomeSelector.getBiomeRegistryEntry()),
                    SpawnGroup.MONSTER, CreeperRegistry.EARTH_CREEPER, ElementalCreepers.CONFIG.earthCreeperSpawnRate, 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.EARTH_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Air Creeper
        if(ElementalCreepers.CONFIG.airCreeperEnabled) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiomeRegistryEntry().isIn(BiomeTags.IS_MOUNTAIN),
                    SpawnGroup.MONSTER, CreeperRegistry.AIR_CREEPER, ElementalCreepers.CONFIG.airCreeperSpawnRate, 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.AIR_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Electric Creeper
        if(ElementalCreepers.CONFIG.electricCreeperEnabled) {
            BiomeModifications.addSpawn(biomeSelector ->
                    isInCommonOverworldBiomes(biomeSelector.getBiomeRegistryEntry()),
                    SpawnGroup.MONSTER, CreeperRegistry.ELECTRIC_CREEPER, ElementalCreepers.CONFIG.electricCreeperSpawnRate, 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.ELECTRIC_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Light Creeper
        if(ElementalCreepers.CONFIG.lightCreeperEnabled) {
            BiomeModifications.addSpawn(biomeSelector ->
                    isInCommonOverworldBiomes(biomeSelector.getBiomeRegistryEntry()),
                    SpawnGroup.MONSTER, CreeperRegistry.LIGHT_CREEPER, ElementalCreepers.CONFIG.lightCreeperSpawnRate, 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.LIGHT_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Dark Creeper
        if(ElementalCreepers.CONFIG.darkCreeperEnabled) {
            BiomeModifications.addSpawn(biomeSelector ->
                    isInCommonOverworldBiomes(biomeSelector.getBiomeRegistryEntry()),
                    SpawnGroup.MONSTER, CreeperRegistry.DARK_CREEPER, ElementalCreepers.CONFIG.darkCreeperSpawnRate, 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.DARK_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Ice Creeper
        if(ElementalCreepers.CONFIG.iceCreeperEnabled) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiomeRegistryEntry().isIn(BiomeTags.IGLOO_HAS_STRUCTURE),
                    SpawnGroup.MONSTER, CreeperRegistry.ICE_CREEPER, ElementalCreepers.CONFIG.iceCreeperSpawnRate, 1, 2);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.ICE_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Magma Creeper
        if(ElementalCreepers.CONFIG.magmaCreeperEnabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInTheNether(),
                    SpawnGroup.MONSTER, CreeperRegistry.MAGMA_CREEPER, ElementalCreepers.CONFIG.magmaCreeperSpawnRate, 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.MAGMA_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Hydrogen Creeper
        if(ElementalCreepers.CONFIG.hydrogenCreeperEnabled) {
            BiomeModifications.addSpawn(biomeSelector ->
                    isInCommonOverworldBiomes(biomeSelector.getBiomeRegistryEntry()),
                    SpawnGroup.MONSTER, CreeperRegistry.HYDROGEN_CREEPER, ElementalCreepers.CONFIG.hydrogenCreeperSpawnRate, 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.HYDROGEN_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Reverse Creeper
        if(ElementalCreepers.CONFIG.reverseCreeperEnabled) {
            BiomeModifications.addSpawn(biomeSelector ->
                    isInCommonOverworldBiomes(biomeSelector.getBiomeRegistryEntry()),
                    SpawnGroup.MONSTER, CreeperRegistry.REVERSE_CREEPER, ElementalCreepers.CONFIG.reverseCreeperSpawnRate, 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.REVERSE_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Miner Creeper
        if(ElementalCreepers.CONFIG.minerCreeperEnabled) {
            BiomeModifications.addSpawn(biomeSelector ->
                    biomeSelector.getBiomeRegistryEntry().isIn(BiomeTags.IS_MOUNTAIN),
                    SpawnGroup.MONSTER, CreeperRegistry.MINER_CREEPER, ElementalCreepers.CONFIG.minerCreeperSpawnRate, 1, 2);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.MINER_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Illusion Creeper
        if(ElementalCreepers.CONFIG.illusionCreeperEnabled) {
            BiomeModifications.addSpawn(biomeSelector ->
                    isInCommonOverworldBiomes(biomeSelector.getBiomeRegistryEntry()),
                    SpawnGroup.MONSTER, CreeperRegistry.ILLUSION_CREEPER, ElementalCreepers.CONFIG.illusionCreeperSpawnRate, 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.ILLUSION_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

        }
        // Firework Creeper
        if(ElementalCreepers.CONFIG.fireworkCreeperEnabled) {
            BiomeModifications.addSpawn(biomeSelector ->
                    isInCommonOverworldBiomes(biomeSelector.getBiomeRegistryEntry()),
                    SpawnGroup.MONSTER, CreeperRegistry.FIREWORK_CREEPER, ElementalCreepers.CONFIG.fireworkCreeperSpawnRate, 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.FIREWORK_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Cookie Creeper
        if(ElementalCreepers.CONFIG.cookieCreeperEnabled) {
            BiomeModifications.addSpawn(biomeSelector ->
                    isInCommonOverworldBiomes(biomeSelector.getBiomeRegistryEntry()),
                    SpawnGroup.MONSTER, CreeperRegistry.COOKIE_CREEPER, ElementalCreepers.CONFIG.cookieCreeperSpawnRate, 1, 2);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.COOKIE_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
        // Rainbow Creeper
        if(ElementalCreepers.CONFIG.rainbowCreeperEnabled) {
            BiomeModifications.addSpawn(biomeSelector ->
                    isInCommonOverworldBiomes(biomeSelector.getBiomeRegistryEntry()),
                    SpawnGroup.MONSTER, CreeperRegistry.HYDROGEN_CREEPER, ElementalCreepers.CONFIG.rainbowCreeperSpawnRate, 1, 1);

            SpawnRestrictionAccessor.callRegister(CreeperRegistry.RAINBOW_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        }
    }

    private static boolean isInCommonOverworldBiomes(RegistryEntry<Biome> biome) {
        return biome.isIn(BiomeTags.VILLAGE_PLAINS_HAS_STRUCTURE) ||
               biome.isIn(BiomeTags.IS_FOREST) ||
               biome.isIn(BiomeTags.IS_TAIGA) ||
               biome.isIn(BiomeTags.VILLAGE_SAVANNA_HAS_STRUCTURE) ||
               biome.isIn(BiomeTags.SWAMP_HUT_HAS_STRUCTURE) ||
               biome.isIn(BiomeTags.IS_JUNGLE);
    }
}