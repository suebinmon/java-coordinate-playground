package coordinate.model;

import coordinate.model.Pointer;
import coordinate.model.Triangle;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.assertj.core.data.Offset.offset;

public class TriangleTest {

    @Test
    void 삼각형_넓이() {
        List<Pointer> pointers = Arrays.asList(new Pointer(10, 10),
                new Pointer(14, 15),
                new Pointer(20, 8)
        );
        Triangle triangle = new Triangle(pointers);
        Assertions.assertThat(triangle.getArea()).isEqualTo(29, offset(0.1));
    }
}
