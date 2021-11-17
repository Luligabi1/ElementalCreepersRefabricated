package me.luligabi.elementalcreepers.common.misc;

import me.luligabi.elementalcreepers.common.ElementalCreepers;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class TagRegistry {

    public static void init() {
        MINER_CREEPER_EXPLODABLE = TagFactory.BLOCK.create(new Identifier(ElementalCreepers.MOD_ID, "miner_creeper_explodable"));
    }

    public static Tag<Block> MINER_CREEPER_EXPLODABLE;
}
