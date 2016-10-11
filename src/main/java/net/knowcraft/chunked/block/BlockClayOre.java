package net.knowcraft.chunked.block;

import net.knowcraft.chunked.reference.EnumOreType;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by oOMitchOo on 10.10.2016.
 */
public class BlockClayOre extends BlockBase{
    private static final PropertyEnum<EnumOreType> ORETYPE = PropertyEnum.create("oretype", EnumOreType.class);

    public BlockClayOre(String registryName) {
        super(Material.ROCK, registryName);
        this.setSoundType(SoundType.STONE);
        this.setHardness(1.25F);
        this.setResistance(7.0F);

        this.setDefaultState(this.blockState.getBaseState().withProperty(ORETYPE, EnumOreType.COAL));
    }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    @Override
    public int damageDropped(IBlockState state)
    {
        return ((EnumOreType)state.getValue(ORETYPE)).getMetadata();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (EnumOreType enumoretype : EnumOreType.values())
        {
            list.add(new ItemStack(itemIn, 1, enumoretype.getMetadata()));
        }
    }

    /**
     * Get the MapColor for this Block and the given BlockState
     * Warum veraltet? Verstehe ich nicht... ist doch für die ingame Minimap wichtig?
     */
    @Override
    public MapColor getMapColor(IBlockState state)
    {
        return ((EnumOreType)state.getValue(ORETYPE)).getMapColor();
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
        return this.getDefaultState().withProperty(ORETYPE, EnumOreType.byMetadata(meta));
    }

    /**
     * Tut eigentlich das selbe wie die Super-Methode, aber
     * ich habe sie von der eigentlich schon veralteten Methode
     * getStateFromMeta(int meta) unabhängig gemacht.
     */
    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        // veraltet ersetzt:
        // return this.getStateFromMeta(meta);
        return this.getDefaultState().withProperty(ORETYPE, EnumOreType.byMetadata(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumOreType)state.getValue(ORETYPE)).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {ORETYPE});
    }
}
