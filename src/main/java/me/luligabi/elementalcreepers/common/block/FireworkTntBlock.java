package me.luligabi.elementalcreepers.common.block;

import me.luligabi.elementalcreepers.common.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.common.entity.tnt.FireworkTntEntity;

public class FireworkTntBlock extends ElementalTntBlock {

    public FireworkTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            FireworkTntEntity tntEntity;
            tntEntity = new FireworkTntEntity(TntRegistry.FIREWORK_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
