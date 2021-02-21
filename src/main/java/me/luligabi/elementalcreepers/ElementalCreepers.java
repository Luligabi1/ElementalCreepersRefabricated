package me.luligabi.elementalcreepers;

import me.luligabi.elementalcreepers.entity.CookieCreeperEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ElementalCreepers implements ModInitializer {

    public static final EntityType<CookieCreeperEntity> COOKIE_CREEPER =
            Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier("elementalcreepers", "cookie_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CookieCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    @Override
    public void onInitialize() {
        System.out.println("ElementalCreepers debug message");
        FabricDefaultAttributeRegistry.register(COOKIE_CREEPER, CookieCreeperEntity.createCreeperAttributes());
        Registry.register(Registry.ITEM, new Identifier("elementalcreepers", "cookie_creeper_spawn_egg"), new SpawnEggItem(COOKIE_CREEPER, 0xE88E3F, 0x8A4929, new Item.Settings().group(ItemGroup.MISC)));
    }
}