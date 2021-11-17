package me.luligabi.elementalcreepers.common.block;

import me.luligabi.elementalcreepers.common.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.common.entity.tnt.MagmaTntEntity;

public class MagmaTntBlock extends ElementalTntBlock {

    public MagmaTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            MagmaTntEntity tntEntity;
            tntEntity = new MagmaTntEntity(TntRegistry.MAGMA_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
