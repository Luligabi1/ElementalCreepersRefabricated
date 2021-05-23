package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.entity.tnt.AirTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.registry.TntRegistry;

public class AirTntBlock extends ElementalTntBlock {

    public AirTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            AirTntEntity tntEntity;
            tntEntity = new AirTntEntity(TntRegistry.AIR_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
