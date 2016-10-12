package net.knowcraft.chunked;

import net.knowcraft.chunked.common.world.ChunkedWorldEvents;
import net.knowcraft.chunked.common.world.WorldTypeChunked;
import net.knowcraft.chunked.init.ModBlocks;
import net.knowcraft.chunked.proxy.IProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.knowcraft.chunked.reference.Reference;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by oOMitchOo on 03.10.2016.
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class Chunked {
    WorldTypeChunked worldTypeChunked;

    @Mod.Instance(Reference.MOD_ID)
    public static Chunked instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        worldTypeChunked = new WorldTypeChunked();

        ModBlocks.initAndRegister();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.TERRAIN_GEN_BUS.register(ChunkedWorldEvents.class);
        // MinecraftForge.EVENT_BUS.register(ChunkedWorldEvents.class);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
