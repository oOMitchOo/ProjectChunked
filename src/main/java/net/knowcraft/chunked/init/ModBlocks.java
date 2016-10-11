package net.knowcraft.chunked.init;

import net.knowcraft.chunked.block.BlockClayOre;
import net.knowcraft.chunked.block.BlockLighterColored;
import net.knowcraft.chunked.item.ItemBlockClayOre;
import net.knowcraft.chunked.item.ItemBlockColored;
import net.knowcraft.chunked.item.IItemModelProvider;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by oOMitchOo on 07.10.2016.
 */
public class ModBlocks
{
    public static BlockLighterColored LIGHTER_STAINED_HARDENED_CLAY;
    public static BlockClayOre CLAY_ORE;

    public static void initAndRegister()
    {
        LIGHTER_STAINED_HARDENED_CLAY = registerColored(new BlockLighterColored("lighter_stained_hardened_clay"), "lighter_stained_hardened_clay");
        CLAY_ORE = registerClayOre(new BlockClayOre("clay_ore"), "clay_ore");
    }

    private static <T extends Block> T register(T block, ItemBlock itemBlockColored)
    {
        GameRegistry.register(block);

        if (itemBlockColored != null) {
            GameRegistry.register(itemBlockColored);

            if (block instanceof IItemModelProvider) {
                // In BlockBase um dann in ClientProxy die Methode aufzurufen.
                ((IItemModelProvider)block).registerItemModel(itemBlockColored);
            }
        }
        return block;
    }

    // Diese und nachfolgende Methode irgendwie zusammen schmeißen.
    private static <T extends Block> T registerColored(T block, String name)
    {
        ItemBlockColored itemBlockColored = new ItemBlockColored(block, name);

        return register(block, itemBlockColored);
    }

    private static <T extends Block> T registerClayOre(T block, String name)
    {
        ItemBlockClayOre itemBlockClayOre = new ItemBlockClayOre(block, name);

        return register(block, itemBlockClayOre);
    }
}
