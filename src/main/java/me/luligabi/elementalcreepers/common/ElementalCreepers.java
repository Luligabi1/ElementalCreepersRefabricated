package me.luligabi.elementalcreepers.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import me.luligabi.elementalcreepers.common.block.TntRegistry;
import me.luligabi.elementalcreepers.common.entity.creeper.CreeperRegistry;
import me.luligabi.elementalcreepers.common.item.ItemRegistry;
import me.luligabi.elementalcreepers.common.item.SpawnEggRegistry;
import me.luligabi.elementalcreepers.common.misc.DispenserLogicRegistry;
import me.luligabi.elementalcreepers.common.misc.NaturalSpawningRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class ElementalCreepers implements ModInitializer {

    @Override
    public void onInitialize() {
        CreeperRegistry.init();
        NaturalSpawningRegistry.init();
        SpawnEggRegistry.init();
        TntRegistry.init();
        ItemRegistry.init();
        DispenserLogicRegistry.init();
        LOGGER.info("Mod Initialized!");
    }

    private static ModConfig createConfig() {
        ModConfig finalConfig;
        LOGGER.info("Trying to read config file...");
        try {
            if(CONFIG_FILE.createNewFile()) {
                LOGGER.info("No config file found, creating a new one...");
                writeConfig(GSON.toJson(JsonParser.parseString(GSON.toJson(new ModConfig()))));
                finalConfig = new ModConfig();
                LOGGER.info("Successfully created default config file.");
            } else {
                LOGGER.info("A config file was found, loading it..");
                finalConfig = GSON.fromJson(new String(Files.readAllBytes(CONFIG_FILE.toPath())), ModConfig.class);
                if(finalConfig == null) {
                    throw new NullPointerException("The config file was empty.");
                } else {
                    LOGGER.info("Successfully loaded config file.");
                }
            }
        } catch(Exception e) {
            LOGGER.error("There was an error creating/loading the config file!", e);
            finalConfig = new ModConfig();
            LOGGER.warn("Defaulting to original config.");
        }
        return finalConfig;
    }

    public static void saveConfig(ModConfig modConfig) {
        try {
            writeConfig(GSON.toJson(JsonParser.parseString(GSON.toJson(modConfig))));
            LOGGER.info("Saved new config file.");
        } catch(Exception e) {
            LOGGER.error("There was an error saving the config file!", e);
        }
    }

    private static void writeConfig(String json) {
        try(PrintWriter printWriter = new PrintWriter(CONFIG_FILE)) {
            printWriter.write(json);
            printWriter.flush();
        } catch(IOException e) {
            LOGGER.error("Failed to write config file", e);
        }
    }

    public static final String MOD_ID = "elementalcreepers";

    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "category"))
            .displayName(Text.translatable("itemGroup.elementalcreepers.category"))
            .icon(() -> new ItemStack(Items.CREEPER_SPAWN_EGG))
            .entries((enabledFeatures, entries, operatorEnabled) -> {
                entries.add(SpawnEggRegistry.WATER_CREEPER_SPAWN_EGG);
                entries.add(SpawnEggRegistry.FIRE_CREEPER_SPAWN_EGG);
                entries.add(SpawnEggRegistry.EARTH_CREEPER_SPAWN_EGG);
                entries.add(SpawnEggRegistry.AIR_CREEPER_SPAWN_EGG);
                entries.add(SpawnEggRegistry.ELECTRIC_CREEPER_SPAWN_EGG);
                entries.add(SpawnEggRegistry.LIGHT_CREEPER_SPAWN_EGG);
                entries.add(SpawnEggRegistry.DARK_CREEPER_SPAWN_EGG);
                entries.add(SpawnEggRegistry.ICE_CREEPER_SPAWN_EGG);
                entries.add(SpawnEggRegistry.MAGMA_CREEPER_SPAWN_EGG);
                entries.add(SpawnEggRegistry.HYDROGEN_CREEPER_SPAWN_EGG);
                entries.add(SpawnEggRegistry.REVERSE_CREEPER_SPAWN_EGG);
                entries.add(SpawnEggRegistry.MINER_CREEPER_SPAWN_EGG);
                entries.add(SpawnEggRegistry.ILLUSION_CREEPER_SPAWN_EGG);
                entries.add(SpawnEggRegistry.FIREWORK_CREEPER_SPAWN_EGG);
                entries.add(SpawnEggRegistry.COOKIE_CREEPER_SPAWN_EGG);
                entries.add(SpawnEggRegistry.RAINBOW_CREEPER_SPAWN_EGG);

                entries.add(TntRegistry.WATER_TNT_BLOCK);
                entries.add(TntRegistry.FIRE_TNT_BLOCK);
                entries.add(TntRegistry.EARTH_TNT_BLOCK);
                entries.add(TntRegistry.AIR_TNT_BLOCK);
                entries.add(TntRegistry.ELECTRIC_TNT_BLOCK);
                entries.add(TntRegistry.LIGHT_TNT_BLOCK);
                entries.add(TntRegistry.DARK_TNT_BLOCK);
                entries.add(TntRegistry.ICE_TNT_BLOCK);
                entries.add(TntRegistry.MAGMA_TNT_BLOCK);
                entries.add(TntRegistry.HYDROGEN_TNT_BLOCK);
                entries.add(TntRegistry.REVERSE_TNT_BLOCK);
                entries.add(TntRegistry.MINER_TNT_BLOCK);
                entries.add(TntRegistry.ILLUSION_TNT_BLOCK);
                entries.add(TntRegistry.FIREWORK_TNT_BLOCK);
                entries.add(TntRegistry.COOKIE_TNT_BLOCK);

                entries.add(ItemRegistry.WATER_GUNPOWDER);
                entries.add(ItemRegistry.FIRE_GUNPOWDER);
                entries.add(ItemRegistry.EARTH_GUNPOWDER);
                entries.add(ItemRegistry.AIR_GUNPOWDER);
                entries.add(ItemRegistry.ELECTRIC_GUNPOWDER);
                entries.add(ItemRegistry.LIGHT_GUNPOWDER);
                entries.add(ItemRegistry.DARK_GUNPOWDER);
                entries.add(ItemRegistry.ICE_GUNPOWDER);
                entries.add(ItemRegistry.MAGMA_GUNPOWDER);
                entries.add(ItemRegistry.HYDROGEN_GUNPOWDER);
                entries.add(ItemRegistry.REVERSE_GUNPOWDER);
                entries.add(ItemRegistry.MINER_GUNPOWDER);
                entries.add(ItemRegistry.ILLUSION_GUNPOWDER);
                entries.add(ItemRegistry.FIREWORK_GUNPOWDER);
                entries.add(ItemRegistry.COOKIE_GUNPOWDER);
            })
            .build();

    public static final Logger LOGGER;
    private static final Gson GSON;

    private static final File CONFIG_FILE;
    public static final ModConfig CONFIG;

    static {
        LOGGER = LoggerFactory.getLogger("Elemental Creepers: Refabricated");
        GSON = new GsonBuilder().setPrettyPrinting().create();

        CONFIG_FILE = new File(String.format("%s%selementalcreepers.json", FabricLoader.getInstance().getConfigDir(), File.separator));
        CONFIG = createConfig();
    }


}