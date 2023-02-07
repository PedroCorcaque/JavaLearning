package com.power.GameStats.libs.annotations;

import com.power.GameStats.libs.DiscordAutoConfiguration;
import com.power.GameStats.libs.beans.DiscordEventBeanProcessor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({DiscordAutoConfiguration.class, DiscordEventBeanProcessor.class})
public @interface EnableDiscord {
}
