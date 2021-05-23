package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.FakeIllusionTntEntity;
import me.luligabi.elementalcreepers.registry.TntRegistry;

public class FakeIllusionTntBlock extends ElementalTntBlock {

    public FakeIllusionTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            FakeIllusionTntEntity tntEntity;
            tntEntity = new FakeIllusionTntEntity(TntRegistry.FAKE_ILLUSION_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
