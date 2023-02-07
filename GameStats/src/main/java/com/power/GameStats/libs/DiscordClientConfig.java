package com.power.GameStats.libs;

import discord4j.core.GatewayDiscordClient;

public abstract class DiscordClientConfig {

    AwaitThreadProvider awaitThread(GatewayDiscordClient gatewayDiscordClient) {
        return () -> {
            Thread awaitThread = new Thread("discord") {
                @Override
                public void run() {
                    gatewayDiscordClient.onDisconnect().block();
                }
            };
            awaitThread.setContextClassLoader(getClass().getClassLoader());
            awaitThread.setDaemon(false);
            return awaitThread;
        };
    }

    @FunctionalInterface
    interface AwaitThreadProvider {
        Thread awaitThread();
    }
}