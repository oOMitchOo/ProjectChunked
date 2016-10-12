package net.knowcraft.chunked.common.world;

import net.minecraftforge.event.terraingen.WorldTypeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by oOMitchOo on 04.10.2016.
 */

public class ChunkedWorldEvents {

    @SubscribeEvent
    public static void CustomBiomeSize (WorldTypeEvent.BiomeSize event){
            if (event.getWorldType() instanceof WorldTypeChunked) {
                event.setNewSize(1);
            }
    }
}
