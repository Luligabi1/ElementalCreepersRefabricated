package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.entity.tnt.EarthTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.registry.TntRegistry;

public class EarthTntBlock extends ElementalTntBlock {

    public EarthTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            EarthTntEntity tntEntity;
            tntEntity = new EarthTntEntity(TntRegistry.EARTH_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z, livingEntity);
            return tntEntity;
        });
    }
}
