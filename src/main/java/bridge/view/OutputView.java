package bridge.view;

import bridge.domain.MovingRoute;
import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private final String STARTING_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private final String GAME_RESULT_INTRO_MESSAGE = "최종 게임 결과";
    private final String DELIMITER = "|";
    private final String GAME_FAIL_MESSAGE = "게임 성공 여부: 실패";
    private final String GAME_SUCCESS_MESSAGE = "게임 성공 여부: 성공";
    private final String TRY_ANNOUNCE_MESSAGE = "총 시도한 횟수: %s";
    private final String START_BRACKET = "[";
    private final String END_BRACKET = "]";


    public void printGameStartMessage() {
        System.out.println(STARTING_MESSAGE);
    }

    public void printMap(MovingRoute movingRoute) {
        List<String> upperSpace = getUpperSpace(movingRoute);
        List<String> lowerSpace = getLowerSpace(movingRoute);
        System.out.println(START_BRACKET + String.join(DELIMITER, upperSpace) + END_BRACKET);
        System.out.println(START_BRACKET + String.join(DELIMITER, lowerSpace) + END_BRACKET);
    }


    public void printResult(MovingRoute movingRoute, int tryCount, boolean isSuccess) {
        System.out.println(GAME_RESULT_INTRO_MESSAGE);
        List<String> upperSpace = getUpperSpace(movingRoute);
        List<String> lowerSpace = getLowerSpace(movingRoute);
        System.out.println(START_BRACKET + String.join(DELIMITER, upperSpace) + END_BRACKET);
        System.out.println(START_BRACKET + String.join(DELIMITER, lowerSpace) + END_BRACKET);
        if (isSuccess) {
            System.out.println(GAME_SUCCESS_MESSAGE);
            System.out.println(String.format(TRY_ANNOUNCE_MESSAGE, tryCount));
            return;
        }

        System.out.println(GAME_FAIL_MESSAGE);
        System.out.println(String.format(TRY_ANNOUNCE_MESSAGE, tryCount));
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    private List<String> getLowerSpace(MovingRoute movingRoute) {
        List<String> lowerSpace = new ArrayList<>();
        for (int i = 0; i < movingRoute.getCurrentPosition(); i++) {
            String route = movingRoute.getRouteByIndex(i);
            String bridgeWay = movingRoute.getBridgePositionByIndex(i);
            if (route.equals(bridgeWay)) {
                if (route.equals("U")) {
                    lowerSpace.add("   ");
                    continue;
                }
                lowerSpace.add(" O ");
                continue;
            }
            if (route.equals("D")) {
                lowerSpace.add(" X ");
                continue;
            }
            lowerSpace.add("   ");

        }
        return lowerSpace;
    }

    private List<String> getUpperSpace(MovingRoute movingRoute) {
        List<String> upperSpace = new ArrayList<>();
        for (int i = 0; i < movingRoute.getCurrentPosition(); i++) {
            String route = movingRoute.getRouteByIndex(i);
            String bridgeWay = movingRoute.getBridgePositionByIndex(i);
            if (route.equals(bridgeWay)) {
                if (route.equals("U")) {
                    upperSpace.add(" O ");
                    continue;
                }
                upperSpace.add("   ");
                continue;
            }
            if (route.equals("D")) {
                upperSpace.add("  ");
                continue;
            }
            upperSpace.add(" X ");
        }
        return upperSpace;
    }
}
