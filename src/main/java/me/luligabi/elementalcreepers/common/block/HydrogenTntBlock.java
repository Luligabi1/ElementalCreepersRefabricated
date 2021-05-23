package me.luligabi.elementalcreepers.common.block;

import me.luligabi.elementalcreepers.common.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.common.entity.tnt.HydrogenTntEntity;
import me.luligabi.elementalcreepers.common.registry.TntRegistry;

public class HydrogenTntBlock extends ElementalTntBlock {

    public HydrogenTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            HydrogenTntEntity tntEntity;
            tntEntity = new HydrogenTntEntity(TntRegistry.HYDROGEN_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
