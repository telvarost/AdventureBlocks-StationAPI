package com.github.telvarost.adventureblocks;

import net.glasslauncher.mods.gcapi3.api.*;

public class Config {

    @ConfigRoot(value = "config", visibleName = "AdventureBlocks")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

        @ConfigCategory(
                name = "Render Barrier Blocks Config",
                description = "Reload world for changes to take effect"
        )
        public RenderBarriersConfig RENDER_BARRIERS_CONFIG = new RenderBarriersConfig();

        @ConfigCategory(
                name = "Render Effect Blocks Config",
                description = "Reload world for changes to take effect"
        )
        public RenderEffectBlocksConfig RENDER_EFFECTS_CONFIG = new RenderEffectBlocksConfig();

        @ConfigCategory(
                name = "Render Orb Blocks Config",
                description = "Reload world for changes to take effect"
        )
        public RenderOrbBlocksConfig RENDER_ORBS_CONFIG = new RenderOrbBlocksConfig();

        @ConfigEntry(
                name = "Disable Living Entities Despawning",
                description = "Living entities will no longer despawn",
                multiplayerSynced = true
        )
        public Boolean disableLivingEntitiesDespawning = true;

        @ConfigEntry(
                name = "Enable Barrier Block Recipes",
                description = "Reload world for changes to take effect",
                multiplayerSynced = true
        )
        public Boolean enableBarrierRecipes = true;

        @ConfigEntry(
                name = "Enable Orb Recipes",
                description = "Reload world for changes to take effect",
                multiplayerSynced = true
        )
        public Boolean enableOrbRecipes = true;
    }

    public static class RenderBarriersConfig {
        @ConfigEntry(
                name = "Disable All Barrier Block Rendering",
                description = "Overrides individual toggles when true"
        )
        public Boolean DISABLE_ALL_BARRIER_RENDERING = false;

        @ConfigEntry(name = "Render Barrier Block")
        public Boolean BEDROCK_BARRIER    = true;

        @ConfigEntry(name = "Render Red Barrier Block")
        public Boolean RED_BARRIER        = true;

        @ConfigEntry(name = "Render Black Barrier Block")
        public Boolean BLACK_BARRIER      = true;

        @ConfigEntry(name = "Render Green Barrier Block")
        public Boolean GREEN_BARRIER      = true;

        @ConfigEntry(name = "Render Brown Barrier Block")
        public Boolean BROWN_BARRIER      = true;

        @ConfigEntry(name = "Render Blue Barrier Block")
        public Boolean BLUE_BARRIER       = true;

        @ConfigEntry(name = "Render Purple Barrier Block")
        public Boolean PURPLE_BARRIER     = true;

        @ConfigEntry(name = "Render Cyan Barrier Block")
        public Boolean CYAN_BARRIER       = true;

        @ConfigEntry(name = "Render Light Gray Barrier Block")
        public Boolean LIGHT_GRAY_BARRIER = true;

        @ConfigEntry(name = "Render Gray Barrier Block")
        public Boolean GRAY_BARRIER       = true;

        @ConfigEntry(name = "Render Pink Barrier Block")
        public Boolean PINK_BARRIER       = true;

        @ConfigEntry(name = "Render Lime Barrier Block")
        public Boolean LIME_BARRIER       = true;

        @ConfigEntry(name = "Render Yellow Barrier Block")
        public Boolean YELLOW_BARRIER     = true;

        @ConfigEntry(name = "Render Light Blue Barrier Block")
        public Boolean LIGHT_BLUE_BARRIER = true;

        @ConfigEntry(name = "Render Magenta Barrier Block")
        public Boolean MAGENTA_BARRIER    = true;

        @ConfigEntry(name = "Render Orange Barrier Block")
        public Boolean ORANGE_BARRIER     = true;

        @ConfigEntry(name = "Render White Barrier Block")
        public Boolean WHITE_BARRIER      = true;

        @ConfigEntry(name = "Render Aqua Barrier Block")
        public Boolean AQUA_BARRIER       = true;

        @ConfigEntry(name = "Render Jade Barrier Block")
        public Boolean JADE_BARRIER       = true;

        @ConfigEntry(name = "Render Indigo Barrier Block")
        public Boolean INDIGO_BARRIER     = true;

    }

    public static class RenderEffectBlocksConfig {
        @ConfigEntry(
                name = "Disable All Effect Block Rendering",
                description = "Overrides individual toggles when true"
        )
        public Boolean DISABLE_ALL_EFFECT_RENDERING = false;

        @ConfigEntry(name = "Render Open Unlock Block")
        public Boolean OPEN_EFFECT = true;

        @ConfigEntry(name = "Render Close Lock Block")
        public Boolean CLOSE_EFFECT = true;

        @ConfigEntry(name = "Render Accelerate Block")
        public Boolean ACCELERATE_EFFECT = true;

        @ConfigEntry(name = "Render Decelerate Block")
        public Boolean DECELERATE_EFFECT = true;

        @ConfigEntry(name = "Render Armor Block")
        public Boolean ARMOR_EFFECT = true;

        @ConfigEntry(name = "Render Sword Block")
        public Boolean SWORD_EFFECT = true;

        @ConfigEntry(name = "Render Boss Block")
        public Boolean BOSS_EFFECT = true;

        @ConfigEntry(name = "Render Chest Block")
        public Boolean CHEST_EFFECT = true;

        @ConfigEntry(name = "Render Death Block")
        public Boolean DEATH_EFFECT = true;

        @ConfigEntry(name = "Render Heal Block")
        public Boolean HEAL_EFFECT = true;

        @ConfigEntry(name = "Render Freeze Block")
        public Boolean FREEZE_EFFECT = true;

        @ConfigEntry(name = "Render Melt Block")
        public Boolean MELT_EFFECT = true;

        @ConfigEntry(name = "Render Off Block")
        public Boolean OFF_EFFECT = true;

        @ConfigEntry(name = "Render On Block")
        public Boolean ON_EFFECT = true;

        @ConfigEntry(name = "Render Sign Block")
        public Boolean SIGN_EFFECT = true;

        @ConfigEntry(name = "Render World Block")
        public Boolean WORLD_EFFECT = true;

        @ConfigEntry(name = "Render Particle Block")
        public Boolean PARTICLE_EFFECT = true;

        @ConfigEntry(name = "Render Surround Block")
        public Boolean SURROUND_EFFECT = true;

        @ConfigEntry(name = "Render Pile Block")
        public Boolean PILE_EFFECT = true;

        @ConfigEntry(name = "Render Trap Block")
        public Boolean TRAP_EFFECT = true;
    }

    public static class RenderOrbBlocksConfig {
        @ConfigEntry(
                name = "Disable All Orb Block Rendering",
                description = "Overrides individual toggles when true"
        )
        public Boolean DISABLE_ALL_ORB_RENDERING = false;

        @ConfigEntry(name = "Render Orb")
        public Boolean ORB = true;

        @ConfigEntry(name = "Render Key Orb")
        public Boolean KEY_ORB = true;
    }
}
