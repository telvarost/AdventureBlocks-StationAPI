package com.github.telvarost.adventureblocks.mixin.client;

import com.github.telvarost.adventureblocks.events.init.BlockListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(SignBlockEntityRenderer.class)
public abstract class SignBlockEntityRendererMixin extends BlockEntityRenderer {

    @Inject(
            method = "render",
            at = @At("HEAD"),
            cancellable = true
    )
    public void render(SignBlockEntity signBlockEntity, double d, double e, double f, float g, CallbackInfo ci) {
        if (signBlockEntity.getBlock().id == BlockListener.SIGN_EFFECT.id && d != -0.5D && e != -0.75D && f != -0.5D && g != 0.0F) {
            ci.cancel();
        }
    }
}
