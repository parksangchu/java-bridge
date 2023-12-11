package bridge.domain.system;

public class GameCommand {
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final String COMMAND_ERROR = "[ERROR] 유효하지 않은 명령입니다.";
    private final String command;

    public GameCommand(String command) {
        validate(command);
        this.command = command;
    }

    private void validate(String command) {
        if (!command.equals(RETRY) && !command.equals(QUIT)) {
            throw new IllegalArgumentException(COMMAND_ERROR);
        }
    }

    public boolean isQuit() {
        return command.equals(QUIT);
    }
}
