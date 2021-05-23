package me.luligabi.elementalcreepers.common.registry;

import me.luligabi.elementalcreepers.common.ElementalCreepers;
import me.luligabi.elementalcreepers.common.item.gunpowder.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "water_gunpowder"), WATER_GUNPOWDER);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "fire_gunpowder"), FIRE_GUNPOWDER);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "earth_gunpowder"), EARTH_GUNPOWDER);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "air_gunpowder"), AIR_GUNPOWDER);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "electric_gunpowder"), ELECTRIC_GUNPOWDER);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "light_gunpowder"), LIGHT_GUNPOWDER);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "dark_gunpowder"), DARK_GUNPOWDER);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "ice_gunpowder"), ICE_GUNPOWDER);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "magma_gunpowder"), MAGMA_GUNPOWDER);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "hydrogen_gunpowder"), HYDROGEN_GUNPOWDER);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "reverse_gunpowder"), REVERSE_GUNPOWDER);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "miner_gunpowder"), MINER_GUNPOWDER);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "illusion_gunpowder"), ILLUSION_GUNPOWDER);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "firework_gunpowder"), FIREWORK_GUNPOWDER);
        Registry.register(Registry.ITEM, new Identifier(ElementalCreepers.MOD_ID, "cookie_gunpowder"), COOKIE_GUNPOWDER);
    }

    public static final WaterGunpowderItem WATER_GUNPOWDER = new WaterGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final FireGunpowderItem FIRE_GUNPOWDER = new FireGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final EarthGunpowderItem EARTH_GUNPOWDER = new EarthGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final AirGunpowderItem AIR_GUNPOWDER = new AirGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final ElectricGunpowderItem ELECTRIC_GUNPOWDER = new ElectricGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final LightGunpowderItem LIGHT_GUNPOWDER = new LightGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final DarkGunpowderItem DARK_GUNPOWDER = new DarkGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final IceGunpowderItem ICE_GUNPOWDER = new IceGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final MagmaGunpowderItem MAGMA_GUNPOWDER = new MagmaGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final HydrogenGunpowderItem HYDROGEN_GUNPOWDER = new HydrogenGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final ReverseGunpowderItem REVERSE_GUNPOWDER = new ReverseGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final MinerGunpowderItem MINER_GUNPOWDER = new MinerGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final IllusionGunpowderItem ILLUSION_GUNPOWDER = new IllusionGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final FireworkGunpowderItem FIREWORK_GUNPOWDER = new FireworkGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final CookieGunpowderItem COOKIE_GUNPOWDER = new CookieGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));
}
