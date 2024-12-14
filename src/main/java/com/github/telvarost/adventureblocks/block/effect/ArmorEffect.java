package com.github.telvarost.adventureblocks.block.effect;

import com.github.telvarost.adventureblocks.Config;
import com.github.telvarost.adventureblocks.ModHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class ArmorEffect extends TemplateBlock {

    public ArmorEffect(Identifier identifier, Material material) {
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
            && Config.config.RENDER_EFFECTS_CONFIG.ARMOR_EFFECT
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
            && Config.config.RENDER_EFFECTS_CONFIG.ARMOR_EFFECT
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
        if (null != entity && entity instanceof PlayerEntity) {
            int lastEventState = world.getBlockMeta(x, y, z);
            if (ModHelper.ModHelperFields.eventCounter != lastEventState) {
                world.setBlockMeta(x, y, z, ModHelper.ModHelperFields.eventCounter);

                /** - Equip chain-mail armor if none is equipped */
                PlayerInventory currentInventory = ((PlayerEntity) entity).inventory;
                ItemStack[] currentArmor = ((PlayerEntity) entity).inventory.armor;
                if (null != currentArmor && 3 < currentArmor.length) {
                    if (null == currentArmor[3]) {
                        currentInventory.setStack(currentInventory.main.length + 3, new ItemStack(Item.CHAIN_HELMET, 1));
                    }

                    if (null == currentArmor[2]) {
                        currentInventory.setStack(currentInventory.main.length + 2, new ItemStack(Item.CHAIN_CHESTPLATE, 1));
                    }

                    if (null == currentArmor[1]) {
                        currentInventory.setStack(currentInventory.main.length + 1, new ItemStack(Item.CHAIN_LEGGINGS, 1));
                    }

                    if (null == currentArmor[0]) {
                        currentInventory.setStack(currentInventory.main.length, new ItemStack(Item.CHAIN_BOOTS, 1));
                    }
                }
            }
        }
    }
}