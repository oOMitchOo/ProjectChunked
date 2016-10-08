package net.knowcraft.chunked.client;

import net.knowcraft.chunked.init.ModBlocks;
import net.knowcraft.chunked.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by oOMitchOo on 08.10.2016.
 */
public class ModCreativeTab extends CreativeTabs {

    public ModCreativeTab() {
        super(Reference.MOD_ID);
    }


    @Override
    public Item getTabIconItem() {

        return Item.getItemFromBlock(ModBlocks.LIGHTER_STAINED_HARDENED_CLAY);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
