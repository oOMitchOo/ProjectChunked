package net.knowcraft.chunked.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
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

// registerBlock(172, "hardened_clay", (new BlockHardenedClay()).setHardness(1.25F).setResistance(7.0F).setSoundType(SoundType.STONE).setUnlocalizedName("clayHardened"));
// registerBlock(159, "stained_hardened_clay", (new BlockColored(Material.ROCK)).setHardness(1.25F).setResistance(7.0F).setSoundType(SoundType.STONE).setUnlocalizedName("clayHardenedStained"));

// BlockColored überarbeiten für mehr Hardened_Clay Farben.
public class BlockLighterColored extends BlockBase {

    public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.<EnumDyeColor>create("color", EnumDyeColor.class);
    // public static final PropertyInteger LIGHT_LEVEL = PropertyInteger.create("lightLevel", 1, 2);

    public BlockLighterColored(String name)
    {
        super(Material.ROCK, name);
        // Der Default-State macht keinen Unterschied. Default ist anscheinend auch für BLACK White.
        this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumDyeColor.WHITE));


        this.setHardness(1.25F);
        this.setResistance(7.0F);
        this.setSoundType(SoundType.STONE);
    }

    @Override
    public BlockLighterColored setCreativeTab(CreativeTabs tab)
    {
        super.setCreativeTab(tab);
        return this;
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
     */
    @Override
    public MapColor getMapColor(IBlockState state)
    {
        return ((EnumDyeColor)state.getValue(COLOR)).getMapColor();
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(meta));
    }

    // Wahrscheinlich überflüssig, da die Super-Klasse das Selbe tut.
    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        // return this.getStateFromMeta(meta);
        return this.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(meta));
    }

    /*
    // Test, ob es überhaupt diesen Block mit einer anderen Farbe gibt. Test erfolgreich.
    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
        worldIn.setBlockState(pos, this.getDefaultState().withProperty(COLOR, EnumDyeColor.BLACK));
    }
    */

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
