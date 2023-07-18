package com.ewyboy.neotech.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.ewyboy.neotech.NeoTech.MOD_ID;
import static com.ewyboy.neotech.register.Registry.BLOCKS.NEO_BLOCK;

public class Registry {
    
    public static void init(IEventBus bus) {
        BLOCKS.BLOCKS.register(bus);
        ITEMS.ITEMS.register(bus);
        BLOCK_ENTITIES.BLOCK_ENTITIES.register(bus);
        CREATIVE_TABS.CREATIVE_TABS.register(bus);
    }

    public static final class CREATIVE_TABS {

        public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

        public static final RegistryObject<CreativeModeTab> NEO_TAB = CREATIVE_TABS.register("neo_tab", () -> CreativeModeTab.builder()
                .title(Component.literal("Neo Tech"))
                .icon(() -> ITEMS.NEO_BLOCK_ITEM.get().getDefaultInstance())
                .displayItems(
                        (parameters, output) -> {
                            output.accept(ITEMS.NEO_ITEM.get().asItem().getDefaultInstance());
                            output.accept(ITEMS.NEO_BLOCK_ITEM.get().getDefaultInstance());
                        })
                .build()
        );

    }

    public static final class BLOCKS {

        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

        public static final RegistryObject<Block> NEO_BLOCK = BLOCKS.register("neo_block", () ->
                new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE))
        );

    }

    public static final class ITEMS {

        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

        public static final RegistryObject<Item> NEO_BLOCK_ITEM = ITEMS.register("neo_itemblock", () ->
                new BlockItem(NEO_BLOCK.get(), new Item.Properties())
        );

        public static final RegistryObject<Item> NEO_ITEM = ITEMS.register("neo_item", () ->
                new Item(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().nutrition(1).saturationMod(2f).build()))
        );

    }

    public static final class BLOCK_ENTITIES {
        public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MOD_ID);
    }
    
}
