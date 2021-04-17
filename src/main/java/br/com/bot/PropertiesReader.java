package br.com.bot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public MessagesProperties getMessageProperties() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("messages.properties");
        Properties properties = new Properties();

        try {
            properties.load(inputStream);
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
