package me.luligabi.elementalcreepers.mixin;

import net.minecraft.entity.mob.CreeperEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin {

    /**
     * @author Luligabi
     */
    @Overwrite
    private void explode() {
        switch(this.getClass().getSimpleName()) {
            case "CookieCreeperEntity":
                System.out.println("test");
                break;
            default: //TODO: Maintain original behavior if creeper attempting to explode isn't registered or is vanilla.
                System.out.println(this.getClass().getSimpleName());
                break;
        }
    }
}
