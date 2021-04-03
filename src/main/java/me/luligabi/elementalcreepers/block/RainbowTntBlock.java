package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.RainbowTntEntity;

public class RainbowTntBlock extends ElementalTntBlock {

    public RainbowTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            RainbowTntEntity tntEntity;
            tntEntity = new RainbowTntEntity(ElementalCreepers.RAINBOW_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z, livingEntity);
            return tntEntity;
        });
    }
}
