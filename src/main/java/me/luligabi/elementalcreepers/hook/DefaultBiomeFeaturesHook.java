package me.luligabi.elementalcreepers.hook;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.SimpleConfig;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.SpawnSettings;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class DefaultBiomeFeaturesHook {

    SimpleConfig config = new ElementalCreepers().getConfig();

    public void addMonsters(SpawnSettings.Builder builder, CallbackInfo info) {
        if(config.getOrDefault("earthCreeperEnabled", true)) {
            builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ElementalCreepers.EARTH_CREEPER, config.getOrDefault("earthCreeperSpawnRate", 20), 1, 2));
        }
        if(config.getOrDefault("airCreeperEnabled", true)) {
            builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ElementalCreepers.AIR_CREEPER, config.getOrDefault("airCreeperSpawnRate", 30), 1, 2));
        }
        if(config.getOrDefault("electricCreeperEnabled", true)) {
            builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ElementalCreepers.ELECTRIC_CREEPER, config.getOrDefault("electricCreeperSpawnRate", 10), 1, 2));
        }
        if(config.getOrDefault("hydrogenCreeperEnabled", true)) {
            builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ElementalCreepers.HYDROGEN_CREEPER, config.getOrDefault("hydrogenCreeperSpawnRate", 7), 1, 2));
        }

        if(config.getOrDefault("reverseCreeperEnabled", true)) {
            builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ElementalCreepers.REVERSE_CREEPER, config.getOrDefault("reverseCreeperSpawnRate", 15), 1, 2));
        }
        if(config.getOrDefault("minerCreeperEnabled", true)) {
            builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ElementalCreepers.MINER_CREEPER, config.getOrDefault("minerCreeperSpawnRate", 20), 1, 2));
        }
        if(config.getOrDefault("hydrogenCreeperEnabled", true)) {
            builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ElementalCreepers.ILLUSION_CREEPER, config.getOrDefault("illusionCreeperSpawnRate", 15), 1, 2));
        }
        if(config.getOrDefault("fireworkCreeperEnabled", true)) {
            builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ElementalCreepers.FIREWORK_CREEPER, config.getOrDefault("fireworkCreeperSpawnRate", 5), 1, 2));
        }
        if(config.getOrDefault("cookieCreeperEnabled", true)) {
            builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ElementalCreepers.COOKIE_CREEPER, config.getOrDefault("cookieCreeperSpawnRate", 2), 1, 2));
        }
        info.cancel();
    }

    public void addOceanMobs(SpawnSettings.Builder builder, CallbackInfo info) {
        if(config.getOrDefault("waterCreeperEnabled", true)) {
            builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ElementalCreepers.WATER_CREEPER, config.getOrDefault("waterCreeperSpawnRate", 15), 1, 2));
        }
        info.cancel();
    }

    public void addWarmOceanMobs(SpawnSettings.Builder builder, CallbackInfo info) {
        if(config.getOrDefault("waterCreeperEnabled", true)) {
            builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ElementalCreepers.WATER_CREEPER, (config.getOrDefault("waterCreeperSpawnRate", 15)) - 10, 1, 1));
        }
        info.cancel();
    }

    public void addDesertMobs(SpawnSettings.Builder builder, CallbackInfo info) {
        if(config.getOrDefault("fireCreeperEnabled", true)) {
            builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ElementalCreepers.FIRE_CREEPER, config.getOrDefault("fireCreeperSpawnRate", 25), 1, 2));
        }
        if(config.getOrDefault("magmaCreeperEnabled", true)) {
            builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ElementalCreepers.MAGMA_CREEPER,config.getOrDefault("magmaCreeperSpawnRate", 5), 1, 1));
        }
        info.cancel();
    }

    public void addSnowyMobs(SpawnSettings.Builder builder, CallbackInfo info) {
        if(config.getOrDefault("iceCreeperEnabled", true)) {
            builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ElementalCreepers.ICE_CREEPER, config.getOrDefault("iceCreeperSpawnRate", 35), 1, 1));
        }
        info.cancel();
    }
}
