package com.power.GameStats.libs;

import com.power.GameStats.libs.annotations.EnableDiscord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.EventDispatcher;
import discord4j.core.shard.GatewayBootstrap;
import discord4j.gateway.GatewayOptions;

@Configuration
@Import(DiscordTokenAutoConfiguration.class)
@ConditionalOnBean(annotation = EnableDiscord.class)
public class DiscordAutoConfiguration extends DiscordClientConfig {

    @Bean("discordClient")
    @ConditionalOnMissingBean
    public DiscordClient discordClient(DiscordTokenProvider tokenProvider) {
        String token = tokenProvider.getToken();
        return DiscordClientBuilder.create(tokenProvider.getToken()).build();
    }

    @Bean("eventDispatcher")
    @ConditionalOnMissingBean
    public EventDispatcher eventDispatcher() {
        return EventDispatcher.builder().build();
    }

    @Bean
    @DependsOn({"discordClient", "eventDispatcher", "discordEventBeanProcessor"})
    @ConditionalOnMissingBean
    public GatewayDiscordClient gatewayDiscordClient(DiscordClient discordClient, EventDispatcher eventDispatcher) {
        GatewayBootstrap<GatewayOptions> gateway = discordClient.gateway();
        return gateway
                .setEventDispatcher(eventDispatcher)
                .login()
                .doOnNext(t -> awaitThread(t).awaitThread().start())
                .block();
    }
}