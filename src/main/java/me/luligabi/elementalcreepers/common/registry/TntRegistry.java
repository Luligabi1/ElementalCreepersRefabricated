package me.luligabi.elementalcreepers.common.registry;

import me.luligabi.elementalcreepers.common.ElementalCreepers;
import me.luligabi.elementalcreepers.common.block.*;
import me.luligabi.elementalcreepers.common.entity.tnt.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TntRegistry {

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "water_tnt"), WATER_TNT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "water_tnt"), new BlockItem(WATER_TNT_BLOCK, new FabricItemSettings().group(ElementalCreepers.CATEGORY)));

        Registry.register(Registry.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "fire_tnt"), FIRE_TNT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "fire_tnt"), new BlockItem(FIRE_TNT_BLOCK, new FabricItemSettings().group(ElementalCreepers.CATEGORY)));

        Registry.register(Registry.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "earth_tnt"), EARTH_TNT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "earth_tnt"), new BlockItem(EARTH_TNT_BLOCK, new FabricItemSettings().group(ElementalCreepers.CATEGORY)));

        Registry.register(Registry.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "air_tnt"), AIR_TNT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "air_tnt"), new BlockItem(AIR_TNT_BLOCK, new FabricItemSettings().group(ElementalCreepers.CATEGORY)));

        Registry.register(Registry.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "electric_tnt"), ELECTRIC_TNT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "electric_tnt"), new BlockItem(ELECTRIC_TNT_BLOCK, new FabricItemSettings().group(ElementalCreepers.CATEGORY)));

        Registry.register(Registry.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "light_tnt"), LIGHT_TNT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "light_tnt"), new BlockItem(LIGHT_TNT_BLOCK, new FabricItemSettings().group(ElementalCreepers.CATEGORY)));

        Registry.register(Registry.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "dark_tnt"), DARK_TNT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "dark_tnt"), new BlockItem(DARK_TNT_BLOCK, new FabricItemSettings().group(ElementalCreepers.CATEGORY)));

        Registry.register(Registry.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "ice_tnt"), ICE_TNT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "ice_tnt"), new BlockItem(ICE_TNT_BLOCK, new FabricItemSettings().group(ElementalCreepers.CATEGORY)));

        Registry.register(Registry.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "magma_tnt"), MAGMA_TNT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "magma_tnt"), new BlockItem(MAGMA_TNT_BLOCK, new FabricItemSettings().group(ElementalCreepers.CATEGORY)));

        Registry.register(Registry.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "hydrogen_tnt"), HYDROGEN_TNT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "hydrogen_tnt"), new BlockItem(HYDROGEN_TNT_BLOCK, new FabricItemSettings().group(ElementalCreepers.CATEGORY)));


        Registry.register(Registry.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "reverse_tnt"), REVERSE_TNT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "reverse_tnt"), new BlockItem(REVERSE_TNT_BLOCK, new FabricItemSettings().group(ElementalCreepers.CATEGORY)));

        Registry.register(Registry.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "miner_tnt"), MINER_TNT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "miner_tnt"), new BlockItem(MINER_TNT_BLOCK, new FabricItemSettings().group(ElementalCreepers.CATEGORY)));

        Registry.register(Registry.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "illusion_tnt"), ILLUSION_TNT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "illusion_tnt"), new BlockItem(ILLUSION_TNT_BLOCK, new FabricItemSettings().group(ElementalCreepers.CATEGORY)));

        Registry.register(Registry.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "firework_tnt"), FIREWORK_TNT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "firework_tnt"), new BlockItem(FIREWORK_TNT_BLOCK, new FabricItemSettings().group(ElementalCreepers.CATEGORY)));

        Registry.register(Registry.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "cookie_tnt"), COOKIE_TNT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "cookie_tnt"), new BlockItem(COOKIE_TNT_BLOCK, new FabricItemSettings().group(ElementalCreepers.CATEGORY)));

        Registry.register(Registry.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "fake_illusion_tnt"), FAKE_ILLUSION_TNT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "fake_illusion_tnt"), new BlockItem(FAKE_ILLUSION_TNT_BLOCK, new FabricItemSettings()));
    }

    public static final Block WATER_TNT_BLOCK = new WaterTntBlock(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<WaterTntEntity> WATER_TNT_ENTITY =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "water_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, WaterTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block FIRE_TNT_BLOCK = new FireTntBlock(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<FireTntEntity> FIRE_TNT_ENTITY =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "fire_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, FireTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block EARTH_TNT_BLOCK = new EarthTntBlock(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<EarthTntEntity> EARTH_TNT_ENTITY =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "earth_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, EarthTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block AIR_TNT_BLOCK = new AirTntBlock(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<AirTntEntity> AIR_TNT_ENTITY =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "air_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, AirTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block ELECTRIC_TNT_BLOCK = new ElectricTntBlock(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<ElectricTntEntity> ELECTRIC_TNT_ENTITY =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "electric_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, ElectricTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block LIGHT_TNT_BLOCK = new LightTntBlock(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<LightTntEntity> LIGHT_TNT_ENTITY =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "light_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, LightTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block DARK_TNT_BLOCK = new DarkTntBlock(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<DarkTntEntity> DARK_TNT_ENTITY =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "dark_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, DarkTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block ICE_TNT_BLOCK = new IceTntBlock(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<IceTntEntity> ICE_TNT_ENTITY =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "ice_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, IceTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block MAGMA_TNT_BLOCK = new MagmaTntBlock(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<MagmaTntEntity> MAGMA_TNT_ENTITY =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "magma_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, MagmaTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block HYDROGEN_TNT_BLOCK = new HydrogenTntBlock(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<HydrogenTntEntity> HYDROGEN_TNT_ENTITY =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "hydrogen_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, HydrogenTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());


    public static final Block REVERSE_TNT_BLOCK = new ReverseTntBlock(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<ReverseTntEntity> REVERSE_TNT_ENTITY =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "reverse_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, ReverseTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block MINER_TNT_BLOCK = new MinerTntBlock(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<MinerTntEntity> MINER_TNT_ENTITY =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "miner_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, MinerTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block ILLUSION_TNT_BLOCK = new IllusionTntBlock(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<IllusionTntEntity> ILLUSION_TNT_ENTITY =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "illusion_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, IllusionTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block FIREWORK_TNT_BLOCK = new FireworkTntBlock(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<FireworkTntEntity> FIREWORK_TNT_ENTITY =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "firework_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, FireworkTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block COOKIE_TNT_BLOCK = new CookieTntBlock(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<CookieTntEntity> COOKIE_TNT_ENTITY =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "cookie_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, CookieTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static final Block FAKE_ILLUSION_TNT_BLOCK = new FakeIllusionTntBlock(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<FakeIllusionTntEntity> FAKE_ILLUSION_TNT_ENTITY =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(ElementalCreepers.MOD_ID, "fake_illusion_tnt"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, FakeIllusionTntEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());
}
