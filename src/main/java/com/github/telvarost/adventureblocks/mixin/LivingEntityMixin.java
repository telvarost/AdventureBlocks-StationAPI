package com.github.telvarost.adventureblocks.mixin;

import com.github.telvarost.adventureblocks.Config;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "canDespawn", at = @At("RETURN"), cancellable = true)
    protected void method_940(CallbackInfoReturnable<Boolean> cir) {
        if (Config.config.disableLivingEntitiesDespawning) {
            cir.setReturnValue(false);
        }
    }
}
