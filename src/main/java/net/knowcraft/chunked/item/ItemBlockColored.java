package net.knowcraft.chunked.item;

import net.knowcraft.chunked.helper.LogHelper;
import net.knowcraft.chunked.reference.EnumOreType;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.Collection;

/**
 * Created by oOMitchOo on 10.10.2016.
 */
public class ItemBlockColored extends ItemBlock {

    public ItemBlockColored(Block block, String registryName) {
        super(block);
        this.setRegistryName(registryName);
        this.setUnlocalizedName(registryName);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage)
    {
        if (damage >= 0 && damage < 16) return damage;
        else return 0;
        /*
        if(this.getBlock().getBlockState().getProperties().contains(COLOR) && damage >= 0 && damage < 16){ return damage; }
        else if(this.getBlock().getBlockState().getProperties().contains(ORETYPE) && damage >= 0 && damage < 7)return damage;
        else return 0;
        */
    }

    /**
     * Returns the unlocalized name of this item.
     */
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return (this.block.getUnlocalizedName() + "." + EnumDyeColor.byMetadata(stack.getMetadata()));

        /*if (this.getBlock().getBlockState().getProperties().contains(COLOR)) { return (this.block.getUnlocalizedName() + "." + EnumDyeColor.byMetadata(stack.getMetadata())); }
        else if (this.getBlock().getBlockState().getProperties().contains(ORETYPE)) { return (this.block.getUnlocalizedName() + "." + EnumOreType.byMetadata(stack.getMetadata())); }
        else return this.block.getUnlocalizedName(); */
    }

}
