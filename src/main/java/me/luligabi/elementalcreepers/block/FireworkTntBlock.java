package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.FireworkTntEntity;
import me.luligabi.elementalcreepers.registry.TntRegistry;

public class FireworkTntBlock extends ElementalTntBlock {

    public FireworkTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            FireworkTntEntity tntEntity;
            tntEntity = new FireworkTntEntity(TntRegistry.FIREWORK_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
