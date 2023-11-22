package bridge.domain;

import bridge.domain.exception.IllegalArgumentExceptionType;

public class RetryCommand {
    private static final String RETRY_COMMAND = "R";
    private static final String END_COMMAND = "Q";
    private final String command;

    public RetryCommand(String command) {
        validate(command);
        this.command = command;
    }

    private void validate(String command) {
        if (!command.equals(RETRY_COMMAND) && !command.equals(END_COMMAND)) {
            throw IllegalArgumentExceptionType.INVALID_RETRY_COMMAND.getException();
        }
    }

    public boolean isRetry() {
        return command.equals(RETRY_COMMAND);
    }
}
