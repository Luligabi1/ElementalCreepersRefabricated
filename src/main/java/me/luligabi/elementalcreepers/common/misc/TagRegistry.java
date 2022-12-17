package me.luligabi.elementalcreepers.common.misc;

import me.luligabi.elementalcreepers.common.ElementalCreepers;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class TagRegistry {

    private TagRegistry() {
        // NO-OP
    }

    public static TagKey<Block> MINER_CREEPER_EXPLODABLE;

    static {
        MINER_CREEPER_EXPLODABLE = TagKey.of(RegistryKeys.BLOCK, new Identifier(ElementalCreepers.MOD_ID, "miner_creeper_explodable"));
    }
}
