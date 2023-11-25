package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static util.LottoNumberGenerator.LOTTO_NUMBER_COUNT_LIMIT;

public class Lotto {
    private Set<LottoNumber> lottoNumbers;

    public Lotto(int num1, int num2, int num3, int num4, int num5, int num6) {
        this(IntStream.of(num1, num2, num3, num4, num5, num6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet()));
    }

    public Lotto(String input) {
        this(Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
    }

    public Lotto(List<Integer> lottoNumbers) {
        this(lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
    }

    public Lotto(Set<LottoNumber> lottoNumbers) {
        validateLottoNumberCount(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    private static void validateLottoNumberCount(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT_LIMIT) {
            throw new IllegalArgumentException("로또 숫자는 6개 입니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .sorted()
                .collect(Collectors.toList());
    }

    public int calculateMatchCount(WinningLotto winningLotto) {
        return (int) lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .filter(lottoNum -> winningLotto.getLottoNumbers().contains(lottoNum) || lottoNum == winningLotto.getBonusNumber().getLottoNumber())
                .count();
    }

    public boolean isMatchBonusNumber(WinningLotto winningLotto) {
        return contains(winningLotto.getBonusNumber());
    }

    private boolean contains(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

}
