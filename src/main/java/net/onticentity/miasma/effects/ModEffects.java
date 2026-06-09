package net.onticentity.miasma.effects;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;

public class ModEffects {

    public static Holder<MobEffect> MIASMA;

    public static void register() {
        MIASMA = Registry.registerForHolder(
                BuiltInRegistries.MOB_EFFECT,
                Identifier.fromNamespaceAndPath("miasma", "miasma_effect"),
                new MiasmaEffect()
        );
    }
}
