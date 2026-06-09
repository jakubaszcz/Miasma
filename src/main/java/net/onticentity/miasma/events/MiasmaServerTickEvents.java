package net.onticentity.miasma.events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.onticentity.miasma.effects.ModEffects;
import net.onticentity.miasma.world.level.biome.ModBiomes;

public class MiasmaServerTickEvents {

    private static final int EFFECT_DURATION = 220;
    private static final int INTERVAL = 200; // 10 secondes
    private static final int MAX_AMPLIFIER = 4;

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {

            for (ServerPlayer player : server.getPlayerList().getPlayers()) {

                 if (player.isCreative() || player.isSpectator()) {
                    continue;
                }

                boolean inBiome = player.level().getBiome(player.blockPosition()).is(ModBiomes.MIASMA_WASTES);

                if (!inBiome) {
                    continue;
                }

                MobEffectInstance effect = player.getEffect(ModEffects.MIASMA);

                int amplifier = effect == null ? 0 : effect.getAmplifier();

                if (server.getTickCount() % INTERVAL == 0 && amplifier < MAX_AMPLIFIER) {
                    amplifier++;
                }

                player.addEffect(new MobEffectInstance(
                        ModEffects.MIASMA,
                        EFFECT_DURATION,
                        amplifier,
                        true,
                        true,
                        true
                ));
            }
        });
    }
}
