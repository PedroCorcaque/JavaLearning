package com.power.GameStats.libs.beans;

import com.power.GameStats.libs.annotations.DiscordErrorHandler;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public class EventUtils {

    public static void doOnError(Object bean, Object error) {
        Optional<Method> errorHandler = Arrays.stream(bean.getClass().getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(DiscordErrorHandler.class))
                .findFirst();

        errorHandler.ifPresent(m -> ReflectionUtils.invokeMethod(m, bean, error));
    }
}
