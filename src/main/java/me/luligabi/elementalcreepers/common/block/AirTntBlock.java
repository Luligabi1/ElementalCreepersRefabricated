package me.luligabi.elementalcreepers.common.block;

import me.luligabi.elementalcreepers.common.entity.tnt.AirTntEntity;
import me.luligabi.elementalcreepers.common.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.common.registry.TntRegistry;

public class AirTntBlock extends ElementalTntBlock {

    public AirTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            AirTntEntity tntEntity;
            tntEntity = new AirTntEntity(TntRegistry.AIR_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
