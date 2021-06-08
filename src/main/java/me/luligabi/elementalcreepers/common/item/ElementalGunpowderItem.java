package me.luligabi.elementalcreepers.common.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class ElementalGunpowderItem extends Item {

    public ElementalGunpowderItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.elementalcreepers.gunpowder.tooltip.1")
                .formatted(Formatting.GRAY).formatted(Formatting.ITALIC));
        tooltip.add(new TranslatableText("item.elementalcreepers.gunpowder.tooltip.2")
                .formatted(Formatting.GRAY).formatted(Formatting.ITALIC));
    }
}