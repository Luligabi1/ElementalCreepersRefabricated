package me.luligabi.elementalcreepers.common.block;

import me.luligabi.elementalcreepers.common.entity.tnt.DarkTntEntity;
import me.luligabi.elementalcreepers.common.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.common.registry.TntRegistry;

public class DarkTntBlock extends ElementalTntBlock {

    public DarkTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            DarkTntEntity tntEntity;
            tntEntity = new DarkTntEntity(TntRegistry.DARK_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
