package bridge.domain.bridge;

import static bridge.domain.constants.Constants.DOWN_SIDE;
import static bridge.domain.constants.Constants.UPPER_SIDE;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private static final int UPPER_SIDE_VALUE = 1;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        while (bridge.size() < size) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            if (bridgeNumber == UPPER_SIDE_VALUE) {
                bridge.add(UPPER_SIDE.getDirection());
                continue;
            }
            bridge.add(DOWN_SIDE.getDirection());
        }
        return bridge;
    }
}
