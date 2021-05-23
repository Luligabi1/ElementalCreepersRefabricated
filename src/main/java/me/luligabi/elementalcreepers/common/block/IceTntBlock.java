package me.luligabi.elementalcreepers.common.block;

import me.luligabi.elementalcreepers.common.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.common.entity.tnt.IceTntEntity;
import me.luligabi.elementalcreepers.common.registry.TntRegistry;

public class IceTntBlock extends ElementalTntBlock {

    public IceTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            IceTntEntity tntEntity;
            tntEntity = new IceTntEntity(TntRegistry.ICE_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
