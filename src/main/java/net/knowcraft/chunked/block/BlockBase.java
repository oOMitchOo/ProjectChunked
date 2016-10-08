package net.knowcraft.chunked.block;

import net.knowcraft.chunked.Chunked;
import net.knowcraft.chunked.item.ItemModelProvider;
import net.knowcraft.chunked.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by oOMitchOo on 08.10.2016.
 */
public class BlockBase extends Block implements ItemModelProvider{

    protected String name;

    public BlockBase(Material material, String name) {
        super(material);

        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);

        setCreativeTab(Reference.creativeTab);
    }

    @Override
    public void registerItemModel(Item item) {
        // Für die einzelnen Metadaten aufrufen löst das Problem, dass nur für weiß der ItemBlock gerendert wird.
        // Trotzdem sind sie alle weiß, haben keine Metadaten bei Mouse Over und fallen auf einen Stack zusammen.
        // ToDO: Schleife bauen, die alle 16 Renderer registriert.
        Chunked.proxy.registerItemRenderer(item, 0, name);
        Chunked.proxy.registerItemRenderer(item, 1, name);
        Chunked.proxy.registerItemRenderer(item, 2, name);
        Chunked.proxy.registerItemRenderer(item, 3, name);
        Chunked.proxy.registerItemRenderer(item, 4, name);
        Chunked.proxy.registerItemRenderer(item, 5, name);
        Chunked.proxy.registerItemRenderer(item, 6, name);
        Chunked.proxy.registerItemRenderer(item, 7, name);
        Chunked.proxy.registerItemRenderer(item, 8, name);
        Chunked.proxy.registerItemRenderer(item, 9, name);
        Chunked.proxy.registerItemRenderer(item, 10, name);
        Chunked.proxy.registerItemRenderer(item, 11, name);
        Chunked.proxy.registerItemRenderer(item, 12, name);
        Chunked.proxy.registerItemRenderer(item, 13, name);
        Chunked.proxy.registerItemRenderer(item, 14, name);
        Chunked.proxy.registerItemRenderer(item, 15, name);
    }

    @Override
    public BlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
