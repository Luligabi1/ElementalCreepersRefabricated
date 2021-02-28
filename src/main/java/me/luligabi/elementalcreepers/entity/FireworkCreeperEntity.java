package me.luligabi.elementalcreepers.entity;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.world.World;

import javax.swing.text.html.parser.Element;

public class FireworkCreeperEntity extends ElementalCreeperEntity {

    public FireworkCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onExplode() {
        ItemStack fireWork = new ItemStack(Items.FIREWORK_ROCKET);
        try {
            fireWork.putSubTag("Fireworks", StringNbtReader.parse("{Explosions:[{Type:3,Flicker:1,Colors:[I;4312372],FadeColors:[I;4312372]}],Flight:1}"));
        } catch(CommandSyntaxException ignored) {}
        FireworkRocketEntity fireworkEntity = new FireworkRocketEntity(
                this.world, this.getX(), this.getY(), this.getZ(), fireWork);
        fireworkEntity.refreshPositionAfterTeleport(this.getX(), this.getY(), this.getZ());
        this.world.spawnEntity(fireworkEntity);
        super.onExplode();
    }
}