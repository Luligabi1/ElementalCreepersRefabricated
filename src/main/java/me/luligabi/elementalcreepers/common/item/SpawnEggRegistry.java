package me.luligabi.elementalcreepers.common.item;

import me.luligabi.elementalcreepers.common.ElementalCreepers;
import me.luligabi.elementalcreepers.common.entity.creeper.CreeperRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class SpawnEggRegistry {

    public static void init() {
        register("water_creeper_spawn_egg", WATER_CREEPER_SPAWN_EGG);
        register("fire_creeper_spawn_egg", FIRE_CREEPER_SPAWN_EGG);
        register("earth_creeper_spawn_egg", EARTH_CREEPER_SPAWN_EGG);
        register("air_creeper_spawn_egg", AIR_CREEPER_SPAWN_EGG);
        register("electric_creeper_spawn_egg", ELECTRIC_CREEPER_SPAWN_EGG);
        register("light_creeper_spawn_egg", LIGHT_CREEPER_SPAWN_EGG);
        register("dark_creeper_spawn_egg", DARK_CREEPER_SPAWN_EGG);
        register("ice_creeper_spawn_egg", ICE_CREEPER_SPAWN_EGG);
        register("magma_creeper_spawn_egg", MAGMA_CREEPER_SPAWN_EGG);
        register("hydrogen_creeper_spawn_egg", HYDROGEN_CREEPER_SPAWN_EGG);

        register("reverse_creeper_spawn_egg", REVERSE_CREEPER_SPAWN_EGG);
        register("miner_creeper_spawn_egg", MINER_CREEPER_SPAWN_EGG);
        register("illusion_creeper_spawn_egg", ILLUSION_CREEPER_SPAWN_EGG);
        register("firework_creeper_spawn_egg", FIREWORK_CREEPER_SPAWN_EGG);
        register("cookie_creeper_spawn_egg", COOKIE_CREEPER_SPAWN_EGG);
        register("rainbow_creeper_spawn_egg", RAINBOW_CREEPER_SPAWN_EGG);
    }


    public static final SpawnEggItem WATER_CREEPER_SPAWN_EGG = createSpawnEgg(CreeperRegistry.WATER_CREEPER, 0x415DB3, 0XA4A4CC);
    public static final SpawnEggItem FIRE_CREEPER_SPAWN_EGG = createSpawnEgg(CreeperRegistry.FIRE_CREEPER, 0xC4814F, 0xA65F0A);
    public static final SpawnEggItem EARTH_CREEPER_SPAWN_EGG = createSpawnEgg(CreeperRegistry.EARTH_CREEPER, 0x7A583C, 0x64A444);
    public static final SpawnEggItem AIR_CREEPER_SPAWN_EGG = createSpawnEgg(CreeperRegistry.AIR_CREEPER, 0x52C671, 0x348349);
    public static final SpawnEggItem ELECTRIC_CREEPER_SPAWN_EGG = createSpawnEgg(CreeperRegistry.ELECTRIC_CREEPER, 0xF2DB47, 0xEED111);
    public static final SpawnEggItem LIGHT_CREEPER_SPAWN_EGG = createSpawnEgg(CreeperRegistry.LIGHT_CREEPER, 0xECEE29, 0xEBE779);
    public static final SpawnEggItem DARK_CREEPER_SPAWN_EGG = createSpawnEgg(CreeperRegistry.DARK_CREEPER, 0x343434, 0x747474);
    public static final SpawnEggItem ICE_CREEPER_SPAWN_EGG = createSpawnEgg(CreeperRegistry.ICE_CREEPER, 0x7CACFC, 0x8CC4FC);
    public static final SpawnEggItem MAGMA_CREEPER_SPAWN_EGG = createSpawnEgg(CreeperRegistry.MAGMA_CREEPER, 0xA50B0E, 0xD599A5);
    public static final SpawnEggItem HYDROGEN_CREEPER_SPAWN_EGG = createSpawnEgg(CreeperRegistry.HYDROGEN_CREEPER, 0x0D5F04, 0x242C24);

    public static final SpawnEggItem REVERSE_CREEPER_SPAWN_EGG = createSpawnEgg(CreeperRegistry.REVERSE_CREEPER, 0x0c9e0a, 0x000000);
    public static final SpawnEggItem MINER_CREEPER_SPAWN_EGG = createSpawnEgg(CreeperRegistry.MINER_CREEPER, 0xA4A4A4, 0xCBCBCB);
    public static final SpawnEggItem ILLUSION_CREEPER_SPAWN_EGG = createSpawnEgg(CreeperRegistry.ILLUSION_CREEPER, 0x4319A2, 0x8274C6);
    public static final SpawnEggItem FIREWORK_CREEPER_SPAWN_EGG = createSpawnEgg(CreeperRegistry.FIREWORK_CREEPER, 0xD73939, 0xE4E4E4);
    public static final SpawnEggItem COOKIE_CREEPER_SPAWN_EGG = createSpawnEgg(CreeperRegistry.COOKIE_CREEPER, 0xE88E3F, 0x8A4929);
    public static final SpawnEggItem RAINBOW_CREEPER_SPAWN_EGG = createSpawnEgg(CreeperRegistry.RAINBOW_CREEPER, 0xD73939, 0x8CC4FC);

    private static void register(String id, SpawnEggItem spawnEggItem) {
        Registry.register(Registries.ITEM, new Identifier(ElementalCreepers.MOD_ID, id), spawnEggItem);
    }

    public static SpawnEggItem createSpawnEgg(EntityType<? extends MobEntity> creeperType, int primaryColor, int secondaryColor) {
        return new SpawnEggItem(creeperType, primaryColor, secondaryColor, new Item.Settings());
    }

}