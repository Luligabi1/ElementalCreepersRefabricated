package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.entity.tnt.DarkTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.registry.TntRegistry;

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
