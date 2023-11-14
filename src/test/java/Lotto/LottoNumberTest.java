package Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {

    @Test
    void collectionShuffleTest() {
        List<Integer> number = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int num = random.nextInt(45);
            number.add(num);
        }
        Collections.shuffle(number);
        System.out.println("number = " + number);
    }

    @Test
    @DisplayName("로또 생성은 Collections.shuffle() 메소드를 활용한다.")
    void generateNumberShuffleTest() {
        List<Integer> lottoNumbers = LottoNumber.generateLottoNumber();

        assertThat(lottoNumbers.stream().distinct().count()).isEqualTo(6);
    }
    @Test
    @DisplayName("로또 생성은 Collections.shuffle() 메소드를 활용한다.")
    void generateNumberShuffleTest2() {
        for (int i = 0; i < 2; i++) {
            List<Integer> lottoNumbers = LottoNumber.generateLottoNumber();
            System.out.println("lottoNumbers = " + lottoNumbers);
        }
    }

    @Test
    @DisplayName("로또 번호 출력은 Collections.sort()를 활용한다.")
    void usingSortTest() {
        List<Integer> lottoNumbers = LottoNumber.generateLottoNumber();
        Collections.sort(lottoNumbers);

        System.out.println("lottoNumbers = " + lottoNumbers);
    }
}