package net.onticentity.miasma.materials;

import com.google.common.collect.Maps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.onticentity.miasma.Miasma;

import java.util.Map;

public class ModArmorMaterials {
    public static final int BASE_DURABILITY = 47;
    // #endregion base_durability

    // #region material_key
    public static final ResourceKey<EquipmentAsset> GUIDITE_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Miasma.MOD_ID, "miasrite"));
    // #endregion material_key

    // #region repair_tag
    public static final TagKey<Item> REPAIRS_MIASRITE_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(Miasma.MOD_ID, "repairs_miasritee_armor"));
    // #endregion repair_tag

    // #region guidite_armor_material
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 5,
                    ArmorType.CHESTPLATE, 10,
                    ArmorType.LEGGINGS, 8,
                    ArmorType.BOOTS, 4
            ),
            5,
            SoundEvents.ARMOR_EQUIP_IRON,
            4.0F,
            0.3F,
            REPAIRS_MIASRITE_ARMOR,
            GUIDITE_ARMOR_MATERIAL_KEY
    );

}
