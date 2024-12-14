package com.github.telvarost.adventureblocks.block.effect;

import com.github.telvarost.adventureblocks.Config;
import com.github.telvarost.adventureblocks.mixin.InGameHudAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class ParticleEffect extends TemplateBlock {

    public ParticleEffect(Identifier identifier, Material material) {
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
            && Config.config.RENDER_EFFECTS_CONFIG.PARTICLE_EFFECT
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
            && Config.config.RENDER_EFFECTS_CONFIG.PARTICLE_EFFECT
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
                float offsetX = world.random.nextFloat();
                float offsetY = world.random.nextFloat();
                float offsetZ = world.random.nextFloat();
                float propertyX;
                float propertyY;
                float propertyZ;


                /** - Summon Particle */
                switch (meta) {
                    default:
                    case 0:
                        world.addParticle("bubble", (double)x + offsetX, (double)y + offsetY + 1, (double)z + offsetZ, 0, 0, 0);
                        break;
                    case 1:
                        world.addParticle("smoke", (double)x + offsetX, (double)y + offsetY, (double)z + offsetZ, 0, 0, 0);
                        break;
                    case 2:
                        propertyX = world.random.nextFloat();
                        propertyY = world.random.nextFloat();
                        propertyZ = world.random.nextFloat();
                        world.addParticle("note", (double)x + offsetX, (double)y + offsetY, (double)z + offsetZ, propertyX, propertyY, propertyZ);
                        break;
                    case 3:
                        world.addParticle("portal", (double)x + offsetX, (double)y + offsetY, (double)z + offsetZ, 0, 0, 0);
                        break;
                    case 4:
                        world.addParticle("explode", (double)x + offsetX, (double)y + offsetY, (double)z + offsetZ, 0, 0, 0);
                        break;
                    case 5:
                        world.addParticle("flame", (double)x + offsetX, (double)y + offsetY, (double)z + offsetZ, 0, 0, 0);
                        break;
                    case 6:
                        world.addParticle("lava", (double)x + offsetX, (double)y + offsetY, (double)z + offsetZ, 0, 0, 0);
                        break;
                    case 7:
                        world.addParticle("footstep", (double)x + offsetX, (double)y + offsetY, (double)z + offsetZ, 0, 0, 0);
                        break;
                    case 8:
                        world.addParticle("splash", (double)x + offsetX, (double)y + offsetY, (double)z + offsetZ, 0, 0, 0);
                        break;
                    case 9:
                        world.addParticle("largesmoke", (double)x + offsetX, (double)y + offsetY, (double)z + offsetZ, 0, 0, 0);
                        break;
                    case 10:
                        world.addParticle("reddust", (double)x + offsetX, (double)y + offsetY, (double)z + offsetZ, 0, 0, 0);
                        break;
                    case 11:
                        world.addParticle("snowballpoof", (double)x + offsetX, (double)y + offsetY, (double)z + offsetZ, 0, 0, 0);
                        break;
                    case 12:
                        world.addParticle("snowshovel", (double)x + offsetX, (double)y + offsetY, (double)z + offsetZ, 0, 0, 0);
                        break;
                    case 13:
                        world.addParticle("slime", (double)x + offsetX, (double)y + offsetY, (double)z + offsetZ, 0, 0, 0);
                        break;
                    case 14:
                        world.addParticle("heart", (double)x + offsetX, (double)y + offsetY, (double)z + offsetZ, 0, 0, 0);
                        break;
                    case 15:
                        propertyX = world.random.nextFloat();
                        propertyY = world.random.nextFloat();
                        propertyZ = world.random.nextFloat();
                        world.addParticle("reddust", (double)x + offsetX, (double)y + offsetY, (double)z + offsetZ, propertyX, propertyY, propertyZ);
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