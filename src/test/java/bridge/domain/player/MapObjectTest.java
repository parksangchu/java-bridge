package bridge.domain.player;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MapObjectTest {

    @Test
    @DisplayName("of 메서드의 매개변수에 따라 다른 MapObject 객체를 반환한다.")
    void of() {
        MapObject mapObject = MapObject.of(true);
        assertThat(mapObject)
                .isEqualTo(MapObject.RIGHT_WAY);
        mapObject = MapObject.of(false);
        assertThat(mapObject)
                .isEqualTo(MapObject.WRONG_WAY);
        mapObject = MapObject.of();
        assertThat(mapObject)
                .isEqualTo(MapObject.UNSELECTED_WAY);
    }
}