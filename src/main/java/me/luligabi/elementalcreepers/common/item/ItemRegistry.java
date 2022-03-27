package me.luligabi.elementalcreepers.common.item;

import me.luligabi.elementalcreepers.common.ElementalCreepers;
import me.luligabi.elementalcreepers.common.item.ElementalGunpowderItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

    public static void init() {
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

    public static final Item WATER_GUNPOWDER = new ElementalGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final Item FIRE_GUNPOWDER = new ElementalGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final Item EARTH_GUNPOWDER = new ElementalGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final Item AIR_GUNPOWDER = new ElementalGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final Item ELECTRIC_GUNPOWDER = new ElementalGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final Item LIGHT_GUNPOWDER = new ElementalGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final Item DARK_GUNPOWDER = new ElementalGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final Item ICE_GUNPOWDER = new ElementalGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final Item MAGMA_GUNPOWDER = new ElementalGunpowderItem(new FabricItemSettings().fireproof().group(ElementalCreepers.CATEGORY));

    public static final Item HYDROGEN_GUNPOWDER = new ElementalGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final Item REVERSE_GUNPOWDER = new ElementalGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final Item MINER_GUNPOWDER = new ElementalGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final Item ILLUSION_GUNPOWDER = new ElementalGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final Item FIREWORK_GUNPOWDER = new ElementalGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));

    public static final Item COOKIE_GUNPOWDER = new ElementalGunpowderItem(new FabricItemSettings().group(ElementalCreepers.CATEGORY));
}
