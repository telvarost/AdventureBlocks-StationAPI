package com.github.telvarost.adventureblocks.events;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.option.KeyBinding;
import net.modificationstation.stationapi.api.client.event.option.KeyBindingRegisterEvent;
import org.lwjgl.input.Keyboard;

public class KeyBindingListener {
    public static KeyBinding toggleAquaBarrierCollision;
    public static KeyBinding toggleJadeBarrierCollision;
    public static KeyBinding toggleIndigoBarrierCollision;

    @EventListener
    public void registerKeyBindings(KeyBindingRegisterEvent event) {
        event.keyBindings.add(toggleAquaBarrierCollision   = new KeyBinding("Aqua Barrier", Keyboard.KEY_H));
        event.keyBindings.add(toggleJadeBarrierCollision   = new KeyBinding("Jade Barrier", Keyboard.KEY_J));
        event.keyBindings.add(toggleIndigoBarrierCollision = new KeyBinding("Indigo Barrier", Keyboard.KEY_K));
    }
}