package com.github.telvarost.adventureblocks.block.barrier;

import com.github.telvarost.adventureblocks.Config;
import com.github.telvarost.adventureblocks.ModHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class IndigoBarrier extends TemplateBlock {

    public IndigoBarrier(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public boolean isSideVisible(BlockView blockView, int x, int y, int z, int side) {
        if (  !Config.config.RENDER_BARRIERS_CONFIG.DISABLE_ALL_BARRIER_RENDERING
            && Config.config.RENDER_BARRIERS_CONFIG.INDIGO_BARRIER
        ) {
            return true;
        } else {
            return false;
        }
    }

    @Environment(EnvType.CLIENT)
    @Override
    public Box getBoundingBox(World world, int x, int y, int z) {
        if (  !Config.config.RENDER_BARRIERS_CONFIG.DISABLE_ALL_BARRIER_RENDERING
            && Config.config.RENDER_BARRIERS_CONFIG.INDIGO_BARRIER
        ) {
            return Box.createCached((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (double)y + this.maxY, (double)z + this.maxZ);
        } else {
            return Box.createCached(0, 0, 0, 0, 0, 0);
        }
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isSolidFace(BlockView blockView, int x, int y, int z, int i) {
        if (ModHelper.ModHelperFields.isIndigoBarrierActive) {
            return blockView.getMaterial(x, y, z).isSolid();
        } else {
            return false;
        }
    }

    @Override
    public boolean hasCollision() {
        if (ModHelper.ModHelperFields.isIndigoBarrierActive) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Box getCollisionShape(World world, int x, int y, int z) {
        if (ModHelper.ModHelperFields.isIndigoBarrierActive) {
            return Box.createCached((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (double)y + this.maxY, (double)z + this.maxZ);
        } else {
            return Box.createCached(0, 0, 0, 0, 0, 0);
        }
    }

    @Override
    public void onEntityCollision(World world, int x, int y, int z, Entity entity) {
        if (null != entity && entity instanceof PlayerEntity) {
            int lastEventState = world.getBlockMeta(x, y, z);
            if (ModHelper.ModHelperFields.eventCounter != lastEventState) {
                world.setBlockMeta(x, y, z, ModHelper.ModHelperFields.eventCounter);
                entity.tickPortalCooldown();
            }
        }
    }
}