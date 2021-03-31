package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.entity.tnt.EarthTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;

public class EarthTntBlock extends ElementalTntBlock {

    public EarthTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            EarthTntEntity tntEntity;
            tntEntity = new EarthTntEntity(ElementalCreepers.EARTH_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z, livingEntity);
            return tntEntity;
        });
    }
}
