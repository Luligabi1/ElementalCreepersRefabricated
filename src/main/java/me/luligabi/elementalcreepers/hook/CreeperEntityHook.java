package me.luligabi.elementalcreepers.hook;

import me.luligabi.elementalcreepers.entity.creeper.AirCreeperEntity;
import me.luligabi.elementalcreepers.entity.creeper.ElementalCreeperEntity;
import me.luligabi.elementalcreepers.entity.creeper.FakeIllusionCreeperEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


public class CreeperEntityHook {

    public static void onExplode(CreeperEntity creeperEntity, CallbackInfo info) {
        if(creeperEntity instanceof ElementalCreeperEntity) {
           if(creeperEntity instanceof AirCreeperEntity) {
               if(!creeperEntity.world.isClient) {
                   creeperEntity.world.createExplosion(creeperEntity, creeperEntity.getX(), creeperEntity.getY(), creeperEntity.getZ(), 0, Explosion.DestructionType.NONE);
               }
               ((ElementalCreeperEntity) creeperEntity).onExplode();
               info.cancel();
           } else if(creeperEntity instanceof FakeIllusionCreeperEntity) {
               if(creeperEntity.world.isClient) {
                   for(int i=0; i < 4; ++i) {
                       creeperEntity.world.addParticle(ParticleTypes.SPIT, creeperEntity.getX(), creeperEntity.getY() + 0.75, creeperEntity.getZ(), 0.0, 0.0, 0.0);
                   }
               }
               ((ElementalCreeperEntity) creeperEntity).onExplode();
               info.cancel();
           } else {
               if(!creeperEntity.world.isClient) {
                   ((ElementalCreeperEntity) creeperEntity).onExplode();
                   info.cancel();
               }
           }
        }
    }
}
