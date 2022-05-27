package me.luligabi.elementalcreepers.common.item;

import me.luligabi.elementalcreepers.common.ElementalCreepers;
import me.luligabi.elementalcreepers.common.entity.creeper.CreeperRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SpawnEggRegistry {

    public static void init() {
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "water_creeper_spawn_egg"), new SpawnEggItem(CreeperRegistry.WATER_CREEPER, 0x415DB3, 0XA4A4CC, new Item.Settings().group(ElementalCreepers.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "fire_creeper_spawn_egg"), new SpawnEggItem(CreeperRegistry.FIRE_CREEPER, 0xC4814F, 0xA65F0A, new Item.Settings().group(ElementalCreepers.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "earth_creeper_spawn_egg"), new SpawnEggItem(CreeperRegistry.EARTH_CREEPER, 0x7A583C, 0x64A444, new Item.Settings().group(ElementalCreepers.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "air_creeper_spawn_egg"), new SpawnEggItem(CreeperRegistry.AIR_CREEPER, 0x52C671, 0x348349, new Item.Settings().group(ElementalCreepers.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "electric_creeper_spawn_egg"), new SpawnEggItem(CreeperRegistry.ELECTRIC_CREEPER, 0xF2DB47, 0xEED111, new Item.Settings().group(ElementalCreepers.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "light_creeper_spawn_egg"), new SpawnEggItem(CreeperRegistry.LIGHT_CREEPER, 0xECEE29, 0xEBE779, new Item.Settings().group(ElementalCreepers.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "dark_creeper_spawn_egg"), new SpawnEggItem(CreeperRegistry.DARK_CREEPER, 0x343434, 0x747474, new Item.Settings().group(ElementalCreepers.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "ice_creeper_spawn_egg"), new SpawnEggItem(CreeperRegistry.ICE_CREEPER, 0x7CACFC, 0x8CC4FC, new Item.Settings().group(ElementalCreepers.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "magma_creeper_spawn_egg"), new SpawnEggItem(CreeperRegistry.MAGMA_CREEPER, 0xA50B0E, 0xD599A5, new Item.Settings().group(ElementalCreepers.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "hydrogen_creeper_spawn_egg"), new SpawnEggItem(CreeperRegistry.HYDROGEN_CREEPER, 0x0D5F04, 0x242C24, new Item.Settings().group(ElementalCreepers.ITEM_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "reverse_creeper_spawn_egg"), new SpawnEggItem(CreeperRegistry.REVERSE_CREEPER, 0x0c9e0a, 0x000000, new Item.Settings().group(ElementalCreepers.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "miner_creeper_spawn_egg"), new SpawnEggItem(CreeperRegistry.MINER_CREEPER, 0xA4A4A4, 0xCBCBCB, new Item.Settings().group(ElementalCreepers.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "illusion_creeper_spawn_egg"), new SpawnEggItem(CreeperRegistry.ILLUSION_CREEPER, 0x4319A2, 0x8274C6, new Item.Settings().group(ElementalCreepers.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "firework_creeper_spawn_egg"), new SpawnEggItem(CreeperRegistry.FIREWORK_CREEPER, 0xD73939, 0xE4E4E4, new Item.Settings().group(ElementalCreepers.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "cookie_creeper_spawn_egg"), new SpawnEggItem(CreeperRegistry.COOKIE_CREEPER, 0xE88E3F, 0x8A4929, new Item.Settings().group(ElementalCreepers.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "rainbow_creeper_spawn_egg"), new SpawnEggItem(CreeperRegistry.RAINBOW_CREEPER, 0xD73939, 0x8CC4FC, new Item.Settings().group(ElementalCreepers.ITEM_GROUP)));
    }
}
