package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.MagmaTntEntity;

public class MagmaTntBlock extends ElementalTntBlock {

    public MagmaTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            MagmaTntEntity tntEntity;
            tntEntity = new MagmaTntEntity(ElementalCreepers.MAGMA_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z, livingEntity);
            return tntEntity;
        });
    }
}
