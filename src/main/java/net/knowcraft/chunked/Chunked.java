package net.knowcraft.chunked;

import net.knowcraft.chunked.common.world.ChunkedWorldEvents;
import net.knowcraft.chunked.common.world.WorldTypeChunked;
import net.knowcraft.chunked.helper.LogHelper;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
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

    static final PropertyEnum<EnumDyeColor> DYE_COLOR_PROPERTY_ENUM = PropertyEnum.create("color", EnumDyeColor.class);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        new WorldTypeChunked();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        // Hier loggt er: [PropertyEnum{name=color, clazz=class net.minecraft.item.EnumDyeColor,
        // values=[white, orange, magenta, lightBlue, yellow, lime, pink, gray, silver, cyan, purple, blue, brown, green, red, black]}]
        LogHelper.error(Blocks.STAINED_HARDENED_CLAY.getBlockState().getProperties().toString());

        // Log: PropertyEnum{name=color, clazz=class net.minecraft.item.EnumDyeColor,
        // values=[white, orange, magenta, lightBlue, yellow, lime, pink, gray, silver, cyan, purple, blue, brown, green, red, black]}
        LogHelper.error(Blocks.STAINED_HARDENED_CLAY.getBlockState().getProperty("color"));


        //IProperty<EnumDyeColor> property = Blocks.STAINED_HARDENED_CLAY.getBlockState().getProperty("color");


        LogHelper.error(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(DYE_COLOR_PROPERTY_ENUM, EnumDyeColor.LIGHT_BLUE).toString());

        // MinecraftForge.EVENT_BUS.register(ChunkedWorldEvents.class);
    }
}
