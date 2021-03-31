package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.entity.tnt.DarkTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;

public class DarkTntBlock extends ElementalTntBlock {

    public DarkTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            DarkTntEntity tntEntity;
            tntEntity = new DarkTntEntity(ElementalCreepers.DARK_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z, livingEntity);
            return tntEntity;
        });
    }
}
