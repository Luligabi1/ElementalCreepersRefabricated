package me.luligabi.elementalcreepers.common.block;

import me.luligabi.elementalcreepers.common.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.common.entity.tnt.ReverseTntEntity;
import me.luligabi.elementalcreepers.common.registry.TntRegistry;

public class ReverseTntBlock extends ElementalTntBlock {

    public ReverseTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            ReverseTntEntity tntEntity;
            tntEntity = new ReverseTntEntity(TntRegistry.REVERSE_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
