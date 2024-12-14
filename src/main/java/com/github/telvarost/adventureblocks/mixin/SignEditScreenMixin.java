package com.github.telvarost.adventureblocks.mixin;

import com.github.telvarost.adventureblocks.events.init.BlockListener;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.gui.screen.ingame.SignEditScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SignEditScreen.class)
public class SignEditScreenMixin {

    @Shadow private SignBlockEntity sign;

    @Shadow protected String title;

    @Inject(
            method = "init",
            at = @At("HEAD"),
            cancellable = true
    )
    public void init(CallbackInfo ci) {
        if (sign.getBlock().id == BlockListener.SIGN_EFFECT.id) {
            this.title = "";
        }
    }
}
