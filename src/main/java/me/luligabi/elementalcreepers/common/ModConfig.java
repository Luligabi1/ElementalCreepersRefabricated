package me.luligabi.elementalcreepers.common;

import dev.isxander.yacl.api.ConfigCategory;
import dev.isxander.yacl.api.Option;
import dev.isxander.yacl.api.OptionGroup;
import dev.isxander.yacl.api.YetAnotherConfigLib;
import dev.isxander.yacl.gui.controllers.BooleanController;
import dev.isxander.yacl.gui.controllers.slider.FloatSliderController;
import dev.isxander.yacl.gui.controllers.slider.IntegerSliderController;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ModConfig {


    public boolean waterCreeperEnabled = true;
    public int waterCreeperSpawnRate = 20;
    public float waterCreeperRadius = 3;

    public boolean fireCreeperEnabled = true;
    public int fireCreeperSpawnRate = 25;
    public float fireCreeperRadius = 3;

    public boolean earthCreeperEnabled = true;
    public int earthCreeperSpawnRate = 15;
    public float earthCreeperRadius = 5;

    public boolean airCreeperEnabled = true;
    public int airCreeperSpawnRate = 20;
    public float airCreeperRadius = 1.75F;

    public boolean electricCreeperEnabled = true;
    public int electricCreeperSpawnRate = 7;

    public boolean lightCreeperEnabled = true;
    public int lightCreeperSpawnRate = 20;
    public float lightCreeperRadius = 4;

    public boolean darkCreeperEnabled = true;
    public int darkCreeperSpawnRate = 12;
    public float darkCreeperRadius = 4;

    public boolean iceCreeperEnabled = true;
    public int iceCreeperSpawnRate = 20;
    public float iceCreeperRadius = 4;

    public boolean magmaCreeperEnabled = true;
    public int magmaCreeperSpawnRate = 25;
    public float magmaCreeperRadius = 4;

    public boolean hydrogenCreeperEnabled = true;
    public int hydrogenCreeperSpawnRate = 3;
    public float hydrogenCreeperRadius = 7;

    public boolean reverseCreeperEnabled = true;
    public int reverseCreeperSpawnRate = 10;
    public float reverseCreeperRadius = 3.75F;

    public boolean minerCreeperEnabled = true;
    public int minerCreeperSpawnRate = 15;
    public float minerCreeperRadius = 3.75F;

    public boolean illusionCreeperEnabled = true;
    public int illusionCreeperSpawnRate = 10;

    public boolean fireworkCreeperEnabled = true;
    public int fireworkCreeperSpawnRate = 4;

    public boolean cookieCreeperEnabled = true;
    public int cookieCreeperSpawnRate = 2;

    public boolean rainbowCreeperEnabled = true;
    public int rainbowCreeperSpawnRate = 1;

    public Screen createGui(Screen parent) {

        /*
         * Water Creeper
         */
        Option<Integer> waterCreeperSpawnRate = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.elementalcreepers.waterCreeperSpawnRate"))
                .tooltip(Text.translatable("configOption.elementalcreepers.waterCreeperSpawnRate.tooltip"))
                .binding(
                        20,
                        () -> this.waterCreeperSpawnRate,
                        newValue -> this.waterCreeperSpawnRate = newValue
                )
                .available(this.waterCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> waterCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.waterCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.waterCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> this.waterCreeperEnabled,
                        newValue -> {
                            this.waterCreeperEnabled = newValue;
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
                        () -> this.waterCreeperRadius,
                        newValue -> this.waterCreeperRadius = newValue
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
                        () -> this.fireCreeperSpawnRate,
                        newValue -> this.fireCreeperSpawnRate = newValue
                )
                .available(this.fireCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> fireCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.fireCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.fireCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> this.fireCreeperEnabled,
                        newValue -> {
                            this.fireCreeperEnabled = newValue;
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
                        () -> this.fireCreeperRadius,
                        newValue -> this.fireCreeperRadius = newValue
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
                        () -> this.earthCreeperSpawnRate,
                        newValue -> this.earthCreeperSpawnRate = newValue
                )
                .available(this.earthCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> earthCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.earthCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.earthCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> this.earthCreeperEnabled,
                        newValue -> {
                            this.earthCreeperEnabled = newValue;
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
                        () -> this.earthCreeperRadius,
                        newValue -> this.earthCreeperRadius = newValue
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
                        () -> this.airCreeperSpawnRate,
                        newValue -> this.airCreeperSpawnRate = newValue
                )
                .available(this.airCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> airCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.airCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.airCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> this.airCreeperEnabled,
                        newValue -> {
                            this.airCreeperEnabled = newValue;
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
                        () -> this.airCreeperRadius,
                        newValue -> this.airCreeperRadius = newValue
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
                        () -> this.electricCreeperSpawnRate,
                        newValue -> this.electricCreeperSpawnRate = newValue
                )
                .available(this.electricCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> electricCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.electricCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.electricCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> this.electricCreeperEnabled,
                        newValue -> {
                            this.electricCreeperEnabled = newValue;
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
                        () -> this.lightCreeperSpawnRate,
                        newValue -> this.lightCreeperSpawnRate = newValue
                )
                .available(this.lightCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> lightCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.lightCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.lightCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> this.lightCreeperEnabled,
                        newValue -> {
                            this.lightCreeperEnabled = newValue;
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
                        () -> this.lightCreeperRadius,
                        newValue -> this.lightCreeperRadius = newValue
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
                        () -> this.darkCreeperSpawnRate,
                        newValue -> this.darkCreeperSpawnRate = newValue
                )
                .available(this.darkCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> darkCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.darkCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.darkCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> this.darkCreeperEnabled,
                        newValue -> {
                            this.darkCreeperEnabled = newValue;
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
                        () -> this.darkCreeperRadius,
                        newValue -> this.darkCreeperRadius = newValue
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
                        () -> this.iceCreeperSpawnRate,
                        newValue -> this.iceCreeperSpawnRate = newValue
                )
                .available(this.iceCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> iceCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.iceCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.iceCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> this.iceCreeperEnabled,
                        newValue -> {
                            this.iceCreeperEnabled = newValue;
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
                        () -> this.iceCreeperRadius,
                        newValue -> this.iceCreeperRadius = newValue
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
                        () -> this.magmaCreeperSpawnRate,
                        newValue -> this.magmaCreeperSpawnRate = newValue
                )
                .available(this.magmaCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> magmaCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.magmaCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.magmaCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> this.magmaCreeperEnabled,
                        newValue -> {
                            this.magmaCreeperEnabled = newValue;
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
                        () -> this.magmaCreeperRadius,
                        newValue -> this.magmaCreeperRadius = newValue
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
                        () -> this.hydrogenCreeperSpawnRate,
                        newValue -> this.hydrogenCreeperSpawnRate = newValue
                )
                .available(this.hydrogenCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> hydrogenCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.hydrogenCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.hydrogenCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> this.hydrogenCreeperEnabled,
                        newValue -> {
                            this.hydrogenCreeperEnabled = newValue;
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
                        () -> this.hydrogenCreeperRadius,
                        newValue -> this.hydrogenCreeperRadius = newValue
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
                        () -> this.reverseCreeperSpawnRate,
                        newValue -> this.reverseCreeperSpawnRate = newValue
                )
                .available(this.reverseCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> reverseCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.reverseCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.reverseCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> this.reverseCreeperEnabled,
                        newValue -> {
                            this.reverseCreeperEnabled = newValue;
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
                        () -> this.reverseCreeperRadius,
                        newValue -> this.reverseCreeperRadius = newValue
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
                        () -> this.minerCreeperSpawnRate,
                        newValue -> this.minerCreeperSpawnRate = newValue
                )
                .available(this.minerCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> minerCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.minerCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.minerCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> this.minerCreeperEnabled,
                        newValue -> {
                            this.minerCreeperEnabled = newValue;
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
                        () -> this.minerCreeperRadius,
                        newValue -> this.minerCreeperRadius = newValue
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
                        () -> this.illusionCreeperSpawnRate,
                        newValue -> this.illusionCreeperSpawnRate = newValue
                )
                .available(this.illusionCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> illusionCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.illusionCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.illusionCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> this.illusionCreeperEnabled,
                        newValue -> {
                            this.illusionCreeperEnabled = newValue;
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
                        () -> this.fireworkCreeperSpawnRate,
                        newValue -> this.fireworkCreeperSpawnRate = newValue
                )
                .available(this.fireworkCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> fireworkCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.fireworkCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.fireworkCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> this.fireworkCreeperEnabled,
                        newValue -> {
                            this.fireworkCreeperEnabled = newValue;
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
                        () -> this.cookieCreeperSpawnRate,
                        newValue -> this.cookieCreeperSpawnRate = newValue
                )
                .available(this.cookieCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> cookieCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.cookieCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.cookieCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> this.cookieCreeperEnabled,
                        newValue -> {
                            this.cookieCreeperEnabled = newValue;
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
                        () -> this.rainbowCreeperSpawnRate,
                        newValue -> this.rainbowCreeperSpawnRate = newValue
                )
                .available(this.rainbowCreeperEnabled)
                .controller((intOption) -> new IntegerSliderController(intOption, 1, 100, 5))
                .build();

        Option<Boolean> rainbowCreeperEnabled = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.elementalcreepers.rainbowCreeperEnabled"))
                .tooltip(Text.translatable("configOption.elementalcreepers.rainbowCreeperEnabled.tooltip"))
                .binding(
                        true,
                        () -> this.rainbowCreeperEnabled,
                        newValue -> {
                            this.rainbowCreeperEnabled = newValue;
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
                .save(() -> ElementalCreepers.saveConfig(this))
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