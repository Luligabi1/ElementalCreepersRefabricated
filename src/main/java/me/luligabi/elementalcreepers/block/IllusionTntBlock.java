package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.IllusionTntEntity;
import me.luligabi.elementalcreepers.registry.TntRegistry;

public class IllusionTntBlock extends ElementalTntBlock {

    public IllusionTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            IllusionTntEntity tntEntity;
            tntEntity = new IllusionTntEntity(TntRegistry.ILLUSION_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
