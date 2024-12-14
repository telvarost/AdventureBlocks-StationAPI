package com.github.telvarost.adventureblocks.block.effect;

import com.github.telvarost.adventureblocks.Config;
import com.github.telvarost.adventureblocks.ModHelper;
import com.github.telvarost.adventureblocks.mixin.ChestBlockEntityAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateChestBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class ChestEffect extends TemplateChestBlock {
    public ChestEffect(Identifier identifier, Material material) {
        super(identifier);
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public boolean isSideVisible(BlockView blockView, int x, int y, int z, int side) {
        if (  !Config.config.RENDER_EFFECTS_CONFIG.DISABLE_ALL_EFFECT_RENDERING
            && Config.config.RENDER_EFFECTS_CONFIG.CHEST_EFFECT
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
            && Config.config.RENDER_EFFECTS_CONFIG.CHEST_EFFECT
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
    public void onBreak(World world, int x, int y, int z) {
        world.removeBlockEntity(x, y, z);
    }

    @Override
    public void onEntityCollision(World world, int x, int y, int z, Entity entity) {
        if (null != entity && entity instanceof PlayerEntity) {
            int lastEventState = world.getBlockMeta(x, y, z);
            if (ModHelper.ModHelperFields.eventCounter != lastEventState) {
                world.setBlockMeta(x, y, z, ModHelper.ModHelperFields.eventCounter);

                /** - Open remote inventory */
                ChestBlockEntity chestBlockEntity = (ChestBlockEntity)world.getBlockEntity(x, y, z);
                if (null == ModHelper.ModHelperFields.remoteInventory) {
                    ModHelper.ModHelperFields.remoteInventory = ((ChestBlockEntityAccessor)chestBlockEntity).getInventory();
                }
                ((ChestBlockEntityAccessor)chestBlockEntity).setInventory(ModHelper.ModHelperFields.remoteInventory);
                onUse(world, x, y, z, ((PlayerEntity) entity));
            }
        }
    }

    @Override
    public boolean onUse(World world, int x, int y, int z, PlayerEntity player) {
        Object var6 = (ChestBlockEntity)world.getBlockEntity(x, y, z);
        if (world.isRemote) {
            return true;
        } else {
            player.openChestScreen((Inventory)var6);
            return true;
        }
    }

    @Override
    public boolean canPlaceAt(World world, int x, int y, int z) {
        int var5 = world.getBlockId(x, y, z);
        return var5 == 0 || BLOCKS[var5].material.isReplaceable();
    }
}