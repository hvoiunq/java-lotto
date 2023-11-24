import domain.Lotto;
import domain.WinningLotto;
import repository.LottoGameResultRepository;
import service.LottoResultService;
import repository.UserLottoRepository;
import service.UserLottoService;
import domain.Currency;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Optional;

public class LottoApplication {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        UserLottoService userLottoService = appConfig.userLottoService();
        LottoResultService lottoResultService = appConfig.lottoResultService();

        long money = InputView.inputLottoPurchaseAmount();
        userLottoService.buyRandomLottoTickets(money);
        List<Lotto> lottoTickets = userLottoService.getAllLottoTickets();
        ResultView.printLottoCount(lottoTickets.size());
        ResultView.printLottoNumbers(lottoTickets);

        String inputWinningNumbers = InputView.inputWinningNumbers();
        int inputBonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(inputWinningNumbers, inputBonusNumber);

        Optional<Currency> optionalCurrency = Optional.of(Currency.KRW);
        LottoGameResultRepository lottoGameResult = lottoResultService.matchUserLotto(winningLotto);
        float rate = lottoResultService.calculateReturnRate(money, lottoGameResult, optionalCurrency);
        ResultView.printLottoGameResult(lottoGameResult, rate, optionalCurrency);
    }
}
