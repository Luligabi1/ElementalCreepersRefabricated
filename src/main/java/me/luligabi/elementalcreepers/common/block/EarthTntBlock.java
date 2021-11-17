package me.luligabi.elementalcreepers.common.block;

import me.luligabi.elementalcreepers.common.entity.tnt.EarthTntEntity;
import me.luligabi.elementalcreepers.common.entity.tnt.ElementalTntEntity;

public class EarthTntBlock extends ElementalTntBlock {

    public EarthTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            EarthTntEntity tntEntity;
            tntEntity = new EarthTntEntity(TntRegistry.EARTH_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
