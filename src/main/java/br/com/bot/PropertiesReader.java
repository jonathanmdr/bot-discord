package br.com.bot;

import static java.util.Objects.requireNonNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesReader {

    public MessagesProperties getMessageProperties() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(
                requireNonNull(getClass().getClassLoader().getResourceAsStream("messages.properties")),
                StandardCharsets.UTF_8
        );
        Properties properties = new Properties();

        try {
            properties.load(inputStreamReader);
        } catch (IOException ex) {
            throw new FileNotFoundException("Properties file not found!");
        }

        String exceededParameters = properties.getProperty("validation.exceeded.parameters");
        String invalidNumber = properties.getProperty("validation.invalid.number");
        String usage = properties.getProperty("validation.usage");
        String responseUnrecognized = properties.getProperty("response.unrecognized");

        return new MessagesProperties(exceededParameters, invalidNumber, usage, responseUnrecognized);
    }

}
