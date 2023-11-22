package bridge.view;

import bridge.domain.MovingRoute;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MovingRoute movingRoute) {
        List<String> upperSpace = getUpperSpace(movingRoute);
        List<String> lowerSpace = getLowerSpace(movingRoute);
        System.out.println(upperSpace);
        System.out.println(lowerSpace);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(MovingRoute movingRoute, int tryCount, boolean isSuccess) {
        System.out.println("최종 게임 결과");
        List<String> upperSpace = getUpperSpace(movingRoute);
        List<String> lowerSpace = getLowerSpace(movingRoute);
        System.out.println(upperSpace);
        System.out.println(lowerSpace);
        if (isSuccess) {
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + tryCount);
        } else {
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + tryCount);
        }

    }

    private List<String> getLowerSpace(MovingRoute movingRoute) {
        List<String> lowerSpace = new ArrayList<>();
        for (int i = 0; i < movingRoute.getCurrentPosition(); i++) {
            String route = movingRoute.getRouteByIndex(i);
            String bridgeWay = movingRoute.getBridgePositionByIndex(i);
            if (route.equals(bridgeWay) && route.equals("D")) {
                lowerSpace.add(" O");
                continue;
            }
            lowerSpace.add(" X");
        }
        return lowerSpace;
    }

    private List<String> getUpperSpace(MovingRoute movingRoute) {
        List<String> upperSpace = new ArrayList<>();
        for (int i = 0; i < movingRoute.getCurrentPosition(); i++) {
            String route = movingRoute.getRouteByIndex(i);
            String bridgeWay = movingRoute.getBridgePositionByIndex(i);
            if (route.equals(bridgeWay) && route.equals("U")) {
                upperSpace.add(" O");
                continue;
            }
            upperSpace.add(" X");
        }
        return upperSpace;
    }
}
