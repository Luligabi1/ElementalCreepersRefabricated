package me.luligabi.elementalcreepers.common.block;

import me.luligabi.elementalcreepers.common.entity.tnt.ElectricTntEntity;
import me.luligabi.elementalcreepers.common.entity.tnt.ElementalTntEntity;

public class ElectricTntBlock extends ElementalTntBlock {

    public ElectricTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            ElectricTntEntity tntEntity;
            tntEntity = new ElectricTntEntity(TntRegistry.ELECTRIC_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
