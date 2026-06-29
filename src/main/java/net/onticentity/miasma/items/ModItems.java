package net.onticentity.miasma.items;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.onticentity.miasma.Miasma;
import net.onticentity.miasma.materials.ModToolMaterials;

import java.util.function.Function;

public class ModItems {

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Miasma.MOD_ID, name));

        // Create the item instance.
        T item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static final Item MIASRITE_ECHO = register("miasrite_echo", Item::new, new Item.Properties());

    public static final Item MIASRITE_SPEAR = register("miasrite_spear", Item::new, new Item.Properties().spear(ModToolMaterials.MIASRITE, 1.35F, 1.4F, 0.25F, 1.5F, 7.0F, 5F, 5.1F, 7.25F, 4.6F).fireResistant());

    public static final Item MIASRITE_SWORD = register("miasrite_sword", Item::new, new Item.Properties().sword(ModToolMaterials.MIASRITE, 3.0F, -2.4F).fireResistant());
    public static final Item MIASRITE_PICKAXE = register("miasrite_pickaxe", Item::new, new Item.Properties().pickaxe(ModToolMaterials.MIASRITE, 1.0F, -2.8F).fireResistant());
    public static final Item MIASRITE_AXE = register("miasrite_axe", (p) -> new AxeItem(ToolMaterial.NETHERITE, 6.0F, -3.0F, p), (new Item.Properties()).fireResistant());
    public static final Item MIASRITE_HOE = register("miasrite_hoe", (p) -> new HoeItem(ToolMaterial.NETHERITE, -4.0F, 0.0F, p), (new Item.Properties()).fireResistant());
    public static final Item MIASRITE_SHOVEL = register("miasrite_shovel", (p) -> new ShovelItem(ToolMaterial.NETHERITE, -4.0F, 0.0F, p), (new Item.Properties()).fireResistant());

    public static void initialize() {
    }

}
