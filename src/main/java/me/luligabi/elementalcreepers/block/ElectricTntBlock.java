package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.entity.tnt.ElectricTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;

public class ElectricTntBlock extends ElementalTntBlock {

    public ElectricTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            ElectricTntEntity tntEntity;
            tntEntity = new ElectricTntEntity(ElementalCreepers.ELECTRIC_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z, livingEntity);
            return tntEntity;
        });
    }
}
