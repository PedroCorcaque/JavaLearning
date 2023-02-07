package com.power.GameStats.libs;

import com.power.GameStats.libs.exceptions.MissingTokenConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

public class DiscordTokenAutoConfiguration {
    private final static Logger LOGGER = LoggerFactory.getLogger(DiscordTokenAutoConfiguration.class);

    @Bean("discordTokenProvider")
    @ConditionalOnMissingBean
    public DiscordTokenProvider tokenProvider(@Value("${discord.token:#{null}}") String token) {
        LOGGER.debug("token {}.", token);
        if (token == null) {
            throw new MissingTokenConfiguration();
        }
        return () -> token;
    }
}