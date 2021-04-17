package br.com.bot;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ImcRange {

    private static final List<ImcRange> rangeList = Arrays.asList(
            new ImcRange(0,18.5, "Se bater um vento voa hahah"),
            new ImcRange(18.5,  24.9, "Tá tranquilo, pode comer doritos com coca!"),
            new ImcRange(25.0,  29.9, "Tu tá bem, anda malhando?"),
            new ImcRange(30.0,  39.9, "Já pensou em se exercitar um pouco?"),
            new ImcRange(40.0,  0, "ACADEMIA, JÁ!")
    );

    private final double lowValue;
    private final double maxValue;
    private final String status;

    public ImcRange(double lowValue, double maxValue, String status) {
        this.lowValue = lowValue;
        this.maxValue = maxValue;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static Optional<ImcRange> getImcRange(double imc) {
        return rangeList.stream()
                .filter(imcRange -> imcRange.isValidRange(imc))
                .findFirst();
    }

    private boolean isValidRange(double imc) {
        if (lowValue == 0 && imc <= maxValue) {
            return true;
        }

        if (maxValue == 0 && imc >= lowValue) {
            return true;
        }

        return imc >= lowValue && imc <= maxValue;
    }

}
