package br.com.bot;

import static br.com.bot.ImcRange.getImcRange;
import static br.com.bot.Log.error;
import static br.com.bot.Log.warning;
import static java.lang.Double.parseDouble;
import static java.lang.String.format;

import java.util.Optional;

public class ImcCommand {

    private static final int PARAMETERS_LIMIT = 4;

    private final ImcResponse imcResponse;
    private final MessagesProperties messagesProperties;

    public ImcCommand(ImcResponse imcResponse, MessagesProperties messagesProperties) {
        this.imcResponse = imcResponse;
        this.messagesProperties = messagesProperties;
    }

    public String execute(String message) {
        String[] separatedParameters = message.split(" ");

        if (separatedParameters.length != PARAMETERS_LIMIT) {
            warning("Total of parameters received doesn't supported!");
            return format("%s\n%s", messagesProperties.getExceededParameters(), messagesProperties.getUsage());
        }

        String name = separatedParameters[1];
        double height;
        double weight;

        try {
            height = parseDouble(separatedParameters[2]);
            weight = parseDouble(separatedParameters[3]);
        } catch(NumberFormatException ex) {
            error("Received invalid height or weight parameters!".concat("Error: ").concat(ex.getLocalizedMessage()));
            return format("%s\n%s", messagesProperties.getInvalidNumber(), messagesProperties.getUsage());
        }

        double userIMC = calculateUserIMC(height, weight);
        Optional<ImcRange> imcRange = getImcRange(userIMC);

        return imcResponse.createResponse(name, userIMC, imcRange, messagesProperties);
    }

    private double calculateUserIMC(double height, double weight) {
        return Math.round(weight / (height * height));
    }

}
