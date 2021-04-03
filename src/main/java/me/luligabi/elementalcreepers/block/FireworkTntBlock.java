package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.FireworkTntEntity;

public class FireworkTntBlock extends ElementalTntBlock {

    public FireworkTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            FireworkTntEntity tntEntity;
            tntEntity = new FireworkTntEntity(ElementalCreepers.FIREWORK_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z, livingEntity);
            return tntEntity;
        });
    }
}
