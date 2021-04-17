package br.com.bot;

public class MessagesProperties {

    private String exceededParameters;
    private String invalidNumber;
    private String usage;
    private String responseUnrecognized;

    public MessagesProperties(String exceededParameters, String invalidNumber, String usage, String responseUnrecognized) {
        this.exceededParameters = exceededParameters;
        this.invalidNumber = invalidNumber;
        this.usage = usage;
        this.responseUnrecognized = responseUnrecognized;
    }

    public String getExceededParameters() {
        return exceededParameters;
    }

    public String getInvalidNumber() {
        return invalidNumber;
    }

    public String getUsage() {
        return usage;
    }

    public String getResponseUnrecognized() {
        return responseUnrecognized;
    }

}
