package br.com.bot;

import static java.lang.String.format;

import java.util.Optional;

public class ImcResponse {

    public String createResponse(String username, double userImc, Optional<ImcRange> imcRange) {
        String message = "Seus dados não fazem sentido, tu é normal?!";

        if (imcRange.isPresent()) {
            message = imcRange.get().getStatus();
        }
        return format("%s seu IMC é: %s \n %s", username, userImc, message);
    }

}
