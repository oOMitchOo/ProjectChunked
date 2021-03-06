package net.knowcraft.chunked.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by oOMitchOo on 07.10.2016.
 */

// BlockColored überarbeiten für mehr Hardened_Clay Farben.
public class BlockLighterColored extends BlockBase {

    private static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.<EnumDyeColor>create("color", EnumDyeColor.class);

    public BlockLighterColored(String name)
    {
        super(Material.ROCK, name);
        this.setSoundType(SoundType.STONE);
        this.setHardness(1.25F);
        this.setResistance(7.0F);

        this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumDyeColor.WHITE));
    }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    @Override
    public int damageDropped(IBlockState state)
    {
        return ((EnumDyeColor)state.getValue(COLOR)).getMetadata();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (EnumDyeColor enumdyecolor : EnumDyeColor.values())
        {
            list.add(new ItemStack(itemIn, 1, enumdyecolor.getMetadata()));
        }
    }

    /**
     * Get the MapColor for this Block and the given BlockState
     * Warum veraltet? Verstehe ich nicht... ist doch für die ingame Minimap wichtig?
     */
    @Override
    public MapColor getMapColor(IBlockState state)
    {
        return ((EnumDyeColor)state.getValue(COLOR)).getMapColor();
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     * Anscheinend veraltet? Test ohne die Methode hat ergeben:
     * Alles funktioniert nur die breaking particles haben für alle
     * Blöcke die Standard-Farbe. -merkwürdig-
     */
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(meta));
    }

    /**
     * Tut eigentlich das selbe wie die Super-Methode, aber
     * ich habe sie von der eigentlich schon veralteten Methode
     * getStateFromMeta(int meta) unabhängig gemacht.
     */
    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        // veraltet:
        // return this.getStateFromMeta(meta);
        return this.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumDyeColor)state.getValue(COLOR)).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {COLOR});
    }
}
