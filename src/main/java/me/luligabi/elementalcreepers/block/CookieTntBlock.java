package me.luligabi.elementalcreepers.block;

import me.luligabi.elementalcreepers.entity.tnt.CookieTntEntity;
import me.luligabi.elementalcreepers.entity.tnt.ElementalTntEntity;
import me.luligabi.elementalcreepers.registry.TntRegistry;

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
