# AdventureBlocks StationAPI Edition for Minecraft Beta 1.7.3

Adventure blocks for b1.7.3! Barriers and Special Effects!
* Mod works on Multiplayer with [GlassConfigAPI](https://modrinth.com/mod/glass-config-api) version 3.0+ used to sync configs!

## Barrier Blocks

Crafting recipes for barrier blocks is two soul sand, stone pressure plate, and dye color of desired barrier block
(Note that Aqua, Jade, and Indigo use special items to craft: diamonds, slime, and unobtainable nether portal)

* Barrier Block = Normal Bedrock Invisible Block
* Aqua, Jade, and Indigo Barrier Blocks = Blocking is toggled for each with their own hotkey
    * Aqua default blocking
    * Jade default non-blocking
    * Indigo default non-blocking
        * (Also makes nether portal sounds on player collision occasionally)
* Red Barrier Block = Blocks everything (toggled to gray barrier via redstone)
* Gray Barrier Block = Blocks nothing (toggled to red barrier via redstone)
* Orange Barrier Block = Blocks when locked
    * Use Key Orb to toggle locked/unlocked globally
    * [Not Craftable] Use "Open Effect Block" to unlock globally
    * [Not Craftable] Use "Close Effect Block" to lock globally
* Yellow Barrier Block = Blocks during the day
* Blue Barrier Block = Blocks at night
* Light Blue Barrier Block = Blocks during the rain
* Light Gray Barrier Block = Blocks during thunderstorms
* Pink Barrier Block = Blocks passive mobs
* Green Barrier Block = Blocks monster mobs
* Purple Barrier Block = Blocks non-player mobs
* Cyan Barrier Block = Blocks players only
* Lime Barrier Block = Blocks players only when they are not sneaking
* Magenta Barrier Block = Blocks entities that are not on fire
* Brown Barrier Block = Blocks falling blocks
    * (This includes sand, gravel, and primed TNT)
* White Barrier Block = Blocks living entities
* Black Barrier Block = Blocks non-living entities

## Orb Blocks

* Orb = Does nothing used in crafting recipes (four yellow dye around an obsidian block)
* Key Orb = Toggles orange barrier blocks (one time use, craftable via orb and gold ingot)

## Effect Blocks

All blocks activate only on collision with an entity

* Open Effect Block, disables orange barrier block collision
* Close Effect Block, enables orange barrier block collision
* Accelerate Effect Block, increases speed while within block if moving
* Decelerate Effect Block, decreases speed while within block if moving
* Freeze Effect Block, periodically changes water source to ice and lava source to obsidian and removes flowing liquid (5x5 cube)
* Melt Effect Block, periodically changes ice to water source and obsidian to lava source blocks (5x5 cube)
* On Effect Block, periodically lights netherrack on fire, lights furnaces, and changes redstone torches to regular torches (5x5 cube)
* Off Effect Block, periodically puts out fires, furnaces, and changes regular torches to unlit redstone torches (5x5 cube)
* Trap Effect Block, periodically ignites TNT, plays note blocks, changes cobwebs to double slabs, and double slabs to cobwebs (5x5 cube)
* Pile Effect Block, summons a falling block
* Particle Effect Block, periodically summons a single particle at block location
* Surround Effect Block, periodically summons particles around a block location
* Death Effect Block, instantly kills any living entity that touches it
* Heal Effect Block, heals any living entity that touches it to full health
* Armor Effect Block, equips any player that walks through it with a full set of chain-mail armor for any empty armor slots
* Sword Effect Block, sets the selected hotbar slot of any player that walks through it to a gold sword if the slot is empty
* Chest Effect Block, forces chest screen open and acts as an ender chest (chest inventories are all linked for this block)
* Sign Effect Block, displays editable sign (on player entity collision)
* Boss Effect Block, spawns a giant within 10 blocks of the player
    * Only players and falling blocks can trigger the summon
        * Players can only summon one giant at a time and all other giants in the world will be removed upon summon
        * Falling blocks can summon more giants, but be warned this tends to cause massive lag
            * Falling block giant summon spawn position is not random and will occur exactly at location of boss effect block unlike player summons
* World Effect Block, sets world spawn to block location (on player entity collision)

## Installation using Prism Launcher

1. Download an instance of Babric for Prism Launcher: https://github.com/Glass-Series/babric-prism-instance
2. Install Java 17, set the instance to use it, and disable compatibility checks on the instance: https://adoptium.net/temurin/releases/
3. Add StationAPI to the mod folder for the instance: https://modrinth.com/mod/stationapi
4. (Optional) Add Mod Menu to the mod folder for the instance: https://modrinth.com/mod/modmenu-beta
5. (Optional) Add GlassConfigAPI 3.0+ to the mod folder for the instance: https://modrinth.com/mod/glass-config-api
6. Add this mod to the mod folder for the instance: https://github.com/telvarost/AdventureBlocks-StationAPI/releases
7. Run and enjoy! 👍

## Feedback

Got any suggestions on what should be added next? Feel free to share it by [creating an issue](https://github.com/telvarost/AdventureBlocks-StationAPI/issues/new). Know how to code and want to do it yourself? Then look below on how to get started.

## Contributing

Thanks for considering contributing! To get started fork this repository, make your changes, and create a PR. 

If you are new to StationAPI consider watching the following videos on Babric/StationAPI Minecraft modding: https://www.youtube.com/watch?v=9-sVGjnGJ5s&list=PLa2JWzyvH63wGcj5-i0P12VkJG7PDyo9T
