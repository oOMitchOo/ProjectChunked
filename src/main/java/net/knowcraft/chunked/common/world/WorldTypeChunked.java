package net.knowcraft.chunked.common.world;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.gen.ChunkProviderFlat;

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

    @Override
    public int getMinimumSpawnHeight(World world) {
        return 74;
    }

    @Override
    public int getSpawnFuzz(@Nonnull WorldServer world, MinecraftServer server) {
        return 0;
    }

    @Override
    public float getCloudHeight() {
        return 272;
    }

    @Nonnull
    @Override
    public IChunkGenerator getChunkGenerator(@Nonnull World world, String generatorOptions) {
        return new ChunkProviderFlat(world, world.getSeed(), false, "3;minecraft:air;");
    }
}
