package net.onticentity.miasma.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {

    public static class Items {

        public static final TagKey<Item> REPAIRS_MIASRITE_TOOL = TagKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath("miasma", "repairs_miasrite_tool")
        );
    }
}