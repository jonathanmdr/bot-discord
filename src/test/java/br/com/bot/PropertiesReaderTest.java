package br.com.bot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class PropertiesReaderTest {

    @Test
    public void givenCallGetMessageProperties_whenValidMessagePropertiesFile_thenReturnMessageProperties() throws IOException {
        PropertiesReader propertiesReader = new PropertiesReader();
        MessagesProperties messagesProperties = propertiesReader.getMessageProperties();

        assertThat(messagesProperties.getExceededParameters()).isEqualTo("Não consegui entender sua mensagem! =(");
        assertThat(messagesProperties.getInvalidNumber()).isEqualTo("Não consigo usar os parâmetros que você me passou para calcular seu IMC! =/");
        assertThat(messagesProperties.getUsage()).isEqualTo("Me envie outra mensagem no seguinte formato: `!imc {nome} {altura} {peso}`");
        assertThat(messagesProperties.getResponseUnrecognized()).isEqualTo("Seus dados não fazem sentido, tu é normal?!");
    }

    @Test
    public void givenCallGetMessageProperties_whenInvalidMessagePropertiesFile_thenThrowsFileNotFoundException() throws IOException {
        PropertiesReader propertiesReader = mock(PropertiesReader.class);

        when(propertiesReader.getMessageProperties()).thenThrow(new FileNotFoundException("Properties file not found!"));

        FileNotFoundException exception = assertThrows(
                FileNotFoundException.class,
                () -> propertiesReader.getMessageProperties()
        );

        assertThat(exception.getLocalizedMessage()).isEqualTo("Properties file not found!");
    }

}
