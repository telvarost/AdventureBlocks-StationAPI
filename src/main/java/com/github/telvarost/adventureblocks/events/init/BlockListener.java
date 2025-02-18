package com.github.telvarost.adventureblocks.events.init;

import com.github.telvarost.adventureblocks.ModHelper;
import com.github.telvarost.adventureblocks.block.barrier.*;
import com.github.telvarost.adventureblocks.block.effect.*;
import com.github.telvarost.adventureblocks.block.orb.KeyOrb;
import com.github.telvarost.adventureblocks.block.orb.Orb;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.util.Identifier;

import static net.minecraft.block.Block.*;

public class BlockListener {

    public static Block[] blocks;

    public static Block ORB;
    public static Block KEY_ORB;

    public static Block BEDROCK_BARRIER   ;
    public static Block RED_BARRIER       ;
    public static Block BLACK_BARRIER     ;
    public static Block GREEN_BARRIER     ;
    public static Block BROWN_BARRIER     ;
    public static Block BLUE_BARRIER      ;
    public static Block PURPLE_BARRIER    ;
    public static Block CYAN_BARRIER      ;
    public static Block LIGHT_GRAY_BARRIER;
    public static Block GRAY_BARRIER      ;
    public static Block PINK_BARRIER      ;
    public static Block LIME_BARRIER      ;
    public static Block YELLOW_BARRIER    ;
    public static Block LIGHT_BLUE_BARRIER;
    public static Block MAGENTA_BARRIER   ;
    public static Block ORANGE_BARRIER    ;
    public static Block WHITE_BARRIER     ;
    public static Block AQUA_BARRIER      ;
    public static Block JADE_BARRIER      ;
    public static Block INDIGO_BARRIER    ;

    public static Block OPEN_EFFECT;
    public static Block CLOSE_EFFECT;
    public static Block ARMOR_EFFECT;
    public static Block SWORD_EFFECT;
    public static Block ACCELERATE_EFFECT;
    public static Block DECELERATE_EFFECT;
    public static Block BOSS_EFFECT;
    public static Block CHEST_EFFECT;
    public static Block DEATH_EFFECT;
    public static Block HEAL_EFFECT;
    public static Block FREEZE_EFFECT;
    public static Block MELT_EFFECT;
    public static Block ON_EFFECT;
    public static Block OFF_EFFECT;
    public static Block PARTICLE_EFFECT;
    public static Block SURROUND_EFFECT;
    public static Block PILE_EFFECT;
    public static Block SIGN_EFFECT;
    public static Block WORLD_EFFECT;
    public static Block TRAP_EFFECT;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {

        ORB                = new Orb             (Identifier.of(ModHelper.NAMESPACE, "orb"               ), Material.STONE).setHardness(1.0F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "orb"              );
        KEY_ORB            = new KeyOrb          (Identifier.of(ModHelper.NAMESPACE, "key_orb"           ), Material.METAL).setHardness(1.0F).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "key_orb"          );

