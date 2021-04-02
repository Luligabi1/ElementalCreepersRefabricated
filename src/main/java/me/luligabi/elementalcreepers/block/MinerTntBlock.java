package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.MinerTntEntity;

public class MinerTntBlock extends ElementalTntBlock {

    public MinerTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            MinerTntEntity tntEntity;
            tntEntity = new MinerTntEntity(ElementalCreepers.MINER_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z, livingEntity);
            return tntEntity;
        });
    }
}
