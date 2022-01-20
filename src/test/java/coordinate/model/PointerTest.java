package coordinate.model;

import coordinate.model.Pointer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PointerTest {

    @Test
    void 좌표_생성() {
        Pointer pointer = new Pointer(10, 12);
        assertThat(pointer).isEqualTo(new Pointer(10, 12));
    }

    @Test
    void 좌표_범위_1_24() {
        assertThrows(IllegalArgumentException.class, () -> new Pointer(0, 10));
        assertThrows(IllegalArgumentException.class, () -> new Pointer(25, 10));
        assertThrows(IllegalArgumentException.class, () -> new Pointer(10, 0));
        assertThrows(IllegalArgumentException.class, () -> new Pointer(10, 25));
    }
}
