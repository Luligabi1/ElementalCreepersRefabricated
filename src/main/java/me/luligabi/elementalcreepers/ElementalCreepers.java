package me.luligabi.elementalcreepers;

import me.luligabi.elementalcreepers.entity.CookieCreeperEntity;
import me.luligabi.elementalcreepers.entity.ElectricCreeperEntity;
import me.luligabi.elementalcreepers.entity.FireworkCreeperEntity;
import me.luligabi.elementalcreepers.entity.HydrogenCreeperEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ElementalCreepers implements ModInitializer {

    public static final EntityType<ElectricCreeperEntity> ELECTRIC_CREEPER =
            Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "electric_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ElectricCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

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


    @Override
    public void onInitialize() {
        registerCreeperEntities();
        registerCreeperSpawnEggItems();
    }
    private void registerCreeperEntities() {
        FabricDefaultAttributeRegistry.register(ELECTRIC_CREEPER, ElectricCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(HYDROGEN_CREEPER, HydrogenCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(FIREWORK_CREEPER, HydrogenCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(COOKIE_CREEPER, CookieCreeperEntity.createCreeperAttributes());
    }
    private void registerCreeperSpawnEggItems() {
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "electric_creeper_spawn_egg"), new SpawnEggItem(ELECTRIC_CREEPER, 0xE88E3F, 0x8A4929, new Item.Settings().group(ItemGroup.MISC))); // TODO: Change colors
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "hydrogen_creeper_spawn_egg"), new SpawnEggItem(HYDROGEN_CREEPER, 0xE88E3F, 0x8A4929, new Item.Settings().group(ItemGroup.MISC))); // TODO: Change colors
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "firework_creeper_spawn_egg"), new SpawnEggItem(FIREWORK_CREEPER, 0xE88E3F, 0x8A4929, new Item.Settings().group(ItemGroup.MISC))); // TODO: Change colors
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "cookie_creeper_spawn_egg"), new SpawnEggItem(COOKIE_CREEPER, 0xE88E3F, 0x8A4929, new Item.Settings().group(ItemGroup.MISC)));
    }
}