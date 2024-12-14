package com.github.telvarost.adventureblocks.block.effect;

import com.github.telvarost.adventureblocks.Config;
import com.github.telvarost.adventureblocks.ModHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class PileEffect extends TemplateBlock {

    public PileEffect(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public boolean isSideVisible(BlockView blockView, int x, int y, int z, int side) {
        if (  !Config.config.RENDER_EFFECTS_CONFIG.DISABLE_ALL_EFFECT_RENDERING
            && Config.config.RENDER_EFFECTS_CONFIG.PILE_EFFECT
        ) {
            return true;
        } else {
            return false;
        }
    }

    @Environment(EnvType.CLIENT)
    @Override
    public Box getBoundingBox(World world, int x, int y, int z) {
        if (  !Config.config.RENDER_EFFECTS_CONFIG.DISABLE_ALL_EFFECT_RENDERING
            && Config.config.RENDER_EFFECTS_CONFIG.PILE_EFFECT
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
    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }

    @Override
    public void onEntityCollision(World world, int x, int y, int z, Entity entity) {
        if (null != entity && !(entity instanceof Particle)) {
            int lastEventState = world.getBlockMeta(x, y, z);
            if (ModHelper.ModHelperFields.eventCounter != lastEventState) {
                world.setBlockMeta(x, y, z, ModHelper.ModHelperFields.eventCounter);

                /** - Change block type to sand for deserts, savannah, and sky */
                Biome biome = world.method_1781().getBiome(x, z);
                int blockId = Block.GRAVEL.id;
                if (null != biome && ((Biome.DESERT == biome) || (Biome.ICE_DESERT == biome) || (Biome.SAVANNA == biome) || (Biome.SKY == biome))) {
                    blockId = Block.SAND.id;
                }

                FallingBlockEntity fallingBlock = new FallingBlockEntity(world, x + 0.5F, 128, z + 0.5F, blockId);
                world.spawnEntity(fallingBlock);
            }
        }
    }
}