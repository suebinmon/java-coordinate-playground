package coordinate.model;

import coordinate.model.Line;
import coordinate.model.Pointer;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    void 라인_길이() {
        List<Pointer> pointers = Arrays.asList(new Pointer(10, 10), new Pointer(14, 15));
        Line line = new Line(pointers);
        assertThat(line.getArea()).isEqualTo(6.403124, offset(0.000001));
    }
}