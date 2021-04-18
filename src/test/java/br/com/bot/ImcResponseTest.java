package br.com.bot;

import static br.com.bot.ImcResponse.response;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

public class ImcResponseTest {

    private MessagesProperties messagesProperties;

    @Before
    public void init() {
        messagesProperties = new MessagesProperties(
                "Não consegui entender sua mensagem! =(",
                "Não consigo usar os parâmetros que você me passou para calcular seu IMC! =/",
                "Me envie outra mensagem no seguinte formato: `!imc {nome} {altura} {peso}`",
                "Seus dados não fazem sentido, tu é normal?!"
        );
    }

    @Test
    public void createResponse_whenReceivedAValidImcRange_thenReturnUserImcMessage() {
        Optional<ImcRange> imcRange = ImcRange.getImcRange(26.0);
        String response = response("%s seu IMC é: %s\n%s", "Jonathan", 26.0, imcRange.get().getMessage());

        assertThat(
            "Jonathan seu IMC é: 26.0" + "\n" +
            "Tu tá bem, anda malhando?"
        ).isEqualTo(response);
    }

    @Test
    public void createResponse_whenReceivedAInvalidImcRange_thenReturnResponseUnrecognizedMessage() {
        String response = response("%s seu IMC é: %s\n%s", "Jonathan", -1, messagesProperties.getResponseUnrecognized());

        assertThat(
            "Jonathan seu IMC é: -1" + "\n" +
            "Seus dados não fazem sentido, tu é normal?!"
        ).isEqualTo(response);
    }

}
