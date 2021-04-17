package br.com.bot;

import static java.lang.System.getenv;

import java.util.logging.Logger;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class BotMain {

    public static void main(String[] args) {
        Logger log = Logger.getLogger(BotMain.class.getName());

        ImcResponse imcResponse = new ImcResponse();
        ImcCommand imcCommand = new ImcCommand(imcResponse);

        DiscordApi api = new DiscordApiBuilder()
                .setToken(getenv("TOKEN"))
                .login()
                .join();

        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().startsWith("!imc")) {
                log.info("Received a new message, processing initialized!");

                String response = imcCommand.execute(event.getMessageContent());
                event.getChannel().sendMessage(response);

                log.info("Message processed, the process finished!");
            }
        });
    }

}
