package net.voidbehemoth.UUAU;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.block.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.voidbehemoth.UUAU.common.blocks.HardenedSkylather;
import net.voidbehemoth.UUAU.common.blocks.SkylatherFoam;
import net.voidbehemoth.UUAU.common.entity.thrownskylathersoapbottle.ThrownSkylatherSoapBottleEntity;
import net.voidbehemoth.UUAU.common.items.SkylatherSoapBottleItem;

public class UpUpAndUpdate implements ModInitializer {
	public static final SkylatherFoam SKYLATHER_FOAM = new SkylatherFoam(Block.Settings.of(Material.SPONGE));
	public static final HardenedSkylather HARDENED_SKYLATHER = new HardenedSkylather(Block.Settings.of(Material.STONE));
	// an instance of our new item
	public static final SkylatherSoapBottleItem SKYLATHER_SOAP = new SkylatherSoapBottleItem(new Item.Settings().itemGroup(ItemGroup.MISC));
	public static final EntityType<ThrownSkylatherSoapBottleEntity> THROWN_SKYLATHER_SOAP = FabricEntityTypeBuilder.<ThrownSkylatherSoapBottleEntity>create(EntityCategory.CREATURE, ThrownSkylatherSoapBottleEntity::new).size(1, 1).build();

	@Override
	public void onInitialize()
	{
		Registry.register(Registry.ITEM, new Identifier("void-up-up", "skylather_soap"), SKYLATHER_SOAP);
		Registry.register(Registry.BLOCK, new Identifier("void-up-up", "skylather_foam"), SKYLATHER_FOAM);
		Registry.register(Registry.BLOCK, new Identifier("void-up-up", "hardened_skylather"), HARDENED_SKYLATHER);

		Registry.register(Registry.ITEM, new Identifier("void-up-up", "skylather_foam"), new BlockItem(SKYLATHER_FOAM, new Item.Settings()));
		Registry.register(Registry.ITEM, new Identifier("void-up-up", "hardened_skylather"), new BlockItem(HARDENED_SKYLATHER, new Item.Settings()));

		Registry.register(Registry.ENTITY_TYPE, new Identifier("void-up-up", "thrown_skylather_soap"), THROWN_SKYLATHER_SOAP);

	}
}
