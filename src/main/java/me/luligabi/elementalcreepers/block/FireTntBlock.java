package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.FireTntEntity;

public class FireTntBlock extends ElementalTntBlock {

    public FireTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            FireTntEntity tntEntity;
            tntEntity = new FireTntEntity(ElementalCreepers.FIRE_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z, livingEntity);
            return tntEntity;
        });
    }
}
