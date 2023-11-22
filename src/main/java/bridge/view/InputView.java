package bridge.view;

import bridge.constant.ExitCommand;
import bridge.constant.MoveDirection;
import bridge.error.ErrorCode;
import camp.nextstep.edu.missionutils.Console;


public class InputView {
    private final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String MOVE_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String RETRY_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);
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

    public String readMoving() {
        System.out.println(MOVE_INPUT_MESSAGE);
        String input = Console.readLine();
        validateMoving(input);
        return input;
    }

    private void validateMoving(String input) {
        if (input.equals(MoveDirection.UP.getDirection()) || input.equals(MoveDirection.DOWN.getDirection())) {
            return;
        }
        throw ErrorCode.INVALID_MOVING.getException();
    }

    public String readGameCommand() {
        System.out.println(RETRY_INPUT_MESSAGE);
        String input = Console.readLine();
        validateCommand(input);
        return input;
    }

    private void validateCommand(String input) {
        if (input.equals(ExitCommand.QUIT.getCommand()) || input.equals(ExitCommand.RETRY.getCommand())) {
            return;
        }
        throw ErrorCode.INVALID_COMMAND.getException();
    }
}
