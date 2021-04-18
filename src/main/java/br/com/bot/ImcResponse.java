package br.com.bot;

import static java.lang.String.format;

public class ImcResponse {

    private ImcResponse() {
        throw new IllegalStateException("Utility class");
    }

    public static String response(String pattern, Object ... params) {
        return format(pattern, params);
    }

}
