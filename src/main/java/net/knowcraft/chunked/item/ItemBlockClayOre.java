package net.knowcraft.chunked.item;

import net.knowcraft.chunked.reference.EnumOreType;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by oOMitchOo on 10.10.2016.
 */
public class ItemBlockClayOre extends ItemBlock {

    public ItemBlockClayOre(Block block, String registryName) {
        super(block);
        this.setRegistryName(registryName);
        this.setUnlocalizedName(registryName);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage)
    {
        if (damage >= 0 && damage < 7) return damage;
        else return 0;
    }

    /**
     * Returns the unlocalized name of this item.
     */
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return (this.block.getUnlocalizedName() + "." + EnumOreType.byMetadata(stack.getMetadata()));
    }
}
