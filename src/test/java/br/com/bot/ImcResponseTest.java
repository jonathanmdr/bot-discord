package br.com.bot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

public class ImcResponseTest {

    private MessagesProperties messagesProperties;
    private ImcResponse subject;

    @Before
    public void init() {
        messagesProperties = new MessagesProperties(
                "Não consegui entender sua mensagem! =(",
                "Não consigo usar os parâmetros que você me passou para calcular seu IMC! =/",
                "Me envie outra mensagem no seguinte formato: `!imc {nome} {altura} {peso}`",
                "Seus dados não fazem sentido, tu é normal?!"
        );
        subject = new ImcResponse();
    }

    @Test
    public void createResponse_whenReceivedAValidImcRange_thenReturnUserImcMessage() {
        Optional<ImcRange> imcRange = ImcRange.getImcRange(26.0);
        String response = subject.createResponse("Jonathan", 26.0, imcRange, messagesProperties);

        assertThat(
            "Jonathan seu IMC é: 26.0" + "\n" +
            "Tu tá bem, anda malhando?"
        ).isEqualTo(response);
    }

    @Test
    public void createResponse_whenReceivedAInvalidImcRange_thenReturnResponseUnrecognizedMessage() {
        Optional<ImcRange> imcRange = Optional.empty();
        String response = subject.createResponse("Jonathan", 0.0, imcRange, messagesProperties);

        assertThat(
            "Jonathan seu IMC é: 0.0" + "\n" +
            "Seus dados não fazem sentido, tu é normal?!"
        ).isEqualTo(response);
    }

}
