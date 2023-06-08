package me.luligabi.elementalcreepers.client.compat.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.BooleanControllerBuilder;
import dev.isxander.yacl3.api.controller.FloatFieldControllerBuilder;
import dev.isxander.yacl3.api.controller.IntegerFieldControllerBuilder;
import me.luligabi.elementalcreepers.common.ElementalCreepers;
import me.luligabi.elementalcreepers.common.ModConfig;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ConfigScreenEntrypoint implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return this::createConfigScreen;
    }

    public Screen createConfigScreen(Screen parent) {
        ModConfig config = ElementalCreepers.CONFIG;

        /*
         * Water Creeper
         */
        Option<Integer> waterCreeperSpawnRate = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.waterCreeperSpawnRate"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.waterCreeperSpawnRate.tooltip")))
                .binding(
                        20,
                        () -> config.waterCreeperSpawnRate,
                        newValue -> config.waterCreeperSpawnRate = newValue
                )
                .available(config.waterCreeperEnabled)
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 100))
                .build();

        Option<Boolean> waterCreeperEnabled = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.waterCreeperEnabled"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.waterCreeperEnabled.tooltip")))
                .binding(
                        true,
                        () -> config.waterCreeperEnabled,
                        newValue -> {
                            config.waterCreeperEnabled = newValue;
                            waterCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Float> waterCreeperRadius = Option.<Float>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.waterCreeperRadius"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.waterCreeperRadius.tooltip")))
                .binding(
                        3F,
                        () -> config.waterCreeperRadius,
                        newValue -> config.waterCreeperRadius = newValue
                )
                .controller(option -> FloatFieldControllerBuilder.create(option).range(1F, 10F))
                .build();

        /*
         * Fire Creeper
         */
        Option<Integer> fireCreeperSpawnRate = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.fireCreeperSpawnRate"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.fireCreeperSpawnRate.tooltip")))
                .binding(
                        25,
                        () -> config.fireCreeperSpawnRate,
                        newValue -> config.fireCreeperSpawnRate = newValue
                )
                .available(config.fireCreeperEnabled)
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 100))
                .build();

        Option<Boolean> fireCreeperEnabled = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.fireCreeperEnabled"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.fireCreeperEnabled.tooltip")))
                .binding(
                        true,
                        () -> config.fireCreeperEnabled,
                        newValue -> {
                            config.fireCreeperEnabled = newValue;
                            fireCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Float> fireCreeperRadius = Option.<Float>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.fireCreeperRadius"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.fireCreeperRadius.tooltip")))
                .binding(
                        3F,
                        () -> config.fireCreeperRadius,
                        newValue -> config.fireCreeperRadius = newValue
                )
                .controller(option -> FloatFieldControllerBuilder.create(option).range(1F, 10F))
                .build();

        /*
         * Earth Creeper
         */
        Option<Integer> earthCreeperSpawnRate = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.earthCreeperSpawnRate"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.earthCreeperSpawnRate.tooltip")))
                .binding(
                        15,
                        () -> config.earthCreeperSpawnRate,
                        newValue -> config.earthCreeperSpawnRate = newValue
                )
                .available(config.earthCreeperEnabled)
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 100))
                .build();

        Option<Boolean> earthCreeperEnabled = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.earthCreeperEnabled"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.earthCreeperEnabled.tooltip")))
                .binding(
                        true,
                        () -> config.earthCreeperEnabled,
                        newValue -> {
                            config.earthCreeperEnabled = newValue;
                            earthCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Float> earthCreeperRadius = Option.<Float>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.earthCreeperRadius"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.earthCreeperRadius.tooltip")))
                .binding(
                        5F,
                        () -> config.earthCreeperRadius,
                        newValue -> config.earthCreeperRadius = newValue
                )
                .controller(option -> FloatFieldControllerBuilder.create(option).range(1F, 10F))
                .build();

        /*
         * Air Creeper
         */
        Option<Integer> airCreeperSpawnRate = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.airCreeperSpawnRate"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.airCreeperSpawnRate.tooltip")))
                .binding(
                        20,
                        () -> config.airCreeperSpawnRate,
                        newValue -> config.airCreeperSpawnRate = newValue
                )
                .available(config.airCreeperEnabled)
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 100))
                .build();

        Option<Boolean> airCreeperEnabled = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.airCreeperEnabled"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.airCreeperEnabled.tooltip")))
                .binding(
                        true,
                        () -> config.airCreeperEnabled,
                        newValue -> {
                            config.airCreeperEnabled = newValue;
                            airCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Float> airCreeperRadius = Option.<Float>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.airCreeperRadius"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.airCreeperRadius.tooltip")))
                .binding(
                        1.75F,
                        () -> config.airCreeperRadius,
                        newValue -> config.airCreeperRadius = newValue
                ) // option -> FloatFieldControllerBuilder.create(option).range(1F, 10F)
                .controller(option -> FloatFieldControllerBuilder.create(option).range(1F, 10F))
                .build();

        /*
         * Electric Creeper
         */
        Option<Integer> electricCreeperSpawnRate = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.electricCreeperSpawnRate"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.electricCreeperSpawnRate.tooltip")))
                .binding(
                        7,
                        () -> config.electricCreeperSpawnRate,
                        newValue -> config.electricCreeperSpawnRate = newValue
                )
                .available(config.electricCreeperEnabled)
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 100))
                .build();

        Option<Boolean> electricCreeperEnabled = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.electricCreeperEnabled"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.electricCreeperEnabled.tooltip")))
                .binding(
                        true,
                        () -> config.electricCreeperEnabled,
                        newValue -> {
                            config.electricCreeperEnabled = newValue;
                            electricCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        /*
         * Light Creeper
         */
        Option<Integer> lightCreeperSpawnRate = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.lightCreeperSpawnRate"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.lightCreeperSpawnRate.tooltip")))
                .binding(
                        20,
                        () -> config.lightCreeperSpawnRate,
                        newValue -> config.lightCreeperSpawnRate = newValue
                )
                .available(config.lightCreeperEnabled)
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 100))
                .build();

        Option<Boolean> lightCreeperEnabled = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.lightCreeperEnabled"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.lightCreeperEnabled.tooltip")))
                .binding(
                        true,
                        () -> config.lightCreeperEnabled,
                        newValue -> {
                            config.lightCreeperEnabled = newValue;
                            lightCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Float> lightCreeperRadius = Option.<Float>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.lightCreeperRadius"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.lightCreeperRadius.tooltip")))
                .binding(
                        4F,
                        () -> config.lightCreeperRadius,
                        newValue -> config.lightCreeperRadius = newValue
                )
                .controller(option -> FloatFieldControllerBuilder.create(option).range(1F, 10F))
                .build();

        /*
         * Dark Creeper
         */
        Option<Integer> darkCreeperSpawnRate = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.darkCreeperSpawnRate"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.darkCreeperSpawnRate.tooltip")))
                .binding(
                        12,
                        () -> config.darkCreeperSpawnRate,
                        newValue -> config.darkCreeperSpawnRate = newValue
                )
                .available(config.darkCreeperEnabled)
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 100))
                .build();

        Option<Boolean> darkCreeperEnabled = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.darkCreeperEnabled"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.darkCreeperEnabled.tooltip")))
                .binding(
                        true,
                        () -> config.darkCreeperEnabled,
                        newValue -> {
                            config.darkCreeperEnabled = newValue;
                            darkCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Float> darkCreeperRadius = Option.<Float>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.darkCreeperRadius"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.darkCreeperRadius.tooltip")))
                .binding(
                        4F,
                        () -> config.darkCreeperRadius,
                        newValue -> config.darkCreeperRadius = newValue
                )
                .controller(option -> FloatFieldControllerBuilder.create(option).range(1F, 10F))
                .build();

        /*
         * Ice Creeper
         */
        Option<Integer> iceCreeperSpawnRate = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.iceCreeperSpawnRate"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.iceCreeperSpawnRate.tooltip")))
                .binding(
                        20,
                        () -> config.iceCreeperSpawnRate,
                        newValue -> config.iceCreeperSpawnRate = newValue
                )
                .available(config.iceCreeperEnabled)
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 100))
                .build();

        Option<Boolean> iceCreeperEnabled = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.iceCreeperEnabled"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.iceCreeperEnabled.tooltip")))
                .binding(
                        true,
                        () -> config.iceCreeperEnabled,
                        newValue -> {
                            config.iceCreeperEnabled = newValue;
                            iceCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Float> iceCreeperRadius = Option.<Float>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.iceCreeperRadius"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.iceCreeperRadius.tooltip")))
                .binding(
                        4F,
                        () -> config.iceCreeperRadius,
                        newValue -> config.iceCreeperRadius = newValue
                )
                .controller(option -> FloatFieldControllerBuilder.create(option).range(1F, 10F))
                .build();

        /*
         * Magma Creeper
         */
        Option<Integer> magmaCreeperSpawnRate = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.magmaCreeperSpawnRate"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.magmaCreeperSpawnRate.tooltip")))
                .binding(
                        25,
                        () -> config.magmaCreeperSpawnRate,
                        newValue -> config.magmaCreeperSpawnRate = newValue
                )
                .available(config.magmaCreeperEnabled)
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 100))
                .build();

        Option<Boolean> magmaCreeperEnabled = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.magmaCreeperEnabled"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.magmaCreeperEnabled.tooltip")))
                .binding(
                        true,
                        () -> config.magmaCreeperEnabled,
                        newValue -> {
                            config.magmaCreeperEnabled = newValue;
                            magmaCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Float> magmaCreeperRadius = Option.<Float>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.magmaCreeperRadius"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.magmaCreeperRadius.tooltip")))
                .binding(
                        4F,
                        () -> config.magmaCreeperRadius,
                        newValue -> config.magmaCreeperRadius = newValue
                )
                .controller(option -> FloatFieldControllerBuilder.create(option).range(1F, 10F))
                .build();

        /*
         * Hydrogen Creeper
         */
        Option<Integer> hydrogenCreeperSpawnRate = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.hydrogenCreeperSpawnRate"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.hydrogenCreeperSpawnRate.tooltip")))
                .binding(
                        3,
                        () -> config.hydrogenCreeperSpawnRate,
                        newValue -> config.hydrogenCreeperSpawnRate = newValue
                )
                .available(config.hydrogenCreeperEnabled)
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 100))
                .build();

        Option<Boolean> hydrogenCreeperEnabled = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.hydrogenCreeperEnabled"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.hydrogenCreeperEnabled.tooltip")))
                .binding(
                        true,
                        () -> config.hydrogenCreeperEnabled,
                        newValue -> {
                            config.hydrogenCreeperEnabled = newValue;
                            hydrogenCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Float> hydrogenCreeperRadius = Option.<Float>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.hydrogenCreeperRadius"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.hydrogenCreeperRadius.tooltip")))
                .binding(
                        7F,
                        () -> config.hydrogenCreeperRadius,
                        newValue -> config.hydrogenCreeperRadius = newValue
                )
                .controller(option -> FloatFieldControllerBuilder.create(option).range(1F, 10F))
                .build();

        /*
         * Reverse Creeper
         */
        Option<Integer> reverseCreeperSpawnRate = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.reverseCreeperSpawnRate"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.reverseCreeperSpawnRate.tooltip")))
                .binding(
                        10,
                        () -> config.reverseCreeperSpawnRate,
                        newValue -> config.reverseCreeperSpawnRate = newValue
                )
                .available(config.reverseCreeperEnabled)
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 100))
                .build();

        Option<Boolean> reverseCreeperEnabled = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.reverseCreeperEnabled"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.reverseCreeperEnabled.tooltip")))
                .binding(
                        true,
                        () -> config.reverseCreeperEnabled,
                        newValue -> {
                            config.reverseCreeperEnabled = newValue;
                            reverseCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Float> reverseCreeperRadius = Option.<Float>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.reverseCreeperRadius"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.reverseCreeperRadius.tooltip")))
                .binding(
                        3.75F,
                        () -> config.reverseCreeperRadius,
                        newValue -> config.reverseCreeperRadius = newValue
                )
                .controller(option -> FloatFieldControllerBuilder.create(option).range(1F, 10F))
                .build();

        /*
         * Miner Creeper
         */
        Option<Integer> minerCreeperSpawnRate = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.minerCreeperSpawnRate"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.minerCreeperSpawnRate.tooltip")))
                .binding(
                        15,
                        () -> config.minerCreeperSpawnRate,
                        newValue -> config.minerCreeperSpawnRate = newValue
                )
                .available(config.minerCreeperEnabled)
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 100))
                .build();

        Option<Boolean> minerCreeperEnabled = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.minerCreeperEnabled"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.minerCreeperEnabled.tooltip")))
                .binding(
                        true,
                        () -> config.minerCreeperEnabled,
                        newValue -> {
                            config.minerCreeperEnabled = newValue;
                            minerCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Float> minerCreeperRadius = Option.<Float>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.minerCreeperRadius"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.minerCreeperRadius.tooltip")))
                .binding(
                        3.75F,
                        () -> config.minerCreeperRadius,
                        newValue -> config.minerCreeperRadius = newValue
                )
                .controller(option -> FloatFieldControllerBuilder.create(option).range(1F, 10F))
                .build();

        /*
         * Illusion Creeper
         */
        Option<Integer> illusionCreeperSpawnRate = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.illusionCreeperSpawnRate"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.illusionCreeperSpawnRate.tooltip")))
                .binding(
                        10,
                        () -> config.illusionCreeperSpawnRate,
                        newValue -> config.illusionCreeperSpawnRate = newValue
                )
                .available(config.illusionCreeperEnabled)
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 100))
                .build();

        Option<Boolean> illusionCreeperEnabled = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.illusionCreeperEnabled"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.illusionCreeperEnabled.tooltip")))
                .binding(
                        true,
                        () -> config.illusionCreeperEnabled,
                        newValue -> {
                            config.illusionCreeperEnabled = newValue;
                            illusionCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        /*
         * Firework Creeper
         */
        Option<Integer> fireworkCreeperSpawnRate = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.fireworkCreeperSpawnRate"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.fireworkCreeperSpawnRate.tooltip")))
                .binding(
                        10,
                        () -> config.fireworkCreeperSpawnRate,
                        newValue -> config.fireworkCreeperSpawnRate = newValue
                )
                .available(config.fireworkCreeperEnabled)
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 100))
                .build();

        Option<Boolean> fireworkCreeperEnabled = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.fireworkCreeperEnabled"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.fireworkCreeperEnabled.tooltip")))
                .binding(
                        true,
                        () -> config.fireworkCreeperEnabled,
                        newValue -> {
                            config.fireworkCreeperEnabled = newValue;
                            fireworkCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        /*
         * Cookie Creeper
         */
        Option<Integer> cookieCreeperSpawnRate = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.cookieCreeperSpawnRate"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.cookieCreeperSpawnRate.tooltip")))
                .binding(
                        2,
                        () -> config.cookieCreeperSpawnRate,
                        newValue -> config.cookieCreeperSpawnRate = newValue
                )
                .available(config.cookieCreeperEnabled)
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 100))
                .build();

        Option<Boolean> cookieCreeperEnabled = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.cookieCreeperEnabled"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.cookieCreeperEnabled.tooltip")))
                .binding(
                        true,
                        () -> config.cookieCreeperEnabled,
                        newValue -> {
                            config.cookieCreeperEnabled = newValue;
                            cookieCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        /*
         * Rainbow Creeper
         */
        Option<Integer> rainbowCreeperSpawnRate = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.rainbowCreeperSpawnRate"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.rainbowCreeperSpawnRate.tooltip")))
                .binding(
                        1,
                        () -> config.rainbowCreeperSpawnRate,
                        newValue -> config.rainbowCreeperSpawnRate = newValue
                )
                .available(config.rainbowCreeperEnabled)
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 100))
                .build();

        Option<Boolean> rainbowCreeperEnabled = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.elementalcreepers.rainbowCreeperEnabled"))
                .description(OptionDescription.of(Text.translatable("configOption.elementalcreepers.rainbowCreeperEnabled.tooltip")))
                .binding(
                        true,
                        () -> config.rainbowCreeperEnabled,
                        newValue -> {
                            config.rainbowCreeperEnabled = newValue;
                            rainbowCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        return YetAnotherConfigLib.createBuilder()
                .title(Text.translatable("itemGroup.elementalcreepers.category"))
                .category(
                        createCategory("water_creeper",
                                waterCreeperEnabled, waterCreeperSpawnRate, waterCreeperRadius
                        )
                )
                .category(
                        createCategory("fire_creeper",
                                fireCreeperEnabled, fireCreeperSpawnRate, fireCreeperRadius
                        )
                )
                .category(
                        createCategory("earth_creeper",
                                earthCreeperEnabled, earthCreeperSpawnRate, earthCreeperRadius
                        )
                )
                .category(
                        createCategory("air_creeper",
                                airCreeperEnabled, airCreeperSpawnRate, airCreeperRadius
                        )
                )
                .category(
                        createCategory("electric_creeper",
                                electricCreeperEnabled, electricCreeperSpawnRate
                        )
                )
                .category(
                        createCategory("light_creeper",
                                lightCreeperEnabled, lightCreeperSpawnRate, lightCreeperRadius
                        )
                )
                .category(
                        createCategory("dark_creeper",
                                darkCreeperEnabled, darkCreeperSpawnRate, darkCreeperRadius
                        )
                )
                .category(
                        createCategory("ice_creeper",
                                iceCreeperEnabled, iceCreeperSpawnRate, iceCreeperRadius
                        )
                )
                .category(
                        createCategory("magma_creeper",
                                magmaCreeperEnabled, magmaCreeperSpawnRate, magmaCreeperRadius
                        )
                )
                .category(
                        createCategory("hydrogen_creeper",
                                hydrogenCreeperEnabled, hydrogenCreeperSpawnRate, hydrogenCreeperRadius
                        )
                )
                .category(
                        createCategory("reverse_creeper",
                                reverseCreeperEnabled, reverseCreeperSpawnRate, reverseCreeperRadius
                        )
                )
                .category(
                        createCategory("miner_creeper",
                                minerCreeperEnabled, minerCreeperSpawnRate, minerCreeperRadius
                        )
                )
                .category(
                        createCategory("illusion_creeper",
                                illusionCreeperEnabled, illusionCreeperSpawnRate
                        )
                )
                .category(
                        createCategory("firework_creeper",
                                fireworkCreeperEnabled, fireworkCreeperSpawnRate
                        )
                )
                .category(
                        createCategory("cookie_creeper",
                                cookieCreeperEnabled, cookieCreeperSpawnRate
                        )
                )
                .category(
                        createCategory("rainbow_creeper",
                                rainbowCreeperEnabled, rainbowCreeperSpawnRate
                        )
                )
                .save(() -> ElementalCreepers.saveConfig(config))
                .build()
                .generateScreen(parent);
    }


    private ConfigCategory createCategory(String creeperName, Option<?> option1, Option<?> option2) {
        return ConfigCategory.createBuilder()
                .name(Text.translatable("entity.elementalcreepers." + creeperName))
                .group(OptionGroup.createBuilder()
                        .name(Text.translatable("entity.elementalcreepers." + creeperName))

                        .option(option1)
                        .option(option2)
                        .build())
                .build();
    }

    private ConfigCategory createCategory(String creeperName, Option<?> option1, Option<?> option2, Option<?> option3) {
        return ConfigCategory.createBuilder()
                .name(Text.translatable("entity.elementalcreepers." + creeperName))
                .group(OptionGroup.createBuilder()
                        .name(Text.translatable("entity.elementalcreepers." + creeperName))

                        .option(option1)
                        .option(option2)
                        .option(option3)
                        .build())
                .build();
    }

}