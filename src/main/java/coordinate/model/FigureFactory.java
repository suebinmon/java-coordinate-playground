package coordinate.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
    private static final Map<Integer, Function<List<Pointer>, Figure>> classifier = new HashMap<>();

    public static final int NUM_OF_LINE = 2;
    public static final int NUM_OF_TRIANGLE = 3;
    public static final int NUM_OF_SQUARE = 4;

    static {
        classifier.put(NUM_OF_LINE, Line::new);
        classifier.put(NUM_OF_TRIANGLE, Triangle::new);
        classifier.put(NUM_OF_SQUARE, Square::new);
    }

    public static Figure create(List<Pointer> pointers){
        if (isInvalidNumberOf(pointers)) {
            throw new IllegalArgumentException("Point 개수가 유효하지 않습니다.");
        }
        return classifier.get(pointers.size()).apply(pointers);
    }

    private static boolean isInvalidNumberOf(List<Pointer> pointers) {
        int numOfPointers = pointers.size();
        return numOfPointers<NUM_OF_LINE || numOfPointers>NUM_OF_SQUARE;
    }
}
