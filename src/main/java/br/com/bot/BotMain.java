package br.com.bot;

import static java.lang.System.getenv;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class BotMain {

    public static void main(String[] args) {
        ImcResponse imcResponse = new ImcResponse();
        ImcCommand imcCommand = new ImcCommand(imcResponse);

        DiscordApi api = new DiscordApiBuilder()
                .setToken(getenv("TOKEN"))
                .login()
                .join();

        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().startsWith("!imc")) {
                String response = imcCommand.execute(event.getMessageContent());
                event.getChannel().sendMessage(response);
            }
        });
    }

}
