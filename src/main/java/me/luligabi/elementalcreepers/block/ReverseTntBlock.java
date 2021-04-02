package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.ReverseTntEntity;

public class ReverseTntBlock extends ElementalTntBlock {

    public ReverseTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            ReverseTntEntity tntEntity;
            tntEntity = new ReverseTntEntity(ElementalCreepers.REVERSE_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z, livingEntity);
            return tntEntity;
        });
    }
}
