package bridge.view;

import bridge.error.ErrorCode;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        int size = parseInt(input);
        validateRange(size);
        return size;
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw ErrorCode.INVALID_BRIDGE_SIZE_TYPE.getException();
        }
    }

    private void validateRange(int number) {
        if (number <= 0) {
            throw ErrorCode.INVALID_BRIDGE_LENGTH.getException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        validateMoving(input);
        return input;
    }

    private void validateMoving(String input) {
        if (input.equals("U") || input.equals("D")) {
            return;
        }
        throw ErrorCode.INVALID_MOVING.getException();
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        validateCommand(input);
        return input;
    }

    private void validateCommand(String input) {
        if (input.equals("Q") || input.equals("R")) {
            return;
        }
        throw ErrorCode.INVALID_COMMAND.getException();
    }
}
