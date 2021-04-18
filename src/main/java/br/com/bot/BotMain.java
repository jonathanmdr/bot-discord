package br.com.bot;

import static br.com.bot.Log.info;
import static java.lang.System.getenv;

import java.io.IOException;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class BotMain {

    public static void main(String[] args) throws IOException {
        PropertiesReader propertiesReader = new PropertiesReader();
        MessagesProperties messagesProperties = propertiesReader.getMessageProperties();
        ImcCommand imcCommand = new ImcCommand(messagesProperties);

        DiscordApi api = new DiscordApiBuilder()
                .setToken(getenv("TOKEN"))
                .login()
                .join();

        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().startsWith("!imc")) {
                info("Received a new message, processing initialized!");

                String response = imcCommand.execute(event.getMessageContent());
                event.getChannel().sendMessage(response);

                info("Message processed, the process finished!");
            }
        });
    }

}
