package view;

import domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() { // 인스턴스화 방지
    }

    public static long inputLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLong();
    }

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> inputSelectedNumber() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<Integer> selectedNumbers = new ArrayList<>();
        for (int j = 0; j < 6; j++) {
            selectedNumbers.add(scanner.nextInt());
        }
        return selectedNumbers;
    }

    public static String inputWinningNumbers() {
        scanner.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
