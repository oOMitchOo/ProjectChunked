package net.knowcraft.chunked.proxy;

import net.knowcraft.chunked.init.ModBlocks;
import net.knowcraft.chunked.reference.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Created by oOMitchOo on 04.10.2016.
 */
public class ClientProxy extends CommonProxy
{

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MOD_ID+":"+id, "inventory"));
    }

}
