package com.example.example_mod;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

// import com.ibm.icu.util.Region;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ExampleModItems {
	public static final Item EXAMPLE_ITEM = new Item(new QuiltItemSettings());
	public static final Block EXAMPLE_BLOCK = new Block(QuiltBlockSettings.create());

	public static void register(ModContainer mod) {
		Registry.register(Registries.BLOCK, new Identifier(mod.metadata().id(), "example_block"), EXAMPLE_BLOCK);
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "example_block"), new BlockItem(EXAMPLE_BLOCK, new QuiltItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "example_item"), EXAMPLE_ITEM);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.addItem(EXAMPLE_ITEM);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
			entries.addItem(EXAMPLE_BLOCK.asItem());
		});
	}

}
