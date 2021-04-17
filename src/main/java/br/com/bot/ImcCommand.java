package br.com.bot;

import static br.com.bot.ImcRange.getImcRange;
import static java.lang.Double.parseDouble;

import java.util.Optional;

public class ImcCommand {

    private final ImcResponse imcResponse;

    public ImcCommand(ImcResponse imcResponse) {
        this.imcResponse = imcResponse;
    }

    public String execute(String message) {
        String[] separatedParameters = message.split(" ");

        String name = separatedParameters[1];
        double height = parseDouble(separatedParameters[2]);
        double weight = parseDouble(separatedParameters[3]);

        double userIMC = calculateUserIMC(height, weight);
        Optional<ImcRange> imcRange = getImcRange(userIMC);

        return imcResponse.createResponse(name, userIMC, imcRange);
    }

    private double calculateUserIMC(double height, double weight) {
        return Math.round(weight / (height * height));
    }

}
