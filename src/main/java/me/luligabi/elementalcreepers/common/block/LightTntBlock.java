package me.luligabi.elementalcreepers.common.block;

import me.luligabi.elementalcreepers.common.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.common.entity.tnt.LightTntEntity;

public class LightTntBlock extends ElementalTntBlock {

    public LightTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            LightTntEntity tntEntity;
            tntEntity = new LightTntEntity(TntRegistry.LIGHT_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
