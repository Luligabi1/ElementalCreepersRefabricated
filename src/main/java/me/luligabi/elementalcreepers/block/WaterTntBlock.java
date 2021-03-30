package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.WaterTntEntity;

public class WaterTntBlock extends ElementalTntBlock {

    public WaterTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            WaterTntEntity tntEntity;
            tntEntity = new WaterTntEntity(ElementalCreepers.WATER_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z, livingEntity);
            return tntEntity;
        });
    }
}
