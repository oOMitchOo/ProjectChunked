package net.knowcraft.chunked.block;

import net.knowcraft.chunked.Chunked;
import net.knowcraft.chunked.item.ItemModelProvider;
import net.knowcraft.chunked.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by oOMitchOo on 08.10.2016.
 */
public class BlockBase extends Block implements ItemModelProvider{

    protected String name;

    public BlockBase(Material material, String registryName) {
        super(material);

        this.name = registryName;

        setRegistryName(name);
        setUnlocalizedName(name);

        setCreativeTab(Reference.creativeTab);
    }

    @Override
    public void registerItemModel(Item item) {
        // Für die einzelnen Metadaten aufrufen löst das Problem, dass nur für weiß der ItemBlock gerendert wird.
        // Trotzdem sind sie alle weiß, haben keine Metadaten bei Mouse Over und fallen auf einen Stack zusammen.
        // ToDO: Schleife bauen, die alle 16 Renderer registriert.
        // getRegistryName().toString() ist chunked:lighter_..._clay
        Chunked.proxy.registerItemRenderer(item, 0, item.getRegistryName().toString().substring(8)+"_"+ EnumDyeColor.byMetadata(0).getName());
        Chunked.proxy.registerItemRenderer(item, 1, item.getRegistryName().toString().substring(8)+"_"+ EnumDyeColor.byMetadata(1).getName());
        Chunked.proxy.registerItemRenderer(item, 2, item.getRegistryName().toString().substring(8)+"_"+ EnumDyeColor.byMetadata(2).getName());
        Chunked.proxy.registerItemRenderer(item, 3, item.getRegistryName().toString().substring(8)+"_"+ EnumDyeColor.byMetadata(3).getName());
        Chunked.proxy.registerItemRenderer(item, 4, item.getRegistryName().toString().substring(8)+"_"+ EnumDyeColor.byMetadata(4).getName());
        Chunked.proxy.registerItemRenderer(item, 5, item.getRegistryName().toString().substring(8)+"_"+ EnumDyeColor.byMetadata(5).getName());
        Chunked.proxy.registerItemRenderer(item, 6, item.getRegistryName().toString().substring(8)+"_"+ EnumDyeColor.byMetadata(6).getName());
        Chunked.proxy.registerItemRenderer(item, 7, item.getRegistryName().toString().substring(8)+"_"+ EnumDyeColor.byMetadata(7).getName());
        Chunked.proxy.registerItemRenderer(item, 8, item.getRegistryName().toString().substring(8)+"_"+ EnumDyeColor.byMetadata(8).getName());
        Chunked.proxy.registerItemRenderer(item, 9, item.getRegistryName().toString().substring(8)+"_"+ EnumDyeColor.byMetadata(9).getName());
        Chunked.proxy.registerItemRenderer(item, 10, item.getRegistryName().toString().substring(8)+"_"+ EnumDyeColor.byMetadata(10).getName());
        Chunked.proxy.registerItemRenderer(item, 11, item.getRegistryName().toString().substring(8)+"_"+ EnumDyeColor.byMetadata(11).getName());
        Chunked.proxy.registerItemRenderer(item, 12, item.getRegistryName().toString().substring(8)+"_"+ EnumDyeColor.byMetadata(12).getName());
        Chunked.proxy.registerItemRenderer(item, 13, item.getRegistryName().toString().substring(8)+"_"+ EnumDyeColor.byMetadata(13).getName());
        Chunked.proxy.registerItemRenderer(item, 14, item.getRegistryName().toString().substring(8)+"_"+ EnumDyeColor.byMetadata(14).getName());
        Chunked.proxy.registerItemRenderer(item, 15, item.getRegistryName().toString().substring(8)+"_"+ EnumDyeColor.byMetadata(15).getName());
    }

    @Override
    public BlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}
