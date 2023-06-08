package me.luligabi.elementalcreepers.common.block;

import me.luligabi.elementalcreepers.common.ElementalCreepers;
import me.luligabi.elementalcreepers.common.entity.tnt.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class TntRegistry {

    public static void init() {
        initTntBlock("water_tnt", WATER_TNT_BLOCK);
        initTntBlock("fire_tnt", FIRE_TNT_BLOCK);
        initTntBlock("earth_tnt", EARTH_TNT_BLOCK);
        initTntBlock("air_tnt", AIR_TNT_BLOCK);
        initTntBlock("electric_tnt", ELECTRIC_TNT_BLOCK);
        initTntBlock("light_tnt", LIGHT_TNT_BLOCK);
        initTntBlock("dark_tnt", DARK_TNT_BLOCK);
        initTntBlock("ice_tnt", ICE_TNT_BLOCK);
        initTntBlock("magma_tnt", MAGMA_TNT_BLOCK);
        initTntBlock("hydrogen_tnt", HYDROGEN_TNT_BLOCK);

        initTntBlock("reverse_tnt", REVERSE_TNT_BLOCK);
        initTntBlock("miner_tnt", MINER_TNT_BLOCK);
        initTntBlock("illusion_tnt", ILLUSION_TNT_BLOCK);
        initTntBlock("firework_tnt", FIREWORK_TNT_BLOCK);
        initTntBlock("cookie_tnt", COOKIE_TNT_BLOCK);
        initTntBlock("fake_illusion_tnt", FAKE_ILLUSION_TNT_BLOCK);
    }

    private static void initTntBlock(String id, Block tntBlock) {
        Registry.register(Registries.BLOCK, new Identifier(ElementalCreepers.MOD_ID, id), tntBlock);
        Registry.register(Registries.ITEM, new Identifier(ElementalCreepers.MOD_ID, id), new BlockItem(tntBlock, new FabricItemSettings()));
    }

    public static final Block WATER_TNT_BLOCK = new WaterTntBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.GRASS).mapColor(DyeColor.BLUE));

    public static final EntityType<WaterTntEntity> WATER_TNT_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "water_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, WaterTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block FIRE_TNT_BLOCK = new FireTntBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.GRASS).mapColor(DyeColor.RED));

    public static final EntityType<FireTntEntity> FIRE_TNT_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "fire_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, FireTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block EARTH_TNT_BLOCK = new EarthTntBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.GRASS).mapColor(DyeColor.BROWN));

    public static final EntityType<EarthTntEntity> EARTH_TNT_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "earth_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, EarthTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block AIR_TNT_BLOCK = new AirTntBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.GRASS).mapColor(MapColor.PALE_GREEN));

    public static final EntityType<AirTntEntity> AIR_TNT_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "air_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, AirTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block ELECTRIC_TNT_BLOCK = new ElectricTntBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.GRASS).mapColor(MapColor.YELLOW));

    public static final EntityType<ElectricTntEntity> ELECTRIC_TNT_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "electric_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, ElectricTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block LIGHT_TNT_BLOCK = new LightTntBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.GRASS).mapColor(MapColor.PALE_YELLOW));

    public static final EntityType<LightTntEntity> LIGHT_TNT_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "light_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, LightTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block DARK_TNT_BLOCK = new DarkTntBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.GRASS).mapColor(DyeColor.GRAY));

    public static final EntityType<DarkTntEntity> DARK_TNT_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "dark_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, DarkTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block ICE_TNT_BLOCK = new IceTntBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.GRASS).mapColor(DyeColor.WHITE));

    public static final EntityType<IceTntEntity> ICE_TNT_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "ice_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, IceTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block MAGMA_TNT_BLOCK = new MagmaTntBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.GRASS).mapColor(MapColor.BRIGHT_RED));

    public static final EntityType<MagmaTntEntity> MAGMA_TNT_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "magma_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, MagmaTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block HYDROGEN_TNT_BLOCK = new HydrogenTntBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.GRASS).mapColor(MapColor.DARK_GREEN));

    public static final EntityType<HydrogenTntEntity> HYDROGEN_TNT_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "hydrogen_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, HydrogenTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());


    public static final Block REVERSE_TNT_BLOCK = new ReverseTntBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.GRASS).mapColor(MapColor.RED));

    public static final EntityType<ReverseTntEntity> REVERSE_TNT_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "reverse_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, ReverseTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block MINER_TNT_BLOCK = new MinerTntBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.GRASS).mapColor(DyeColor.LIGHT_GRAY));

    public static final EntityType<MinerTntEntity> MINER_TNT_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "miner_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, MinerTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block ILLUSION_TNT_BLOCK = new IllusionTntBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.GRASS).mapColor(DyeColor.MAGENTA));

    public static final EntityType<IllusionTntEntity> ILLUSION_TNT_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "illusion_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, IllusionTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block FIREWORK_TNT_BLOCK = new FireworkTntBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<FireworkTntEntity> FIREWORK_TNT_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "firework_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, FireworkTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block COOKIE_TNT_BLOCK = new CookieTntBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.GRASS).mapColor(MapColor.DIRT_BROWN));

    public static final EntityType<CookieTntEntity> COOKIE_TNT_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "cookie_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, CookieTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block FAKE_ILLUSION_TNT_BLOCK = new FakeIllusionTntBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.GRASS).mapColor(DyeColor.MAGENTA));

    public static final EntityType<FakeIllusionTntEntity> FAKE_ILLUSION_TNT_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "fake_illusion_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, FakeIllusionTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());
}
