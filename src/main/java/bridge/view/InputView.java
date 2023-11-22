package bridge.view;

import bridge.domain.exception.IllegalArgumentExceptionType;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVING_DIRECTION_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY_COMMAND_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private int parseBridgeSize(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw IllegalArgumentExceptionType.INVALID_BRIDGE_LENGTH.getException();
        }
    }

    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);
        String input = Console.readLine();

        return parseBridgeSize(input);
    }

    public String readMoving() {
        System.out.println(MOVING_DIRECTION_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(RETRY_COMMAND_INPUT_MESSAGE);
        return Console.readLine();
    }
}
