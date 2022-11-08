package me.luligabi.elementalcreepers.client.compat.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl.api.ConfigCategory;
import dev.isxander.yacl.api.Option;
import dev.isxander.yacl.api.OptionGroup;
import dev.isxander.yacl.api.YetAnotherConfigLib;
import dev.isxander.yacl.gui.controllers.BooleanController;
import dev.isxander.yacl.gui.controllers.slider.FloatSliderController;
import dev.isxander.yacl.gui.controllers.slider.IntegerSliderController;
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
        Option<Integer> waterCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.waterCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.waterCreeperSpawnRate.tooltip"))
                .binding(
                        20,
                        () -> config.waterCreeperSpawnRate,
                        newValue -> config.waterCreeperSpawnRate = newValue
                )
                .available(config.waterCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> waterCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.waterCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.waterCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> config.waterCreeperEnabled,
                        newValue -> {
                            config.waterCreeperEnabled = newValue;
                            waterCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        Option<Float> waterCreeperRadius = Option.createBuilder(Float.class)
                .name(Text.translatable("configOption.elementalcreepers.waterCreeperRadius"))
                .tooltip(Text.translatable("configOption.elementalcreepers.waterCreeperRadius.tooltip"))
                .binding(
                        3F,
                        () -> config.waterCreeperRadius,
                        newValue -> config.waterCreeperRadius = newValue
                )
                .controller((intOption) -> new FloatSliderController(intOption, 1, 10, 0.25F))
                .build();

        /*
         * Fire Creeper
         */
        Option<Integer> fireCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.fireCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.fireCreeperSpawnRate.tooltip"))
                .binding(
                        25,
                        () -> config.fireCreeperSpawnRate,
                        newValue -> config.fireCreeperSpawnRate = newValue
                )
                .available(config.fireCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> fireCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.fireCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.fireCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> config.fireCreeperEnabled,
                        newValue -> {
                            config.fireCreeperEnabled = newValue;
                            fireCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        Option<Float> fireCreeperRadius = Option.createBuilder(Float.class)
                .name(Text.translatable("configOption.elementalcreepers.fireCreeperRadius"))
                .tooltip(Text.translatable("configOption.elementalcreepers.fireCreeperRadius.tooltip"))
                .binding(
                        3F,
                        () -> config.fireCreeperRadius,
                        newValue -> config.fireCreeperRadius = newValue
                )
                .controller((intOption) -> new FloatSliderController(intOption, 1, 10, 0.25F))
                .build();

        /*
         * Earth Creeper
         */
        Option<Integer> earthCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.earthCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.earthCreeperSpawnRate.tooltip"))
                .binding(
                        15,
                        () -> config.earthCreeperSpawnRate,
                        newValue -> config.earthCreeperSpawnRate = newValue
                )
                .available(config.earthCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> earthCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.earthCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.earthCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> config.earthCreeperEnabled,
                        newValue -> {
                            config.earthCreeperEnabled = newValue;
                            earthCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        Option<Float> earthCreeperRadius = Option.createBuilder(Float.class)
                .name(Text.translatable("configOption.elementalcreepers.earthCreeperRadius"))
                .tooltip(Text.translatable("configOption.elementalcreepers.earthCreeperRadius.tooltip"))
                .binding(
                        5F,
                        () -> config.earthCreeperRadius,
                        newValue -> config.earthCreeperRadius = newValue
                )
                .controller((intOption) -> new FloatSliderController(intOption, 1, 10, 0.25F))
                .build();

        /*
         * Air Creeper
         */
        Option<Integer> airCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.airCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.airCreeperSpawnRate.tooltip"))
                .binding(
                        20,
                        () -> config.airCreeperSpawnRate,
                        newValue -> config.airCreeperSpawnRate = newValue
                )
                .available(config.airCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> airCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.airCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.airCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> config.airCreeperEnabled,
                        newValue -> {
                            config.airCreeperEnabled = newValue;
                            airCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        Option<Float> airCreeperRadius = Option.createBuilder(Float.class)
                .name(Text.translatable("configOption.elementalcreepers.airCreeperRadius"))
                .tooltip(Text.translatable("configOption.elementalcreepers.airCreeperRadius.tooltip"))
                .binding(
                        1.75F,
                        () -> config.airCreeperRadius,
                        newValue -> config.airCreeperRadius = newValue
                )
                .controller((intOption) -> new FloatSliderController(intOption, 1, 10, 0.25F))
                .build();

        /*
         * Electric Creeper
         */
        Option<Integer> electricCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.electricCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.electricCreeperSpawnRate.tooltip"))
                .binding(
                        7,
                        () -> config.electricCreeperSpawnRate,
                        newValue -> config.electricCreeperSpawnRate = newValue
                )
                .available(config.electricCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> electricCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.electricCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.electricCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> config.electricCreeperEnabled,
                        newValue -> {
                            config.electricCreeperEnabled = newValue;
                            electricCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        /*
         * Light Creeper
         */
        Option<Integer> lightCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.lightCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.lightCreeperSpawnRate.tooltip"))
                .binding(
                        20,
                        () -> config.lightCreeperSpawnRate,
                        newValue -> config.lightCreeperSpawnRate = newValue
                )
                .available(config.lightCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> lightCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.lightCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.lightCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> config.lightCreeperEnabled,
                        newValue -> {
                            config.lightCreeperEnabled = newValue;
                            lightCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        Option<Float> lightCreeperRadius = Option.createBuilder(Float.class)
                .name(Text.translatable("configOption.elementalcreepers.lightCreeperRadius"))
                .tooltip(Text.translatable("configOption.elementalcreepers.lightCreeperRadius.tooltip"))
                .binding(
                        4F,
                        () -> config.lightCreeperRadius,
                        newValue -> config.lightCreeperRadius = newValue
                )
                .controller((intOption) -> new FloatSliderController(intOption, 1, 10, 0.25F))
                .build();

        /*
         * Dark Creeper
         */
        Option<Integer> darkCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.darkCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.darkCreeperSpawnRate.tooltip"))
                .binding(
                        12,
                        () -> config.darkCreeperSpawnRate,
                        newValue -> config.darkCreeperSpawnRate = newValue
                )
                .available(config.darkCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> darkCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.darkCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.darkCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> config.darkCreeperEnabled,
                        newValue -> {
                            config.darkCreeperEnabled = newValue;
                            darkCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        Option<Float> darkCreeperRadius = Option.createBuilder(Float.class)
                .name(Text.translatable("configOption.elementalcreepers.darkCreeperRadius"))
                .tooltip(Text.translatable("configOption.elementalcreepers.darkCreeperRadius.tooltip"))
                .binding(
                        4F,
                        () -> config.darkCreeperRadius,
                        newValue -> config.darkCreeperRadius = newValue
                )
                .controller((intOption) -> new FloatSliderController(intOption, 1, 10, 0.25F))
                .build();

        /*
         * Ice Creeper
         */
        Option<Integer> iceCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.iceCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.iceCreeperSpawnRate.tooltip"))
                .binding(
                        20,
                        () -> config.iceCreeperSpawnRate,
                        newValue -> config.iceCreeperSpawnRate = newValue
                )
                .available(config.iceCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> iceCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.iceCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.iceCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> config.iceCreeperEnabled,
                        newValue -> {
                            config.iceCreeperEnabled = newValue;
                            iceCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        Option<Float> iceCreeperRadius = Option.createBuilder(Float.class)
                .name(Text.translatable("configOption.elementalcreepers.iceCreeperRadius"))
                .tooltip(Text.translatable("configOption.elementalcreepers.iceCreeperRadius.tooltip"))
                .binding(
                        4F,
                        () -> config.iceCreeperRadius,
                        newValue -> config.iceCreeperRadius = newValue
                )
                .controller((intOption) -> new FloatSliderController(intOption, 1, 10, 0.25F))
                .build();

        /*
         * Magma Creeper
         */
        Option<Integer> magmaCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.magmaCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.magmaCreeperSpawnRate.tooltip"))
                .binding(
                        25,
                        () -> config.magmaCreeperSpawnRate,
                        newValue -> config.magmaCreeperSpawnRate = newValue
                )
                .available(config.magmaCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> magmaCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.magmaCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.magmaCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> config.magmaCreeperEnabled,
                        newValue -> {
                            config.magmaCreeperEnabled = newValue;
                            magmaCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        Option<Float> magmaCreeperRadius = Option.createBuilder(Float.class)
                .name(Text.translatable("configOption.elementalcreepers.magmaCreeperRadius"))
                .tooltip(Text.translatable("configOption.elementalcreepers.magmaCreeperRadius.tooltip"))
                .binding(
                        4F,
                        () -> config.magmaCreeperRadius,
                        newValue -> config.magmaCreeperRadius = newValue
                )
                .controller((intOption) -> new FloatSliderController(intOption, 1, 10, 0.25F))
                .build();

        /*
         * Hydrogen Creeper
         */
        Option<Integer> hydrogenCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.hydrogenCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.hydrogenCreeperSpawnRate.tooltip"))
                .binding(
                        3,
                        () -> config.hydrogenCreeperSpawnRate,
                        newValue -> config.hydrogenCreeperSpawnRate = newValue
                )
                .available(config.hydrogenCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> hydrogenCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.hydrogenCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.hydrogenCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> config.hydrogenCreeperEnabled,
                        newValue -> {
                            config.hydrogenCreeperEnabled = newValue;
                            hydrogenCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        Option<Float> hydrogenCreeperRadius = Option.createBuilder(Float.class)
                .name(Text.translatable("configOption.elementalcreepers.hydrogenCreeperRadius"))
                .tooltip(Text.translatable("configOption.elementalcreepers.hydrogenCreeperRadius.tooltip"))
                .binding(
                        7F,
                        () -> config.hydrogenCreeperRadius,
                        newValue -> config.hydrogenCreeperRadius = newValue
                )
                .controller((intOption) -> new FloatSliderController(intOption, 1, 10, 0.25F))
                .build();

        /*
         * Reverse Creeper
         */
        Option<Integer> reverseCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.reverseCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.reverseCreeperSpawnRate.tooltip"))
                .binding(
                        10,
                        () -> config.reverseCreeperSpawnRate,
                        newValue -> config.reverseCreeperSpawnRate = newValue
                )
                .available(config.reverseCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> reverseCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.reverseCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.reverseCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> config.reverseCreeperEnabled,
                        newValue -> {
                            config.reverseCreeperEnabled = newValue;
                            reverseCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        Option<Float> reverseCreeperRadius = Option.createBuilder(Float.class)
                .name(Text.translatable("configOption.elementalcreepers.reverseCreeperRadius"))
                .tooltip(Text.translatable("configOption.elementalcreepers.reverseCreeperRadius.tooltip"))
                .binding(
                        3.75F,
                        () -> config.reverseCreeperRadius,
                        newValue -> config.reverseCreeperRadius = newValue
                )
                .controller((intOption) -> new FloatSliderController(intOption, 1, 10, 0.25F))
                .build();

        /*
         * Miner Creeper
         */
        Option<Integer> minerCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.minerCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.minerCreeperSpawnRate.tooltip"))
                .binding(
                        15,
                        () -> config.minerCreeperSpawnRate,
                        newValue -> config.minerCreeperSpawnRate = newValue
                )
                .available(config.minerCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> minerCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.minerCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.minerCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> config.minerCreeperEnabled,
                        newValue -> {
                            config.minerCreeperEnabled = newValue;
                            minerCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        Option<Float> minerCreeperRadius = Option.createBuilder(Float.class)
                .name(Text.translatable("configOption.elementalcreepers.minerCreeperRadius"))
                .tooltip(Text.translatable("configOption.elementalcreepers.minerCreeperRadius.tooltip"))
                .binding(
                        3.75F,
                        () -> config.minerCreeperRadius,
                        newValue -> config.minerCreeperRadius = newValue
                )
                .controller((intOption) -> new FloatSliderController(intOption, 1, 10, 0.25F))
                .build();

        /*
         * Illusion Creeper
         */
        Option<Integer> illusionCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.illusionCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.illusionCreeperSpawnRate.tooltip"))
                .binding(
                        10,
                        () -> config.illusionCreeperSpawnRate,
                        newValue -> config.illusionCreeperSpawnRate = newValue
                )
                .available(config.illusionCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> illusionCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.illusionCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.illusionCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> config.illusionCreeperEnabled,
                        newValue -> {
                            config.illusionCreeperEnabled = newValue;
                            illusionCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        /*
         * Firework Creeper
         */
        Option<Integer> fireworkCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.fireworkCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.fireworkCreeperSpawnRate.tooltip"))
                .binding(
                        10,
                        () -> config.fireworkCreeperSpawnRate,
                        newValue -> config.fireworkCreeperSpawnRate = newValue
                )
                .available(config.fireworkCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> fireworkCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.fireworkCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.fireworkCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> config.fireworkCreeperEnabled,
                        newValue -> {
                            config.fireworkCreeperEnabled = newValue;
                            fireworkCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        /*
         * Cookie Creeper
         */
        Option<Integer> cookieCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.cookieCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.cookieCreeperSpawnRate.tooltip"))
                .binding(
                        2,
                        () -> config.cookieCreeperSpawnRate,
                        newValue -> config.cookieCreeperSpawnRate = newValue
                )
                .available(config.cookieCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> cookieCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.cookieCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.cookieCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> config.cookieCreeperEnabled,
                        newValue -> {
                            config.cookieCreeperEnabled = newValue;
                            cookieCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        /*
         * Rainbow Creeper
         */
        Option<Integer> rainbowCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.rainbowCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.rainbowCreeperSpawnRate.tooltip"))
                .binding(
                        1,
                        () -> config.rainbowCreeperSpawnRate,
                        newValue -> config.rainbowCreeperSpawnRate = newValue
                )
                .available(config.rainbowCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> rainbowCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.rainbowCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.rainbowCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> config.rainbowCreeperEnabled,
                        newValue -> {
                            config.rainbowCreeperEnabled = newValue;
                            rainbowCreeperSpawnRate.setAvailable(newValue);
                        }
                )
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
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