package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.LightTntEntity;
import me.luligabi.elementalcreepers.registry.TntRegistry;

public class LightTntBlock extends ElementalTntBlock {

    public LightTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            LightTntEntity tntEntity;
            tntEntity = new LightTntEntity(TntRegistry.LIGHT_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z, livingEntity);
            return tntEntity;
        });
    }
}
