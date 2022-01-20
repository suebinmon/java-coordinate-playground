package coordinate.model;

import java.util.List;

public class Triangle extends AbstractFigure{
    private static final String OUTPUT_AREA_OF_TRIANGLE = "삼각형의 넓이는 %.1f";
    public Triangle(List<Pointer> pointers) {
        super(pointers);
    }


    @Override
    public double getArea() {
        List<Pointer> pointers = getPoints();
        Pointer firstPointer = pointers.get(0);
        Pointer secondPointer = pointers.get(1);
        Pointer thirdPointer = pointers.get(2);

        double firstValue = firstPointer.calculateDistance(secondPointer);
        double secondValue = secondPointer.calculateDistance(thirdPointer);
        double thirdValue = thirdPointer.calculateDistance(firstPointer);

        return calculateFormulaOfHeron(firstValue, secondValue, thirdValue);
    }

    private double calculateFormulaOfHeron(double firstValue, double secondValue, double thirdValue) {
        double s = (firstValue + secondValue + thirdValue) / 2;
        return Math.sqrt((s * (s - firstValue) * (s - secondValue) * (s - thirdValue)));
    }

    @Override
    public String getAreaInfo() {
        return String.format(OUTPUT_AREA_OF_TRIANGLE, getArea());
    }

    @Override
    public String getName() {
        return "삼각형";
    }
}
