package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.MinerTntEntity;
import me.luligabi.elementalcreepers.registry.TntRegistry;

public class MinerTntBlock extends ElementalTntBlock {

    public MinerTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            MinerTntEntity tntEntity;
            tntEntity = new MinerTntEntity(TntRegistry.MINER_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z, livingEntity);
            return tntEntity;
        });
    }
}
