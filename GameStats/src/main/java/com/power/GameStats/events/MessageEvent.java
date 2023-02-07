package com.power.GameStats.events;

import com.power.GameStats.libs.annotations.DiscordEventListener;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MessageEvent {

    @DiscordEventListener
    public Mono<Message> pingCommand(MessageCreateEvent messageCreateEvent) {

        String BOT_ID = "1072547694821773312";
        String substring = null;

        Message msg = messageCreateEvent.getMessage();
        String message_content = msg.getContent();

        try {
            substring = message_content.substring(message_content.indexOf("@") + 1, message_content.indexOf(">"));
        } catch (Exception exception) {
            return Mono.empty();
        }

        if (substring.equals(BOT_ID)) {
            String filtered_string = message_content.substring(message_content.indexOf(">")+2);

            if ("ping".equals(filtered_string)) {
                return msg.getChannel()
                        .flatMap(channel -> channel.createMessage("Pong!"));
            }
            return Mono.empty();
        }
        return Mono.empty();
    }
}
