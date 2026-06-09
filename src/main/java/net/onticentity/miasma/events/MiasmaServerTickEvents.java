package net.onticentity.miasma.events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.level.ServerPlayer;
import net.onticentity.miasma.world.level.biome.ModBiomes;

public class MiasmaServerTickEvents {

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                if (player.level().getBiome(player.blockPosition()).is(ModBiomes.MIASMA_WASTES)) {
                    System.out.println("Is in the Miasma");
                }
            }
        });
    }

}
