package coordinate.model;

import coordinate.model.Pointer;
import coordinate.model.Square;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {

    @Test
    void 사각형_검증() {
        List<Pointer> pointers = Arrays.asList(new Pointer(10, 10),
                new Pointer(23, 10),
                new Pointer(22, 18),
                new Pointer(10, 18)
        );
        assertThrows(IllegalArgumentException.class, () -> new Square(pointers));
    }

    @Test
    void 사각형_넓이() {
        List<Pointer> pointers = Arrays.asList(new Pointer(10, 10),
                new Pointer(22, 10),
                new Pointer(22, 18),
                new Pointer(10, 18)
        );
        Square square = new Square(pointers);
        Assertions.assertThat(square.getArea()).isEqualTo(96);
    }
}
