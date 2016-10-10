package net.knowcraft.chunked.init;

import net.knowcraft.chunked.block.BlockLighterColored;
import net.knowcraft.chunked.helper.LogHelper;
import net.knowcraft.chunked.item.ItemBlockColored;
import net.knowcraft.chunked.item.ItemModelProvider;
import net.knowcraft.chunked.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by oOMitchOo on 07.10.2016.
 */
public class ModBlocks
{
    public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.<EnumDyeColor>create("color", EnumDyeColor.class);

    public static BlockLighterColored LIGHTER_STAINED_HARDENED_CLAY;

    public static void initAndRegister()
    {
        LIGHTER_STAINED_HARDENED_CLAY = register(new BlockLighterColored("lighter_stained_hardened_clay"), "lighter_stained_hardened_clay");
    }

    private static <T extends Block> T register(T block, ItemBlock itemBlockC)
    {
        GameRegistry.register(block);

        if (itemBlockC != null) {
            GameRegistry.register(itemBlockC);

            if (block instanceof ItemModelProvider) {
                // In BlockBase um dann in ClientProxy die Methode aufzurufen.
                ((ItemModelProvider)block).registerItemModel(itemBlockC);
            }
        }
        return block;
    }

    private static <T extends Block> T register(T block, String name)
    {
        ItemBlockColored itemBlockC = new ItemBlockColored(block, name);

        /*
        ItemBlock itemBlock = new ItemBlock(block);
        // TÄST TÄST TÄST TÄST TÄST
        // OH WUNDER! Plötzlich gibt es Metadaten für die Blöcke!
        itemBlock.setHasSubtypes(true);
        itemBlock.setUnlocalizedName(name);
        itemBlock.setRegistryName(name);
        */

        return register(block, itemBlockC);
    }
}
