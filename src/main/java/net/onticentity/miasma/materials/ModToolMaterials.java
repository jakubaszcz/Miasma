package net.onticentity.miasma.materials;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;
import net.onticentity.miasma.tags.ModTags;

public class ModToolMaterials {

    public static final ToolMaterial MIASRITE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2500,
            9.0F,
            6F,
            20,
            ModTags.Items.REPAIRS_MIASRITE_TOOL
    );
}
