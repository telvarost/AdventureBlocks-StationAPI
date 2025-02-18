package com.github.telvarost.adventureblocks.mixin.client;

import com.github.telvarost.adventureblocks.ModHelper;
import com.github.telvarost.adventureblocks.events.KeyBindingListener;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Shadow public World world;

    @Inject(
            method = "startGame",
            at = @At("HEAD"),
            cancellable = true
    )
    public void createOrLoadWorld(String string2, String l, long par3, CallbackInfo ci) {
        ModHelper.ModHelperFields.remoteInventory = null;
    }

    @Inject(
            method = "tick",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/input/Keyboard;getEventKey()I",
                    ordinal = 7
            )
    )
    public void adventureBlocks_tickGetEventKey(CallbackInfo ci) {
        int eventKey = Keyboard.getEventKey();

        if (this.world != null) {
            if(eventKey == KeyBindingListener.toggleAquaBarrierCollision.code) {
                ModHelper.ModHelperFields.isAquaBarrierActive = !ModHelper.ModHelperFields.isAquaBarrierActive;
            }

            if(eventKey == KeyBindingListener.toggleJadeBarrierCollision.code) {
                ModHelper.ModHelperFields.isJadeBarrierActive = !ModHelper.ModHelperFields.isJadeBarrierActive;
            }

            if(eventKey == KeyBindingListener.toggleIndigoBarrierCollision.code) {
                ModHelper.ModHelperFields.isIndigoBarrierActive = !ModHelper.ModHelperFields.isIndigoBarrierActive;
            }
        }
    }
}
