package net.knowcraft.chunked.item;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
        if(damage >= 0 && damage < 16)return damage;
        else return 0;
    }

    /**
     * Returns the unlocalized name of this item.
     */
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return (this.block.getUnlocalizedName() + "." + EnumDyeColor.byMetadata(stack.getMetadata()));
    }
}
