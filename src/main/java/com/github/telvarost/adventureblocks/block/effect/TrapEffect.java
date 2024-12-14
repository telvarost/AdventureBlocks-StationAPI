package com.github.telvarost.adventureblocks.block.effect;

import com.github.telvarost.adventureblocks.Config;
import com.github.telvarost.adventureblocks.ModHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.entity.NoteBlockBlockEntity;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class TrapEffect extends TemplateBlock {

    public TrapEffect(Identifier identifier, Material material) {
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
            && Config.config.RENDER_EFFECTS_CONFIG.TRAP_EFFECT
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
            && Config.config.RENDER_EFFECTS_CONFIG.TRAP_EFFECT
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

                /** - Activate some traps in 5x5 cube */
                byte var5 = 2;
                for(int var6 = x - var5; var6 <= x + var5; ++var6) {
                    for(int var7 = y - var5; var7 <= y + var5; ++var7) {
                        for(int var8 = z - var5; var8 <= z + var5; ++var8) {
                            if (world.getBlockId(var6, var7, var8) == Block.DOUBLE_SLAB.id) {
                                int meta = world.getBlockMeta(var6, var7, var8);
                                world.setBlock(var6, var7, var8, Block.COBWEB.id, meta);
                            } else if (world.getBlockId(var6, var7, var8) == Block.COBWEB.id) {
                                int meta = world.getBlockMeta(var6, var7, var8);
                                world.setBlock(var6, var7, var8, Block.DOUBLE_SLAB.id, meta);
                            }

                            if (world.getBlockId(var6, var7, var8) == Block.TNT.id) {
                                world.setBlock(var6, var7, var8, 0, 0);
                                TntEntity tntEntity = new TntEntity(world, (double)((float)var6 + 0.5F), (double)((float)var7 + 0.5F), (double)((float)var8 + 0.5F));
                                world.spawnEntity(tntEntity);
                                world.playSound(tntEntity, "random.fuse", 1.0F, 1.0F);
                            }

                            if (world.getBlockId(var6, var7, var8) == Block.NOTE_BLOCK.id) {
                                if (!world.isRemote) {
                                    NoteBlockBlockEntity noteBlockBlockEntity = (NoteBlockBlockEntity)world.getBlockEntity(var6, var7, var8);
                                    noteBlockBlockEntity.playNote(world, var6, var7, var8);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}