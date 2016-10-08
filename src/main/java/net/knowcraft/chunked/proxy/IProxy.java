package net.knowcraft.chunked.proxy;

import net.minecraft.item.Item;

/**
 * Created by oOMitchOo on 04.10.2016.
 */
public interface IProxy
{

    void registerItemRenderer(Item item, int meta, String id);


}
