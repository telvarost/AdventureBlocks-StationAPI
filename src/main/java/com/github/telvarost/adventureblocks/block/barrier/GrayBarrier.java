package com.github.telvarost.adventureblocks.block.barrier;

import com.github.telvarost.adventureblocks.Config;
import com.github.telvarost.adventureblocks.ModHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.ArrayList;

import static com.github.telvarost.adventureblocks.events.init.BlockListener.GRAY_BARRIER;
import static com.github.telvarost.adventureblocks.events.init.BlockListener.RED_BARRIER;

public class GrayBarrier extends TemplateBlock {

    public GrayBarrier(Identifier identifier, Material material) {
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
            && Config.config.RENDER_BARRIERS_CONFIG.GRAY_BARRIER
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
            && Config.config.RENDER_BARRIERS_CONFIG.GRAY_BARRIER
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
        return false;
    }

    @Override
    public boolean hasCollision() {
        return false;
    }

    @Override
    public Box getCollisionShape(World world, int x, int y, int z) {
        return Box.createCached(0, 0, 0, 0, 0, 0);
    }

    public void method_1059(World world, int x, int y, int z, boolean hasRedstonePower) {
        if (hasRedstonePower) {
            world.setBlock(x, y, z, RED_BARRIER.id);
            world.setBlockMeta(x, y, z, 1);
        }
    }

    @Override
    public void neighborUpdate(World world, int x, int y, int z, int id) {
        if (!world.isRemote) {
            if (id > 0 && Block.BLOCKS[id].canEmitRedstonePower()) {
                boolean hasRedstonePower = world.isEmittingRedstonePower(x, y, z);
                this.method_1059(world, x, y, z, !hasRedstonePower);
            }
        }
    }
}