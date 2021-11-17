package me.luligabi.elementalcreepers.common.block;

import me.luligabi.elementalcreepers.common.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.common.entity.tnt.MinerTntEntity;

public class MinerTntBlock extends ElementalTntBlock {

    public MinerTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            MinerTntEntity tntEntity;
            tntEntity = new MinerTntEntity(TntRegistry.MINER_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
