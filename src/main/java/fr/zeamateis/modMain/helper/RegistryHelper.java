package fr.zeamateis.modMain.helper;

import com.leviathanstudio.craftstudio.common.animation.simpleImpl.CSTileEntitySpecialRenderer;

import fr.zeamateis.modMain.ExampleModMain;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


/**This class is an... helper... for a more easy way in registration*/
public class RegistryHelper
{

    public static class EMMBlocks
    {
        public void register(RegistryEvent.Register<Block> event, Block blockIn) {
            event.getRegistry().register(blockIn);
        }

        public void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String key) {
            GameRegistry.registerTileEntity(tileEntityClass, String.format("%s:%s", ExampleModMain.MODID, key));
        }

        public static <T extends TileEntity> void bindTESR(Class<T> tileEntityClass, String modelName, int textureSizeX, int textureSizeY) {
            ClientRegistry.bindTileEntitySpecialRenderer(tileEntityClass, new CSTileEntitySpecialRenderer(ExampleModMain.MODID, modelName,
                    textureSizeX, textureSizeY, new ResourceLocation(ExampleModMain.MODID, String.format("textures/block/%s.png", modelName))));
        }

        public static <T extends TileEntity> void bindTESR(Class<T> tileEntityClass, String modelName, int textureSizeXY) {
            ClientRegistry.bindTileEntitySpecialRenderer(tileEntityClass, new CSTileEntitySpecialRenderer(ExampleModMain.MODID, modelName,
                    textureSizeXY, textureSizeXY, new ResourceLocation(ExampleModMain.MODID, String.format("textures/block/%s.png", modelName))));
        }
    }

    public static class EMMItems
    {
        public void register(RegistryEvent.Register<Item> event, Item itemIn) {
            event.getRegistry().register(itemIn);
        }

        @SideOnly(Side.CLIENT)
        public void registerModel(Item item, String nameIn, int metadata) {
            ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(ExampleModMain.MODID + ":" + nameIn, "inventory"));
        }
    }

    public static class EMMEntities
    {
        public static int entityID = 0;

        /**
         * Create an {@link EntityEntryBuilder} with the specified
         * unlocalised/registry name and an automatically-assigned network ID.
         *
         * @param name
         *            The name
         * @param <E>
         *            The entity type
         * @return The builder
         */
        public static <E extends Entity> EntityEntryBuilder<E> createBuilder(final String name) {
            final EntityEntryBuilder<E> builder = EntityEntryBuilder.create();
            final ResourceLocation registryName = new ResourceLocation(ExampleModMain.MODID, name);
            return builder.id(registryName, entityID++).name(registryName.toString());
        }

        /**
         * Get an array of {@link Biome}s with the specified
         * {@link BiomeDictionary.Type}.
         *
         * @param type
         *            The Type
         * @return An array of Biomes
         */
        public static Biome[] getBiomes(final BiomeDictionary.Type type) {
            return BiomeDictionary.getBiomes(type).toArray(new Biome[0]);
        }

        /**
         * Add a spawn list entry for {@code classToAdd} in each {@link Biome}
         * with an entry for {@code classToCopy} using the same weight and group
         * count.
         *
         * @param classToAdd
         *            The class to add spawn entries for
         * @param creatureTypeToAdd
         *            The EnumCreatureType to add spawn entries for
         * @param classToCopy
         *            The class to copy spawn entries from
         * @param creatureTypeToCopy
         *            The EnumCreatureType to copy spawn entries from
         */
        public static void copySpawns(final Class<? extends EntityLiving> classToAdd, final EnumCreatureType creatureTypeToAdd,
                final Class<? extends EntityLiving> classToCopy, final EnumCreatureType creatureTypeToCopy) {
            for (final Biome biome : ForgeRegistries.BIOMES) {
                biome.getSpawnableList(creatureTypeToCopy).stream().filter(entry -> entry.entityClass == classToCopy).findFirst()
                        .ifPresent(spawnListEntry -> biome.getSpawnableList(creatureTypeToAdd).add(new Biome.SpawnListEntry(classToAdd,
                                spawnListEntry.itemWeight, spawnListEntry.minGroupCount, spawnListEntry.maxGroupCount)));
            }
        }
    }
}