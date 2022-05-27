package me.luligabi.elementalcreepers.common;

import draylar.omegaconfig.OmegaConfig;
import me.luligabi.elementalcreepers.common.block.TntRegistry;
import me.luligabi.elementalcreepers.common.entity.creeper.CreeperRegistry;
import me.luligabi.elementalcreepers.common.item.ItemRegistry;
import me.luligabi.elementalcreepers.common.item.SpawnEggRegistry;
import me.luligabi.elementalcreepers.common.misc.DispenserLogicRegistry;
import me.luligabi.elementalcreepers.common.misc.NaturalSpawningRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ElementalCreepers implements ModInitializer {

    @Override
    public void onInitialize() {
        CreeperRegistry.init();
        NaturalSpawningRegistry.init();
        SpawnEggRegistry.init();
        TntRegistry.init();
        ItemRegistry.init();
        DispenserLogicRegistry.init();
        //LOGGER.info("Mod Initialized!"); // TODO: Replace this (should've been done by 1.18.2 *sigh*)
    }

    public static final String MOD_ID = "elementalcreepers";

    public static final ModConfig CONFIG = OmegaConfig.register(ModConfig.class);

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "category"))
            .icon(() -> new ItemStack(Items.CREEPER_SPAWN_EGG))
            .build();

}