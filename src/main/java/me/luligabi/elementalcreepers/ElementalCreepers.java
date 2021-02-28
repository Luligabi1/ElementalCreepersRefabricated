package me.luligabi.elementalcreepers;

import me.luligabi.elementalcreepers.entity.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ElementalCreepers implements ModInitializer {

    @Override
    public void onInitialize() {
        registerCreeperEntities();
        registerCreeperSpawnEggItems();
    }
    private void registerCreeperEntities() {
        FabricDefaultAttributeRegistry.register(WATER_CREEPER, WaterCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(ELECTRIC_CREEPER, ElectricCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(LIGHT_CREEPER, LightCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(ICE_CREEPER, IceCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(HYDROGEN_CREEPER, HydrogenCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(FIREWORK_CREEPER, FireworkCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(COOKIE_CREEPER, CookieCreeperEntity.createCreeperAttributes());
    }
    private void registerCreeperSpawnEggItems() {
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "water_creeper_spawn_egg"), new SpawnEggItem(WATER_CREEPER, 0x415db3, 0xa4a4cc, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "electric_creeper_spawn_egg"), new SpawnEggItem(ELECTRIC_CREEPER, 0xF2DB47, 0xEED111, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "light_creeper_spawn_egg"), new SpawnEggItem(LIGHT_CREEPER, 0xF2DB47, 0xEED111, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS))); //TODO: Change colors
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "ice_creeper_spawn_egg"), new SpawnEggItem(ICE_CREEPER, 0x7CACFC, 0x8CC4FC, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "hydrogen_creeper_spawn_egg"), new SpawnEggItem(HYDROGEN_CREEPER, 0xE88E3F, 0x8A4929, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS))); //TODO: Change colors
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "firework_creeper_spawn_egg"), new SpawnEggItem(FIREWORK_CREEPER, 0xD73939, 0xE4E4E4, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "cookie_creeper_spawn_egg"), new SpawnEggItem(COOKIE_CREEPER, 0xE88E3F, 0x8A4929, new Item.Settings().group(ElementalCreepers.SPAWN_EGGS)));
    }

    public static final EntityType<WaterCreeperEntity> WATER_CREEPER =
            Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "water_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WaterCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<ElectricCreeperEntity> ELECTRIC_CREEPER =
            Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "electric_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ElectricCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<LightCreeperEntity> LIGHT_CREEPER =
            Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "light_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, LightCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<IceCreeperEntity> ICE_CREEPER =
            Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "ice_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, IceCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<HydrogenCreeperEntity> HYDROGEN_CREEPER =
            Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "hydrogen_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HydrogenCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<FireworkCreeperEntity> FIREWORK_CREEPER =
            Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "firework_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FireworkCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<CookieCreeperEntity> COOKIE_CREEPER =
            Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "cookie_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CookieCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final ItemGroup SPAWN_EGGS = FabricItemGroupBuilder.create(
            new Identifier("elementalcreepers", "category"))
            .icon(() -> new ItemStack(Items.CREEPER_SPAWN_EGG))
            .build();
}