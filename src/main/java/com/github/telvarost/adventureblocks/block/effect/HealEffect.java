package com.github.telvarost.adventureblocks.block.effect;

import com.github.telvarost.adventureblocks.Config;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.GiantEntity;
import net.minecraft.entity.mob.MonsterEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class HealEffect extends TemplateBlock {

    public HealEffect(Identifier identifier, Material material) {
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
            && Config.config.RENDER_EFFECTS_CONFIG.HEAL_EFFECT
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
            && Config.config.RENDER_EFFECTS_CONFIG.HEAL_EFFECT
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
        if (null != entity && (entity instanceof LivingEntity)) {
            if (entity instanceof MonsterEntity) {
                if (entity instanceof GiantEntity) {
                    ((GiantEntity) entity).health = 100;
                } else {
                    ((MonsterEntity) entity).health = 20;
                }
            } else if (entity instanceof PlayerEntity) {
                ((PlayerEntity) entity).health = 20;
            } else if (entity instanceof WolfEntity) {
                if (((WolfEntity) entity).isTamed()) {
                    ((WolfEntity) entity).health = 20;
                } else {
                    ((WolfEntity) entity).health = 8;
                }
            } else if (entity instanceof ChickenEntity) {
                ((ChickenEntity) entity).health = 4;
            } else if (entity instanceof SlimeEntity) {
                int size = ((SlimeEntity) entity).getSize();
                ((SlimeEntity) entity).health = size * size;
            } else {
                ((LivingEntity) entity).health = 10;
            }
        }
    }
}