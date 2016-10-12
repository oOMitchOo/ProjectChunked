package net.knowcraft.chunked.common.world;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkGenerator;

import javax.annotation.Nonnull;

/**
 * Created by oOMitchOo on 04.10.2016.
 */

public class WorldTypeChunked extends WorldType{

    /**
     * Creates a new world type, the ID is hidden and should not be referenced by modders.
     * It will automatically expand the underlying workdType array if there are no IDs left.
     */

    public WorldTypeChunked() {
        super("chunked");
    }

    @Override
    public boolean showWorldInfoNotice() {
        return true;
    }

    // Standard ist Sealevel + 1.
    @Override
    public int getMinimumSpawnHeight(World world) {
        return world.getSeaLevel() + 1;
    }

    // Bestimmt die Block-Abweichung vom Spawn in der Spieler spawnen können beim ersten Betreten der Welt.
    @Override
    public int getSpawnFuzz(@Nonnull WorldServer world, MinecraftServer server) { return 0; }

    // Standard ist 128.0F .
    @Override
    public float getCloudHeight() {
        return 128.0F;
    }

    @Nonnull
    @Override
    public IChunkGenerator getChunkGenerator(@Nonnull World world, String generatorOptions) {

        // Muss noch herausfinden, wofür der String (hier "") steht.
        // In einer flatword kann es z.B. "3;minecraft:air;" sein um eine void world zu erschaffen.
        // Für den String siehe ChunkProviderSettings.java in world.gen biomeSize:1
        return new ChunkProviderChunkedOverworld(world, world.getSeed(), false, "");
    }
}
