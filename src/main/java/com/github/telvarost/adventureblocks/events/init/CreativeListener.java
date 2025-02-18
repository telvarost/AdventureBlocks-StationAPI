package com.github.telvarost.adventureblocks.events.init;

import com.github.telvarost.adventureblocks.ModHelper;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import paulevs.bhcreative.api.CreativeTab;
import paulevs.bhcreative.api.SimpleTab;
import paulevs.bhcreative.registry.TabRegistryEvent;

public class CreativeListener {
    public static CreativeTab tabSameOldSpellsSpells;

    @EventListener
    public void onTabInit(TabRegistryEvent event){
        tabSameOldSpellsSpells = new SimpleTab(ModHelper.NAMESPACE.id("orb"), BlockListener.ORB.asItem());
        event.register(tabSameOldSpellsSpells);
        for (Block block : BlockListener.blocks){
            tabSameOldSpellsSpells.addItem(new ItemStack(block.asItem(), 1));
        }
    }
}