package me.luligabi.elementalcreepers.common;

import me.luligabi.elementalcreepers.common.block.TntRegistry;
import me.luligabi.elementalcreepers.common.entity.creeper.CreeperRegistry;
import me.luligabi.elementalcreepers.common.item.ItemRegistry;
import me.luligabi.elementalcreepers.common.item.SpawnEggRegistry;
import me.luligabi.elementalcreepers.common.misc.DispenserLogicRegistry;
import me.luligabi.elementalcreepers.common.misc.NaturalSpawningRegistry;
import me.luligabi.elementalcreepers.common.misc.TagRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ElementalCreepers implements ModInitializer {

    public static final String MOD_ID = "elementalcreepers";
    private static final Logger LOGGER = LogManager.getLogger("Elemental Creepers: Refabricated");

    @Override
    public void onInitialize() {
        CreeperRegistry.init();
        NaturalSpawningRegistry.init();
        SpawnEggRegistry.init();
        TntRegistry.init();
        ItemRegistry.init();
        TagRegistry.init();
        DispenserLogicRegistry.init();
        LOGGER.info("Mod Initialized!");
    }

    public static final ItemGroup CATEGORY = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "category"))
            .icon(() -> new ItemStack(Items.CREEPER_SPAWN_EGG))
            .build();

    SimpleConfig config = SimpleConfig.of(MOD_ID).provider(this::provider).request();

    private String provider(String filename) {
        return """
                # Elemental Creepers: Refabricated Configuration File

                # enabled - If creeper can naturally spawn | true for yes, false for no.
                # radius - Radius of the explosion effect and/or effect applied | Number
                # spawnRate - Rate of spawn | The smaller the number, more rarely it spawns. Vanilla Creeper's 100.

                # Water Creeper
                waterCreeperEnabled=true
                waterCreeperRadius=3
                waterCreeperSpawnRate=20

                # Fire Creeper
                fireCreeperEnabled=true
                fireCreeperRadius=3
                fireCreeperSpawnRate=25

                # Earth Creeper
                earthCreeperEnabled=true
                earthCreeperRadius=5
                earthCreeperSpawnRate=15

                # Air Creeper
                airCreeperEnabled=true
                airCreeperRadius=1.75
                airCreeperSpawnRate=20

                # Electric Creeper
                electricCreeperEnabled=true
                electricCreeperSpawnRate=7

                # Light Creeper
                lightCreeperEnabled=true
                lightCreeperRadius=4
                lightCreeperSpawnRate=12

                # Dark Creeper
                darkCreeperEnabled=true
                darkCreeperRadius=4
                darkCreeperSpawnRate=12

                # Ice Creeper
                iceCreeperEnabled=true
                iceCreeperRadius=4
                iceCreeperSpawnRate=20

                # Magma Creeper
                magmaCreeperEnabled=true
                magmaCreeperRadius=4
                magmaCreeperSpawnRate=25

                # Hydrogen Creeper
                hydrogenCreeperEnabled=true
                hydrogenCreeperRadius=7
                hydrogenCreeperSpawnRate=3

                # Reverse Creeper
                reverseCreeperEnabled=true
                reverseCreeperRadius=3.75
                reverseCreeperSpawnRate=10

                # Miner Creeper
                minerCreeperEnabled=true
                minerCreeperRadius=3.75
                minerCreeperSpawnRate=15

                # Illusion Creeper
                illusionCreeperEnabled=true
                illusionCreeperSpawnRate=10

                # Firework Creeper
                fireworkCreeperEnabled=true
                fireworkCreeperSpawnRate=4

                # Cookie Creeper
                cookieCreeperEnabled=true
                cookieCreeperSpawnRate=2

                # Rainbow Creeper
                rainbowCreeperEnabled=true
                rainbowCreeperSpawnRate=1""";
    }

    public SimpleConfig getConfig() { return config; }
}