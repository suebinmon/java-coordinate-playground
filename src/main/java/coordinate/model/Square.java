package coordinate.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Square extends AbstractFigure{

    private static final String OUTPUT_AREA_OF_SQUARE = "사각형의 넓이는 %.0f";
    public static final int NUM_OF_TYPES_OF_SQUARE_COORDINATES = 2;

    public Square(List<Pointer> pointers) {
        super(pointers);
        checkSquareWith(pointers);
    }

    private void checkSquareWith(List<Pointer> pointers) {
        Set<Integer> xValue = convertToUniqueXValues(pointers);
        Set<Integer> yValue = convertToUniqueYValues(pointers);

        if (hasNotTwoPointer(xValue) || hasNotTwoPointer(yValue)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }

    }

    private boolean hasNotTwoPointer(Set<Integer> values) {
        if(values.size() != NUM_OF_TYPES_OF_SQUARE_COORDINATES){
            return true;
        }
        return false;
    }

    @Override
    public double getArea() {
        List<Pointer> points = getPoints();
        int differenceOfXValues = calculateDifference(convertToUniqueXValues(points));
        int differenceOfYValues = calculateDifference(convertToUniqueYValues(points));

        return differenceOfXValues * differenceOfYValues;
    }

    private int calculateDifference(Set<Integer> valuesOfPoint) {
        List<Integer> values = new ArrayList<>(valuesOfPoint);
        return Math.abs(values.get(0) - values.get(1));
    }

    private Set<Integer> convertToUniqueYValues(List<Pointer> points) {
        return convertToUniqueValues(points,Pointer::getY);
    }
    private Set<Integer> convertToUniqueXValues(List<Pointer> points) {
        return convertToUniqueValues(points,Pointer::getX);
    }
    private Set<Integer> convertToUniqueValues(List<Pointer> points,Function<Pointer,Integer> function) {
        return points.stream()
                .map(function::apply)
                .collect(Collectors.toSet());
    }

    @Override
    public String getAreaInfo() {
        return String.format(OUTPUT_AREA_OF_SQUARE, getArea());
    }

    @Override
    public String getName() {
        return "사각형";
    }

}
