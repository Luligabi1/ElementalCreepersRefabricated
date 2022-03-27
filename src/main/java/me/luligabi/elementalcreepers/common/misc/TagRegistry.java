package me.luligabi.elementalcreepers.common.misc;

import me.luligabi.elementalcreepers.common.ElementalCreepers;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TagRegistry {

    private TagRegistry() {
        // NO-OP
    }

    public static TagKey<Block> MINER_CREEPER_EXPLODABLE;

    static {
        MINER_CREEPER_EXPLODABLE = TagKey.of(Registry.BLOCK_KEY, new Identifier(ElementalCreepers.MOD_ID, "miner_creeper_explodable"));
    }
}
