package br.com.bot;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;

public class PropertiesReaderTest {

    @Test
    public void validateGetMessageProperties() throws IOException {
        PropertiesReader propertiesReader = new PropertiesReader();
        MessagesProperties messagesProperties = propertiesReader.getMessageProperties();

        assertThat(messagesProperties.getExceededParameters()).isEqualTo("Não consegui entender sua mensagem! =(");
        assertThat(messagesProperties.getInvalidNumber()).isEqualTo("Não consigo usar os parâmetros que você me passou para calcular seu IMC! =/");
        assertThat(messagesProperties.getUsage()).isEqualTo("Me envie outra mensagem no seguinte formato: `!imc {nome} {altura} {peso}`");
        assertThat(messagesProperties.getResponseUnrecognized()).isEqualTo("Seus dados não fazem sentido, tu é normal?!");
    }

}
