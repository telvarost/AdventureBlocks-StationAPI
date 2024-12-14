package com.github.telvarost.adventureblocks.mixin;

import com.github.telvarost.adventureblocks.ModHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.WorldProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

import static com.github.telvarost.adventureblocks.events.init.BlockListener.DEATH_EFFECT;

@Mixin(World.class)
public abstract class WorldMixin {

    @Shadow protected WorldProperties properties;

    @Shadow public abstract boolean setBlock(int x, int y, int z, int id);

    @Shadow public abstract int getBlockId(int x, int y, int z);

    @Shadow public abstract float getTime(float partialTicks);

    @Unique private int counter = 0;

    @Inject(
            method = "tickEntities",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/List;isEmpty()Z",
                    ordinal = 0
            )
    )
    public void method_227(CallbackInfo ci) {
        if (0 == counter % 100) {
            float f = getTime(1.0f);

            if (0.75F <= f || 0.25F > f) {
                ModHelper.ModHelperFields.isYellowBarrierActive = true;
                ModHelper.ModHelperFields.isBlueBarrierActive = false;
            } else {
                ModHelper.ModHelperFields.isYellowBarrierActive = false;
                ModHelper.ModHelperFields.isBlueBarrierActive = true;
            }

            ModHelper.ModHelperFields.isLightBlueBarrierActive = properties.getRaining();
            ModHelper.ModHelperFields.isLightGrayBarrierActive = (properties.getRaining() && properties.getThundering());
            ModHelper.ModHelperFields.eventCounter = (ModHelper.ModHelperFields.eventCounter + 1) % 16;
        }

        counter++;
    }

    @Inject(
            method = "getEntityCollisions",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;addIntersectingBoundingBox(Lnet/minecraft/world/World;IIILnet/minecraft/util/math/Box;Ljava/util/ArrayList;)V"
            )
    )
    public void getEntityCollisions(Entity entity, Box box, CallbackInfoReturnable<List> cir) {
        ModHelper.ModHelperFields.collisionEntity = entity;
    }

    @Inject(
            method = "spawnEntity",
            at = @At("HEAD"),
            cancellable = true
    )
    public void spawnEntity(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof PlayerEntity) {
            int spawnX = (int)Math.floor(entity.x);
            int spawnY = (int)Math.floor(entity.y);
            int spawnZ = (int)Math.floor(entity.z);
             if (DEATH_EFFECT.id == getBlockId(spawnX, spawnY - 1, spawnZ)) {
                setBlock(spawnX, spawnY - 1, spawnZ, 0);
            }
            if (DEATH_EFFECT.id == getBlockId(spawnX, spawnY, spawnZ)) {
                setBlock(spawnX, spawnY, spawnZ, 0);
            }
            if (DEATH_EFFECT.id == getBlockId(spawnX, spawnY + 1, spawnZ)) {
                setBlock(spawnX, spawnY + 1, spawnZ, 0);
            }
        }
    }
}
