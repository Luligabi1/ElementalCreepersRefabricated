package me.luligabi.elementalcreepers.common.block;

import me.luligabi.elementalcreepers.common.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.common.entity.tnt.FakeIllusionTntEntity;

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
