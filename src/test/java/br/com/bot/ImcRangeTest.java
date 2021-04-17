package br.com.bot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;

public class ImcRangeTest {

    @Test
    public void getImcRange_whenUnderWeightImcRange_thenReturnFirstRecordOnTheListRanges() {
        Optional<ImcRange> imcRange = ImcRange.getImcRange(10.0);

        assertThat(imcRange.get().getMessage()).isEqualTo("Se cuida, se bater um vento meio forte tu voa hahah");
    }

    @Test
    public void getImcRange_whenNormalWeightImcRange_thenReturnSecondRecordOnTheListRanges() {
        Optional<ImcRange> imcRange = ImcRange.getImcRange(20.0);

        assertThat(imcRange.get().getMessage()).isEqualTo("Tá tranquilo, pode comer doritos com coca!");
    }

    @Test
    public void getImcRange_whenOverweightImcRange_thenReturnThirdRecordOnTheListRanges() {
        Optional<ImcRange> imcRange = ImcRange.getImcRange(25.0);

        assertThat(imcRange.get().getMessage()).isEqualTo("Tu tá bem, anda malhando?");
    }

    @Test
    public void getImcRange_whenGradeOneObesityImcRange_thenReturnFourthRecordOnTheListRanges() {
        Optional<ImcRange> imcRange = ImcRange.getImcRange(30.0);

        assertThat(imcRange.get().getMessage()).isEqualTo("Já pensou em se exercitar um pouco?");
    }

    @Test
    public void getImcRange_whenGradeTwoObesityImcRange_thenReturnFifthRecordOnTheListRanges() {
        Optional<ImcRange> imcRange = ImcRange.getImcRange(40.0);

        assertThat(imcRange.get().getMessage()).isEqualTo("DIETA E ACADEMIA, JÁ!");
    }

}
