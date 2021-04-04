package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.entity.tnt.AirTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;

public class AirTntBlock extends ElementalTntBlock {

    public AirTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            AirTntEntity tntEntity;
            tntEntity = new AirTntEntity(ElementalCreepers.AIR_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z, livingEntity);
            return tntEntity;
        });
    }
}
