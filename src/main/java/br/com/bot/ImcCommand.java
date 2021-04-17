package br.com.bot;

import static br.com.bot.ImcRange.getImcRange;
import static java.lang.Double.parseDouble;

import java.util.Optional;
import java.util.logging.Logger;

public class ImcCommand {

    private static final int TOTAL_PARAMETERS = 4;

    private static Logger log = Logger.getLogger(ImcCommand.class.getName());

    private final ImcResponse imcResponse;

    public ImcCommand(ImcResponse imcResponse) {
        this.imcResponse = imcResponse;
    }

    public String execute(String message) {
        String[] separatedParameters = message.split(" ");

        if (separatedParameters.length != TOTAL_PARAMETERS) {
            log.warning("Total of parameters received doesn't supported!");
            return "Não consegui entender sua mensagem =( \n Me envie novamente seguindo o seguinte formato: `!imc {nome} {altura} {peso}`";
        }

        String name = separatedParameters[1];
        double height;
        double weight;

        try {
            height = parseDouble(separatedParameters[2]);
            weight = parseDouble(separatedParameters[3]);
        } catch(NumberFormatException ex) {
            log.warning("Received invalid height or weight parameters!");
            return "Não consigo usar os parâmetros que você me passou para calcular seu IMC =/";
        }

        double userIMC = calculateUserIMC(height, weight);
        Optional<ImcRange> imcRange = getImcRange(userIMC);

        return imcResponse.createResponse(name, userIMC, imcRange);
    }

    private double calculateUserIMC(double height, double weight) {
        return Math.round(weight / (height * height));
    }

}
