package me.luligabi.elementalcreepers.common.block;

import me.luligabi.elementalcreepers.common.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.common.entity.tnt.FireTntEntity;

public class FireTntBlock extends ElementalTntBlock {

    public FireTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            FireTntEntity tntEntity;
            tntEntity = new FireTntEntity(TntRegistry.FIRE_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
