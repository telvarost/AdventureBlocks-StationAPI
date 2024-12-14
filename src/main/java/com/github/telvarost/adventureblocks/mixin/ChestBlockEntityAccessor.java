package com.github.telvarost.adventureblocks.mixin;

import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ChestBlockEntity.class)
public interface ChestBlockEntityAccessor {
    @Accessor("inventory")
    ItemStack[] getInventory();
    @Accessor("inventory")
    public void setInventory(ItemStack[] inventory);
}
