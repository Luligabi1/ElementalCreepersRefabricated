package me.luligabi.elementalcreepers;

import me.luligabi.elementalcreepers.registry.*;
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

    SimpleConfig config = SimpleConfig.of(MOD_ID).provider(this::provider).request();

    private String provider(String filename) {
        return "# Elemental Creepers: Refabricated Configuration File\n\n" +

                "# enabled - If creeper can naturally spawn | true for yes, false for no.\n" +
                "# radius - Radius of the explosion effect and/or effect applied | Number\n" +
                "# spawnRate - Rate of spawn | The smaller the number, more rarely it spawns. Vanilla Creeper's 100.\n\n" +

                "# Water Creeper\n" +
                "waterCreeperEnabled=true\n" +
                "waterCreeperRadius=3\n" +
                "waterCreeperSpawnRate=20\n\n" +

                "# Fire Creeper\n" +
                "fireCreeperEnabled=true\n" +
                "fireCreeperRadius=3\n" +
                "fireCreeperSpawnRate=25\n\n" +

                "# Earth Creeper\n" +
                "earthCreeperEnabled=true\n" +
                "earthCreeperRadius=5\n" +
                "earthCreeperSpawnRate=15\n\n" +

                "# Air Creeper\n" +
                "airCreeperEnabled=true\n" +
                "airCreeperRadius=1.75\n" +
                "airCreeperSpawnRate=20\n\n" +

                "# Electric Creeper\n" +
                "electricCreeperEnabled=true\n" +
                "electricCreeperSpawnRate=7\n\n" +

                "# Light Creeper\n" +
                "lightCreeperEnabled=true\n" +
                "lightCreeperRadius=4\n" +
                "lightCreeperSpawnRate=12\n\n" +

                "# Dark Creeper\n" +
                "darkCreeperEnabled=true\n" +
                "darkCreeperRadius=4\n" +
                "darkCreeperSpawnRate=12\n\n" +

                "# Ice Creeper\n" +
                "iceCreeperEnabled=true\n" +
                "iceCreeperRadius=4\n" +
                "iceCreeperSpawnRate=20\n\n" +

                "# Magma Creeper\n" +
                "magmaCreeperEnabled=true\n" +
                "magmaCreeperRadius=4\n" +
                "magmaCreeperSpawnRate=25\n\n" +

                "# Hydrogen Creeper\n" +
                "hydrogenCreeperEnabled=true\n" +
                "hydrogenCreeperRadius=7\n" +
                "hydrogenCreeperSpawnRate=3\n\n" +

                "# Reverse Creeper\n" +
                "reverseCreeperEnabled=true\n" +
                "reverseCreeperRadius=3.75\n" +
                "reverseCreeperSpawnRate=10\n\n" +

                "# Miner Creeper\n" +
                "minerCreeperEnabled=true\n" +
                "minerCreeperRadius=3.75\n" +
                "minerCreeperSpawnRate=15\n\n" +

                "# Illusion Creeper\n" +
                "illusionCreeperEnabled=true\n" +
                "illusionCreeperSpawnRate=10\n\n" +

                "# Firework Creeper\n" +
                "fireworkCreeperEnabled=true\n" +
                "fireworkCreeperSpawnRate=4\n\n" +

                "# Cookie Creeper\n" +
                "cookieCreeperEnabled=true\n" +
                "cookieCreeperSpawnRate=2\n\n" +

                "# Rainbow Creeper\n" +
                "rainbowCreeperEnabled=true\n" +
                "rainbowCreeperSpawnRate=1";
    }

    @Override
    public void onInitialize() {
        CreeperRegistry.register();
        NaturalSpawningRegistry.register();
        SpawnEggRegistry.register();
        TntRegistry.register();
        ItemRegistry.register();
        LOGGER.info("Mod Initialized!");
    }

    public static final ItemGroup CATEGORY = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "category"))
            .icon(() -> new ItemStack(Items.CREEPER_SPAWN_EGG))
            .build();

    public SimpleConfig getConfig() { return config; }
}