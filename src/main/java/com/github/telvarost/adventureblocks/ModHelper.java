package com.github.telvarost.adventureblocks;

import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Null;
import net.modificationstation.stationapi.api.util.Namespace;

public class ModHelper {

    //public static final Namespace NAMESPACE = Namespace.resolve();
    @Entrypoint.Namespace
    public static Namespace NAMESPACE = Null.get();

    public static class ModHelperFields {
        public static ItemStack[] remoteInventory = null;
        public static Integer eventCounter = 0;
        public static Boolean isOrangeBarrierActive = true;
        public static Boolean isYellowBarrierActive = true;
        public static Boolean isBlueBarrierActive = true;
        public static Boolean isLightGrayBarrierActive = false;
        public static Boolean isLightBlueBarrierActive = false;
        public static Boolean isAquaBarrierActive = true;
        public static Boolean isJadeBarrierActive = false;
        public static Boolean isIndigoBarrierActive = false;
    }
}
