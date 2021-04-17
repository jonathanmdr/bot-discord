package br.com.bot;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ImcRange {

    private static final List<ImcRange> rangeList = Arrays.asList(
            new ImcRange(0, 18.5, "Se cuida bater um vento meio forte tu voa hahah"),
            new ImcRange(18.5, 24.9, "Tá tranquilo, pode comer doritos com coca!"),
            new ImcRange(25.0, 29.9, "Tu tá bem, anda malhando?"),
            new ImcRange(30.0, 39.9, "Já pensou em se exercitar um pouco?"),
            new ImcRange(40.0, 0, "DIETA E ACADEMIA, JÁ!")
    );

    private final double minValue;
    private final double maxValue;
    private final String message;

    public ImcRange(double minValue, double maxValue, String message) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static Optional<ImcRange> getImcRange(double imc) {
        return rangeList.stream()
                .filter(imcRange -> imcRange.isValidRange(imc))
                .findFirst();
    }

    private boolean isValidRange(double imc) {
        if (minValue == 0 && imc <= maxValue) {
            return true;
        }

        if (maxValue == 0 && imc >= minValue) {
            return true;
        }

        return imc >= minValue && imc <= maxValue;
    }

}
