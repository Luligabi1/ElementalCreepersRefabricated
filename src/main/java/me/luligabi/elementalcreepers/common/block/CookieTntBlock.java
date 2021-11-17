package me.luligabi.elementalcreepers.common.block;

import me.luligabi.elementalcreepers.common.entity.tnt.CookieTntEntity;
import me.luligabi.elementalcreepers.common.entity.tnt.ElementalTntEntity;

public class CookieTntBlock extends ElementalTntBlock {

    public CookieTntBlock(Settings settings) {
        super(settings, (world, x, y, z, livingEntity) -> {
            CookieTntEntity tntEntity;
            tntEntity = new CookieTntEntity(TntRegistry.COOKIE_TNT_ENTITY, world);
            ElementalTntEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
