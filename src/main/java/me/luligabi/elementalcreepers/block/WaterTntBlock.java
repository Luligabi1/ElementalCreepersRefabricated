package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.WaterTntEntity;
import me.luligabi.elementalcreepers.registry.TntRegistry;

public class WaterTntBlock extends ElementalTntBlock {

    public WaterTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            WaterTntEntity tntEntity;
            tntEntity = new WaterTntEntity(TntRegistry.WATER_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
