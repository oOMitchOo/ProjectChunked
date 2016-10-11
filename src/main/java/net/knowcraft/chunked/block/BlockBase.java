package net.knowcraft.chunked.block;

import net.knowcraft.chunked.Chunked;
import net.knowcraft.chunked.helper.LogHelper;
import net.knowcraft.chunked.item.IItemModelProvider;
import net.knowcraft.chunked.reference.EnumOreType;
import net.knowcraft.chunked.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

/**
 * Created by oOMitchOo on 08.10.2016.
 */
public class BlockBase extends Block implements IItemModelProvider {

    protected String name;

    public BlockBase(Material material, String registryName) {
        super(material);

        this.name = registryName;

        setRegistryName(name);
        setUnlocalizedName(name);

        setCreativeTab(Reference.creativeTab);
    }

    @Override
    public void registerItemModel(ItemBlock item) {

        PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.<EnumDyeColor>create("color", EnumDyeColor.class);
        PropertyEnum<EnumOreType> ORETYPE = PropertyEnum.create("oretype", EnumOreType.class);


        if (item.getHasSubtypes()) {
            /** Hier müsste man von den SubTypes abhängig handeln. Für EnumDyeColor z. B. möchte
            *  man sicherlich, dass jeder SubType mit der passenden Texture gerendert wird.
            */
            // LogHelper.error(item.getBlock().getBlockState().getProperties().toString()); gibt aus:
            // [PropertyEnum{name=color, clazz=class net.minecraft.item.EnumDyeColor, values=[white, orange, magenta, lightBlue, yellow, lime, pink, gray, silver, cyan, purple, blue, brown, green, red, black]}]
            // Der Name ist also wichtig und muss auch "color" sein! Ausßerdem handelt es sich um eine Liste von Properties, deshalb wird contains aufgerufen.
            if (item.getBlock().getBlockState().getProperties().contains(COLOR))
            {
                // Eventuell ist hier bald eine case-Unterscheidung angebrachter.
                for (EnumDyeColor enumdyecolor : EnumDyeColor.values())
                {
                    // LogHelper.error(enumdyecolor.getUnlocalizedName());
                    Chunked.proxy.registerItemRenderer(item, enumdyecolor.getMetadata(), (item.getRegistryName().toString().substring(8) + "_" + enumdyecolor.getName()));
                }
            } else if (item.getBlock().getBlockState().getProperties().contains(ORETYPE))
            {
                for (EnumOreType enumoretype : EnumOreType.values())
                {
                    Chunked.proxy.registerItemRenderer(item, enumoretype.getMetadata(), (item.getRegistryName().toString().substring(8) + "_" + enumoretype.getName()));
                }
            }
        } else {
            // getRegistryName().toString() ist chunked:lighter_..._clay
            Chunked.proxy.registerItemRenderer(item, 0, item.getRegistryName().toString().substring(8));
        }
    }

    @Override
    public BlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}
