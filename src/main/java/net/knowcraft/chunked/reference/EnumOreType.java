package net.knowcraft.chunked.reference;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

/**
 * Created by oOMitchOo on 10.10.2016.
 */
public enum EnumOreType implements IStringSerializable {
    // TextFormatting eventuell anpassen.
    GOLD(0, "gold", "gold", MapColor.GOLD),
    IRON(1, "iron", "iron", MapColor.IRON),
    COAL(2, "coal", "coal", MapColor.BLACK),
    LAPIS_LAZULI(3, "lapis_lazuli", "lapisLazuli", MapColor.LAPIS),
    DIAMOND(4, "diamond", "diamond", MapColor.DIAMOND),
    REDSTONE(5, "redstone", "redstone", MapColor.RED),
    EMERALD(6, "emerald", "emerald", MapColor.EMERALD);

    private static final EnumOreType[] META_LOOKUP = new EnumOreType[values().length];
    private final int meta;
    private final String name;
    private final String unlocalizedName;
    private final MapColor mapColor;

    private EnumOreType(int meta, String name, String unlocalizedName, MapColor mapColorIn)
    {
        this.meta = meta;
        this.name = name;
        this.unlocalizedName = unlocalizedName;
        this.mapColor = mapColorIn;
    }

    public int getMetadata()
    {
        return this.meta;
    }

    public String getUnlocalizedName()
    {
        return this.unlocalizedName;
    }

    public MapColor getMapColor()
    {
        return this.mapColor;
    }

    public static EnumOreType byMetadata(int meta)
    {
        if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public String toString()
    {
        return this.unlocalizedName;
    }

    @Override
    public String getName() { return this.name; }

    static
    {
        for (EnumOreType enumoretype : values())
        {
            META_LOOKUP[enumoretype.getMetadata()] = enumoretype;
        }
    }
}
