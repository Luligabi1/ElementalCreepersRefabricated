package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.FireTntEntity;
import me.luligabi.elementalcreepers.registry.TntRegistry;

public class FireTntBlock extends ElementalTntBlock {

    public FireTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            FireTntEntity tntEntity;
            tntEntity = new FireTntEntity(TntRegistry.FIRE_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