        BEDROCK_BARRIER    = new BedrockBarrier  (Identifier.of(ModHelper.NAMESPACE, "bedrock_barrier"   ), Material.STONE).setUnbreakable().setResistance(6000000.0F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "bedrock_barrier").disableTrackingStatistics();
        RED_BARRIER        = new RedBarrier      (Identifier.of(ModHelper.NAMESPACE, "red_barrier"       ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "red_barrier"        );
        BLACK_BARRIER      = new BlackBarrier    (Identifier.of(ModHelper.NAMESPACE, "black_barrier"     ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "black_barrier"      );
        GREEN_BARRIER      = new GreenBarrier    (Identifier.of(ModHelper.NAMESPACE, "green_barrier"     ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "green_barrier"      );
        BROWN_BARRIER      = new BrownBarrier    (Identifier.of(ModHelper.NAMESPACE, "brown_barrier"     ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "brown_barrier"      );
        BLUE_BARRIER       = new BlueBarrier     (Identifier.of(ModHelper.NAMESPACE, "blue_barrier"      ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "blue_barrier"       );
        PURPLE_BARRIER     = new PurpleBarrier   (Identifier.of(ModHelper.NAMESPACE, "purple_barrier"    ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "purple_barrier"     );
        CYAN_BARRIER       = new CyanBarrier     (Identifier.of(ModHelper.NAMESPACE, "cyan_barrier"      ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "cyan_barrier"       );
        LIGHT_GRAY_BARRIER = new LightGrayBarrier(Identifier.of(ModHelper.NAMESPACE, "light_gray_barrier"), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "light_gray_barrier" );
        GRAY_BARRIER       = new GrayBarrier     (Identifier.of(ModHelper.NAMESPACE, "gray_barrier"      ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "gray_barrier"       );
        PINK_BARRIER       = new PinkBarrier     (Identifier.of(ModHelper.NAMESPACE, "pink_barrier"      ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "pink_barrier"       );
        LIME_BARRIER       = new LimeBarrier     (Identifier.of(ModHelper.NAMESPACE, "lime_barrier"      ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "lime_barrier"       );
        YELLOW_BARRIER     = new YellowBarrier   (Identifier.of(ModHelper.NAMESPACE, "yellow_barrier"    ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "yellow_barrier"     );
        LIGHT_BLUE_BARRIER = new LightBlueBarrier(Identifier.of(ModHelper.NAMESPACE, "light_blue_barrier"), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "light_blue_barrier" );
        MAGENTA_BARRIER    = new MagentaBarrier  (Identifier.of(ModHelper.NAMESPACE, "magenta_barrier"   ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "magenta_barrier"    );
        ORANGE_BARRIER     = new OrangeBarrier   (Identifier.of(ModHelper.NAMESPACE, "orange_barrier"    ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "orange_barrier"     );
        WHITE_BARRIER      = new WhiteBarrier    (Identifier.of(ModHelper.NAMESPACE, "white_barrier"     ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "white_barrier"      );
        AQUA_BARRIER       = new AquaBarrier     (Identifier.of(ModHelper.NAMESPACE, "aqua_barrier"      ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "aqua_barrier"       );
        JADE_BARRIER       = new JadeBarrier     (Identifier.of(ModHelper.NAMESPACE, "jade_barrier"      ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "jade_barrier"       );
        INDIGO_BARRIER     = new IndigoBarrier   (Identifier.of(ModHelper.NAMESPACE, "indigo_barrier"    ), Material.AIR).setHardness(0.5F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "indigo_barrier"     );

        OPEN_EFFECT        = new OpenEffect      (Identifier.of(ModHelper.NAMESPACE, "open_effect"       ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "open_effect"     );
        CLOSE_EFFECT       = new CloseEffect     (Identifier.of(ModHelper.NAMESPACE, "close_effect"      ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "close_effect"    );
        ARMOR_EFFECT       = new ArmorEffect     (Identifier.of(ModHelper.NAMESPACE, "armor_effect"      ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "armor_effect"    );
        SWORD_EFFECT       = new SwordEffect     (Identifier.of(ModHelper.NAMESPACE, "sword_effect"      ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "sword_effect"    );
        ACCELERATE_EFFECT  = new AccelerateEffect(Identifier.of(ModHelper.NAMESPACE, "accelerate_effect" ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "accelerate_effect" );
        DECELERATE_EFFECT  = new DecelerateEffect(Identifier.of(ModHelper.NAMESPACE, "decelerate_effect" ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "decelerate_effect" );
        BOSS_EFFECT        = new BossEffect      (Identifier.of(ModHelper.NAMESPACE, "boss_effect"       ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "boss_effect"     );
        CHEST_EFFECT       = new ChestEffect     (Identifier.of(ModHelper.NAMESPACE, "chest_effect"      ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "chest_effect"    );
        DEATH_EFFECT       = new DeathEffect     (Identifier.of(ModHelper.NAMESPACE, "death_effect"      ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "death_effect"    );
        HEAL_EFFECT        = new HealEffect      (Identifier.of(ModHelper.NAMESPACE, "heal_effect"       ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "heal_effect"     );
        FREEZE_EFFECT      = new FreezeEffect    (Identifier.of(ModHelper.NAMESPACE, "freeze_effect"     ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "freeze_effect"   );
        MELT_EFFECT        = new MeltEffect      (Identifier.of(ModHelper.NAMESPACE, "melt_effect"       ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "melt_effect"     );
        SIGN_EFFECT        = new SignEffect      (Identifier.of(ModHelper.NAMESPACE, "sign_effect"       ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "sign_effect"     );
        WORLD_EFFECT       = new WorldEffect     (Identifier.of(ModHelper.NAMESPACE, "world_effect"      ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "world_effect"    );
        OFF_EFFECT         = new OffEffect       (Identifier.of(ModHelper.NAMESPACE, "off_effect"        ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "off_effect"      );
        ON_EFFECT          = new OnEffect        (Identifier.of(ModHelper.NAMESPACE, "on_effect"         ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "on_effect"       );
        PARTICLE_EFFECT    = new ParticleEffect  (Identifier.of(ModHelper.NAMESPACE, "particle_effect"   ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "particle_effect" );
        SURROUND_EFFECT    = new SurroundEffect  (Identifier.of(ModHelper.NAMESPACE, "surround_effect"   ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "surround_effect" );
        PILE_EFFECT        = new PileEffect      (Identifier.of(ModHelper.NAMESPACE, "pile_effect"       ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "pile_effect"     );
        TRAP_EFFECT        = new TrapEffect      (Identifier.of(ModHelper.NAMESPACE, "trap_effect"       ), Material.GLASS).setHardness(0.25F).setSoundGroup(GLASS_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "trap_effect"     );

        blocks = new Block[]
        {   ORB
        ,   KEY_ORB
        ,   BEDROCK_BARRIER   
        ,   RED_BARRIER       
        ,   BLACK_BARRIER     
        ,   GREEN_BARRIER     
        ,   BROWN_BARRIER     
        ,   BLUE_BARRIER      
        ,   PURPLE_BARRIER    
        ,   CYAN_BARRIER      
        ,   LIGHT_GRAY_BARRIER
        ,   GRAY_BARRIER      
        ,   PINK_BARRIER      
        ,   LIME_BARRIER      
        ,   YELLOW_BARRIER    
        ,   LIGHT_BLUE_BARRIER
        ,   MAGENTA_BARRIER   
        ,   ORANGE_BARRIER    
        ,   WHITE_BARRIER     
        ,   AQUA_BARRIER      
        ,   JADE_BARRIER      
        ,   INDIGO_BARRIER    
        ,   OPEN_EFFECT      
        ,   CLOSE_EFFECT     
        ,   ARMOR_EFFECT     
        ,   SWORD_EFFECT     
        ,   ACCELERATE_EFFECT
        ,   DECELERATE_EFFECT
        ,   BOSS_EFFECT      
        ,   CHEST_EFFECT     
        ,   DEATH_EFFECT     
        ,   HEAL_EFFECT      
        ,   FREEZE_EFFECT    
        ,   MELT_EFFECT      
        ,   SIGN_EFFECT      
        ,   WORLD_EFFECT     
        ,   OFF_EFFECT       
        ,   ON_EFFECT        
        ,   PARTICLE_EFFECT  
        ,   SURROUND_EFFECT  
        ,   PILE_EFFECT      
        ,   TRAP_EFFECT
        };
    }
}

