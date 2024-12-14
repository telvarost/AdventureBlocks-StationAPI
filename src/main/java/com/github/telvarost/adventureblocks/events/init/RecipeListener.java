package com.github.telvarost.adventureblocks.events.init;

import com.github.telvarost.adventureblocks.Config;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

import static com.github.telvarost.adventureblocks.events.init.BlockListener.*;

public class RecipeListener {

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        Identifier type = event.recipeId;

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type()) {
            if (Config.config.enableOrbRecipes) {
                CraftingRegistry.addShapedRecipe(new ItemStack(ORB.asItem(), 1), " X ", "XYX", " X ", 'X', new ItemStack(Item.DYE, 1, 11), 'Y', Block.OBSIDIAN);
            }
        }

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
            if (Config.config.enableOrbRecipes) {
                CraftingRegistry.addShapelessRecipe(new ItemStack(KEY_ORB.asItem(), 1)  , new ItemStack(ORB.asItem(), 1), Item.GOLD_INGOT);
            }

            if (Config.config.enableBarrierRecipes) {
                CraftingRegistry.addShapelessRecipe(new ItemStack(WHITE_BARRIER.asItem()     , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Item.DYE, 1, 15));
                CraftingRegistry.addShapelessRecipe(new ItemStack(ORANGE_BARRIER.asItem()    , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Item.DYE, 1, 14));
                CraftingRegistry.addShapelessRecipe(new ItemStack(MAGENTA_BARRIER.asItem()   , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Item.DYE, 1, 13));
                CraftingRegistry.addShapelessRecipe(new ItemStack(LIGHT_BLUE_BARRIER.asItem(), 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Item.DYE, 1, 12));
                CraftingRegistry.addShapelessRecipe(new ItemStack(YELLOW_BARRIER.asItem()    , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Item.DYE, 1, 11));
                CraftingRegistry.addShapelessRecipe(new ItemStack(LIME_BARRIER.asItem()      , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Item.DYE, 1, 10));
                CraftingRegistry.addShapelessRecipe(new ItemStack(PINK_BARRIER.asItem()      , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Item.DYE, 1, 9));
                CraftingRegistry.addShapelessRecipe(new ItemStack(GRAY_BARRIER.asItem()      , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Item.DYE, 1, 8));
                CraftingRegistry.addShapelessRecipe(new ItemStack(LIGHT_GRAY_BARRIER.asItem(), 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Item.DYE, 1, 7));
                CraftingRegistry.addShapelessRecipe(new ItemStack(CYAN_BARRIER.asItem()      , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Item.DYE, 1, 6));
                CraftingRegistry.addShapelessRecipe(new ItemStack(PURPLE_BARRIER.asItem()    , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Item.DYE, 1, 5));
                CraftingRegistry.addShapelessRecipe(new ItemStack(BLUE_BARRIER.asItem()      , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Item.DYE, 1, 4));
                CraftingRegistry.addShapelessRecipe(new ItemStack(BROWN_BARRIER.asItem()     , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Item.DYE, 1, 3));
                CraftingRegistry.addShapelessRecipe(new ItemStack(GREEN_BARRIER.asItem()     , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Item.DYE, 1, 2));
                CraftingRegistry.addShapelessRecipe(new ItemStack(RED_BARRIER.asItem()       , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Item.DYE, 1, 1));
                CraftingRegistry.addShapelessRecipe(new ItemStack(BLACK_BARRIER.asItem()     , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Item.DYE, 1, 0));

                CraftingRegistry.addShapelessRecipe(new ItemStack(AQUA_BARRIER.asItem()      , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, Item.DIAMOND);
                CraftingRegistry.addShapelessRecipe(new ItemStack(JADE_BARRIER.asItem()      , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, Item.SLIMEBALL);
                CraftingRegistry.addShapelessRecipe(new ItemStack(INDIGO_BARRIER.asItem()    , 1), Block.SOUL_SAND, Block.STONE_PRESSURE_PLATE, Block.SOUL_SAND, new ItemStack(Block.NETHER_PORTAL.asItem(), 1));
            }
        }
    }
}