package br.com.bot;

import static java.lang.String.format;

import java.util.Optional;

public class ImcResponse {

    public String createResponse(String username, double userImc, Optional<ImcRange> imcRange, MessagesProperties messagesProperties) {
        String message = imcRange.isPresent() ? imcRange.get().getMessage() : messagesProperties.getResponseUnrecognized();
        return format("%s seu IMC é: %s\n%s", username, userImc, message);
    }

}
