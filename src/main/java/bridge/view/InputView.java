package bridge.view;

import bridge.domain.exception.IllegalArgumentExceptionType;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String BRIDGE_SIZE_INPUT_PRE_MESSAGE = "다리의 길이를 입력해주세요.";

    private int parseBridgeSize(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw IllegalArgumentExceptionType.INVALID_BRIDGE_LENGTH.getException();
        }
    }

    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_INPUT_PRE_MESSAGE);
        String input = Console.readLine();

        return parseBridgeSize(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
