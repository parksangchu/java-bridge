package bridge.domain;

public class GameCommand {
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private final String command;

    public GameCommand(String command) {
        validate(command);
        this.command = command;
    }

    private void validate(String command) {
        if (command != RETRY && command != QUIT) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 명령입니다.");
        }
    }

    public boolean isRetry() {
        return command.equals(RETRY);
    }
}
