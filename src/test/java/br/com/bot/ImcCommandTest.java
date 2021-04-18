package br.com.bot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ImcCommandTest {

    private MessagesProperties messagesProperties;
    private ImcCommand subject;

    @Before
    public void init() {
        messagesProperties = new MessagesProperties(
                "Não consegui entender sua mensagem! =(",
                "Não consigo usar os parâmetros que você me passou para calcular seu IMC! =/",
                "Me envie outra mensagem no seguinte formato: `!imc {nome} {altura} {peso}`",
                "Seus dados não fazem sentido, tu é normal?!"
        );
        subject = new ImcCommand(messagesProperties);
    }

    @Test
    public void givenCallExecuteCommand_whenExceededParameters_thenReturnExceededParametersMessage() {
        String response = subject.execute("!imc Jonathan 1.75 80 80");

        assertThat(
            messagesProperties.getExceededParameters() + "\n" +
            messagesProperties.getUsage()
        ).isEqualTo(response);
    }

    @Test
    public void givenCallExecuteCommand_whenInvalidNumber_thenReturnInvalidNumberMessage() {
        String response = subject.execute("!imc Jonathan Henrique 80");

        assertThat(
            messagesProperties.getInvalidNumber() + "\n" +
            messagesProperties.getUsage()
        ).isEqualTo(response);
    }

    @Test
    public void givenCallExecuteCommand_whenValidParameter_thenReturnUserImcMessage() {
        String response = subject.execute("!imc Jonathan 1.75 80");

        assertThat(
            "Jonathan seu IMC é: 26.0" + "\n" +
            "Tu tá bem, anda malhando?"
        ).isEqualTo(response);
    }

}
