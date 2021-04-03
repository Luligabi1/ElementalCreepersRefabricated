package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.FakeIllusionTntEntity;

public class FakeIllusionTntBlock extends ElementalTntBlock {

    public FakeIllusionTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            FakeIllusionTntEntity tntEntity;
            tntEntity = new FakeIllusionTntEntity(ElementalCreepers.FAKE_ILLUSION_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z, livingEntity);
            return tntEntity;
        });
    }
}
