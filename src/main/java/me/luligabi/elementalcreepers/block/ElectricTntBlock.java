package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.entity.tnt.ElectricTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.registry.TntRegistry;

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
