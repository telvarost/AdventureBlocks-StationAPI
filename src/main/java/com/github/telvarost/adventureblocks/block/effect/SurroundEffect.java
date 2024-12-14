package com.github.telvarost.adventureblocks.block.effect;

import com.github.telvarost.adventureblocks.Config;
import com.github.telvarost.adventureblocks.mixin.InGameHudAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.RainSplashParticle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class SurroundEffect extends TemplateBlock {

    public SurroundEffect(Identifier identifier, Material material) {
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
            && Config.config.RENDER_EFFECTS_CONFIG.SURROUND_EFFECT
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
            && Config.config.RENDER_EFFECTS_CONFIG.SURROUND_EFFECT
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
            if (0 == world.random.nextInt(20)) {

                /** - Get particle properties */
                int meta = world.getBlockMeta(x, y, z);
                float propertyX = 0.0F;
                float propertyY = 0.0F;
                float propertyZ = 0.0F;

                /** - Summon Particle */
                switch (meta) {
                    default:
                    case 0:
                        world.addParticle("bubble", (x + 0.5F) + 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("bubble", (x + 0.5F) - 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("bubble", x + 0.5F, y + 0.5D, (z + 0.5F) + 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("bubble", x + 0.5F, y + 0.5D, (z + 0.5F) - 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("bubble", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("bubble", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("bubble", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        world.addParticle("bubble", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        break;
                    case 1:
                        world.addParticle("smoke", (x + 0.5F) + 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("smoke", (x + 0.5F) - 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("smoke", x + 0.5F, y + 0.5D, (z + 0.5F) + 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("smoke", x + 0.5F, y + 0.5D, (z + 0.5F) - 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("smoke", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("smoke", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("smoke", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        world.addParticle("smoke", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        break;
                    case 2:
                        propertyX = world.random.nextFloat();
                        propertyY = world.random.nextFloat();
                        propertyZ = world.random.nextFloat();
                        world.addParticle("note", (x + 0.5F) + 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("note", (x + 0.5F) - 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("note", x + 0.5F, y + 0.5D, (z + 0.5F) + 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("note", x + 0.5F, y + 0.5D, (z + 0.5F) - 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("note", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("note", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("note", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        world.addParticle("note", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        break;
                    case 3:
                        world.addParticle("portal", (x + 0.5F) + 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("portal", (x + 0.5F) - 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("portal", x + 0.5F, y + 0.5D, (z + 0.5F) + 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("portal", x + 0.5F, y + 0.5D, (z + 0.5F) - 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("portal", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("portal", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("portal", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        world.addParticle("portal", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        break;
                    case 4:
                        world.addParticle("explode", (x + 0.5F) + 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("explode", (x + 0.5F) - 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("explode", x + 0.5F, y + 0.5D, (z + 0.5F) + 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("explode", x + 0.5F, y + 0.5D, (z + 0.5F) - 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("explode", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("explode", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("explode", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        world.addParticle("explode", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        break;
                    case 5:
                        world.addParticle("flame", (x + 0.5F) + 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("flame", (x + 0.5F) - 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("flame", x + 0.5F, y + 0.5D, (z + 0.5F) + 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("flame", x + 0.5F, y + 0.5D, (z + 0.5F) - 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("flame", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("flame", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("flame", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        world.addParticle("flame", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        break;
                    case 6:
                        world.addParticle("lava", (x + 0.5F) + 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("lava", (x + 0.5F) - 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("lava", x + 0.5F, y + 0.5D, (z + 0.5F) + 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("lava", x + 0.5F, y + 0.5D, (z + 0.5F) - 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("lava", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("lava", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("lava", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        world.addParticle("lava", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        break;
                    case 7:
                        world.addParticle("footstep", (x + 0.5F) + 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("footstep", (x + 0.5F) - 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("footstep", x + 0.5F, y + 0.5D, (z + 0.5F) + 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("footstep", x + 0.5F, y + 0.5D, (z + 0.5F) - 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("footstep", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("footstep", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("footstep", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        world.addParticle("footstep", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        break;
                    case 8:
                        world.addParticle("splash", (x + 0.5F) + 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("splash", (x + 0.5F) - 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("splash", x + 0.5F, y + 0.5D, (z + 0.5F) + 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("splash", x + 0.5F, y + 0.5D, (z + 0.5F) - 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("splash", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("splash", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("splash", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        world.addParticle("splash", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        break;
                    case 9:
                        world.addParticle("largesmoke", (x + 0.5F) + 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("largesmoke", (x + 0.5F) - 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("largesmoke", x + 0.5F, y + 0.5D, (z + 0.5F) + 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("largesmoke", x + 0.5F, y + 0.5D, (z + 0.5F) - 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("largesmoke", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("largesmoke", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("largesmoke", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        world.addParticle("largesmoke", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        break;
                    case 10:
                        world.addParticle("reddust", (x + 0.5F) + 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("reddust", (x + 0.5F) - 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("reddust", x + 0.5F, y + 0.5D, (z + 0.5F) + 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("reddust", x + 0.5F, y + 0.5D, (z + 0.5F) - 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("reddust", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("reddust", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("reddust", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        world.addParticle("reddust", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        break;
                    case 11:
                        world.addParticle("snowballpoof", (x + 0.5F) + 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("snowballpoof", (x + 0.5F) - 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("snowballpoof", x + 0.5F, y + 0.5D, (z + 0.5F) + 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("snowballpoof", x + 0.5F, y + 0.5D, (z + 0.5F) - 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("snowballpoof", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("snowballpoof", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("snowballpoof", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        world.addParticle("snowballpoof", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        break;
                    case 12:
                        world.addParticle("snowshovel", (x + 0.5F) + 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("snowshovel", (x + 0.5F) - 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("snowshovel", x + 0.5F, y + 0.5D, (z + 0.5F) + 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("snowshovel", x + 0.5F, y + 0.5D, (z + 0.5F) - 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("snowshovel", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("snowshovel", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("snowshovel", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        world.addParticle("snowshovel", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        break;
                    case 13:
                        world.addParticle("slime", (x + 0.5F) + 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("slime", (x + 0.5F) - 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("slime", x + 0.5F, y + 0.5D, (z + 0.5F) + 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("slime", x + 0.5F, y + 0.5D, (z + 0.5F) - 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("slime", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("slime", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("slime", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        world.addParticle("slime", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        break;
                    case 14:
                        world.addParticle("heart", (x + 0.5F) + 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("heart", (x + 0.5F) - 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("heart", x + 0.5F, y + 0.5D, (z + 0.5F) + 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("heart", x + 0.5F, y + 0.5D, (z + 0.5F) - 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("heart", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("heart", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("heart", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        world.addParticle("heart", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        break;
                    case 15:
                        propertyX = world.random.nextFloat();
                        propertyY = world.random.nextFloat();
                        propertyZ = world.random.nextFloat();
                        world.addParticle("reddust", (x + 0.5F) + 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("reddust", (x + 0.5F) - 1.5F, y + 0.5D, z + 0.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("reddust", x + 0.5F, y + 0.5D, (z + 0.5F) + 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("reddust", x + 0.5F, y + 0.5D, (z + 0.5F) - 1.5F, propertyX, propertyY, propertyZ);
                        world.addParticle("reddust", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("reddust", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) + 1, propertyX, propertyY, propertyZ);
                        world.addParticle("reddust", (x + 0.5F) + 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        world.addParticle("reddust", (x + 0.5F) - 1, y + 0.5D, (z + 0.5F) - 1, propertyX, propertyY, propertyZ);
                        break;
                }
            }
        }
    }

    @Override
    public boolean onUse(World world, int x, int y, int z, PlayerEntity player) {
        int meta = (world.getBlockMeta(x, y, z) + 1) % 16;
        world.setBlockMeta(x, y, z, meta);

        if (!world.isRemote) {
            Minecraft minecraft = (Minecraft) FabricLoader.getInstance().getGameInstance();

            switch (meta) {
                default:
                case 0:
                    ((InGameHudAccessor) minecraft.inGameHud).setOverlayMessage("Particle: " + "bubble/nothing");
                    break;
                case 1:
                    ((InGameHudAccessor) minecraft.inGameHud).setOverlayMessage("Particle: " + "smoke");
                    break;
                case 2:
                    ((InGameHudAccessor) minecraft.inGameHud).setOverlayMessage("Particle: " + "note");
                    break;
                case 3:
                    ((InGameHudAccessor) minecraft.inGameHud).setOverlayMessage("Particle: " + "portal");
                    break;
                case 4:
                    ((InGameHudAccessor) minecraft.inGameHud).setOverlayMessage("Particle: " + "explode");
                    break;
                case 5:
                    ((InGameHudAccessor) minecraft.inGameHud).setOverlayMessage("Particle: " + "flame");
                    break;
                case 6:
                    ((InGameHudAccessor) minecraft.inGameHud).setOverlayMessage("Particle: " + "lava");
                    break;
                case 7:
                    ((InGameHudAccessor) minecraft.inGameHud).setOverlayMessage("Particle: " + "footstep");
                    break;
                case 8:
                    ((InGameHudAccessor) minecraft.inGameHud).setOverlayMessage("Particle: " + "splash");
                    break;
                case 9:
                    ((InGameHudAccessor) minecraft.inGameHud).setOverlayMessage("Particle: " + "largesmoke");
                    break;
                case 10:
                    ((InGameHudAccessor) minecraft.inGameHud).setOverlayMessage("Particle: " + "reddust");
                    break;
                case 11:
                    ((InGameHudAccessor) minecraft.inGameHud).setOverlayMessage("Particle: " + "snowballpoof");
                    break;
                case 12:
                    ((InGameHudAccessor) minecraft.inGameHud).setOverlayMessage("Particle: " + "snowshovel");
                    break;
                case 13:
                    ((InGameHudAccessor) minecraft.inGameHud).setOverlayMessage("Particle: " + "slime");
                    break;
                case 14:
                    ((InGameHudAccessor) minecraft.inGameHud).setOverlayMessage("Particle: " + "heart");
                    break;
                case 15:
                    ((InGameHudAccessor) minecraft.inGameHud).setOverlayMessage("Particle: " + "chaosdust");
                    break;
            }

            ((InGameHudAccessor) minecraft.inGameHud).setOverlayRemaining(40);
        }

        return true;
    }
}