package net.knowcraft.chunked;

import net.knowcraft.chunked.common.world.ChunkedWorldEvents;
import net.knowcraft.chunked.common.world.WorldTypeChunked;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.knowcraft.chunked.reference.Reference;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by oOMitchOo on 03.10.2016.
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class Chunked {

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        new WorldTypeChunked();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        // MinecraftForge.EVENT_BUS.register(ChunkedWorldEvents.class);
    }
}
