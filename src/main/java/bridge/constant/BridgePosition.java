package bridge.constant;

import java.util.Arrays;

public enum BridgePosition {
    UP("U", 1),
    DOWN("D", 0);

    private String position;
    private int number;

    private BridgePosition(String position, int number) {
        this.position = position;
        this.number = number;
    }

    public static BridgePosition getPosition(int number) {
        return Arrays.stream(values())
                .filter(p -> p.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public String getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }
}
