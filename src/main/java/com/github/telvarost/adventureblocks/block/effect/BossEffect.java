package com.github.telvarost.adventureblocks.block.effect;

import com.github.telvarost.adventureblocks.Config;
import com.github.telvarost.adventureblocks.ModHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.mob.GiantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class BossEffect extends TemplateBlock {

    public BossEffect(Identifier identifier, Material material) {
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
            && Config.config.RENDER_EFFECTS_CONFIG.BOSS_EFFECT
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
            && Config.config.RENDER_EFFECTS_CONFIG.BOSS_EFFECT
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
        if (null != entity && (entity instanceof PlayerEntity || entity instanceof FallingBlockEntity)) {
            int lastEventState = world.getBlockMeta(x, y, z);
            if (ModHelper.ModHelperFields.eventCounter != lastEventState) {
                world.setBlockMeta(x, y, z, ModHelper.ModHelperFields.eventCounter);

                /** - Summon giant */
                GiantEntity giantEntity = new GiantEntity(world);
                if (entity instanceof PlayerEntity) {
                    /** - Randomize location a bit if spawned by player */
                    giantEntity.setPositionAndAnglesKeepPrevAngles( entity.x + (world.random.nextInt(11) - 5)
                            , entity.y + 0.5
                            , entity.z + (world.random.nextInt(11) - 5)
                            , world.random.nextFloat() * 360.0f
                            , 0.0f);

                    /** - Remove other giants if spawned by player */
                    for (int entityIndex = 0; entityIndex < world.entities.size(); entityIndex++) {
                        if (world.entities.get(entityIndex) instanceof  GiantEntity) {
                            world.remove((Entity)world.entities.get(entityIndex));
                        }
                    }
                } else {
                    giantEntity.setPositionAndAnglesKeepPrevAngles( entity.x
                            , entity.y + 0.5
                            , entity.z
                            , world.random.nextFloat() * 360.0f
                            , 0.0f);
                }
                world.spawnEntity(giantEntity);
            }
        }
    }
}