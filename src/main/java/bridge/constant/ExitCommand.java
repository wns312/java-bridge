package bridge.constant;

public enum ExitCommand {
    QUIT("Q"),
    RETRY("R");

    private String command;

    private ExitCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
