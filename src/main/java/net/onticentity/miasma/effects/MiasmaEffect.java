package net.onticentity.miasma.effects;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jspecify.annotations.NonNull;

import java.util.Objects;

public class MiasmaEffect extends MobEffect {

    private static final Identifier MIASMA_EFFECT =
            Identifier.fromNamespaceAndPath("miasma", "miasma_effect");

    public MiasmaEffect() {
        super(
                MobEffectCategory.HARMFUL,
                0x2D5A1B
        );
    }

    @Override
    public boolean applyEffectTick(@NonNull ServerLevel serverLevel, LivingEntity mob, int amplification) {
        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public void addAttributeModifiers(AttributeMap attributes, int amplifier) {
        Objects.requireNonNull(attributes.getInstance(Attributes.MAX_HEALTH))
                .addPermanentModifier(new AttributeModifier(
                        MIASMA_EFFECT,
                        -2.0 * (amplifier + 1),
                        AttributeModifier.Operation.ADD_VALUE
                ));
    }

    @Override
    public void removeAttributeModifiers(AttributeMap attributes) {
        Objects.requireNonNull(attributes.getInstance(Attributes.MAX_HEALTH))
                .removeModifier(MIASMA_EFFECT);
    }
}
